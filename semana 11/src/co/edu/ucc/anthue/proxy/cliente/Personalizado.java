package co.edu.ucc.anthue.proxy.cliente;

import java.util.Base64;

public class Personalizado {
    private String encabezado;

    public Personalizado(String encabezado) {
        this.encabezado = encabezado;
    }

    public void mostrarEncabezado() {
        System.out.println(encabezado);
    }

    public String getIdentidad() {
        String nombre = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombre.getBytes());
    }

    public String getPatron() {
        return "Patrón implementado: proxy";
    }
}
