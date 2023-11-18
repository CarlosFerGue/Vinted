package action;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Articulo;
import model.ArticuloDAO;

public class ProductoAction implements IAction {

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
                cadDestino = upload(request, response);
                break;
//            case "FILTER":
//                cadDestino = findByFilter(request, response);
//                break;
//            case "PRICE":
//                cadDestino = findByPrice(request, response);
//                break;
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
        String tipo = request.getParameter("FILTRO");
        ArrayList<Articulo> articulos = articuloDAO.filterType(tipo);
        return Articulo.toArrayJSon(articulos);
    }

    private String upload(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ArticuloDAO articuloDAO = new ArticuloDAO();
        String tipo = request.getParameter("RANGO");
        ArrayList<Articulo> articulos = articuloDAO.filterType(tipo);
        return Articulo.toArrayJSon(articulos);
    }
}
