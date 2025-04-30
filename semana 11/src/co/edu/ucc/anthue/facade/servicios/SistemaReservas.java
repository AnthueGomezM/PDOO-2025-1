package co.edu.ucc.anthue.facade.servicios;

import co.edu.ucc.anthue.facade.interfaces.ISistemaReservas;

public class SistemaReservas  implements ISistemaReservas {
    public void verificarDisponibilidad() {
        System.out.println("Hotel disponible.");
    }
}
