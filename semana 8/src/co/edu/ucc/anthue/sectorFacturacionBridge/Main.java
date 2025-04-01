package co.edu.ucc.anthue.sectorFacturacionBridge;

import java.util.Base64;

interface FormatoFactura {
    void generarFactura(String datos);
}

class FormatoPDF implements FormatoFactura {
    public void generarFactura(String datos) {
        System.out.println("Generando factura en PDF: " + datos);
    }
}

class FormatoXML implements FormatoFactura {
    public void generarFactura(String datos) {
        System.out.println("Generando factura en XML: " + datos);
    }
}

abstract class Factura {
    protected FormatoFactura formato;

    public Factura(FormatoFactura formato) {
        this.formato = formato;
    }

    public abstract void emitir(String datos);
}

class FacturaElectronica extends Factura {
    public FacturaElectronica(FormatoFactura formato) {
        super(formato);
    }

    public void emitir(String datos) {
        formato.generarFactura(datos);
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
                 Como desarrollador de un sistema de facturación electrónica, necesito que el sistema pueda 
                 emitir facturas tanto en formato PDF como en XML, dependiendo del cliente.
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
        Factura factura1 = new FacturaElectronica(new FormatoPDF());
        factura1.emitir("Factura #789 - Total: $1.200.000");
        Factura facturaXML = new FacturaElectronica(new FormatoXML());
        facturaXML.emitir("Factura #789 - Total: $1.200.000");
        System.out.println("\nIdentidad codificada: " + getIdentidad());
        System.out.println("\nPatron implementado: " + getPatron());
    }
}
