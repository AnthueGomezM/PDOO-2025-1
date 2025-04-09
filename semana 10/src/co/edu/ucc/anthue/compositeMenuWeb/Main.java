package co.edu.ucc.anthue.compositeMenuWeb;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

interface ElementoMenu {
    void mostrar();
}

class Opcion implements ElementoMenu {
    private String nombre;

    public Opcion(String nombre) {
        this.nombre = nombre;
    }

    public void mostrar() {
        System.out.println("Opción: " + nombre);
    }
}

class Menu implements ElementoMenu {
    private String nombre;
    private List<ElementoMenu> elementos = new ArrayList<>();

    public Menu(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ElementoMenu elemento) {
        elementos.add(elemento);
    }

    public void mostrar() {
        System.out.println("Menú: " + nombre);
        for (ElementoMenu e : elementos) {
            e.mostrar();
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
                 Como diseñador de interfaz, quiero crear menús que puedan tener submenús y opciones, y que puedan 
                 recorrerse uniformemente sin importar su nivel.
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
        Menu menuPrincipal = new Menu("Principal");

        Menu menuArchivo = new Menu("Archivo");
        menuArchivo.agregar(new Opcion("Nuevo"));
        menuArchivo.agregar(new Opcion("Abrir"));
        menuArchivo.agregar(new Opcion("Guardar"));

        Menu menuEditar = new Menu("Editar");
        menuEditar.agregar(new Opcion("Deshacer"));
        menuEditar.agregar(new Opcion("Rehacer"));

        menuPrincipal.agregar(menuArchivo);
        menuPrincipal.agregar(menuEditar);
        System.out.println("=== ESTRUCTURA COMPLETA DEL MENÚ ===");
        menuPrincipal.mostrar();
        System.out.println("\n=== SUBMENÚ EDITAR ===");
        menuEditar.mostrar();
        System.out.println("\nIdentidad codificada: " + getIdentidad());
        System.out.println("\nPatron implementado: " + getPatron());
    }
}