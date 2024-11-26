package Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class CargaNotas {
    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        Scanner s = new Scanner(System.in);
        int cantidadAlumnos = 0;

        System.out.print("Ingrese la cantidad de alumnos: ");
        cantidadAlumnos = s.nextInt();
        s.nextLine();

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("----------------------------------------------------------");
            System.out.print("Nombre del alumno " + (i + 1) + ": ");
            String nombre = s.nextLine();

            System.out.print("Legajo del alumno " + nombre + ": ");
            int legajo = s.nextInt();

            ArrayList<Nota> notas = new ArrayList<>();

            while (notas.isEmpty()) {
                System.out.print("Ingrese la cantidad de notas para " + nombre + ": ");
                int cantidadNotas = s.nextInt();
                s.nextLine();

                if (cantidadNotas > 0) {
                    for (int j = 0; j < cantidadNotas; j++) {
                        System.out.print("Denominación de la cátedra: ");
                        String catedra = s.nextLine();
                        System.out.print("Nota examen de " + catedra + ": ");
                        double notaExamen = s.nextDouble();
                        s.nextLine();
                        notas.add(new Nota(catedra, notaExamen));
                    }
                } else {
                    System.out.println("Debe cargar por lo menos una nota");
                }

            }

            Alumno alumno = new Alumno(nombre, legajo, notas);
            alumnos.add(alumno);
        }

        System.out.println("--------------- INFORMACIÓN DE LOS ALUMNOS ---------------");
        for (Alumno alumno : alumnos) {
            System.out.println("Nombre: " + alumno.getNombreCompleto());
            System.out.println("Legajo: " + alumno.getLegajo());
            System.out.println("Notas: ");
            for (Nota nota : alumno.getNotas()) {
                System.out.printf("Cátedra: %-20s Nota: %5.2f%n", nota.getCatedra(), nota.getNotaExamen());
            }
            System.out.println("Promedio: " + alumno.calcularPromedio());
            System.out.println("----------------------------------------------------------");
        }


    }
}