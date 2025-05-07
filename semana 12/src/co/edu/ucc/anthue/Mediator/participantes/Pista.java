package co.edu.ucc.anthue.Mediator.participantes;

import co.edu.ucc.anthue.Mediator.mediador.TorreControl;

public class Pista extends Participante {
    public Pista(String nombre, TorreControl torre) {
        super(nombre, torre);
    }

    public void recibir(String mensaje) {
        System.out.println("Pista " + nombre + " recibe: " + mensaje);
    }
}
