package co.edu.ucc.anthue.sectorTransporteBridge;

import java.util.Base64;

interface ModoReporte {
    void imprimir(String contenido);
}

class Consola implements ModoReporte {
    public void imprimir(String contenido) {
        System.out.println("Reporte en consola: " + contenido);
    }
}

class ArchivoTexto implements ModoReporte {
    public void imprimir(String contenido) {
        System.out.println("Guardando en archivo: " + contenido);
    }
}

abstract class ReporteVehiculo {
    protected ModoReporte salida;

    public ReporteVehiculo(ModoReporte salida) {
        this.salida = salida;
    }

    public abstract void generar(String estado);
}

class ReporteEstado extends ReporteVehiculo {
    public ReporteEstado(ModoReporte salida) {
        super(salida);
    }

    public void generar(String estado) {
        salida.imprimir("Estado del vehículo: " + estado);
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
                 Como supervisor de mantenimiento, quiero que el sistema de monitoreo pueda generar reportes del 
                 estado de los vehículos con distintas salidas: en pantalla, archivo de texto o correo 
                 electrónico, sin modificar la lógica de captura de datos.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron(){
        return "Patron bridge";
    }
    public static void main(String[] args) {
        System.out.println(encabezado());
        ReporteVehiculo reporte = new ReporteEstado(new Consola());
        reporte.generar("Motor funcionando, llantas en buen estado");
        ReporteVehiculo reporteArchivo = new ReporteEstado(new ArchivoTexto());
        reporteArchivo.generar("Motor funcionando, llantas en buen estado");
        System.out.println("\nIdentidad codificada: " + getIdentidad());
        System.out.println("\nPatron implementado: " + getPatron());
    }
}
