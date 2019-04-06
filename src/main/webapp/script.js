var dir = window.location.pathname;

var GET_params = {};
var params_url_format = window.location.search.substring(1, window.location.search.length); // page=1&page_rows_nb=10&sortBy=id&order_desc=false
var nb_lines = 16719;

function init_params() {
    // case the URL contains GET params
    if (params_url_format !== "") {
        // build JSON from url params
        GET_params = JSON
            .parse('{"' + decodeURI(params_url_format
                .replace(/&/g, "\",\"")              // replace '&' with ','
                .replace(/=/g, "\":\"")) + '"}'      // replace '=' with ':'
            );
    } // else we keep the default ones
    // init params of table
    if (GET_params.page_rows_nb !== undefined) {
        table_params.page_rows_nb = parseInt(GET_params.page_rows_nb);
    }
    if (GET_params.order_desc !== undefined) {
        table_params.page = parseInt(GET_params.page);
    }
    if (GET_params.sortBy !== undefined) {
        table_params.sortBy = GET_params.sortBy;
    }
    if (GET_params.page_rows_nb !== undefined) {
        table_params.order_desc = (GET_params.order_desc === 'true');
    }

    // init params of chart
    if (GET_params.sales_type !== undefined) {
        chart_params.sales_type = GET_params.sales_type;
        // select the right sales_type
        $("#sales_type_form_select").val(chart_params.sales_type);
    }
    if (GET_params.group_field !== undefined) {
        chart_params.group_field = GET_params.group_field;
        // activate btn of the right group_field
        $("#btn-" + chart_params.group_field).addClass("active");
    } else {
        // if no grouping is specified we activate btn of the default grouping which is Platform
        $("#btn-Platform").addClass("active");
    }
}

// case we change something in the params
function update_url(params) {
    // this updates the url without reloading the page
    window.history.pushState('', 'update', dir + "?" + $.param(params));
}

// table headers
var headers = [
    "id",
    "Name",
    "Platform",
    "Year_of_Release",
    "Genre",
    "Publisher",
    "NA_Sales",
    "EU_Sales",
    "JP_Sales",
    //"Other_Sales",
    "Global_Sales"
    //"Critic_Score",
    //"Critic_Count",
    //"User_Score",
    //"User_Count",
    //"Developer",
    //"Rating"
];
// default GET params for table
var table_params = {
    page: 1,
    page_rows_nb: 10,
    sortBy: "id",
    order_desc: false
};

function insert_table_headers() {
    $("#mainTableHeader").empty();
    $.each(headers, function (index, header) {
        $("#mainTableHeader")
            .append("<th scope='col' id='col-" + header + "' style='cursor: pointer;'>" + header + "</th>");
        $("#col-" + header)
            .click(function () {
                // if we click on the same header the order change else the order is not reversed (means : ordering asc)
                table_params.order_desc = (table_params.sortBy === header ? !table_params.order_desc : false);
                // update data and recreate the table
                table_params.sortBy = header;
                table_params.page = 1; // every new sort begins in the first page
                update_url(table_params);
                insert_table();
            });
    });
    $("#col-" + table_params.sortBy).append(table_params.order_desc ? "▼" : "▲");
}

function insert_table_body() {
    $.ajax(
        "/api/videoGames/all/" +
        table_params.page + "/" +
        table_params.page_rows_nb + "/" +
        table_params.sortBy + "/" +
        table_params.order_desc
    )
        .done(function (json) {
            $("#mainTableBody").empty();
            $.each(json, function (index, row) {
                $("#mainTableBody").append("<tr id=row-" + row.id + ">");
                $.each(headers, function (index, header) {
                    // the 'id' column is styled differently
                    if (header === "id")
                        $("#mainTableBody #row-" + row.id)
                            .append("<th scope='col'>" + row[header] + "</th>");
                    else
                        $("#mainTableBody #row-" + row.id)
                            .append("<td>" + row[header] + "</td>");
                });

            });
        })
        .fail(function () {
            alert("error table");
        });
}

function insert_table() {
    insert_table_headers();
    insert_table_body();
}


// default GET params for chart
var chart_params = {
    sales_type: "Global_Sales",
    group_field: "Platform"
};

function insert_chart() {
    $("#chart").empty();
    $.ajax(
        "/api/videoGames/grouped/" +
        chart_params.sales_type + "/" +
        chart_params.group_field
    )
        .done(function (json) {
            var years = json[0];
            // creaating space between labels (only for plotting the chart)
            var labels = [];
            $.each(years, function (index, year) {
                labels.push(year % 2 == 0 ? year : "");
            });

            var grouped_videogames = json[1];
            var series = [];
            $.each(grouped_videogames, function (group_field, sales) {
                // if a group_field is empty or undefined we pass it
                if (group_field === undefined || group_field === "") {
                    return true; // like pass or continue in other programming languages
                }
                // each serie represents a line to be ploted
                var serie = {"name": group_field, "data": []};
                $.each(years, function (index, year) {
                    // for each year (x) we have a sale value (y). in case there is no sale value we let 'undefined'
                    serie.data.push({x: year, y: sales[year]});
                });
                // push the serie in the list of series
                series.push(serie);
            });
            // params of Chartist constructor
            var chart_data = {
                labels: labels,
                series: series
            };
            var chart_options = {
                showPoint: false,
                fullWidth: true,
                width: "100%",
                height: "400px",
                low: 0,
                chartPadding: {
                    right: 40,
                    left: 40,
                    top: 10
                },
                axisY: {
                    type: Chartist.AutoScaleAxis
                },
                // fill the holes created by undefined values
                lineSmooth: Chartist.Interpolation.cardinal({
                    fillHoles: true,
                }),
                plugins: [
                    Chartist.plugins.legend({
                        position: 'bottom',
                        className: 'mt-3'
                    }),
                    Chartist.plugins.ctAxisTitle({
                        axisX: {
                            axisTitle: 'Years',
                            axisClass: 'ct-axis-title',
                            offset: {
                                x: 0,
                                y: 35
                            },
                            textAnchor: 'middle'
                        },
                        axisY: {
                            axisTitle: 'Sales $',
                            axisClass: 'ct-axis-title',
                            offset: {
                                x: 0,
                                y: -20
                            },
                            textAnchor: 'middle',
                            flipTitle: false
                        }
                    })
                ]
            };
            // creating the chart
            new Chartist.Line('.ct-chart-line', chart_data, chart_options);
        })
        .fail(function () {
            alert("error chart");
        });
}