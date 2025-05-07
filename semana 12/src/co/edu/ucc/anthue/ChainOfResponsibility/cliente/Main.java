package co.edu.ucc.anthue.ChainOfResponsibility.cliente;

import co.edu.ucc.anthue.ChainOfResponsibility.manejadores.Aprobador;
import co.edu.ucc.anthue.ChainOfResponsibility.manejadores.DirectorFinanciero;
import co.edu.ucc.anthue.ChainOfResponsibility.manejadores.JefeDepartamento;
import co.edu.ucc.anthue.ChainOfResponsibility.manejadores.Supervisor;
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
                 María es analista de TI en una empresa multinacional que implementa un nuevo sistema de aprobación de compras. 
                 Cada solicitud de compra debe ser evaluada por distintos roles según su monto:
                 •	Menor a $500: supervisor directo.
                 •	Entre $500 y $5000: jefe de departamento.
                 •	Mayor a $5000: dirección financiera.
                 Inicialmente, el flujo estaba codificado como una gran estructura if-else, lo que hacía difícil su modificación. 
                 María decide aplicar el patrón Chain of Responsibility.
                 Define una interfaz Aprobador con un método setSiguiente() y procesarSolicitud(). Cada clase representa un rol y 
                 maneja solo su caso.
                 Ahora, la cadena se configura dinámicamente, y nuevos niveles de aprobación pueden agregarse fácilmente sin 
                 modificar la lógica principal. Incluso se pueden registrar logs de cada paso en la cadena para auditoría.
                 -------------------------------------------------------------------------------------------------------------
                ""","Patrón implementado: Chain of Responsibility");

        programa.mostrarEncabezado();
        Aprobador supervisor = new Supervisor();
        Aprobador jefe = new JefeDepartamento();
        Aprobador director = new DirectorFinanciero();

        supervisor.setSiguiente(jefe);
        jefe.setSiguiente(director);

        supervisor.procesarSolicitud(300);   // Supervisor
        supervisor.procesarSolicitud(3000);  // Jefe de Departamento
        supervisor.procesarSolicitud(15000); // Director Financiero
        System.out.println("\nIdentidad codificada: " + programa.getIdentidad());
        programa.mostrarPatron();
    }
}