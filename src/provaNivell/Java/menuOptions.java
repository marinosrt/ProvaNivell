package provaNivell.Java;

import provaNivell.Class.Factura;
import provaNivell.Class.LineasFactura;
import provaNivell.Exceptions.MostrarClientException;
import provaNivell.Tools;
import provaNivell.TxtFile.SavingIntoTxtFactura;
import provaNivell.TxtFile.SavingIntoTxtLineaFactura;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class menuOptions {

    //List de factures, amb un arrayList dins de cada factura amb les seves linies.
    static List<Factura> facturaList = new ArrayList<>();

    private static int facturaExisteix(String missatge) {
        int relatedFactura = 0;
        int IDfactura = 0;
        boolean exit = false;
        int k = 0;

        //demanem factura i mirem si la factura existeix
        relatedFactura = Tools.getInt(missatge);

        do {
            if (facturaList.get(k).getIDFactura() == relatedFactura){
                IDfactura = facturaList.get(k).getIDFactura();
                exit = true;
            }
            k++;
        } while (!exit && k < facturaList.size());

        return IDfactura;

    }
    public static void crearFactura() {

        facturaList.add(new Factura(Tools.getString("\nNom Client"),
                Tools.getString("Direccio Client"),
                Tools.getString("TelefonClient")));
        System.out.println("\nFactura generada i guardada!");

    }
    public static void crearLiniesFactura() {
        int IDfactura = facturaExisteix("\nA quina factura vols crear-li una linea?");

        if (IDfactura != 0){
            facturaList.stream()
                    .filter(factura -> factura.getIDFactura() == IDfactura)
                    .findAny()
                    .ifPresent(factura -> factura.addLiniaFactura(new LineasFactura(Tools.getInt("Nº factura relacionada"),
                            Tools.getString("Nom article"),
                            Tools.getString("Descripcio article"),
                            Tools.getInt("Quantitat articles"),
                            Tools.getDouble("Preu article"))));
            System.out.println("\nLinia afegida amb èxit!");
        } else {
            System.out.println("\nAquesta factura no existeix.");
        }


    }
    public static void calcularImportTotalFactura() {
        double totalFactura;
        int IDfactura = facturaExisteix("\nDe quina factura vols calcular-ne el total?");

        if (IDfactura != 0){
            //find total factura
            totalFactura = facturaList.stream()
                    .filter(factura -> factura.getIDFactura() == IDfactura)
                    .findAny()
                    .map(Factura::getTotalFactura)
                    .orElse(0.0);

            System.out.println("\nLa factura nº" + IDfactura + ", té un total de :" + totalFactura + "€.");
        } else {
            System.out.println("\nAquesta factura no existeix.");
        }
    }

    public static void calcularImportTotalTotesFactures() {

        double importTotalFactures = 0;

        for (int i = 0; i < facturaList.size(); i++){
            importTotalFactures = importTotalFactures + facturaList.get(i).getTotalFactura();
        }

        System.out.println("\nTotes les factures acumulen un total de: " + importTotalFactures);

    }

    public static void mostrarQuantitatFacturesClient() throws MostrarClientException {

        String client;
        int totalFacturesClient = 0;

        client = Tools.getString("\nDe quin client vols saber quantes factures té?");

        for (int k = 0; k < facturaList.size(); k++){
            if (facturaList.get(k).getNomClient().equalsIgnoreCase(client)){
                totalFacturesClient++;
            }
        }

        if (totalFacturesClient > 0){
            System.out.println("\nAquest client té un total de " + totalFacturesClient + " factures.");
        } else {
            throw new MostrarClientException("\nAquest client no té cap factura.");
        }

    }

    public static void mostrarFacturesClientData() {

        String client;

        client = Tools.getString("\nDe quin client vols mostrar les seves factures?");

        for (int i = 0; i < facturaList.size(); i++){
            if (facturaList.get(i).getNomClient().equalsIgnoreCase(client)){
                facturaList.get(i).mostrarFacturaCompleta();
            }
        }

    }

    public static void mostrarFacturesClientLambda() {

        String client;

        client = Tools.getString("\nDe quin client vols mostrar les seves factures?");

        facturaList.stream()
                .filter(factura -> factura.getNomClient().equalsIgnoreCase(client))
                .forEach(Factura::mostrarFacturaCompleta);

    }

    public static void mostrarFacturesAmbArticleDeterminat() {

        String article;

        article = Tools.getString("\nQuin és l'article del que vols mostrar totes les factures on apareix?");

        facturaList.forEach(factura -> factura.getListLineas().stream()
                        .filter(linea -> linea.getNomArticulo().equalsIgnoreCase(article))
                        .forEach(fila -> System.out.println("\nL'article " + article + " apareix en les seguents factures:\n" +
                                "Factura nº" + factura.getIDFactura() + " del client: " + factura.getNomClient() + "\n" + fila.toString())));

    }

    @Deprecated
    public static void eliminarFactura() {

        int IDfactura = facturaExisteix("\nQuin nº de factura vols eliminar?");

        if (IDfactura != 0){
            facturaList.removeIf(factura -> factura.getIDFactura() == IDfactura);
            System.out.println("\nFactura eliminada amb èxit!");
        } else {
            System.out.println("\nAquesta factura no existeix!");
        }


    }

    public static void escriureEnTxt() throws IOException {

        SavingIntoTxtFactura.readList(facturaList, "factures.txt");
        SavingIntoTxtLineaFactura.readList(facturaList, "linies.txt");

        System.out.println("\nArxius .txt creats amb èxit!");

    }

}
