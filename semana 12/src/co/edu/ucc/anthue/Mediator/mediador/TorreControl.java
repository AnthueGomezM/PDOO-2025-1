package co.edu.ucc.anthue.Mediator.mediador;

import co.edu.ucc.anthue.Mediator.participantes.Participante;

public interface TorreControl {
    void enviarMensaje(String mensaje, Participante emisor);
    void registrarParticipante(Participante p);
}
