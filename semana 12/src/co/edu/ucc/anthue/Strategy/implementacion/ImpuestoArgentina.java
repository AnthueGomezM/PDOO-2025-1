package co.edu.ucc.anthue.Strategy.implementacion;

import co.edu.ucc.anthue.Strategy.interfaz.EstrategiaImpuesto;

public class ImpuestoArgentina implements EstrategiaImpuesto {
    public double calcular(double monto) {
        return monto * 0.21;
    }
}
