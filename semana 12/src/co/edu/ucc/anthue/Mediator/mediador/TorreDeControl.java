package co.edu.ucc.anthue.Mediator.mediador;

import co.edu.ucc.anthue.Mediator.participantes.Participante;

import java.util.ArrayList;
import java.util.List;

public class TorreDeControl implements TorreControl {
    private List<Participante> participantes = new ArrayList<>();

    public void registrarParticipante(Participante p) {
        participantes.add(p);
    }

    public void enviarMensaje(String mensaje, Participante emisor) {
        for (Participante p : participantes) {
            if (p != emisor) {
                p.recibir(mensaje + " (de " + emisor.getNombre() + ")");
            }
        }
    }
}
