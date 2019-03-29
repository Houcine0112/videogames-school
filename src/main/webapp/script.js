var dir = window.location.pathname;
var headers = [
    "id",
    "Name",
    "Platform",
    "Year_of_Release",
    "Genre",
    "Publisher",
    //"NA_Sales",
    //"EU_Sales",
    //"JP_Sales",
    //"Other_Sales",
    "Global_Sales"
    //"Critic_Score",
    //"Critic_Count",
    //"User_Score",
    //"User_Count",
    //"Developer",
    //"Rating"
];
// default GET params
var params = {
    page: 1,
    page_rows_nb: 10,
    sortBy: "id",
    reverse: false
};
var params_url_format = window.location.search.substring(1, window.location.search.length);
var nb_lines = 16719;

// case the URL contains GET params
function init_params() {
    if (params_url_format !== "") {
        // build JSON from url params
        params = JSON
            .parse('{"' + decodeURI(params_url_format
                .replace(/&/g, "\",\"")              // replace '&' with ','
                .replace(/=/g, "\":\"")) + '"}'      // replace '=' with ':'
            );
        // cast strings to the right type
        params.page_rows_nb = parseInt(params.page_rows_nb);
        params.page = parseInt(params.page);
        params.reverse = (params.reverse === 'true');
    }
    // else we will keep the initial params (look global variables)
}

// case we change something in the params
function update_url() {
    window.history.pushState('', 'TableauxDnamique', dir + "?" + $.param(params));
}

function sort_table() {
    params.page = 1; // every new sort begins in the first page
    update_url();
    insert_table_headers();
    insert_table_body();
}

function insert_table_headers() {
    $("#mainTableHeader").empty();
    $.each(headers, function (index, data) {
        $("#mainTableHeader")
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

function insert_table_body() {
    $.ajax(
        "/api/videoGames/all" +
        "?sortBy=" + params.sortBy +
        "&reverse=" + params.reverse +
        "&page=" + params.page +
        "&page_rows_nb=" + params.page_rows_nb
    )
        .done(function (arg) {
            $("#page")
                .empty()
                .append("<h1 class=\"display-4 \" > Page : " + params.page + "</h1>");
            $("#mainTableBody").empty();
            $.each(arg, function (index, row) {
                $("#mainTableBody").append("<tr id=row-" + row.id + ">");
                $.each(headers, function (index, field) {
                    // the 'id' header is styled differently
                    if (field === "id")
                        $("#mainTableBody #row-" + row.id)
                            .append("<th scope='col'>" + row[field] + "</th>");
                    else
                        $("#mainTableBody #row-" + row.id)
                            .append("<td>" + row[field] + "</td>");
                });

            });
        })
        .fail(function () {
            alert("error");
        });
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