import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ParserConfigurationException, IOException, SAXException {
        String accionUsuario = "";
        String tabla = "";

        String eleccionUsuario = new Scanner(System.in).nextLine();

        //Cambiar los numeros por las peticiones de Android

        switch (eleccionUsuario) {
            case "1":
                accionUsuario = "MOSTRAR_TODO";
                break;
            case "2":
                accionUsuario = "EXPORTAR";
                break;
            case "3":
                accionUsuario = "IMPORTAR";
                break;
        }

        System.out.println("¿Que tabla deseas " + accionUsuario + "?");
        System.out.println("1 - Artículos.");
        System.out.println("2 - Particulares.");
        System.out.println("3 - Tickets.");
        System.out.println("4 - Direcciones.");

        String seleccionarTabla = new Scanner(System.in).nextLine();

        switch (seleccionarTabla) {
            case "1":
                tabla = "ARTICULOS";
//                break;
//            case "2":
//                tabla = "PARTICULARES";
//                break;
//            case "3":
//                tabla = "TICKETS";
//                break;
//            case "4":
//                tabla = "DIRECCIONES";
//                break;
        }

        Controller.ejecutar(tabla,accionUsuario);

    }
}