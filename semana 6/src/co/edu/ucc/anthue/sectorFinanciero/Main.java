package co.edu.ucc.anthue.sectorFinanciero;

import java.util.Base64;

interface Prestamo {
    void mostrarDetalles();
}

class PrestamoHipotecario implements Prestamo {
    @Override
    public void mostrarDetalles() {
        System.out.println("Préstamo Hipotecario: tasa 5%, plazo 30 años");
    }
}

class PrestamoAutomotriz implements Prestamo {
    @Override
    public void mostrarDetalles() {
        System.out.println("Préstamo Automotriz: tasa 7%, plazo 5 años");
    }
}

class PrestamoPersonal implements Prestamo {
    @Override
    public void mostrarDetalles() {
        System.out.println("Préstamo Personal: tasa 10%, plazo 3 años");
    }
}

class FabricaPrestamo {
    public static Prestamo obtenerPrestamo(String tipo) {
        switch (tipo.toLowerCase()) {
            case "hipotecario":
                return new PrestamoHipotecario();
            case "automotriz":
                return new PrestamoAutomotriz();
            case "personal":
                return new PrestamoPersonal();
            default:
                throw new IllegalArgumentException("Tipo de préstamo no válido");
        }
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
                  Como desarrollador de un banco digital, necesito un sistema que permita a los clientes 
                  solicitar diferentes tipos de préstamos (hipotecario, automotriz, personal) con diferentes 
                  tasas de interés y plazos. El sistema debe garantizar que las reglas de negocio sean aplicadas 
                  correctamente según el tipo de préstamo seleccionado.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
    public static void main(String[] args) {
        System.out.println(encabezado());
        Prestamo prestamo1 = FabricaPrestamo.obtenerPrestamo("hipotecario");
        Prestamo prestamo2 = FabricaPrestamo.obtenerPrestamo("automotriz");
        Prestamo prestamo3 = FabricaPrestamo.obtenerPrestamo("personal");

        prestamo1.mostrarDetalles();
        prestamo2.mostrarDetalles();
        prestamo3.mostrarDetalles();
        System.out.println("\nIdentidad codificada: " + getIdentidad());
    }
}