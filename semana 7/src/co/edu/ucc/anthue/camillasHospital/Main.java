package co.edu.ucc.anthue.camillasHospital;

import java.util.Base64;
import java.util.Queue;
import java.util.LinkedList;

class Camilla {
    private String id;

    public Camilla(String id) {
        this.id = id;
        System.out.println("Nueva camilla disponible: " + id);
    }

    public void asignarPaciente(String paciente) {
        System.out.println("Camilla " + id + " asignada a paciente " + paciente);
    }
}

class PoolCamillas {
    private Queue<Camilla> pool;
    private int limite;

    public PoolCamillas(int limite) {
        this.limite = limite;
        this.pool = new LinkedList<>();
        for (int i = 0; i < limite; i++) {
            pool.add(new Camilla("Camilla-" + (i + 1)));
        }
    }

    public Camilla obtenerCamilla() {
        if (!pool.isEmpty()) {
            return pool.poll();
        } else {
            System.out.println("No hay camillas disponibles, espere...");
            return null;
        }
    }

    public void liberarCamilla(Camilla camilla) {
        pool.offer(camilla);
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
                 Como director de un hospital, necesito administrar las camillas de urgencias para que puedan ser asignadas 
                 a pacientes cuando sea necesario y liberadas una vez finalizada la atención, evitando la sobreasignación 
                 de camillas y asegurando su reutilización eficiente.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
    public static void main(String[] args) {
        System.out.println(encabezado());
        PoolCamillas pool = new PoolCamillas(3);

        Camilla c1 = pool.obtenerCamilla();
        Camilla c2 = pool.obtenerCamilla();

        c1.asignarPaciente("María");
        pool.liberarCamilla(c1);

        Camilla c3 = pool.obtenerCamilla();
        c3.asignarPaciente("Pedro");
        System.out.println("\nIdentidad codificada: " + getIdentidad());
    }
}
