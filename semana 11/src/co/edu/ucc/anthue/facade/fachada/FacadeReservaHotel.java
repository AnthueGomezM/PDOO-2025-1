package co.edu.ucc.anthue.facade.fachada;

import co.edu.ucc.anthue.facade.interfaces.ISistemaFacturacion;
import co.edu.ucc.anthue.facade.interfaces.ISistemaPagos;
import co.edu.ucc.anthue.facade.interfaces.ISistemaReservas;
import co.edu.ucc.anthue.facade.servicios.SistemaFacturacion;
import co.edu.ucc.anthue.facade.servicios.SistemaPagos;
import co.edu.ucc.anthue.facade.servicios.SistemaReservas;


public class FacadeReservaHotel {
    private ISistemaReservas reservas;
    private ISistemaPagos pagos;
    private ISistemaFacturacion facturacion;

    public FacadeReservaHotel() {
        this.reservas = new SistemaReservas();
        this.pagos = new SistemaPagos();
        this.facturacion = new SistemaFacturacion();
    }

    public void reservar() {
        reservas.verificarDisponibilidad();
        pagos.procesarPago();
        facturacion.generarFactura();
        System.out.println("Reserva completada.");
    }
}
