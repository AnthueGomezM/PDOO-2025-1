package co.edu.ucc.anthue.Command.comandos;

import co.edu.ucc.anthue.Command.interfaz.Comando;
import co.edu.ucc.anthue.Command.receptores.Cortina;

public class ComandoSubirCortina implements Comando {
    private Cortina cortina;

    public ComandoSubirCortina(Cortina cortina) {
        this.cortina = cortina;
    }

    public void ejecutar() {
        cortina.subir();
    }
}
