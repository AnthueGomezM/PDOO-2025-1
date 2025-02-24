package co.edu.ucc.anthue.recreacion;

import java.util.HashMap;
import java.util.Map;
import java.util.Base64;

class CanchaReserva {
    private static CanchaReserva instance;
    private Map<String, String> reservas = new HashMap<>();

    private CanchaReserva() {}

    public static CanchaReserva getInstance() {
        if (instance == null) {
            instance = new CanchaReserva();
        }
        return instance;
    }

    public boolean reservarCancha(String fecha, String hora, String usuario) {
        String clave = fecha + " " + hora;
        if (reservas.containsKey(clave)) {
            return false; // Ya está reservada
        }
        reservas.put(clave, usuario);
        return true;
    }

    public void mostrarReservas() {
        System.out.println("Reservas Registradas:");
        for (Map.Entry<String, String> entry : reservas.entrySet()) {
            System.out.println("Fecha y Hora: " + entry.getKey() + " | Usuario: " + entry.getValue());
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
                Como usuario, quiero poder reservar una cancha de fútbol
                para un día y hora específicos, para poder jugar con mis amigos.
                ---------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreComple = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreComple.getBytes());
    }

    public static String getPatron() {
        return "El patrón implementado es singleton";
    }

    public static void main(String[] args) {
        System.out.println(encabezado());

        CanchaReserva cancha = CanchaReserva.getInstance();
        cancha.reservarCancha("2023-10-15", "18:00", "Juan Pérez");
        cancha.reservarCancha("2023-10-15", "20:00", "Carlos Gómez");
        cancha.mostrarReservas();

        System.out.println("Identidad codificada: " + getIdentidad());
        System.out.println(getPatron());
    }
}