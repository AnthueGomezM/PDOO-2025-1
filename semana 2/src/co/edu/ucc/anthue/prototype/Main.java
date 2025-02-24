package co.edu.ucc.anthue.prototype;

import java.util.Base64;

// Prototipo
interface CuentaBancaria extends Cloneable {
    CuentaBancaria clone() throws CloneNotSupportedException;
    void mostrarInfo();
}

// Producto concreto: Cuenta de Ahorros
class CuentaAhorros implements CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaAhorros(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    @Override
    public CuentaBancaria clone() throws CloneNotSupportedException {
        return (CuentaAhorros) super.clone();
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Cuenta de Ahorros - Titular: " + titular + ", Saldo: " + saldo);
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
        try {
            CuentaAhorros cuentaOriginal = new CuentaAhorros("Carlos Gómez", 1000.0);
            CuentaAhorros cuentaClonada = (CuentaAhorros) cuentaOriginal.clone();

            cuentaOriginal.mostrarInfo();
            cuentaClonada.mostrarInfo();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("Identidad codificada: " + getIdentidad());
    }

}
