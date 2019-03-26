<%-- 
    Document   : addUser
    Created on : 13 mars 2019, 15:54:14
    Author     : lelaidou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add user</title>
    </head>
    <body>
        <h1>add user</h1>
        
        <form action='/addUser' method='post'>
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
