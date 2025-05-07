package co.edu.ucc.anthue.Mediator.cliente;

import co.edu.ucc.anthue.Mediator.mediador.TorreControl;
import co.edu.ucc.anthue.Mediator.mediador.TorreDeControl;
import co.edu.ucc.anthue.Mediator.participantes.Avion;
import co.edu.ucc.anthue.Mediator.participantes.Controlador;
import co.edu.ucc.anthue.Mediator.participantes.Participante;
import co.edu.ucc.anthue.Mediator.participantes.Pista;
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
                 Clara es ingeniera de software en un sistema de gestión aérea. Está diseñando un módulo donde aviones, controladores 
                 de vuelo y personal de pista deben intercambiar mensajes para coordinar aterrizajes.
                 Inicialmente, cada clase conocía las otras y se comunicaba directamente, creando una red compleja y propensa a 
                 errores. Cualquier cambio en una clase obligaba a modificar muchas otras.
                 Clara decide implementar el patrón Mediator. Define una interfaz TorreControl, que centraliza toda la coordinación. 
                 Los objetos Avion, Controlador y Pista solo se comunican a través del mediador.
                 Esto permite que nuevos componentes puedan integrarse (como un sistema automático de alertas meteorológicas) 
                 sin alterar las clases existentes. Además, el código es más fácil de probar y mantener.                                                               
                 -------------------------------------------------------------------------------------------------------------
                ""","Patrón implementado: Mediator");

        programa.mostrarEncabezado();
        TorreControl torre = new TorreDeControl();

        Participante avion1 = new Avion("LATAM 123", torre);
        Participante controlador = new Controlador("ATC Norte", torre);
        Participante pista = new Pista("Pista A", torre);

        avion1.enviar("Solicito autorización para aterrizar");
        controlador.enviar("Autorizado a aterrizar");
        programa.mostrarPatron();
    }
}