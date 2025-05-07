package co.edu.ucc.anthue.Strategy.contexto;

import co.edu.ucc.anthue.Strategy.interfaz.EstrategiaImpuesto;

public class CalculadoraImpuesto {
    private EstrategiaImpuesto estrategia;

    public void setEstrategia(EstrategiaImpuesto estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularImpuesto(double monto) {
        return estrategia.calcular(monto);
    }
}
