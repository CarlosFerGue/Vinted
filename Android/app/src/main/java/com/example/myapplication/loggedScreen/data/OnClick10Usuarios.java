package com.example.myapplication.loggedScreen.data;

public class OnClick10Usuarios {
    private String nombre, email, user;

    public OnClick10Usuarios(String nombre, String email, String user) {
        this.nombre = nombre;
        this.email = email;
        this.user = user;
    }

    @Override
    public String toString(){
        return "OnClick10Usuarios{"+
                "nombre=" + nombre +
                ", email='" + email + '\'' +
                ", user='" + user + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
