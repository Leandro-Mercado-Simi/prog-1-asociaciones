package Ejercicio1;

import java.util.ArrayList;

public class Alumno {
    private String nombreCompleto;
    private long legajo;
    private ArrayList<Nota> notas;

    public Alumno() {

    }

    public Alumno(String nombreCompleto, long legajo, ArrayList<Nota> notas) {
        this.nombreCompleto = nombreCompleto;
        this.legajo = legajo;
        this.notas = notas;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public long getLegajo() {
        return legajo;
    }

    public void setLegajo(long legajo) {
        this.legajo = legajo;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    public double calcularPromedio() {
        double suma = 0;
        if (!this.notas.isEmpty()) {
            for (Nota nota : this.notas) {
                suma += nota.getNotaExamen();
            }
            return suma / this.notas.size();
        } else {
            System.out.println("No se han cargado notas para el alumno");
            return 0;
        }
    }
}
