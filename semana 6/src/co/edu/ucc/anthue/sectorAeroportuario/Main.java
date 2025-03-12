package co.edu.ucc.anthue.sectorAeroportuario;

import java.util.Base64;

class Boleto {
    private String clase;
    private boolean equipajeExtra;
    private boolean seleccionAsiento;
    private boolean comidaEspecial;

    private Boleto(BoletoBuilder builder) {
        this.clase = builder.clase;
        this.equipajeExtra = builder.equipajeExtra;
        this.seleccionAsiento = builder.seleccionAsiento;
        this.comidaEspecial = builder.comidaEspecial;
    }

    public void mostrarDetalles() {
        System.out.println("Clase: " + clase +
                ", Equipaje Extra: " + equipajeExtra +
                ", Selección de Asiento: " + seleccionAsiento +
                ", Comida Especial: " + comidaEspecial);
    }

    public static class BoletoBuilder {
        private String clase;
        private boolean equipajeExtra = false;
        private boolean seleccionAsiento = false;
        private boolean comidaEspecial = false;

        public BoletoBuilder(String clase) {
            this.clase = clase;
        }

        public BoletoBuilder agregarEquipajeExtra() {
            this.equipajeExtra = true;
            return this;
        }

        public BoletoBuilder seleccionarAsiento() {
            this.seleccionAsiento = true;
            return this;
        }

        public BoletoBuilder agregarComidaEspecial() {
            this.comidaEspecial = true;
            return this;
        }

        public Boleto build() {
            return new Boleto(this);
        }
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
                  Como ingeniero de software en una aerolínea, necesito un sistema de gestión de reservas de vuelos 
                  que permita a los clientes personalizar su boleto eligiendo la clase del vuelo (económica, ejecutiva, 
                  primera clase) y los servicios adicionales (equipaje extra, selección de asiento, comida especial). 
                  El sistema debe facilitar la creación de boletos personalizados sin alterar la lógica principal.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
    public static void main(String[] args) {
        System.out.println(encabezado());
        Boleto boleto = new Boleto.BoletoBuilder("Ejecutiva")
                .agregarEquipajeExtra()
                .seleccionarAsiento()
                .agregarComidaEspecial()
                .build();

        boleto.mostrarDetalles();
        System.out.println("\nIdentidad codificada: " + getIdentidad());
    }
}