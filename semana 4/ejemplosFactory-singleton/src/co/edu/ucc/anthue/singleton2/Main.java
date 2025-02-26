package co.edu.ucc.anthue.singleton2;

import java.util.Base64;

class Database {
    private static Database instance;
    private Database() { System.out.println("Conectando a la base de datos...🧿🧿🧿"); }
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public void ejecutarConsulta(String consulta) {
        System.out.println("🔂🔂🔂🔂🔂Ejecutando: " + consulta);
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
                Un sistema de gestión de pedidos necesita que la conexión a la base de datos sea única para evitar 
                conflictos y mejorar el rendimiento.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
    public static void main(String[] args) {
        System.out.println(encabezado());
        Database db1 = Database.getInstance();
        db1.ejecutarConsulta("SELECT * FROM pedidos");
        System.out.println("\nIdentidad codificada: " + getIdentidad());
    }
}
