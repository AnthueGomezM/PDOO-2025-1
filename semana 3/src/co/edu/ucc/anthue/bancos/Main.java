package co.edu.ucc.anthue.bancos;

import java.util.Base64;

class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public boolean transferir(CuentaBancaria destino, double monto) {
        if (this.saldo >= monto && monto > 0) {
            this.saldo -= monto;
            destino.depositar(monto);
            return true;
        }
        return false;
    }

    private void depositar(double monto) {
        this.saldo += monto;
    }

    public void mostrarSaldo() {
        System.out.println("Cuenta: " + numeroCuenta + " | Saldo: $" + saldo);
    }
}

public class Main {

    public static String encabezado() {
        return """
                ***********************
                *   BIENVENIDO A MI   *
                *     PROGRAMA 🚀     *
                *       AnthueG       *
                ***********************
                Historia de Usuario:
                Como cliente del banco, quiero poder transferir dinero 
                de mi cuenta a otra cuenta, para poder realizar pagos 
                o enviar dinero a familiares.
                ---------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }

    public static String getPatron() {
        return "El patrón implementado es prototype";
    }

    public static void main(String[] args) {
        System.out.println(encabezado());

        CuentaBancaria cuenta1 = new CuentaBancaria("123456", 1000.0);
        CuentaBancaria cuenta2 = new CuentaBancaria("654321", 500.0);

        if (cuenta1.transferir(cuenta2, 200.0)) {
            System.out.println("Transferencia exitosa.");
        } else {
            System.out.println("Transferencia fallida. Fondos insuficientes.");
        }

        cuenta1.mostrarSaldo();
        cuenta2.mostrarSaldo();

        System.out.println("Identidad codificada: " + getIdentidad());
        System.out.println(getPatron());
    }
}