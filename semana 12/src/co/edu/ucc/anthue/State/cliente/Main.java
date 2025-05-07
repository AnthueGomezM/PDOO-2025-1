package co.edu.ucc.anthue.State.cliente;

import co.edu.ucc.anthue.Personalizado;
import co.edu.ucc.anthue.State.contexto.Cajero;

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
                 Andrés trabaja en el equipo de desarrollo de una fintech que quiere simular un cajero automático en software. 
                 Este cajero debe tener comportamientos distintos dependiendo del estado actual:
                 •	Cuando sin tarjeta, debe pedir que se inserte una.
                 •	Cuando con tarjeta, debe solicitar PIN.
                 •	Cuando autenticado, debe permitir operaciones.
                 La implementación inicial se basaba en muchos condicionales, lo que dificultaba las pruebas unitarias y el 
                 mantenimiento. Andrés decide usar el patrón State.
                 Define una interfaz EstadoCajero y crea clases como SinTarjeta, ConTarjeta y Autenticado, cada una encapsulando 
                 la lógica específica.
                 El objeto Cajero mantiene una referencia al estado actual y delega en él el comportamiento. El sistema se 
                 volvió más legible, cada estado es fácilmente extensible, y ahora se pueden agregar nuevos estados 
                 (por ejemplo, Bloqueado) sin alterar el código existente.                                                                     
                 -------------------------------------------------------------------------------------------------------------
                ""","Patrón implementado: State");

        programa.mostrarEncabezado();
        Cajero cajero = new Cajero();

        cajero.insertarTarjeta();
        cajero.ingresarPin(1111);
        cajero.ingresarPin(1234);
        cajero.retirarDinero(200);
        System.out.println("\nIdentidad codificada: " + programa.getIdentidad());
        programa.mostrarPatron();
    }
}