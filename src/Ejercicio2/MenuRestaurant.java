package Ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuRestaurant {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Plato> platos = new ArrayList<>();
        int cantidadPlatos = 0;

        System.out.print("Ingrese la cantidad de platos del menú: ");
        cantidadPlatos = s.nextInt();
        s.nextLine();

        for (int i = 0; i < cantidadPlatos; i++) {
            int eleccion = 0;
            System.out.println("----------------------------------------------------------");
            System.out.print("Nombre del plato o bebida: ");
            String nombre = s.nextLine();
            System.out.print("Precio del plato o bebida: ");
            double precio = s.nextDouble();
            do {
                System.out.println("Seleccione el tipo de plato ingresado: \n" +
                        "1) Alimento \n" +
                        "2) Bebida");
                eleccion = s.nextInt();
                s.nextLine();
            } while (eleccion < 1 || eleccion > 2);


            if (eleccion == 1) {
                ArrayList<Ingrediente> ingredientes = new ArrayList<>();

                while (ingredientes.isEmpty()) {
                    System.out.print("Ingrese la cantidad de ingredientes del plato: ");
                    int cantidadIngredientes = s.nextInt();
                    s.nextLine();
                    if (cantidadIngredientes > 0) {
                        for (int j = 0; j < cantidadIngredientes; j++) {
                            System.out.println("----------------------------------------------------------");
                            System.out.print("Nombre del ingrediente: ");
                            String nombreIngrediente = s.nextLine();

                            System.out.print("Cantidad necesaria de " + nombreIngrediente + ": ");
                            double cantidad = s.nextDouble();
                            s.nextLine();

                            System.out.print("Unidad de medida para " + nombreIngrediente + ": ");
                            String unidad = s.nextLine();

                            ingredientes.add(new Ingrediente(nombreIngrediente, cantidad, unidad));
                        }
                    } else {
                        System.out.println("Debe cargar al menos 1 ingrediente");
                    }
                }
                Plato plato = new Plato(nombre, precio, false, ingredientes);
                platos.add(plato);
                System.out.println("Plato añadido al menú...");
            }

            if (eleccion == 2) {
                Plato bebida = new Plato();
                bebida.setNombreCompleto(nombre);
                bebida.setPrecio(precio);
                bebida.setEsBebida(true);
                platos.add(bebida);
                System.out.println("Bebida añadida al menú...");
            }
        }

        System.out.println("========================== MENÚ ===========================");
        for (Plato plato : platos) {
            System.out.println(plato.getNombreCompleto());
            System.out.println("Precio: $" + plato.getPrecio());
            if (!plato.isEsBebida()) {
                System.out.println("Ingredientes: ");
                System.out.printf("%-20s  %-20s  %-20s%n", "Nombre", "Cantidad", "Unidad de medida");
                for (Ingrediente ingrediente : plato.getIngredientes()) {
                    System.out.printf("%-20s  %-20s  %-20s%n", ingrediente.getNombre(), ingrediente.getCantidad(), ingrediente.getUnidadDeMedida());
                }
            }
            System.out.println("-----------------------------------------------------------");
        }
    }
}