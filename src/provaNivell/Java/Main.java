package provaNivell.Java;

import provaNivell.Exceptions.MostrarClientException;
import provaNivell.Tools;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws MostrarClientException, IOException {
        menu();
    }

    private static void menu() throws MostrarClientException, IOException {

        int option;

        do {
            System.out.println("""
                    \nQue vols fer?
                    1. Crear una factura.
                    2. Crear línies factura a factura existent.
                    3. Calcular import total d'una factura.
                    4. Calcular import total de totes les factures. 
                    5. Mostrar la quantitat de factures d'un client. 
                    6. Mostrar totes les factures d'un client amb última data modificació.
                    7. Mostrar factures d'un client amb lambda.
                    8. Mostrar factures que tenen un determinat article amb lambda.
                    9. Eliminar factura d'una forma obsoleta.
                    10. Escriure totes les factures i línies en un fitxer .txt""");
            option = Tools.getInt("Tria una opció.");

            switch (option){
                case 1 -> menuOptions.crearFactura();
                case 2 -> menuOptions.crearLiniesFactura();
                case 3 -> menuOptions.calcularImportTotalFactura();
                case 4 -> menuOptions.calcularImportTotalTotesFactures();
                case 5 -> menuOptions.mostrarQuantitatFacturesClient();
                case 6 -> menuOptions.mostrarFacturesClientData();
                case 7 -> menuOptions.mostrarFacturesClientLambda();
                case 8 -> menuOptions.mostrarFacturesAmbArticleDeterminat();
                case 9 -> menuOptions.eliminarFactura();
                case 10 -> menuOptions.escriureEnTxt();
            }

        } while (option != 0);


    }
}