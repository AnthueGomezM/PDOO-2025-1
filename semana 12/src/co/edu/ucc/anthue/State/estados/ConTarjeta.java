package co.edu.ucc.anthue.State.estados;

import co.edu.ucc.anthue.State.contexto.Cajero;

public class ConTarjeta implements EstadoCajero{
    private Cajero cajero;

    public ConTarjeta(Cajero cajero) {
        this.cajero = cajero;
    }

    public void insertarTarjeta() {
        System.out.println("Ya hay una tarjeta insertada.");
    }

    public void ingresarPin(int pin) {
        if (pin == 1234) {
            System.out.println("PIN correcto.");
            cajero.setEstado(new Autenticado(cajero));
        } else {
            System.out.println("PIN incorrecto.");
        }
    }

    public void retirarDinero(double monto) {
        System.out.println("Debe ingresar su PIN primero.");
    }

}
