package co.edu.ucc.anthue.builder;

import java.util.Base64;

// Producto: Paciente
class Paciente {
    private String nombre;
    private int edad;
    private String diagnostico;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void mostrarInfo() {
        System.out.println("Paciente: " + nombre + ", Edad: " + edad + ", Diagnóstico: " + diagnostico);
    }
}

// Builder abstracto
interface PacienteBuilder {
    void construirNombre();
    void construirEdad();
    void construirDiagnostico();
    Paciente getPaciente();
}

// Builder concreto para Paciente con Gripe
class PacienteGripeBuilder implements PacienteBuilder {
    private Paciente paciente;

    public PacienteGripeBuilder() {
        this.paciente = new Paciente();
    }

    @Override
    public void construirNombre() {
        paciente.setNombre("Juan Pérez");
    }

    @Override
    public void construirEdad() {
        paciente.setEdad(30);
    }

    @Override
    public void construirDiagnostico() {
        paciente.setDiagnostico("Gripe");
    }

    @Override
    public Paciente getPaciente() {
        return paciente;
    }
}

// Director
class Medico {
    private PacienteBuilder pacienteBuilder;

    public void setPacienteBuilder(PacienteBuilder pacienteBuilder) {
        this.pacienteBuilder = pacienteBuilder;
    }

    public Paciente getPaciente() {
        return pacienteBuilder.getPaciente();
    }

    public void construirPaciente() {
        pacienteBuilder.construirNombre();
        pacienteBuilder.construirEdad();
        pacienteBuilder.construirDiagnostico();
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

        Medico medico = new Medico();
        PacienteBuilder pacienteGripeBuilder = new PacienteGripeBuilder();

        medico.setPacienteBuilder(pacienteGripeBuilder);
        medico.construirPaciente();

        Paciente paciente = medico.getPaciente();
        paciente.mostrarInfo();

        System.out.println("Identidad codificada: " + getIdentidad());
    }

}