package co.edu.ucc.anthue.Visitor.visitor;

import co.edu.ucc.anthue.Visitor.interfaz.ActivoVisitor;
import co.edu.ucc.anthue.Visitor.modelos.Inmueble;
import co.edu.ucc.anthue.Visitor.modelos.Vehiculo;

public class ReporteFiscalVisitor implements ActivoVisitor {
    public void visitar(Inmueble i) {
        System.out.println("Inmueble - Valor fiscal: $" + i.calcularValorFiscal());
    }

    public void visitar(Vehiculo v) {
        System.out.println("Vehículo - Valor fiscal: $" + v.calcularValorFiscal());
    }

}
