var dir = window.location.pathname;

var headers = [
    "id",
    "Name",
    "Platform",
    "Year_of_Release",
    "Genre",
    "Publisher",
    "NA_Sales",
    "EU_Sales",
    //"JP_Sales",
    //"Other_Sales",
    "Global_Sales",
    //"Critic_Score",
    //"Critic_Count",
    //"User_Score",
    //"User_Count",
    //"Developer",
    //"Rating"
];


// default params
var params = {
    page: 1,
    page_rows_nb: 10,
    sortBy: "id",
    reverse: false
};

// change params case existe in the link
var params_url_format = window.location.search.substring(1, window.location.search.length);
var nb_lines = 16719;

function update_url() {
    window.history.pushState('', 'TableauxDnamique', dir + "?" + $.param(params));
}

function init_params(){
    if (params_url_format !== "") {
        params = JSON
            .parse('{"' + decodeURI(params_url_format
                .replace(/&/g, "\",\"")              // replace '&' with ','
                .replace(/=/g, "\":\"")) + '"}'      // replace '=' with ':'
            );
        params.page_rows_nb = parseInt(params.page_rows_nb);
        params.page         = parseInt(params.page);
        params.reverse      = (params.reverse == 'true');
    }
}

function sort_table() {
    params.page = 1;
    insert_table_headers();
    update_url();
    insert_table_body();
}

function insert_table_body() {
    $.ajax("/api/videoGames/all?sortBy=" + params.sortBy + "&reverse=" +
        params.reverse + "&page=" + params.page + "&page_rows_nb=" + params.page_rows_nb)
        .done(function (arg) {
            $("#mainbody").empty();
            $("#page").empty();
            $("#page").append("<h1 class=\"display-4 \" > Page : " + params.page + "</h1>");
            $.each(arg, function (index, row) {
                $("#mainbody").append("<tr id=row-" + row.id + ">");
                $.each(headers, function (index, field) {
                    if (field === "id") $("#mainbody #row-" + row.id).append("<th scope='col'>" + row[field] + "</th>");
                    else $("#mainbody #row-" + row.id).append("<td>" + row[field] + "</td>");
                });

            });
        })
        .fail(function () {
            alert("error");
        });
}

function insert_table_headers() {
    $("#mainheader").empty();
    $.each(headers, function (index, data) {
        $("#mainheader")
            .append("<th scope='col' id='col-" + data + "' style='cursor: pointer;'>" + data + "</th>");
        $("#col-" + data)
            .click(function () {
                // if we click on the same header the order change else the order is not reversed (means : ordering asc)
                params.reverse = (params.sortBy === data ? !params.reverse : false);
                params.sortBy = data;
                sort_table();
            });
    });
    $("#col-" + params.sortBy).append(params.reverse ? "▼" : "▲");
}


$(document).ready(function () {
    init_params();
    insert_table_headers();
    insert_table_body();

    $("#next-page").click(function () {
        if (params.page + 1 < nb_lines / params.page_rows_nb) {
            params.page += 1;
            update_url();
        }
        insert_table_body();
    });

    $("#previous-page").click(function () {
        if (params.page - 1 > 0) {
            params.page += -1;
            update_url();
        }
        insert_table_body();
    });
});