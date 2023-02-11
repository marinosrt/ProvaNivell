package provaNivell.Class;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura {

    private static int id = 1;
    private int idFactura;
    private String nomClient;
    private String direccio;
    private String telefon;
    private double totalFactura = 0;
    private Date dataModificacio;

    private List<LineasFactura> lineasFacturaList;

    public Factura(String nomClient, String direccio, String telefon) {
        idFactura = id++;
        this.nomClient = nomClient;
        this.direccio = direccio;
        this.telefon = telefon;
        this.lineasFacturaList = new ArrayList<>();
        this.dataModificacio = new Date();
    }

    //getters
    public int getIDFactura() {
        return idFactura;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getDireccio() {
        return direccio;
    }

    public String getTelefon() {
        return telefon;
    }

    public List<LineasFactura> getListLineas(){
        return lineasFacturaList;
    }

    public double getTotalFactura() {
        for (int i = 0; i < lineasFacturaList.size(); i++){
            totalFactura = lineasFacturaList.get(i).getTotalPreu();
        }
        return totalFactura;
    }

    public String getDataModificacio() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(dataModificacio);
    }

    //metode per afegir linea factura a la factura actual
    public void addLiniaFactura(LineasFactura lineasFactura){
        lineasFacturaList.add(lineasFactura);
        actualitzarData();
    }

    //toString personalitzat
    public void mostrarFacturaCompleta(){

        System.out.println("Factura nº" + idFactura + " del client " + nomClient + ".\n" +
                direccio + ", telèfon " + telefon + ". TOTAL FACTURA: " + getTotalFactura() + "€.\n" +
                "Última data modificació: " + getDataModificacio() + "\n" +
                "Linies de la factura:");
        lineasFacturaList.forEach(linea -> System.out.println(linea.toString()));

    }

    //metode per anar actualitzant data conforme es fan canvis
    public void actualitzarData(){
        this.dataModificacio = new Date();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura nº").append(idFactura).append(" del client ").append(nomClient).append(".\n")
                .append(direccio).append(", telèfon ").append(telefon).append(". TOTAL FACTURA: ").append(getTotalFactura()).append("€.\n")
                .append("Última data modificació: ").append(getDataModificacio()).append("\n")
                .append("Linies de la factura:\n");
        return sb.toString();
    }
}
