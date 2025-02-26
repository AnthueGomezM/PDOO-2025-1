package co.edu.ucc.anthue.factory1;

import java.util.Base64;

interface Vehiculo {
    void conducir();
}

class CarroElectrico implements Vehiculo {
    public void conducir() {
        System.out.println("Conduciendo un carro eléctrico 🚗🔌");
    }
}

class CarroGasolina implements Vehiculo {
    public void conducir() {
        System.out.println("Conduciendo un carro a gasolina 🚗📎");
    }
}

class FabricaVehiculos {
    public static Vehiculo crearVehiculo(String tipo) {
        if (tipo.equalsIgnoreCase("electrico")) return new CarroElectrico();
        else if (tipo.equalsIgnoreCase("gasolina")) return new CarroGasolina();
        return null;
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
                Una empresa automotriz fabrica autos eléctricos y a gasolina. Se requiere una fábrica que genere
                instancias sin especificar directamente la clase concreta.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
    public static void main(String[] args) {
        System.out.println(encabezado());
        Vehiculo v1 = FabricaVehiculos.crearVehiculo("electrico");
        v1.conducir();
        System.out.println("\nIdentidad codificada: " + getIdentidad());
    }
}

