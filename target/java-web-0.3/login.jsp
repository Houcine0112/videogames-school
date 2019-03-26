<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>
<h1>Please login</h1>

<%
    if (request.getAttribute("message") != null) {
        out.write("<b><p>" + request.getAttribute("message") + "</p></b>");
    }
%>

<form action='/login' method='post'>
    <table>
        <tr>
            <td>Login</td>
            <td><input type='text' name='login'></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type='password' name='password'></td>
        </tr>
    </table>
    <input type="submit" value="Send">
</form>
</body>
</html>
