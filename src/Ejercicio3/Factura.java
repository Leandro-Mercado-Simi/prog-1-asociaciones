package Ejercicio3;

import java.util.ArrayList;

public class Factura {

    private String fechaFactura;
    private long numeroFactura;
    private double totalCalculadoFactura;
    private String cliente;
    private ArrayList<DetalleFactura> detallesFactura;

    public Factura(String fechaFactura, long numeroFactura, double totalCalculadoFactura, String cliente, ArrayList<DetalleFactura> detallesFactura) {
        this.fechaFactura = fechaFactura;
        this.numeroFactura = numeroFactura;
        this.totalCalculadoFactura = totalCalculadoFactura;
        this.cliente = cliente;
        this.detallesFactura = detallesFactura;
    }

    public Factura() {
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public double getTotalCalculadoFactura() {
        return totalCalculadoFactura;
    }

    public void setTotalCalculadoFactura(double totalCalculadoFactura) {
        this.totalCalculadoFactura = totalCalculadoFactura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public ArrayList<DetalleFactura> getDetallesFactura() {
        return detallesFactura;
    }

    public void setDetallesFactura(ArrayList<DetalleFactura> detallesFactura) {
        this.detallesFactura = detallesFactura;
    }

    public void calcularMontoTotal() {
        double totalCalculado = 0;
        for (DetalleFactura detalle : this.detallesFactura) {
            totalCalculado += detalle.getSubtotal();
        }
        this.totalCalculadoFactura = totalCalculado;
    }
}
