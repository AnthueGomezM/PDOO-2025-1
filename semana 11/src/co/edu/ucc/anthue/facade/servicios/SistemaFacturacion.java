package co.edu.ucc.anthue.facade.servicios;

import co.edu.ucc.anthue.facade.interfaces.ISistemaFacturacion;

public class SistemaFacturacion implements ISistemaFacturacion {
    public void generarFactura() {
        System.out.println("Factura generada.");
    }
}
