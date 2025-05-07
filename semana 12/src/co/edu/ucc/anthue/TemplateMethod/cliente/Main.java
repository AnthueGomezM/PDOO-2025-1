package co.edu.ucc.anthue.TemplateMethod.cliente;

import co.edu.ucc.anthue.Personalizado;
import co.edu.ucc.anthue.TemplateMethod.core.GeneradorReporte;
import co.edu.ucc.anthue.TemplateMethod.implementaciones.ReporteExcel;
import co.edu.ucc.anthue.TemplateMethod.implementaciones.ReportePDF;

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
                 Alejandro trabaja en el backend de una plataforma contable SaaS que genera reportes para los usuarios. 
                 Los reportes pueden exportarse en PDF o Excel, y aunque comparten varios pasos (recolección de datos, 
                 encabezado, pie de página), difieren en la forma en que presentan los datos y el formato.
                 Inicialmente, se implementaron dos clases separadas que compartían mucha lógica duplicada. Alejandro decidió 
                 usar el patrón Template Method.
                 Creó una clase abstracta GeneradorReporte con el método generar() que incluye pasos comunes como obtenerDatos(), 
                 generarEncabezado(), generarContenido() y generarPie(). Los métodos generarContenido() y formatear() se dejaron como abstractos.
                 Las clases ReportePDF y ReporteExcel extienden GeneradorReporte e implementan las diferencias específicas. 
                 Ahora, agregar un nuevo formato de exportación solo requiere implementar dos métodos, manteniendo la estructura central intacta.                                                                    
                 -------------------------------------------------------------------------------------------------------------
                ""","Patrón implementado: Template Method");

        programa.mostrarEncabezado();
        GeneradorReporte pdf = new ReportePDF();
        GeneradorReporte excel = new ReporteExcel();

        System.out.println("==== Generando PDF ====");
        pdf.generar();

        System.out.println("\n==== Generando Excel ====");
        excel.generar();
        programa.mostrarPatron();
    }
}