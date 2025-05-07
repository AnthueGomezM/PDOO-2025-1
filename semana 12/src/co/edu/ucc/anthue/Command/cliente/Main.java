package co.edu.ucc.anthue.Command.cliente;

import co.edu.ucc.anthue.Command.comandos.ComandoEncenderLuz;
import co.edu.ucc.anthue.Command.comandos.ComandoSubirCortina;
import co.edu.ucc.anthue.Command.interfaz.Comando;
import co.edu.ucc.anthue.Command.invocador.Boton;
import co.edu.ucc.anthue.Command.receptores.Cortina;
import co.edu.ucc.anthue.Command.receptores.Luz;
import co.edu.ucc.anthue.Personalizado;

public class Main {
    public static void main(String[] args) {
        Personalizado programa = new Personalizado("""
                 ------------------------------------------------------------------------------------------------------------
                 ****************************
                 *        BIENVENIDO A MI   *
                 *          PROGRAMA 🚀     *
                 *✨✨✨Anthue Gomez✨✨✨*
                 ****************************
                 👷‍♂️historia de Usuario:
                 Santiago es desarrollador en una startup de domótica que permite controlar luces, cortinas y aire acondicionado 
                 desde una app móvil. El cliente desea que desde un panel central se puedan configurar botones que envíen órdenes a 
                 distintos dispositivos.
                 Antes, Santiago implementó lógica en botones como if (tipo.equals("LUZ")) { encenderLuz(); }. Este diseño no era 
                 extensible. Cada vez que se agregaba un nuevo dispositivo, debía modificar código existente, violando el principio 
                 de cerrado para modificación.
                 Aplicó el patrón Command: creó una interfaz Comando con el método ejecutar(). Cada acción (encender luz, subir 
                 cortina, activar aire) se encapsuló en su propia clase de comando.
                 Los botones del panel ahora reciben comandos configurables en tiempo de ejecución. Esto permitió agregar nuevas 
                 funciones, crear colas de tareas y hasta implementar funciones de deshacer.                                                                                 
                 -------------------------------------------------------------------------------------------------------------
                ""","Patrón implementado: Command");

        programa.mostrarEncabezado();
        Luz luz = new Luz();
        Cortina cortina = new Cortina();

        Comando cmdLuz = new ComandoEncenderLuz(luz);
        Comando cmdCortina = new ComandoSubirCortina(cortina);

        Boton boton1 = new Boton(cmdLuz);
        Boton boton2 = new Boton(cmdCortina);

        boton1.presionar(); // Luz encendida
        boton2.presionar(); // Cortina subida
        System.out.println("\nIdentidad codificada: " + programa.getIdentidad());
        programa.mostrarPatron();
    }
}