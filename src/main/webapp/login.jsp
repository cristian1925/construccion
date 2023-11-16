<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        form {
            margin-top: 50px;
            display: flex;
            flex-direction: column;
            width: 200px;
            margin-left: auto;
            margin-right: auto;
        }
        label, input {
            margin-bottom: 10px;
        }
        input[type="submit"] {
            cursor: pointer;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <%-- Verificar si hay un mensaje de error para mostrar --%>
    <% if (request.getParameter("error") != null) { %>
        <p>Error en el login, intenta nuevamente.</p>
    <% } %>
    <form action="LoginServlet" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
