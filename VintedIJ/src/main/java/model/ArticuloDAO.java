package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticuloDAO implements DAO<Articulo, Integer> {
    private MotorSQL motorSql;

    public ArticuloDAO() {
        motorSql = new MotorSQL();
    }

    @Override
    public ArrayList<Articulo> findAll(Articulo entity) throws SQLException {
        ArrayList<Articulo> articulos = new ArrayList<>();
        String sql = "SELECT * FROM articulos";

        try {
            //1º)
            motorSql.conectar();
            System.out.println(sql);
            ResultSet rs = motorSql.consultar(sql);

            while (rs.next()) {// TRANSFOMAR LA COLECCIÓN DE BASE DE DATOS A UN ARRAYLIST
                Articulo articulo = new Articulo(
                        rs.getInt("id_producto"),
                        rs.getString("marca_producto"),
                        rs.getString("estado"),
                        rs.getString("fecha_subida_producto"),
                        rs.getString("descripcion_producto"),
                        rs.getString("nombre_producto"),
                        rs.getString("imagen_producto"),
                        rs.getString("precio_producto")
                );
                articulos.add(articulo);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            motorSql.desconectar();
        }
        return articulos;
    }


    public ArrayList<Articulo> filterType(String id_usuario) throws SQLException {
        ArrayList<Articulo> articulos = new ArrayList<>();
        String sql = "SELECT * FROM articulos WHERE id_usuario='" + id_usuario +"'";
        try {
            //1º)
            motorSql.conectar();

            System.out.println(sql);
            ResultSet rs = motorSql.consultar(sql);

            while (rs.next()) {// TRANSFOMAR LA COLECCIÓN DE BASE DE DATOS A UN ARRAYLIST
                Articulo articulo = new Articulo(
                        rs.getInt("id_producto"),
                        rs.getString("marca_producto"),
                        rs.getString("estado"),
                        rs.getString("fecha_subida_producto"),
                        rs.getString("descripcion_producto"),
                        rs.getString("nombre_producto"),
                        rs.getString("imagen_producto"),
                        rs.getString("precio_producto")
                );
                articulos.add(articulo);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            motorSql.desconectar();
        }
        return articulos;
    }

    public ArrayList<Articulo> upload(String tipo) throws SQLException {
        ArrayList<Articulo> articulos = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTOS WHERE TIPO='" + tipo +"'";
        try {
            //1º)
            motorSql.conectar();

            System.out.println(sql);
            ResultSet rs = motorSql.consultar(sql);

            while (rs.next()) {// TRANSFOMAR LA COLECCIÓN DE BASE DE DATOS A UN ARRAYLIST
                Articulo articulo = new Articulo(
                        rs.getInt("ID_PRODUCTO"),
                        rs.getString("MARCA"),
                        rs.getString("ESTADO"),
                        rs.getString("FECHA"),
                        rs.getString("DESCRIPCION"),
                        rs.getString("NOMBRE"),
                        rs.getString("IMAGEN"),
                        rs.getString("PRECIO")
                );
                articulos.add(articulo);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            motorSql.desconectar();
        }
        return articulos;
    }



    /*
    public static void main(String[] args) {

        ProductoDAO productoDAO = new ProductoDAO();

        ArrayList lstProductos = productoDAO.findAll(null);
        System.out.println(lstProductos.toString());
    }*/

    @Override
    public int add(Articulo entity) throws SQLException {
        int resp = 0;
        try {
            motorSql.conectar();
            String sql = "INSERT INTO `articulos`(`id_producto`, `marca_producto`, `precio_producto`, `imagen_producto`, `nombre_producto`, `descripcion_producto`, `fecha_subida_producto`, `estado`, `id_usuario`) VALUES" + "("
                    + entity.getId() + ", '"
                    + entity.getMarca() + "', '"
                    + entity.getPrecio() + "', '"
                    + entity.getImagen() + "', '"
                    + entity.getNombre() + "', '"
                    + entity.getDescripcion() + "', '"
                    + entity.getFecha() + "', '"
                    + entity.getEstado() + "')";
            resp = motorSql.modificar(sql);
        } catch (Exception e) {
            System.out.println("No se inserto con exito");
        } finally {
            motorSql.desconectar();
        }
        if (resp > 0) {
            System.out.println("Articulo insertado con exito.");
        }
        return resp;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Articulo entity) {
        return 0;
    }
}

