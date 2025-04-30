package co.edu.ucc.anthue.proxy.proxy;

import co.edu.ucc.anthue.proxy.implementacion.ReporteReal;
import co.edu.ucc.anthue.proxy.interfaces.IReporte;

public class ProxyReporte implements IReporte {
    private ReporteReal reporteReal;
    private String rolUsuario;

    public ProxyReporte(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public void mostrar() {
        if ("gerente".equalsIgnoreCase(rolUsuario)) {
            if (reporteReal == null) {
                reporteReal = new ReporteReal();
            }
            reporteReal.mostrar();
        } else {
            System.out.println("Acceso denegado: " + rolUsuario);
        }
    }
}
