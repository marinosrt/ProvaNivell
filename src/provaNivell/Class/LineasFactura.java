package provaNivell.Class;

public class LineasFactura {

    private static int id = 1;
    private int idLineaFactura;
    private int numRelatedFactura;
    private String articulo;
    private String despripcioArt;
    private int cantidad;
    private double precio;


    public LineasFactura(int numRelatedFactura, String articulo, String despripcioArt, int cantidad, double precio) {
        idLineaFactura = LineasFactura.id++;
        this.numRelatedFactura = numRelatedFactura;
        this.articulo = articulo;
        this.despripcioArt = despripcioArt;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNomArticulo() {
        return articulo;
    }

    public int getNumLineaFactura() {
        return idLineaFactura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getTotalPreu(){
        return getCantidad()*getPrecio();
    }

    public int getNumRelatedFactura() {
        return numRelatedFactura;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Articule: ").append(articulo).append("\n")
                .append("Descripcio: ").append(despripcioArt).append("\n")
                .append("Quantitat: ").append(cantidad).append("\n")
                .append("Preu: ").append(precio).append("€.");
        return sb.toString();
    }
}
