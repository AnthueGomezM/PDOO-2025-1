package co.edu.ucc.anthue.factory;

import java.util.Base64;

// Producto abstracto
interface Medicamento {
    void administrar();
}

// Producto concreto: Analgésico
class Analgesico implements Medicamento {
    @Override
    public void administrar() {
        System.out.println("Administrando analgésico para el dolor.");
    }
}

// Producto concreto: Antibiótico
class Antibiotico implements Medicamento {
    @Override
    public void administrar() {
        System.out.println("Administrando antibiótico para la infección.");
    }
}

// Creador abstracto
abstract class Farmacia {
    public abstract Medicamento crearMedicamento();

    public void recetarMedicamento() {
        Medicamento medicamento = crearMedicamento();
        medicamento.administrar();
    }
}

// Creador concreto para Analgésico
class FarmaciaAnalgesico extends Farmacia {
    @Override
    public Medicamento crearMedicamento() {
        return new Analgesico();
    }
}

// Creador concreto para Antibiótico
class FarmaciaAntibiotico extends Farmacia {
    @Override
    public Medicamento crearMedicamento() {
        return new Antibiotico();
    }
}

// Uso
public class Main {
    public static String encabezado() {
        return """
                ***********************
                *   BIENVENIDO A MI   *
                *     PROGRAMA 🚀     *
                *       AnthueG       *
                ***********************
                """;
    }

    public static String getIdentidad() {
        String nombreComple = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreComple.getBytes());
    }

    public static void main(String[] args) {
        System.out.println(encabezado());
        Farmacia farmaciaAnalgesico = new FarmaciaAnalgesico();
        farmaciaAnalgesico.recetarMedicamento();

        Farmacia farmaciaAntibiotico = new FarmaciaAntibiotico();
        farmaciaAntibiotico.recetarMedicamento();

        System.out.println("Identidad codificada: " + getIdentidad());
    }
}
