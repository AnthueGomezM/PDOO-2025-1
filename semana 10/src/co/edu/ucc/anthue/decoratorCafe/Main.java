package co.edu.ucc.anthue.decoratorCafe;

import java.util.Base64;

interface Cafe {
    String descripcion();
    double costo();
}

class CafeBasico implements Cafe {
    public String descripcion() { return "Café básico"; }
    public double costo() { return 5.0; }
}

abstract class CafeDecorator implements Cafe {
    protected Cafe cafe;

    public CafeDecorator(Cafe cafe) {
        this.cafe = cafe;
    }

    public String descripcion() {
        return cafe.descripcion();
    }

    public double costo() {
        return cafe.costo();
    }
}

class ConLeche extends CafeDecorator {
    public ConLeche(Cafe cafe) {
        super(cafe);
    }

    public String descripcion() {
        return super.descripcion() + " + Leche";
    }

    public double costo() {
        return super.costo() + 1.5;
    }
}

class ConAzucar extends CafeDecorator {
    public ConAzucar(Cafe cafe) {
        super(cafe);
    }

    public String descripcion() {
        return super.descripcion() + " + Azúcar";
    }

    public double costo() {
        return super.costo() + 0.5;
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
                 Como barista digital en una app de pedidos, necesito permitir a los usuarios personalizar su 
                 café con azúcar, leche, sabores, sin modificar la clase base.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron(){
        return "Patron decorator";
    }
    public static void main(String[] args) {
        System.out.println(encabezado());

        Cafe cafeSimple = new CafeBasico();
        System.out.println("Pedido: " + cafeSimple.descripcion());
        System.out.println("Costo: $" + cafeSimple.costo());
        System.out.println("---------------------");

        Cafe cafeConLeche = new ConLeche(new CafeBasico());
        System.out.println("Pedido: " + cafeConLeche.descripcion());
        System.out.println("Costo: $" + cafeConLeche.costo());
        System.out.println("---------------------");

        Cafe cafeConAzucar = new ConAzucar(new CafeBasico());
        System.out.println("Pedido: " + cafeConAzucar.descripcion());
        System.out.println("Costo: $" + cafeConAzucar.costo());
        System.out.println("---------------------");
        System.out.println("\nIdentidad codificada: " + getIdentidad());
        System.out.println("\nPatron implementado: " + getPatron());
    }
}