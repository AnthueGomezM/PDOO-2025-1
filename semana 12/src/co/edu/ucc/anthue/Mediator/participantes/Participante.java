package co.edu.ucc.anthue.Mediator.participantes;

import co.edu.ucc.anthue.Mediator.mediador.TorreControl;

public abstract class Participante {
    protected TorreControl torre;
    protected String nombre;

    public Participante(String nombre, TorreControl torre) {
        this.nombre = nombre;
        this.torre = torre;
        torre.registrarParticipante(this);
    }

    public abstract void recibir(String mensaje);
    public void enviar(String mensaje) {
        torre.enviarMensaje(mensaje, this);
    }

    public String getNombre() {
        return nombre;
    }
}
