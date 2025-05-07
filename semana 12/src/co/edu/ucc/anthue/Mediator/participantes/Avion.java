package co.edu.ucc.anthue.Mediator.participantes;

import co.edu.ucc.anthue.Mediator.mediador.TorreControl;

public class Avion extends Participante {
    public Avion(String nombre, TorreControl torre) {
        super(nombre, torre);
    }

    public void recibir(String mensaje) {
        System.out.println("Avión " + nombre + " recibe: " + mensaje);
    }
}
