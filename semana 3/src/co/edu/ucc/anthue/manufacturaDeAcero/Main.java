package co.edu.ucc.anthue.manufacturaDeAcero;

import java.util.ArrayList;
import java.util.List;
import java.util.Base64;

class Maquina {
    private String nombre;
    private double aceroProducido;

    public Maquina(String nombre) {
        this.nombre = nombre;
        this.aceroProducido = 0;
    }

    public void producirAcero(double cantidad) {
        this.aceroProducido += cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAceroProducido() {
        return aceroProducido;
    }
}

class Turno {
    private List<Maquina> maquinas = new ArrayList<>();

    public void agregarMaquina(Maquina maquina) {
        maquinas.add(maquina);
    }

    public void mostrarProduccion() {
        System.out.println("Reporte de Producción:");
        for (Maquina maquina : maquinas) {
            System.out.println("Máquina: " + maquina.getNombre() +
                    " | Acero Producido: " + maquina.getAceroProducido() + " toneladas");
        }
    }
}

public class Main {

    public static String encabezado() {
        return """
                ***********************
                *   BIENVENIDO A MI   *
                *     PROGRAMA 🚀     *
                *       AnthueG       *
                ***********************
                Historia de Usuario:
                Como supervisor de producción, quiero poder registrar
                la cantidad de acero producido por cada máquina en un turno,
                para poder llevar un control de la producción.
                ---------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreComple = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreComple.getBytes());
    }

    public static String getPatron() {
        return "El patrón implementado es builder";
    }

    public static void main(String[] args) {
        System.out.println(encabezado());

        Turno turno = new Turno();
        Maquina maquina1 = new Maquina("Máquina 1");
        Maquina maquina2 = new Maquina("Máquina 2");

        maquina1.producirAcero(5.3);
        maquina2.producirAcero(7.8);

        turno.agregarMaquina(maquina1);
        turno.agregarMaquina(maquina2);

        turno.mostrarProduccion();

        System.out.println("Identidad codificada: " + getIdentidad());
        System.out.println(getPatron());
    }
}