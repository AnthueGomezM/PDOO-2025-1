package co.edu.ucc.anthue.transporteTurismo;

import java.util.Base64;
import java.util.Queue;
import java.util.LinkedList;

// Clase que representa una conexión a la base de datos
class ConexionDB {
    private String id;

    public ConexionDB(String id) {
        this.id = id;
        System.out.println("Nueva conexión creada: " + id);
    }

    public void ejecutarConsulta(String consulta) {
        System.out.println("Ejecutando consulta en " + id + ": " + consulta);
    }
}

// Implementación del Object Pool
class PoolConexiones {
    private Queue<ConexionDB> pool;
    private int limite;

    public PoolConexiones(int limite) {
        this.limite = limite;
        this.pool = new LinkedList<>();
        for (int i = 0; i < limite; i++) {
            pool.add(new ConexionDB("Conexion-" + (i + 1)));
        }
    }

    public ConexionDB obtenerConexion() {
        if (!pool.isEmpty()) {
            return pool.poll();
        } else {
            System.out.println("No hay conexiones disponibles, espere...");
            return null;
        }
    }

    public void liberarConexion(ConexionDB conexion) {
        pool.offer(conexion);
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
                
                👷‍♂️historia de Usuario:
                 Como operador de una agencia de turismo, necesito un sistema que administre un conjunto de vehículos 
                 turísticos para que puedan ser asignados a clientes cuando estén disponibles y devueltos al sistema 
                 una vez finalizado el recorrido, optimizando el uso de los recursos sin necesidad de crear nuevas instancias de vehículos.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
    public static void main(String[] args) {
        System.out.println(encabezado());
        PoolConexiones pool = new PoolConexiones(2);

        ConexionDB c1 = pool.obtenerConexion();
        ConexionDB c2 = pool.obtenerConexion();
        ConexionDB c3 = pool.obtenerConexion(); // No hay conexiones disponibles

        c1.ejecutarConsulta("SELECT * FROM usuarios");
        pool.liberarConexion(c1);

        ConexionDB c4 = pool.obtenerConexion(); // Ahora sí hay conexión disponible
        c4.ejecutarConsulta("INSERT INTO transacciones VALUES (1, 100)");
        System.out.println("\nIdentidad codificada: " + getIdentidad());
    }
}
