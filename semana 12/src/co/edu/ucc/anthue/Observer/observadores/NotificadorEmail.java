package co.edu.ucc.anthue.Observer.observadores;

import co.edu.ucc.anthue.Observer.interfaz.Observador;

public class NotificadorEmail implements Observador {
    public void actualizar(double temperatura) {
        if (temperatura > 8.0) {
            System.out.println("Email enviado: temperatura alta -> " + temperatura + "°C");
        }
    }
}
