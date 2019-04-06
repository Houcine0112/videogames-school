<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Static table</title>
    <link rel="icon" href="icon.png"/>
    <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" rel="stylesheet">
    <script crossorigin="anonymous"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script crossorigin="anonymous"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script crossorigin="anonymous"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
    </script>
</head>

<body class="bg-light">
<nav class="navbar navbar-expand-lg navbar-light bg-light mb-3">
    <img src="/icon.png" width="30" height="30" class="d-inline-block align-top" alt="">
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/.">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/chart.html">Chart</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/videogames.html">Dynamic table</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/videoGamesStatic">Static table</a>
            </li>
        </ul>
    </div>
</nav>


<div class="container mr-auto">
    <form class="form-inline">
        <div class="form-group mx-sm-3 mb-2">
            <input type="number" min="1" max="999999" class="form-control" id="page" name="page" placeholder="Page">
        </div>
        <button type="submit" class="btn btn-primary mb-2">Submit</button>
    </form>
    <div class="table-responsive">
        <table class="table table-sm table-striped table-hover">
            <thead class="thead-dark">
            <th>Name</th>
            <th>Platform</th>
            <th>Year_of_Release</th>
            <th>Genre</th>
            <th>Publisher</th>
            <th>NA_Sales</th>
            <th>EU_Sales</th>
            <th>JP_Sales</th>
            <th>Other_Sales</th>
            <th>Global_Sales</th>
            <th>Critic_Score</th>
            <th>Critic_Count</th>
            <th>User_Score</th>
            <th>User_Count</th>
            <th>Developer</th>
            <th>Rating</th>
            </thead>
            <%
                if (request.getAttribute("data") != null) {
                    List<List<String>> data = (List<List<String>>) request.getAttribute("data");
                    for (List<String> row : data) {
                        out.println("<tr>");
                        for (String v : row) {
                            out.println("<td>" + v + "</td>");
                        }
                        out.println("</tr>");
                    }

                }
            %>
        </table>
    </div>
</div>

</body>
</html>
