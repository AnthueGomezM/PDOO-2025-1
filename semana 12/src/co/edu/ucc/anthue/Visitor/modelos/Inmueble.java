package co.edu.ucc.anthue.Visitor.modelos;

import co.edu.ucc.anthue.Visitor.interfaz.Activo;
import co.edu.ucc.anthue.Visitor.interfaz.ActivoVisitor;

public class Inmueble implements Activo {
    public void aceptar(ActivoVisitor visitor) {
        visitor.visitar(this);
    }

    public double calcularValorFiscal() {
        return 100000;
    }
}
