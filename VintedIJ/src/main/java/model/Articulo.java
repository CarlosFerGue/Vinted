package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class Articulo {
    private int id;
    private String marca, estado, fecha, descripcion, nombre, imagen, precio;

    public Articulo(String marca, String estado, String fecha, String descripcion, String nombre, String imagen, String precio) {
        this.marca = marca;
        this.estado = estado;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
    }

    public Articulo(int id, String marca, String estado, String fecha, String descripcion, String nombre, String imagen, String precio) {
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

    public static String toArrayJSon(ArrayList<Articulo> articulos) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(articulos);

        return resp;
    }

}