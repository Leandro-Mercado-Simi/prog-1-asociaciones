package Ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class Facturacion {

    private static final String[][] articulos = {
            {"101", "Leche", "25"},
            {"102", "Gaseosa", "30"},
            {"103", "Fideos", "15"},
            {"104", "Arroz", "28"},
            {"105", "Vino", "120"},
            {"106", "Manteca", "20"},
            {"107", "Lavandina", "18"},
            {"108", "Detergente", "46"},
            {"109", "Jabón en polvo", "96"},
            {"110", "Galletas", "60"}
    };

    private static ArrayList<Articulo> llenarArrayListDeArticulos() {
        ArrayList<Articulo> listaArticulos = new ArrayList<>();

        for (int i = 0; i < articulos.length; i++) {
            long codigo = Long.parseLong(articulos[i][0]);
            String descripcion = articulos[i][1];
            double precio = Double.parseDouble(articulos[i][2]);

            Articulo articulo = new Articulo(codigo, descripcion, precio);
            listaArticulos.add(articulo);
        }
        return listaArticulos;
    }

    private static Factura cargarDatosFactura(Scanner s) {
        Factura factura = new Factura();

        System.out.print("Ingrese la fecha de la factura: ");
        factura.setFechaFactura(s.nextLine());

        long numeroFactura;
        do {
            System.out.print("Ingrese el número de la factura (entero mayor a 0): ");
            numeroFactura = s.nextLong();
        } while (numeroFactura <= 0);
        factura.setNumeroFactura(numeroFactura);

        s.nextLine();

        String cliente;
        do {
            System.out.print("Ingrese el nombre del cliente: ");
            cliente = s.nextLine();
        } while (cliente.isEmpty());
        factura.setCliente(cliente);

        return factura;

    }

    private static void menuDeArticulosParaFactura(Scanner s, Factura factura, ArrayList<Articulo> listadoArticulos) {

        ArrayList<DetalleFactura> detalles = new ArrayList<>();

        boolean finalizar = false;

        System.out.println("---------------    Artículos disponibles    ---------------");
        for (Articulo articulo : listadoArticulos) {
            System.out.printf("Código: %d | Descripción: %s | Precio: %.2f%n",
                    articulo.getCodigo(), articulo.getDescripcion(), articulo.getPrecio());
        }
        while (!finalizar) {
            System.out.println("-----------------------------------------------------------");
            System.out.print("Ingrese el código del artículo para añadir o 0 para finalizar: ");
            long codigoIngresado = s.nextLong();

            if (codigoIngresado == 0) {
                finalizar = true;
                break;
            }

            Articulo articuloSeleccionado = listadoArticulos.stream()
                    .filter(articulo -> articulo.getCodigo() == codigoIngresado)
                    .findFirst()
                    .orElse(null);

            if (articuloSeleccionado == null) {
                System.out.println("El código ingresado no existe, intente nuevamente");
                continue;
            }

            System.out.print("Ingrese la cantidad a facturar: ");
            int cantidad = s.nextInt();

            s.nextLine();

            double descuentoItem = articuloSeleccionado.getPrecio() * 0.1;
            double subTotal = (articuloSeleccionado.getPrecio() * cantidad) - (descuentoItem * cantidad);
            DetalleFactura detalle = new DetalleFactura();
            detalle.setCodigoArticulo(String.valueOf(articuloSeleccionado.getCodigo()));
            detalle.setNombreArticulo(articuloSeleccionado.getDescripcion());
            detalle.setCantidad(cantidad);
            detalle.setPrecioUnitario(articuloSeleccionado.getPrecio());
            detalle.setDescuentoItem(descuentoItem);
            detalle.setSubtotal(subTotal);

            detalles.add(detalle);
        }

        factura.setDetallesFactura(detalles);
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        ArrayList<Articulo> listadoArticulos = llenarArrayListDeArticulos();

        Factura factura = cargarDatosFactura(s);

        menuDeArticulosParaFactura(s, factura, listadoArticulos);

        factura.calcularMontoTotal();

        System.out.println("-----------------------------------------     FACTURA     -----------------------------------------");
        System.out.printf("%-10s %-20s%n", "Fecha: ", factura.getFechaFactura());
        System.out.printf("%-10s %-20s%n", "Número: ", factura.getNumeroFactura());
        System.out.printf("%-10s %-20s%n", "Cliente: ", factura.getCliente());
        System.out.println("-----------------------------------------     DETALLE     -----------------------------------------");
        System.out.printf("%-20s  %-20s  %-20s %-20s %-20s%n", "Código Artículo", "Nombre Artículo", "Precio Unitario", "Descuento", "Subtotal");
        for (DetalleFactura detalle : factura.getDetallesFactura()) {
            System.out.printf("%-20s  %-20s  %-20s %-20s %-20s%n", detalle.getCodigoArticulo(), detalle.getNombreArticulo(), detalle.getPrecioUnitario(), detalle.getDescuentoItem(), detalle.getSubtotal());
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.printf("%90s %-20s%n", "Total: ", factura.getTotalCalculadoFactura());


    }
}
