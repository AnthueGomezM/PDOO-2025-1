package co.edu.ucc.anthue.proxy.cliente;

import co.edu.ucc.anthue.facade.cliente.Personalizado;
import co.edu.ucc.anthue.proxy.interfaces.IReporte;
import co.edu.ucc.anthue.proxy.proxy.ProxyReporte;

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
                Como gerente, quiero visualizar reportes confidenciales solo si tengo permisos válidos.
                -------------------------------------------------------------------------------------------------------------
                """);
        programa.mostrarEncabezado();
        IReporte reporte1 = new ProxyReporte("gerente");
        reporte1.mostrar();

        IReporte reporte2 = new ProxyReporte("empleado");
        reporte2.mostrar();

        System.out.println("\nIdentidad codificada: " + programa.getIdentidad());
        System.out.println(programa.getPatron());
    }
}