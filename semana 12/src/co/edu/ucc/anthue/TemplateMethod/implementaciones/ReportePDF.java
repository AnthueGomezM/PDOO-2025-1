package co.edu.ucc.anthue.TemplateMethod.implementaciones;

import co.edu.ucc.anthue.TemplateMethod.core.GeneradorReporte;

public class ReportePDF extends GeneradorReporte {
    protected void generarContenido() {
        System.out.println("Escribiendo contenido en PDF.");
    }

    protected void formatear() {
        System.out.println("Formateando como documento PDF.");
    }
}
