package co.edu.ucc.anthue.compositeArchivos;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

interface ArchivoComponent {
    void mostrar();
}

class Archivo implements ArchivoComponent {
    private String nombre;

    public Archivo(String nombre) {
        this.nombre = nombre;
    }

    public void mostrar() {
        System.out.println("Archivo: " + nombre);
    }
}

class Carpeta implements ArchivoComponent {
    private String nombre;
    private List<ArchivoComponent> elementos = new ArrayList<>();

    public Carpeta(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ArchivoComponent componente) {
        elementos.add(componente);
    }

    public void mostrar() {
        System.out.println("Carpeta: " + nombre);
        for (ArchivoComponent c : elementos) {
            c.mostrar();
        }
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
                 Como administrador de servidores, necesito representar carpetas y archivos en una estructura 
                 jerárquica para recorrer y gestionar todo el sistema de almacenamiento de forma uniforme.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron(){
        return "Patron composite";
    }
    public static void main(String[] args) {
        System.out.println(encabezado());

        Carpeta primera = new Carpeta("Raíz");
        primera.agregar(new Archivo("documento.txt"));
        primera.agregar(new Archivo("imagen.jpg"));

        Carpeta proyectos = new Carpeta("Proyectos");
        proyectos.agregar(new Archivo("Main.java"));
        proyectos.agregar(new Archivo("Config.properties"));
        primera.agregar(proyectos);
        System.out.println("=== ESTRUCTURA COMPLETA ===");
        primera.mostrar();
        System.out.println("\n=== CONTENIDO DE PROYECTOS ===");
        proyectos.mostrar();
        System.out.println("\nIdentidad codificada: " + getIdentidad());
        System.out.println("\nPatron implementado: " + getPatron());
    }
}