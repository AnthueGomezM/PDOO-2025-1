package co.edu.ucc.anthue.vehiculos;

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
                Un sistema de vehículos necesita eliminar la creación manual de objetos y aplicar Factory Method.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron() {
        return "El patrón implementado es factory";
    }

    public static void main(String[] args) {
        System.out.println(encabezado());
        Vehiculo v1 = FabricaVehiculos.crearVehiculo("electrico");
        v1.conducir();
        Vehiculo v2 = FabricaVehiculos.crearVehiculo("gasolina");
        v2.conducir();
        System.out.println("\nIdentidad codificada: " + getIdentidad());
        System.out.println(getPatron());
    }
}