package co.edu.ucc.anthue.proxy.implementacion;

import co.edu.ucc.anthue.proxy.interfaces.IReporte;

public class ReporteReal implements IReporte {
    public void mostrar() {
        System.out.println("Mostrando reporte confidencial.");
    }
}
