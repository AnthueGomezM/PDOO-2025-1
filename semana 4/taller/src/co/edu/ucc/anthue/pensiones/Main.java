package co.edu.ucc.anthue.pensiones;

import java.util.Base64;

interface LiquidacionPension {
    double calcularPension(double salarioBase);
}

class Ley78 implements LiquidacionPension {
    @Override
    public double calcularPension(double salarioBase) {
        return salarioBase * 15;
    }
}

class Ley86 implements LiquidacionPension {
    @Override
    public double calcularPension(double salarioBase) {
        return salarioBase * 5;
    }
}

class Ley98 implements LiquidacionPension {
    @Override
    public double calcularPension(double salarioBase) {
        return salarioBase * 2.5;
    }
}

class Ley100 implements LiquidacionPension {
    private double[] ultimosSalarios;

    public Ley100(double[] ultimosSalarios) {
        this.ultimosSalarios = ultimosSalarios;
    }

    @Override
    public double calcularPension(double salarioBase) {
        double suma = 0;
        for (double salario : ultimosSalarios) {
            suma += salario;
        }
        return suma / ultimosSalarios.length;
    }
}

class LeyPetro implements LiquidacionPension {
    @Override
    public double calcularPension(double salarioBase) {
        double tope = 3.5 * salarioBase;
        double liquidacion = salarioBase * 0.7;
        return Math.min(tope, liquidacion);
    }
}

abstract class FabricaLiquidacion {
    public abstract LiquidacionPension crearLiquidacion();
}

class FabricaLey78 extends FabricaLiquidacion {
    @Override
    public LiquidacionPension crearLiquidacion() {
        return new Ley78();
    }
}

class FabricaLey86 extends FabricaLiquidacion {
    @Override
    public LiquidacionPension crearLiquidacion() {
        return new Ley86();
    }
}

class FabricaLey98 extends FabricaLiquidacion {
    @Override
    public LiquidacionPension crearLiquidacion() {
        return new Ley98();
    }
}

class FabricaLey100 extends FabricaLiquidacion {
    private double[] ultimosSalarios;

    public FabricaLey100(double[] ultimosSalarios) {
        this.ultimosSalarios = ultimosSalarios;
    }

    @Override
    public LiquidacionPension crearLiquidacion() {
        return new Ley100(ultimosSalarios);
    }
}

class FabricaLeyPetro extends FabricaLiquidacion {
    @Override
    public LiquidacionPension crearLiquidacion() {
        return new LeyPetro();
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
                 Un sistema de liquidación de pensiones requiere procesar varias leyes de liquidación de pensión para 
                 realizar el pago mensual, para ello se necesita que el salario de pensión sea liquidado con base en la 
                 ley a la que pertenece
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron() {
        return "El patrón implementado es factory 🏭";
    }

    public static void main(String[] args) {
        System.out.println(encabezado());

        double[] salarios78 = {850000, 850000, 850000};
        double[] salarios86 = {930000, 930000};
        double[] salarios98 = {1020000, 1020000, 1020000, 2040000, 2040000};
        double[] salarios100_1 = {1200000, 1200000};
        double[] salarios100_2 = {1230000, 1300000, 1300000, 1300000, 1300000, 1300000, 1300000, 1300000, 1300000, 1300000};
        double[] salariosPetro = {1400000, 1400000, 1400000, 1400000, 1400000, 1400000, 1400000};

        calculaPension(new FabricaLey78(), salarios78);
        calculaPension(new FabricaLey86(), salarios86);
        calculaPension(new FabricaLey98(), salarios98);
        calculaPension(new FabricaLey100(salarios100_1), new double[]{1200000});
        calculaPension(new FabricaLey100(salarios100_2), new double[]{1230000});
        calculaPension(new FabricaLeyPetro(), salariosPetro);

        System.out.println("\nIdentidad codificada: " + getIdentidad());
        System.out.println(getPatron());
    }

    private static void calculaPension(FabricaLiquidacion fabrica, double[] salarios) {
        LiquidacionPension liquidacion = fabrica.crearLiquidacion();
        for (double salario : salarios) {
            System.out.println("💵Salario base: $" + salario + " -> Pensión: $" + liquidacion.calcularPension(salario));
        }
    }
}
