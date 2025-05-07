package co.edu.ucc.anthue.ChainOfResponsibility.manejadores;

public class Supervisor extends Aprobador {
    public void procesarSolicitud(double monto) {
        if (monto <= 500) {
            System.out.println("Aprobado por Supervisor.");
        } else if (siguiente != null) {
            siguiente.procesarSolicitud(monto);
        }
    }
}
