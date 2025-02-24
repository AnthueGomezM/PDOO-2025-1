package co.edu.ucc.anthue.abstractFactory;

import java.util.Base64;

// Producto abstracto: Cuenta
interface Cuenta {
    void abrir();
}

// Producto concreto: Cuenta Corriente
class CuentaCorriente implements Cuenta {
    @Override
    public void abrir() {
        System.out.println("Abriendo cuenta corriente.");
    }
}

// Producto concreto: Cuenta Ahorros
class CuentaAhorros implements Cuenta {
    @Override
    public void abrir() {
        System.out.println("Abriendo cuenta de ahorros.");
    }
}

// Producto abstracto: Tarjeta
interface Tarjeta {
    void emitir();
}

// Producto concreto: Tarjeta Débito
class TarjetaDebito implements Tarjeta {
    @Override
    public void emitir() {
        System.out.println("Emitiendo tarjeta de débito.");
    }
}

// Producto concreto: Tarjeta Crédito
class TarjetaCredito implements Tarjeta {
    @Override
    public void emitir() {
        System.out.println("Emitiendo tarjeta de crédito.");
    }
}

// Fábrica abstracta
interface BancoFactory {
    Cuenta crearCuenta();
    Tarjeta crearTarjeta();
}

// Fábrica concreta para Cuenta Corriente y Tarjeta Débito
class BancoCorrienteFactory implements BancoFactory {
    @Override
    public Cuenta crearCuenta() {
        return new CuentaCorriente();
    }

    @Override
    public Tarjeta crearTarjeta() {
        return new TarjetaDebito();
    }
}

// Fábrica concreta para Cuenta Ahorros y Tarjeta Crédito
class BancoAhorrosFactory implements BancoFactory {
    @Override
    public Cuenta crearCuenta() {
        return new CuentaAhorros();
    }

    @Override
    public Tarjeta crearTarjeta() {
        return new TarjetaCredito();
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

        BancoFactory bancoCorriente = new BancoCorrienteFactory();
        Cuenta cuentaCorriente = bancoCorriente.crearCuenta();
        Tarjeta tarjetaDebito = bancoCorriente.crearTarjeta();
        cuentaCorriente.abrir();
        tarjetaDebito.emitir();

        BancoFactory bancoAhorros = new BancoAhorrosFactory();
        Cuenta cuentaAhorros = bancoAhorros.crearCuenta();
        Tarjeta tarjetaCredito = bancoAhorros.crearTarjeta();
        cuentaAhorros.abrir();
        tarjetaCredito.emitir();

        System.out.println("Identidad codificada: " + getIdentidad());
    }

}