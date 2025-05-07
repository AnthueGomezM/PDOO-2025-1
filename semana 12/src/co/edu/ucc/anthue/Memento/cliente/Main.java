package co.edu.ucc.anthue.Memento.cliente;

import co.edu.ucc.anthue.Memento.modelo.EditorTexto;
import co.edu.ucc.anthue.Memento.momento.Historial;
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
                 Daniela trabaja como desarrolladora frontend en una app de edición de notas en línea. Los usuarios pueden 
                 escribir texto, y la app guarda automáticamente cada versión del texto cada cierto tiempo o antes de una operación destructiva.
                 En un inicio, Daniela intentó guardar copias completas del objeto en listas manualmente, pero esto era propenso 
                 a errores y difícil de mantener. Para resolverlo de forma limpia, aplicó el patrón Memento.
                 Creó una clase EditorTexto que actúa como el Originador, una clase Memento que guarda el estado del texto, y una 
                 clase Historial como Caretaker, que maneja una pila de estados.
                 Ahora, el editor puede hacer undo() para regresar al último estado sin violar la encapsulación. La solución es limpia, 
                 testable, y fácil de extender para soporte de redo().                                                   
                 -------------------------------------------------------------------------------------------------------------
                ""","Patrón implementado: Memento");

        programa.mostrarEncabezado();
        EditorTexto editor = new EditorTexto();
        Historial historial = new Historial();

        editor.escribir("Hola");
        historial.guardar(editor.guardar());

        editor.escribir(" mundo");
        historial.guardar(editor.guardar());

        editor.escribir(" cruel");

        System.out.println("Actual: " + editor.getContenido()); // Hola mundo cruel

        editor.restaurar(historial.deshacer());
        System.out.println("Undo 1: " + editor.getContenido()); // Hola mundo

        editor.restaurar(historial.deshacer());
        System.out.println("Undo 2: " + editor.getContenido()); // Hola
        programa.mostrarPatron();
    }
}