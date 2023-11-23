package com.example.myapplication.beans;

public class Producto {
    private int id, id_user;
    private String marca, estado, fecha, descripcion, nombre, imagen, precio;


    public Producto(String marca, String estado, String descripcion, String nombre, String precio, int id_user) {
        this.marca = marca;
        this.estado = estado;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
        this.id_user = id_user;
    }

    public Producto(int id_user, String marca, String estado, String descripcion, String nombre,String precio) {
        this.id_user = id_user;
        this.marca = marca;
        this.estado = estado;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String marca, int id, String estado, String fecha, String descripcion, String nombre, String imagen, String precio) {
        this.id = id;
        this.marca = marca;
        this.estado = estado;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }


}
