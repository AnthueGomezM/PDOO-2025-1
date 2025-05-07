package co.edu.ucc.anthue.Strategy.cliente;

import co.edu.ucc.anthue.Personalizado;
import co.edu.ucc.anthue.Strategy.contexto.CalculadoraImpuesto;
import co.edu.ucc.anthue.Strategy.implementacion.ImpuestoArgentina;
import co.edu.ucc.anthue.Strategy.implementacion.ImpuestoColombia;
import co.edu.ucc.anthue.Strategy.implementacion.ImpuestoEcuador;

public class Main {
    public static void main(String[] args) {
        Personalizado programa = new Personalizado("""
                 ------------------------------------------------------------------------------------------------------------
                 ****************************
                 *        BIENVENIDO A MI   *
                 *          PROGRAMA 🚀     *
                 *✨✨✨Anthue Gomez✨✨✨*
                 ****************************
                 👷‍♂️historia de Usuario:
                 Camila es una ingeniera de software encargada del módulo de facturación. Su sistema debe calcular el impuesto 
                 según el país del cliente: si el país es Colombia, se aplica el 19% de IVA; si es Argentina, se calcula el 
                 21% de IVA; en Ecuador, no se aplica impuesto.
                 Inicialmente, Camila implementó una serie de condicionales que seleccionaban el algoritmo de cálculo dependiendo 
                 del país. Sin embargo, con cada cambio de política fiscal, debía modificar esta clase, violando el principio abierto/cerrado.
                 Decidió aplicar el patrón Strategy: creó una interfaz EstrategiaImpuesto con un método calcular(double monto) 
                 y definió implementaciones específicas para cada país.
                 Gracias a esto, pudo registrar estrategias nuevas en tiempo de ejecución y cumplir con los requerimientos 
                 del equipo de compliance fiscal sin modificar el código base.                                                                                           
                 -------------------------------------------------------------------------------------------------------------
                ""","Patrón implementado: Strategy");

        programa.mostrarEncabezado();
        CalculadoraImpuesto calculadora = new CalculadoraImpuesto();

        calculadora.setEstrategia(new ImpuestoColombia());
        System.out.println("Colombia: " + calculadora.calcularImpuesto(100000));

        calculadora.setEstrategia(new ImpuestoArgentina());
        System.out.println("Argentina: " + calculadora.calcularImpuesto(100000));

        calculadora.setEstrategia(new ImpuestoEcuador());
        System.out.println("Ecuador: " + calculadora.calcularImpuesto(100000));
        System.out.println("\nIdentidad codificada: " + programa.getIdentidad());
        programa.mostrarPatron();
    }
}