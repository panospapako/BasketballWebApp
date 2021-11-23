<%-- 
    Document   : login
    Created on : Sep 23, 2021, 8:52:39 AM
    Author     : ppapakostas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
    <script src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
</head>
<body>
<div align="center">
    <c:if test="${message != null}">
        <div align="center">
            <h4>${message}</h4>
            <p>Username:${username}</p>
            <p>Password:${password}</p>
        </div>
    </c:if>
    <h3>Please enter your credentials</h3>
    <form id="loginform" action="login" method="post">
        <table>
            <tr>
                <td>Username</td>
                <td>
                    <input id="username" type="text" name="username" size="20">
                </td>
            </tr>
            <tr>
                <td>Password</td>
                <td>
                    <input id="password" type="password" name="password" size="20">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit">Login</button>
            </tr>
        </table>
    </form>
</div>
</body>

<script type="text/javascript">
    $(document).ready(function () {
        $('#loginform').validate({
            rules: {
                username: "required",
                password: "required"
            },
            messages: {
                username: "Please enter username",
                password: "Please enter password"
            }
        });
    });
</script>
</html>
