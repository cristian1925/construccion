package com.myconstruccion.model;

public class Usuario {

	private String username;
    private String password; // En una aplicación real, la contraseña no se debería manejar en texto plano.

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con todos los atributos
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter para username
    public String getUsername() {
        return username;
    }

    // Setter para username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter para password
    public String getPassword() {
        return password;
    }

    // Setter para password
    public void setPassword(String password) {
        this.password = password;
    }

}
