<%@ page import="fr.plil.sio.web.VideoGamesRepository" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Static table</title>
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
                <a class="nav-link" href="/videogames.jsp">Static table</a>
            </li>
        </ul>
    </div>
</nav>

<nav class="container" aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item">
            <button class="page-link" id="previous-page" type="button">Previous page</button>
        </li>
        <li class="page-item">
            <button class="page-link" id="next-page" type="button">Next page</button>
        </li>
    </ul>
</nav>

<div class="container mr-auto">

    <div class="table-responsive">
        <table class="table table-sm table-striped table-hover">
            <%
                VideoGamesRepository videoGamesRepository = (VideoGamesRepository) getServletContext().getAttribute("videoGamesRepository");
                VideoGame head = videoGames.get(0);
                out.println("<tr>");
                out.println("<td> # </td>");
                for (String d : head.getData()) {
                    out.println("<td>" + d + "</td>");
                }
                out.println("</tr>");
                for (int i = page * 10 - 10; i < page * 10 + 1; i++) {
                    VideoGame v = videoGames.get(i);
                    out.println("<tr>");
                    out.println("<td>" + i + "</td>");
                    for (String d : v.getData()) {
                        out.println("<td>" + d + "</td>");
                    }
                    out.println("</tr>");
                }
            %>
        </table>
    </div>
</div>

</body>
</html>
