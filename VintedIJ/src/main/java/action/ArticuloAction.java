package action;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Articulo;
import model.ArticuloDAO;
import model.Usuario;
import model.UsuarioDAO;

public class ArticuloAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "FIND_ALL": //Este es un findall en el que no te salen los productos de ti mismo.
                cadDestino = findAll(request, response);
                break;
            case "FILTER_USUARIO": //Los que has subido tu como usuario
                cadDestino = findByFilter(request, response);
                break;
            case "DAR_ALTA": //Subes tus productos
                darAlta(request, response);
                break;
            case "PUNTUAR":
                puntuar(request, response);
                break;
            case "TOP10": //Top 10 productos con mas reseñas
                cadDestino = find10(request, response);
                break;
            case "ESTADO":
                cadDestino = estado(request, response);
                break;
            case "PALABRA":
                cadDestino = palabra(request, response);
                break;
            case "COMPRAR":
                cadDestino = comprar(request, response);
                break;

        }
        return cadDestino;
    }

    private int comprar(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ArticuloDAO articuloDAO = new ArticuloDAO();

        String idArticulo = request.getParameter("ID_ARTICULO");
        int idInt = Integer.parseInt(idArticulo);
        String idUsuario = request.getParameter("ID_USUARIO");
        int idInt = Integer.parseInt(idUsuario);


        Articulo articulo = new Articulo(idInt, valoracion);
        ArticuloDAO ariticuloDAO = new ArticuloDAO();
        System.out.println(ariticuloDAO.update(articulo));
        return ariticuloDAO.update(articulo);
    }

    private String palabra(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String idUsuario = request.getParameter("ID");
        int idInt = Integer.parseInt(idUsuario);
        String palabra = request.getParameter("PALABRA");

        ArticuloDAO articuloDAO = new ArticuloDAO();
        ArrayList<Articulo> articulos = articuloDAO.palabra(palabra, idInt);
        return Articulo.toArrayJSon(articulos);
    }

    private String estado(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String estado2;
        String idUsuario = request.getParameter("ID");
        int idInt = Integer.parseInt(idUsuario);
        String estado = request.getParameter("ESTADO");

        if (estado.equals("Active")) {
            estado2 = "='Active";
        } else {
            estado2 = "!='Active";
        }

        ArticuloDAO articuloDAO = new ArticuloDAO();
        ArrayList<Articulo> articulos = articuloDAO.estado(estado2, idInt);
        return Articulo.toArrayJSon(articulos);
    }

    private int puntuar(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ArticuloDAO articuloDAO = new ArticuloDAO();

        String idArticulo = request.getParameter("ID");
        int idInt = Integer.parseInt(idArticulo);
        String valoracion = request.getParameter("VALORACION");


        Articulo articulo = new Articulo(idInt, valoracion);
        ArticuloDAO ariticuloDAO = new ArticuloDAO();
        System.out.println(ariticuloDAO.update(articulo));
        return ariticuloDAO.update(articulo);
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ArticuloDAO articuloDAO = new ArticuloDAO();
        String id_usuario = request.getParameter("ID");
        ArrayList<Articulo> articulos = articuloDAO.findAllProductos(id_usuario);
        return Articulo.toArrayJSon(articulos);
    }

    private String findByFilter(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ArticuloDAO articuloDAO = new ArticuloDAO();
        String id_usuario = request.getParameter("ID");
        ArrayList<Articulo> articulos = articuloDAO.filterType(id_usuario);
        return Articulo.toArrayJSon(articulos);
    }


    //http://localhost:8080/Controller?ACTION=PRODUCTOS.DAR_ALTA&NOMBRE=sa&MARCA=se&ID=53&PRECIO=12&IMAGEN=s&DESCRIPCION=sasa&FECHA=23&ESTADO=bIEN
    private int darAlta(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//        String idUsuario = request.getParameter("ID");
//
//        if (idUsuario == null) {
//            int idUsuarioInt = 1;
//        }else{
//            int idUsuarioInt = Integer.parseInt(idUsuario);
//        }
//        int idUsuarioInt = 1; //hay que fixear esta mierda

//        String marca = request.getParameter("MARCA");
//        String precio = request.getParameter("PRECIO");
//        String imagen = request.getParameter("IMAGEN");
//        String nombre = request.getParameter("NOMBRE");
//        String descripcion = request.getParameter("DESCRIPCION");
//        String fecha = request.getParameter("FECHA");
//        String estado = request.getParameter("ESTADO");
//        String valoracion = request.getParameter("VALORACION");
        System.out.println("Sexy");
        String idUsuario = request.getParameter("ID");
        int idInt = Integer.parseInt(idUsuario);
        String color = request.getParameter("COLOR");
        String precio = request.getParameter("PRECIO");
        String nombre = request.getParameter("NOMBRE");
        String marca = request.getParameter("MARCA");
        String descripcion = request.getParameter("DESCRIPCION");


        Articulo articulo = new Articulo(idInt, color, precio, nombre, marca, descripcion, "Active");
        ArticuloDAO ariticuloDAO = new ArticuloDAO();
        return ariticuloDAO.add(articulo);
    }

    private String find10(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ArticuloDAO articuloDAO = new ArticuloDAO();
        ArrayList<Articulo> articulos = articuloDAO.find10(null);
        return Articulo.toArrayJSon(articulos);
    }
}
