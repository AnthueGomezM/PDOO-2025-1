package co.edu.ucc.anthue.Command.comandos;

import co.edu.ucc.anthue.Command.interfaz.Comando;
import co.edu.ucc.anthue.Command.receptores.Luz;

public class ComandoEncenderLuz implements Comando {
    private Luz luz;

    public ComandoEncenderLuz(Luz luz) {
        this.luz = luz;
    }

    public void ejecutar() {
        luz.encender();
    }
}
