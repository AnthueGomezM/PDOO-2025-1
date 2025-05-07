package co.edu.ucc.anthue.Observer.observadores;

import co.edu.ucc.anthue.Observer.interfaz.Observador;

public class RegistroEvento implements Observador {
    public void actualizar(double temperatura) {
        if (temperatura > 8.0) {
            System.out.println("Evento registrado en base de datos -> " + temperatura + "°C");
        }
    }
}
