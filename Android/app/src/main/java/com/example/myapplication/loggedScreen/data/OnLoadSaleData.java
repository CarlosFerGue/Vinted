package com.example.myapplication.loggedScreen.data;

public class OnLoadSaleData {
    // ATRIBUTOS
    private int id_producto, id_usuario;

    private String marca, precio, imagen, nombre, descripcion, fecha, estado;


    // CONSTRUCTOR
    public OnLoadSaleData() {
    }

    public OnLoadSaleData(int id_usuario, String marca, String precio, String imagen, String nombre, String descripcion, String fecha, String estado) {
        this.id_usuario = id_usuario;
        this.marca = marca;
        this.precio = precio;
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "OnLoadSaleData{" +
                "id=" + id_usuario +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }


    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
