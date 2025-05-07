package co.edu.ucc.anthue.State.estados;

public interface EstadoCajero {
    void insertarTarjeta();
    void ingresarPin(int pin);
    void retirarDinero(double monto);
}
