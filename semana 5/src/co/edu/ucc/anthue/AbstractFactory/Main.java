package co.edu.ucc.anthue.AbstractFactory;

import java.util.Base64;

interface Boton {
    void render();
}

// Interfaz común para Ventana
interface Ventana {
    void mostrar();
}

// Implementaciones para Light Mode
class BotonLight implements Boton {
    public void render() { System.out.println("Renderizando botón Light"); }
}
class VentanaLight implements Ventana {
    public void mostrar() { System.out.println("Mostrando ventana Light"); }
}

// Implementaciones para Dark Mode
class BotonDark implements Boton {
    public void render() { System.out.println("Renderizando botón Dark"); }
}
class VentanaDark implements Ventana {
    public void mostrar() { System.out.println("Mostrando ventana Dark"); }
}

// Abstract Factory
interface GUIFactory {
    Boton crearBoton();
    Ventana crearVentana();
}

// Fábricas concretas
class LightFactory implements GUIFactory {
    public Boton crearBoton() { return new BotonLight(); }
    public Ventana crearVentana() { return new VentanaLight(); }
}

class DarkFactory implements GUIFactory {
    public Boton crearBoton() { return new BotonDark(); }
    public Ventana crearVentana() { return new VentanaDark(); }
}

// Cliente
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
                  Un sistema operativo permite cambiar el tema de su interfaz gráfica (Light Mode y Dark Mode). 
                  Cada tema debe proporcionar sus propios botones y ventanas con estilos coherentes.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
    public static void main(String[] args) {
        System.out.println(encabezado());
        GUIFactory factory = new DarkFactory(); // Puede cambiarse por LightFactory
        Boton boton = factory.crearBoton();
        Ventana ventana = factory.crearVentana();
        boton.render();
        ventana.mostrar();
        System.out.println("\nIdentidad codificada: " + getIdentidad());
    }
}
