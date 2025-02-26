package co.edu.ucc.anthue.singleton1;

import java.util.Base64;

class Logger {
    private static Logger instance;
    private Logger() {}
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

public class Main {
    public static String encabezado() {
        return """
                ------------------------------------------------------------------------------------------------------------
                ****************************
                *        BIENVENIDO A MI   *
                *          PROGRAMA 🚀     *
                *✨✨✨Anthue Gomez✨✨✨*
                ****************************
                
                👷‍♂️istoria de Usuario:
                Una aplicación bancaria necesita registrar eventos de usuario (inicio de sesión, transacciones, errores).
                Para evitar múltiples instancias del Logger y asegurar un control centralizado, se implementa el patrón Singleton.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
    public static void main(String[] args) {
        System.out.println(encabezado());
        Logger logger1 = Logger.getInstance();
        logger1.log("Inicio de sesión");
        Logger logger2 = Logger.getInstance();
        logger2.log("Transacción realizada");
        System.out.println("\nIdentidad codificada: " + getIdentidad());
    }
}