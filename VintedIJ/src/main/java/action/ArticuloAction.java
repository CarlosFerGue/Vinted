package action;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Articulo;
import model.ArticuloDAO;

public class ArticuloAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "FIND_ALL":
                cadDestino = findAll(request, response);
                break;
            case "FILTER_USUARIO": //Los que has subido tu como usuario
                cadDestino = findByFilter(request, response);
                break;
            case "DAR_ALTA": //Subes tus productos
                System.out.println("Voy a entrar olii");
                upload(request, response);
                break;
        }
        return cadDestino;
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ArticuloDAO articuloDAO = new ArticuloDAO();
        ArrayList<Articulo> articulos = articuloDAO.findAll(null);
        return Articulo.toArrayJSon(articulos);
    }

    private String findByFilter(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ArticuloDAO articuloDAO = new ArticuloDAO();
        String id_usuario = request.getParameter("ID_USUARIO");
        ArrayList<Articulo> articulos = articuloDAO.filterType(id_usuario);
        return Articulo.toArrayJSon(articulos);
    }


    //http://localhost:8080/Controller?ACTION=PRODUCTOS.DAR_ALTA&NOMBRE=sa&MARCA=se&ID=53&PRECIO=12&IMAGEN=s&DESCRIPCION=sasa&FECHA=23&ESTADO=bIEN
    private int upload(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        System.out.println("He entrado xddd");
//        String nombre = request.getParameter("NOMBRE"); //en verde el nombre de la tabla URL
//        String marca = request.getParameter("MARCA");
//        String precioString = request.getParameter("PRECIO");
//        String imagen = request.getParameter("IMAGEN");
//        String descripcion = request.getParameter("DESCRIPCION");
//        String fecha = request.getParameter("FECHA");
//        String estado = request.getParameter("ESTADO");
//        String idUsuario = request.getParameter("ID");
//        int precio = Integer.parseInt(precioString);
//        int idUsuarioInt = Integer.parseInt(idUsuario);
        String idUsuario = request.getParameter("ID");


        int idUsuarioInt = Integer.parseInt(idUsuario);
        String marca = request.getParameter("MARCA");
        String precio = request.getParameter("PRECIO");
        String imagen = request.getParameter("IMAGEN");
        String nombre = request.getParameter("NOMBRE");
        String descripcion = request.getParameter("DESCRIPCION");
        String fecha = request.getParameter("FECHA");
        String estado = request.getParameter("ESTADO");
        Articulo articulo = new Articulo(idUsuarioInt, marca,
        precio, imagen, nombre, descripcion, fecha, estado);
        ArticuloDAO ariticuloDAO = new ArticuloDAO();
        return ariticuloDAO.add(articulo);
    }
}
