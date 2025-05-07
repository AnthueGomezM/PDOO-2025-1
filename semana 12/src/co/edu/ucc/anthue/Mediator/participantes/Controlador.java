package co.edu.ucc.anthue.Mediator.participantes;

import co.edu.ucc.anthue.Mediator.mediador.TorreControl;

public class Controlador extends Participante {
    public Controlador(String nombre, TorreControl torre) {
        super(nombre, torre);
    }

    public void recibir(String mensaje) {
        System.out.println("Controlador " + nombre + " recibe: " + mensaje);
    }
}
