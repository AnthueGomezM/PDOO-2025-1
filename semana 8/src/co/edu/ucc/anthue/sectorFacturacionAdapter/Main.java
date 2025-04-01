package co.edu.ucc.anthue.sectorFacturacionAdapter;

import java.util.Base64;

interface ReporteNuevo {
    void generar(String datos);
}

class SistemaContableAntiguo {
    public void exportar(String contenido) {
        System.out.println("Exportando a sistema contable antiguo: " + contenido);
    }
}

class AdaptadorReporte implements ReporteNuevo {
    private SistemaContableAntiguo sistema;

    public AdaptadorReporte(SistemaContableAntiguo sistema) {
        this.sistema = sistema;
    }

    public void generar(String datos) {
        sistema.exportar(datos);
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
                 Como analista financiero, necesito que el nuevo sistema de facturación pueda generar reportes 
                 compatibles con el sistema contable antiguo de la empresa, sin cambiar la lógica principal del sistema nuevo.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron(){
        return "Patron adapter";
    }

    public static void main(String[] args) {
        System.out.println(encabezado());
        ReporteNuevo reporte = new AdaptadorReporte(new SistemaContableAntiguo());
        reporte.generar("Factura #123 - Total: $50000");
        System.out.println("\nIdentidad codificada: " + getIdentidad());
        System.out.println("\nPatron implementado: " + getPatron());
    }
}
