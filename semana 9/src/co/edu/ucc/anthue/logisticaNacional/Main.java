package co.edu.ucc.anthue.logisticaNacional;

import java.util.Base64;

//ADAPTER
interface GPS {
    String localizacion();
    String estado();
}

class GarminGPS {
    public String ubiGarmin() { return "Lat: 12.34, Lon: 56.78"; }
    public String estadoGarmin() { return "Activo"; }
}

class TomTomGPS {
    public String ubiTom() { return "Lat: 98.76, Lon: 54.32"; }
    public String estadoTOm() { return "Inactivo"; }
}

class HuaweiGPS {
    public String ubiHuawei() { return "Lat: 23.45, Lon: 67.89"; }
    public String estadoHuawei() { return "Activo"; }
}

class GarminAdapter implements GPS {
    private GarminGPS garmin;
    public GarminAdapter(GarminGPS garmin) { this.garmin = garmin; }
    public String localizacion() { return garmin.ubiGarmin(); }
    public String estado() { return garmin.estadoGarmin(); }
}

class TomTomAdapter implements GPS {
    private TomTomGPS tomtom;
    public TomTomAdapter(TomTomGPS tomtom) { this.tomtom = tomtom; }
    public String localizacion() { return tomtom.ubiTom(); }
    public String estado() { return tomtom.estadoTOm(); }
}

class HuaweiAdapter implements GPS {
    private HuaweiGPS huawei;
    public HuaweiAdapter(HuaweiGPS huawei) { this.huawei = huawei; }
    public String localizacion() { return huawei.ubiHuawei(); }
    public String estado() { return huawei.estadoHuawei(); }
}

// BRIDGE
abstract class PanelRastreo {
    protected Vista view;
    public PanelRastreo(Vista view) { this.view = view; }
    abstract void displayData(GPS device);
}

interface Vista {
    void render(String ubi, String estado);
}

class VistaEscritorio implements Vista {
    public void render(String ubi, String estado) {
        System.out.println("[Escritorio] Ubicación: " + ubi + " | Estado: " + estado);
    }
}

class VistaCelular implements Vista {
    public void render(String ubi, String estado) {
        System.out.println("[Celular] Ubicación: " + ubi + " | Estado: " + estado);
    }
}

// Implementación concreta del Panel de Rastreo
class VehicleTrackingPanel extends PanelRastreo {
    public VehicleTrackingPanel(Vista view) { super(view); }
    public void displayData(GPS device) {
        view.render(device.localizacion(), device.estado());
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
                 Como ingeniero de integración en una empresa de logística nacional, necesito que nuestro sistema de 
                 rastreo de vehículos sea capaz de integrarse con múltiples dispositivos GPS de diferentes marcas 
                 (Garmin, TomTom, Huawei), cada uno con su propia API, para mostrar de forma unificada los datos de 
                 ubicación y estado del vehículo en una aplicación móvil y de escritorio.
                 Además, quiero poder modificar la interfaz gráfica del panel de rastreo dependiendo de si el usuario 
                 accede desde escritorio o desde el celular, sin tener que cambiar toda la lógica del sistema.
                 
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron(){
        return "Patron adapter y bridge";
    }
    public static void main(String[] args) {
        System.out.println(encabezado());
        GPS garmin = new GarminAdapter(new GarminGPS());
        GPS tomtom = new TomTomAdapter(new TomTomGPS());
        GPS huawei = new HuaweiAdapter(new HuaweiGPS());

        PanelRastreo desktopPanel = new VehicleTrackingPanel(new VistaEscritorio());
        PanelRastreo mobilePanel = new VehicleTrackingPanel(new VistaCelular());

        System.out.println("--- Datos en Escritorio ---");
        desktopPanel.displayData(garmin);
        desktopPanel.displayData(tomtom);
        desktopPanel.displayData(huawei);

        System.out.println("\n--- Datos en Celular ---");
        mobilePanel.displayData(garmin);
        mobilePanel.displayData(tomtom);
        mobilePanel.displayData(huawei);

        System.out.println("\nIdentidad codificada: " + getIdentidad());
        System.out.println("\nPatron implementado: " + getPatron());
    }
}