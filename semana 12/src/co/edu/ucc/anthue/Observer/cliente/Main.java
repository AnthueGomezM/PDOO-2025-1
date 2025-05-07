package co.edu.ucc.anthue.Observer.cliente;

import co.edu.ucc.anthue.Observer.observadores.NotificadorEmail;
import co.edu.ucc.anthue.Observer.observadores.OrdenTecnica;
import co.edu.ucc.anthue.Observer.observadores.RegistroEvento;
import co.edu.ucc.anthue.Observer.sujeto.Sensor;
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
                 En una planta de producción de alimentos, Julia es responsable de monitorear sensores de temperatura ubicados 
                 en diferentes zonas de almacenamiento. Cada vez que un sensor supera los 8 °C, deben activarse múltiples acciones:
                 •	Notificar al gerente por correo electrónico.
                 •	Registrar el evento en el sistema de alertas.
                 •	Activar una orden de verificación técnica.
                 Antes, todo esto estaba embebido en una sola clase de Sensor. El código era difícil de mantener y no podía ampliarse fácilmente.
                 Julia decidió aplicar el patrón Observer: el Sensor se convierte en el "sujeto observable", y cada uno de los módulos 
                 anteriores se convierte en un "observador" que se suscribe al sensor.
                 Con esta solución, ahora puede agregar o quitar observadores sin tocar el código del sensor. Incluso el equipo de TI 
                 implementó nuevos observadores para reportes en Power BI y simuladores                                                                                     
                 -------------------------------------------------------------------------------------------------------------
                ""","Patrón implementado: Observer");

        programa.mostrarEncabezado();
        Sensor sensor = new Sensor();
        sensor.agregarObservador(new NotificadorEmail());
        sensor.agregarObservador(new RegistroEvento());
        sensor.agregarObservador(new OrdenTecnica());

        sensor.setTemperatura(6.5); // no se notifica
        sensor.setTemperatura(8.5); // activa todos los observadores
        programa.mostrarPatron();
    }
}