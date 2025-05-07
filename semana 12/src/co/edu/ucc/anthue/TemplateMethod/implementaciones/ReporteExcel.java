package co.edu.ucc.anthue.TemplateMethod.implementaciones;

import co.edu.ucc.anthue.TemplateMethod.core.GeneradorReporte;

public class ReporteExcel extends GeneradorReporte {
    protected void generarContenido() {
        System.out.println("Escribiendo contenido en celdas Excel.");
    }

    protected void formatear() {
        System.out.println("Formateando como hoja Excel.");
    }
}
