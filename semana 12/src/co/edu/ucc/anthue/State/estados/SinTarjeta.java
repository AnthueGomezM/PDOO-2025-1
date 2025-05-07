package co.edu.ucc.anthue.State.estados;

import co.edu.ucc.anthue.State.contexto.Cajero;

public class SinTarjeta implements EstadoCajero{
    private Cajero cajero;

    public SinTarjeta(Cajero cajero) {
        this.cajero = cajero;
    }

    public void insertarTarjeta() {
        System.out.println("Tarjeta insertada.");
        cajero.setEstado(new ConTarjeta(cajero));
    }

    public void ingresarPin(int pin) {
        System.out.println("Primero inserte una tarjeta.");
    }

    public void retirarDinero(double monto) {
        System.out.println("Primero inserte una tarjeta.");
    }
}
