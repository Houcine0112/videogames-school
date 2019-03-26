<%@ page import="fr.plil.sio.web.User" %>
<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Attributes Page</title>
</head>
<body>
<h1>Attributes example</h1>

<h2>Session scope</h2>
<table>
    <%
        for (Enumeration<String> e = session.getAttributeNames(); e.hasMoreElements(); ) {
            String key = e.nextElement();
            Object value = session.getAttribute(key);
            out.print("<tr>" +
                    "<td>" + key + "</td>" +
                    "<td>" + value + "</td>" +
                    "</tr>");
        }
    %>
</table>
<h2>Application scope</h2>
<table>
    <%
        for (Enumeration<String> e = application.getAttributeNames(); e.hasMoreElements(); ) {
            String key = e.nextElement();
            Object value = application.getAttribute(key);
            out.print("<tr>" +
                    "<td>" + key + "</td>" +
                    "<td>" + value + "</td>" +
                    "</tr>");
        }
    %>
</table>
<h2>User information</h2>
<%
    User user = (User) session.getAttribute("user");
    if (user != null) {
        out.print("<p>Hello " + user.getLogin() + "!!!</p>");
    } else {
        out.print("No user</p>");
    }
%>
</body>
</html>
