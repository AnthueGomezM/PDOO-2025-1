package co.edu.ucc.anthue.State.contexto;

import co.edu.ucc.anthue.State.estados.EstadoCajero;
import co.edu.ucc.anthue.State.estados.SinTarjeta;

public class Cajero {
    private EstadoCajero estado;

    public Cajero() {
        this.estado = new SinTarjeta(this);
    }

    public void setEstado(EstadoCajero estado) {
        this.estado = estado;
    }

    public void insertarTarjeta() {
        estado.insertarTarjeta();
    }

    public void ingresarPin(int pin) {
        estado.ingresarPin(pin);
    }

    public void retirarDinero(double monto) {
        estado.retirarDinero(monto);
    }
}
