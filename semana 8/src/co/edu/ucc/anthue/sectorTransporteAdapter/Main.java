package co.edu.ucc.anthue.sectorTransporteAdapter;

import java.util.Base64;

interface LocalizadorWeb {
    void mostrarUbicacion(String coordenadas);
}

class GPSCamion {
    public String obtenerUbicacion() {
        return "Lat: 4.60971, Lon: -74.08175";
    }
}

class AdaptadorGPS implements LocalizadorWeb {
    private GPSCamion gps;

    public AdaptadorGPS(GPSCamion gps) {
        this.gps = gps;
    }

    public void mostrarUbicacion(String idCamion) {
        String ubicacion = gps.obtenerUbicacion();
        System.out.println("Ubicación del camión " + idCamion + ": " + ubicacion);
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
                 Como administrador de flotas, necesito integrar el sistema GPS de los camiones, que usa un 
                 protocolo diferente, con la plataforma web de monitoreo de rutas en tiempo real.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron(){
        return "Patron adapter";
    }

    public static void main(String[] args) {
        System.out.println(encabezado());
        LocalizadorWeb localizador = new AdaptadorGPS(new GPSCamion());
        localizador.mostrarUbicacion("CAM-123");
        System.out.println("\nIdentidad codificada: " + getIdentidad());
        System.out.println("\nPatron implementado: " + getPatron());
    }
}
