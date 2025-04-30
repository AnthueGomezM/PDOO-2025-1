package co.edu.ucc.anthue.facade.cliente;

import co.edu.ucc.anthue.facade.fachada.FacadeReservaHotel;

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
                Como usuario, quiero reservar un hotel en línea sin tener que interactuar con reservas, pagos y facturación manualmente.
                -------------------------------------------------------------------------------------------------------------
                """);
        programa.mostrarEncabezado();
        FacadeReservaHotel facade = new FacadeReservaHotel();
        facade.reservar();

        System.out.println("\nIdentidad codificada: " + programa.getIdentidad());
        System.out.println(programa.getPatron());
    }
}