package co.edu.ucc.anthue.Command.invocador;

import co.edu.ucc.anthue.Command.interfaz.Comando;

public class Boton {
    private Comando comando;

    public Boton(Comando comando) {
        this.comando = comando;
    }

    public void presionar() {
        comando.ejecutar();
    }
}
