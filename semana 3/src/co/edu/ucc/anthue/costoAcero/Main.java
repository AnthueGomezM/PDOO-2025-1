package co.edu.ucc.anthue.costoAcero;

import java.util.Base64;

class LoteAcero {
    private double cantidad; // en toneladas
    private double costoPorTonelada;

    public LoteAcero(double cantidad, double costoPorTonelada) {
        this.cantidad = cantidad;
        this.costoPorTonelada = costoPorTonelada;
    }

    public double calcularCostoTotal() {
        return cantidad * costoPorTonelada;
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
                Como gerente de planta, quiero poder calcular el costo total de producción
                de un lote de acero, para poder planificar el presupuesto.
                ---------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron() {
        return "El patrón implementado es builder";
    }

    public static void main(String[] args) {
        System.out.println(encabezado());

        LoteAcero lote = new LoteAcero(50.0, 1200.0);
        System.out.println("Costo total del lote: $" + lote.calcularCostoTotal());

        System.out.println("Identidad codificada: " + getIdentidad());
        System.out.println(getPatron());
    }
}