package co.edu.ucc.anthue;

import java.util.Base64;

public class Personalizado {
    private String encabezado;
    private String patron;

    public Personalizado(String encabezado, String patron) {
        this.encabezado = encabezado;
        this.patron = patron;
    }

    public void mostrarEncabezado() {
        System.out.println(encabezado);
    }
    public void mostrarPatron() {
        System.out.println("\n"+patron);
    }

    public String getIdentidad() {
        String nombre = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombre.getBytes());
    }

}
