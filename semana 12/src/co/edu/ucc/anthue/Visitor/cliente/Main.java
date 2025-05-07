package co.edu.ucc.anthue.Visitor.cliente;

import co.edu.ucc.anthue.Personalizado;
import co.edu.ucc.anthue.Visitor.interfaz.Activo;
import co.edu.ucc.anthue.Visitor.interfaz.ActivoVisitor;
import co.edu.ucc.anthue.Visitor.modelos.Inmueble;
import co.edu.ucc.anthue.Visitor.modelos.Vehiculo;
import co.edu.ucc.anthue.Visitor.visitor.ReporteFiscalVisitor;

import java.util.ArrayList;
import java.util.List;

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
                 Francisco trabaja en un sistema contable que maneja diferentes tipos de activos: Inmuebles, Vehículos, 
                 Equipos. El sistema debe generar reportes fiscales y financieros sobre estos activos.
                 Cada tipo de activo tiene reglas distintas para el cálculo de depreciación, valor residual, e impacto 
                 contable. Además, los reportes pueden cambiar con la normativa legal.
                 En lugar de modificar las clases Activo, Inmueble, Vehículo, cada vez que se agrega una operación nueva, 
                 Francisco implementa el patrón Visitor. Define una interfaz ActivoVisitor con métodos visitar(Inmueble), visitar(Vehiculo), etc.
                 Las operaciones como ReporteFiscalVisitor, ReporteFinancieroVisitor implementan esa interfaz y aplican 
                 lógica según el tipo de activo. Esto permitió agregar nuevas operaciones sin modificar las clases base, y 
                 separar completamente la lógica contable de la lógica de presentación.                                                                               
                 -------------------------------------------------------------------------------------------------------------
                ""","Patrón implementado: Visitor");

        programa.mostrarEncabezado();
        List<Activo> activos = new ArrayList<>();
        activos.add(new Inmueble());
        activos.add(new Vehiculo());

        ActivoVisitor reporte = new ReporteFiscalVisitor();

        for (Activo a : activos) {
            a.aceptar(reporte);
        }
        System.out.println("\nIdentidad codificada: " + programa.getIdentidad());
        programa.mostrarPatron();
    }
}