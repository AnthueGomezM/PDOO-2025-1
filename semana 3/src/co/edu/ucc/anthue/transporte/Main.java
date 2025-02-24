package co.edu.ucc.anthue.transporte;

import java.util.Base64;

class Boleto {
    private String viaje;
    private String pasajero;

    public Boleto(String viaje, String pasajero) {
        this.viaje = viaje;
        this.pasajero = pasajero;
    }

    public void mostrarBoleto() {
        System.out.println("Viaje: " + viaje + ", Pasajero: " + pasajero);
    }
}

class Autobus {
    public Boleto comprarBoleto(String viaje, String pasajero) {
        return new Boleto(viaje, pasajero);
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
                Como pasajero, quiero poder comprar un boleto de autobús
                para un viaje específico, para poder viajar a mi destino.
                ---------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron() {
        return "El patrón implementado es factory";
    }

    public static void main(String[] args) {
        System.out.println(encabezado());

        Autobus autobus = new Autobus();
        Boleto boleto = autobus.comprarBoleto("Ciudad A - Ciudad B", "Juan Pérez");
        boleto.mostrarBoleto();

        System.out.println("Identidad codificada: " + getIdentidad());
        System.out.println(getPatron());
    }
}