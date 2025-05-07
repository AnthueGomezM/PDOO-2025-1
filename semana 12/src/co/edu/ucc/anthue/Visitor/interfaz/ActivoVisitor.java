package co.edu.ucc.anthue.Visitor.interfaz;

import co.edu.ucc.anthue.Visitor.modelos.Inmueble;
import co.edu.ucc.anthue.Visitor.modelos.Vehiculo;

public interface ActivoVisitor {
    void visitar(Inmueble i);
    void visitar(Vehiculo v);
}
