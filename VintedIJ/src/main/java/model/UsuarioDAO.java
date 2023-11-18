package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO implements DAO<Usuario, Integer> {

    private MotorSQL motorSql;

    public UsuarioDAO() {
        motorSql = new MotorSQL();
    }

    @Override
    public ArrayList<Usuario> findAll(Usuario entity) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIOS";

        try {
            motorSql.conectar();

            System.out.println(sql);
            ResultSet rs = motorSql.consultar(sql);

            while (rs.next()) {// TRANSFOMAR LA COLECCIÓN DE BASE DE DATOS A UN ARRAYLIST
                Usuario usuario = new Usuario(
                        rs.getInt("ID_USUARIO"),
                        rs.getString("NOMBRE"),
                        rs.getString("CORREO"),
                        rs.getString("CONTRASENA"),
                        rs.getString("APELLIDO1"),
                        rs.getString("APELLIDO2"),
                        rs.getString("USER")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            motorSql.desconectar();
        }
        return usuarios;
    }

    public ArrayList<Usuario> findAllUsers(Usuario entity) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIOS WHERE TIPO = 'usuario'";
        try {
            motorSql.conectar();
            System.out.println(sql);
            ResultSet rs = motorSql.consultar(sql);

            while (rs.next()) {// TRANSFOMAR LA COLECCIÓN DE BASE DE DATOS A UN ARRAYLIST
                Usuario usuario = new Usuario(
                        rs.getInt("ID_USUARIO"),
                        rs.getString("NOMBRE"),
                        rs.getString("CORREO"),
                        rs.getString("CONTRASENA"),
                        rs.getString("APELLIDO1"),
                        rs.getString("APELLIDO2"),
                        rs.getString("USER")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.desconectar();
        }
        return usuarios;
    }

//    public ArrayList<Usuario> findAllStaff(Usuario entity) {
//        ArrayList<Usuario> usuarios = new ArrayList<>();
//        String sql = "SELECT * FROM USUARIOS WHERE TIPO = 'staff'";
//        try {
//            motorSql.conectar();
//            System.out.println(sql);
//            ResultSet rs = motorSql.consultar(sql);
//
//            while (rs.next()) {// TRANSFOMAR LA COLECCIÓN DE BASE DE DATOS A UN ARRAYLIST
//                Usuario usuario = new Usuario(
//                        rs.getInt("ID_USUARIO"),
//                        rs.getString("NOMBRE"),
//                        rs.getString("EMAIL"),
//                        rs.getString("CONTRASENA"),
//                        rs.getString("TIPO")
//                );
//                usuarios.add(usuario);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        } finally {
//            motorSql.desconectar();
//        }
//        return usuarios;
//    }

    @Override
    public int add(Usuario entity) throws SQLException {
        int resp = 0;
        try {
            motorSql.conectar();
            String sql = "INSERT INTO USUARIOS VALUES" + "("
                    + entity.getId() + ", '"
                    + entity.getNombre() + "', '"
                    + entity.getEmail() + "', '"
                    + entity.getContrasena() + "', '"
                    + entity.getApellido1() + "', '"
                    + entity.getApellido2() + "', '"
                    + entity.getUser() + "')";
            resp = motorSql.modificar(sql);
        } catch (Exception e) {
            System.out.println("No se inserto con exito");
        } finally {
            motorSql.desconectar();
        }
        if (resp > 0) {
            System.out.println("Usuario insertado con exito.");
        }
        return resp;
    }

    @Override
    public int delete(Integer e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
