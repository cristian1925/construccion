package com.myconstruccion.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myconstruccion.model.Usuario;
import com.myconstruccion.util.DatabaseUtil;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password"); // En una aplicación real, se debería usar hashing para la contraseña.

        Usuario usuario = getAuthenticatedUser(username, password);

        if (usuario != null) {
            request.getSession().setAttribute("usuario", usuario);
            response.sendRedirect("home.jsp"); // Redirige a la página de inicio de la sesión.
        } else {
            response.sendRedirect("login.jsp?error=true"); // Login fallido.
        }
    }

    private Usuario getAuthenticatedUser(String username, String password) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password); // En una aplicación real, se debería comparar el hash de la contraseña.

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Usuario usuario = new Usuario();
                        usuario.setUsername(resultSet.getString("username"));
                        usuario.setPassword(resultSet.getString("password"));
                        return usuario;
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
