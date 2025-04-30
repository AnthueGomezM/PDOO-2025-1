package co.edu.ucc.anthue.flyweight.cliente;

import co.edu.ucc.anthue.facade.cliente.Personalizado;
import co.edu.ucc.anthue.flyweight.fabrica.FabricaLetras;
import co.edu.ucc.anthue.flyweight.interfaces.ILetra;

public class Main {
    public static void main(String[] args) {
        co.edu.ucc.anthue.facade.cliente.Personalizado programa = new Personalizado("""
                ------------------------------------------------------------------------------------------------------------
                ****************************
                *        BIENVENIDO A MI   *
                *          PROGRAMA 🚀     *
                *✨✨✨Anthue Gomez✨✨✨*
                ****************************
                👷‍♂️historia de Usuario:
                Como desarrollador, quiero ahorrar memoria en el editor de texto reutilizando las mismas letras en diferentes posiciones.
                -------------------------------------------------------------------------------------------------------------
                """);
        programa.mostrarEncabezado();
        ILetra letraA1 = FabricaLetras.obtenerLetra('A');
        ILetra letraA2 = FabricaLetras.obtenerLetra('A');
        ILetra letraB = FabricaLetras.obtenerLetra('B');

        letraA1.mostrar("1");
        letraA2.mostrar("2");
        letraB.mostrar("3");

        System.out.println("\nIdentidad codificada: " + programa.getIdentidad());
        System.out.println(programa.getPatron());
    }
}