package com.example.myapplication.usuario.comprasUsuario.historicoCompras.data;

public class OnHistorialData {
    // ATRIBUTOS
    private int id_producto, id_usuario;

    private String marca, precio, imagen, nombre, descripcion, fecha, estado, valoracion;


    // CONSTRUCTOR
    public OnHistorialData() {
    }

    public OnHistorialData(int id_usuario, String marca, String precio, String imagen, String nombre, String descripcion, String fecha, String estado, String valoracion) {
        this.id_usuario = id_usuario;
        this.marca = marca;
        this.precio = precio;
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "OnAllProdData{" +
                "id=" + id_usuario +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", estado='" + estado + '\'' +
                ", valoracion='" + valoracion + '\'' +
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

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
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
