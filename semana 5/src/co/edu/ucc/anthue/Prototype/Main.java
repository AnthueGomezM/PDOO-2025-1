package co.edu.ucc.anthue.Prototype;

import java.util.Base64;

class Documento implements Cloneable {
    private String contenido;

    public Documento(String contenido) {
        this.contenido = contenido;
    }

    public void mostrar() {
        System.out.println("Contenido del documento: " + contenido);
    }

    @Override
    protected Documento clone() throws CloneNotSupportedException {
        return (Documento) super.clone();
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
                 Un sistema de gestión documental permite a los usuarios crear documentos a partir de una
                  plantilla preexistente en lugar de configurarlos manualmente desde cero.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
    public static void main(String[] args) {
        System.out.println(encabezado());
        try {
            Documento docOriginal = new Documento("Plantilla Base");
            Documento docClonado = docOriginal.clone();

            docOriginal.mostrar();
            docClonado.mostrar();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("\nIdentidad codificada: " + getIdentidad());
    }
}
