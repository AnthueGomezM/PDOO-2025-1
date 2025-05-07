package co.edu.ucc.anthue.Observer.sujeto;

import co.edu.ucc.anthue.Observer.interfaz.Observador;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private List<Observador> observadores = new ArrayList<>();
    private double temperatura;

    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void removerObservador(Observador o) {
        observadores.remove(o);
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (Observador o : observadores) {
            o.actualizar(temperatura);
        }
    }

}
