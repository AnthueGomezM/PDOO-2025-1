package co.edu.ucc.anthue.singleton;

import java.util.Base64;

class Banco {
    private static Banco instance;
    private String nombreBanco;

    private Banco() {
        nombreBanco = "Banco Central";
    }

    public static Banco getInstance() {
        if (instance == null) {
            instance = new Banco();
        }
        return instance;
    }

    public void mostrarNombre() {
        System.out.println("Bienvenido al " + nombreBanco);
    }

}

// Uso
public class Main {

    public static String encabezado() {
        return """
                ***********************
                *   BIENVENIDO A MI   *
                *     PROGRAMA 🚀     *
                *       AnthueG       *
                ***********************
                """;
    }

    public static String getIdentidad() {
        String nombreComple = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreComple.getBytes());
    }

    public static void main(String[] args) {
        System.out.println(encabezado());
        Banco banco = Banco.getInstance();
        banco.mostrarNombre();

        System.out.println("Identidad codificada: " + getIdentidad());
    }
}