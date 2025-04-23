package co.edu.ucc.anthue.SectorIndustrial;

class Auto {
    private String modelo;
    private String motor;
    private String sistemaAudio;
    private boolean sensorProximidad;

    private Auto(AutoBuilder builder) {
        this.modelo = builder.modelo;
        this.motor = builder.motor;
        this.sistemaAudio = builder.sistemaAudio;
        this.sensorProximidad = builder.sensorProximidad;
    }

    public static class AutoBuilder {
        private String modelo;
        private String motor;
        private String sistemaAudio;
        private boolean sensorProximidad;

        public AutoBuilder(String modelo) {
            this.modelo = modelo;
        }

        public AutoBuilder setMotor(String motor) {
            this.motor = motor;
            return this;
        }

        public AutoBuilder setSistemaAudio(String sistemaAudio) {
            this.sistemaAudio = sistemaAudio;
            return this;
        }

        public AutoBuilder setSensorProximidad(boolean sensorProximidad) {
            this.sensorProximidad = sensorProximidad;
            return this;
        }

        public Auto build() {
            return new Auto(this);
        }
    }

    @Override
    public String toString() {
        return "Auto modelo=" + modelo +
                "\n, motor=" + motor +
                "\n, sistemaAudio=" + sistemaAudio +
                "\n, sensorProximidad=" + (sensorProximidad ? "posee la tecnologia" : "no posee la tecnologia") ;
    }
}

public class Main {
    public static void main(String[] args) {
        Auto autoElectrico = new Auto.AutoBuilder("Tesla 2025")
                .setMotor("Electrico")
                .setSistemaAudio("premium")
                .setSensorProximidad(true)
                .build();

        System.out.println(autoElectrico);

        Auto autoGasolina = new Auto.AutoBuilder("Spark GT 2014")
                .setMotor("Gasolina")
                .setSistemaAudio("Estandar")
                .setSensorProximidad(false)
                .build();

        System.out.println(autoGasolina);
    }
}