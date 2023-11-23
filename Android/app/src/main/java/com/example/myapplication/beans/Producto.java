package com.example.myapplication.beans;

public class Producto {
//    private int id, id_user;
//    private String marca, estado, fecha, descripcion, nombre, imagen, precio;
//
//
//    public Producto(String marca, String estado, String descripcion, String nombre, String precio, int id_user) {
//        this.marca = marca;
//        this.estado = estado;
//        this.descripcion = descripcion;
//        this.nombre = nombre;
//        this.precio = precio;
//        this.id_user = id_user;
//    }
//
//    public Producto(int id_user, String marca, String estado, String descripcion, String nombre,String precio) {
//        this.id_user = id_user;
//        this.marca = marca;
//        this.estado = estado;
//        this.descripcion = descripcion;
//        this.nombre = nombre;
//        this.precio = precio;
//    }
//
//    public Producto(String marca, int id, String estado, String fecha, String descripcion, String nombre, String imagen, String precio) {
//        this.id = id;
//        this.marca = marca;
//        this.estado = estado;
//        this.fecha = fecha;
//        this.descripcion = descripcion;
//        this.nombre = nombre;
//        this.imagen = imagen;
//        this.precio = precio;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getMarca() {
//        return marca;
//    }
//
//    public void setMarca(String marca) {
//        this.marca = marca;
//    }
//
//    public String getEstado() {
//        return estado;
//    }
//
//    public void setEstado(String estado) {
//        this.estado = estado;
//    }
//
//    public String getFecha() {
//        return fecha;
//    }
//
//    public void setFecha(String fecha) {
//        this.fecha = fecha;
//    }
//
//    public String getDescripcion() {
//        return descripcion;
//    }
//
//    public void setDescripcion(String descripcion) {
//        this.descripcion = descripcion;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getImagen() {
//        return imagen;
//    }
//
//    public void setImagen(String imagen) {
//        this.imagen = imagen;
//    }
//
//    public String getPrecio() {
//        return precio;
//    }
//
//    public void setPrecio(String precio) {
//        this.precio = precio;
//    }
//
//    public int getId_user() {
//        return id_user;
//    }
//
//    public void setId_user(int id_user) {
//        this.id_user = id_user;
//    }

    private int id_producto, id_usuario;

    private String marca, precio, imagen, nombre, descripcion, fecha, estado;



    public Producto(int id_producto, int id_usuario, String marca, String precio, String imagen, String nombre, String descripcion, String fecha, String estado) {
        this.id_producto = id_producto;
        this.id_usuario = id_usuario;
        this.marca = marca;
        this.precio = precio;
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Producto(int id_usuario, String marca, String precio, String imagen, String nombre, String descripcion, String fecha, String estado) {
        this.id_usuario = id_usuario;
        this.marca = marca;
        this.precio = precio;
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
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
