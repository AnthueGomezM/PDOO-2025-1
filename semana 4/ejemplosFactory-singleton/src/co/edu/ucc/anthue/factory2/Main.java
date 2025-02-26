package co.edu.ucc.anthue.factory2;

import java.util.Base64;

interface Figura {
    void dibujar();
}

class Circulo implements Figura {
    public void dibujar() {
        System.out.println("Dibujando un círculo ⭕");
    }
}

class Cuadrado implements Figura {
    public void dibujar() {
        System.out.println("Dibujando un cuadrado 🟥");
    }
}


class FiguraFactory {
    public static Figura crearFigura(String tipo) {
        if (tipo.equalsIgnoreCase("circulo")) return new Circulo();
        else if (tipo.equalsIgnoreCase("cuadrado")) return new Cuadrado();
        return null;
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
                Un software de diseño gráfico necesita una fábrica que genere distintos tipos de figuras 
                sin definir explícitamente sus clases.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
    public static void main(String[] args) {
        System.out.println(encabezado());
        Figura f1 = FiguraFactory.crearFigura("circulo");
        f1.dibujar();
        System.out.println("\nIdentidad codificada: " + getIdentidad());
    }
}
