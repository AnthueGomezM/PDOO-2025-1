package co.edu.ucc.anthue.decoratorNotificacion;

import java.util.Base64;

interface Notificacion {
    void enviar(String mensaje);
}

class NotificacionBasica implements Notificacion {
    public void enviar(String mensaje) {
        System.out.println("Notificación básica: " + mensaje);
    }
}

abstract class NotificacionDecorator implements Notificacion {
    protected Notificacion wrappee;

    public NotificacionDecorator(Notificacion n) {
        this.wrappee = n;
    }

    public void enviar(String mensaje) {
        wrappee.enviar(mensaje);
    }
}

class NotificacionEmail extends NotificacionDecorator {
    public NotificacionEmail(Notificacion n) {
        super(n);
    }

    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("Enviando email: " + mensaje);
    }
}

class NotificacionSMS extends NotificacionDecorator {
    public NotificacionSMS(Notificacion n) {
        super(n);
    }

    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("Enviando SMS: " + mensaje);
    }
}


public class Main {
    public static String encabezado() {
        return """
                ------------------------------------------------------------------------------------------------------------
                ****************************
                *        BIENVENIDO A MI   *
                *          PROGRAMA 🚀     *
                *✨✨✨Anthue Gomez✨✨✨*
                ****************************
                
                👷‍♂️historia de Usuario:
                 Como responsable de comunicación, quiero que las notificaciones puedan enviarse por email, SMS 
                 y notificaciones push sin modificar el código base.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron(){
        return "Patron decorator";
    }
    public static void main(String[] args) {
        System.out.println(encabezado());

        Notificacion notificacionSimple = new NotificacionBasica();
        System.out.println("\n--- Notificación simple ---");
        notificacionSimple.enviar("Este es un mensaje importante");

        Notificacion notificacionEmail = new NotificacionEmail(new NotificacionBasica());
        System.out.println("\n--- Notificación por email ---");
        notificacionEmail.enviar("Recordatorio de reunión a las 3pm");

        Notificacion notificacionSMS = new NotificacionSMS(new NotificacionBasica());
        System.out.println("\n--- Notificación por SMS ---");
        notificacionSMS.enviar("Tu código de verificación es 123456");

        System.out.println("\nIdentidad codificada: " + getIdentidad());
        System.out.println("\nPatron implementado: " + getPatron());
    }
}