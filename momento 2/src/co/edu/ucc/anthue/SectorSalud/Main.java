package co.edu.ucc.anthue.SectorSalud;

class HistorialMedico implements Cloneable {
    private String nombrePaciente;
    private String diagnostico;
    private String notas;

    public HistorialMedico(String nombrePaciente, String diagnostico, String notas) {
        this.nombrePaciente = nombrePaciente;
        this.diagnostico = diagnostico;
        this.notas = notas;
    }

    public void agregarNota(String nuevaNota) {
        this.notas += "\n- " + nuevaNota;
    }

    @Override
    public HistorialMedico clone() throws CloneNotSupportedException {
            return (HistorialMedico) super.clone();
    }

    @Override
    public String toString() {
        return "Paciente: " + nombrePaciente +
                "\nDiagnóstico: " + diagnostico +
                "\nNotas: " + notas;
    }
}

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        HistorialMedico original = new HistorialMedico(
                "Juan Pérez",
                "Diabetes",
                "- Control de insulina"
        );

        HistorialMedico nuevaVersion = original.clone();
        nuevaVersion.agregarNota("Se recomienda bajar el azucar");
        nuevaVersion.agregarNota("ir al medico cada mes");

        System.out.println("Historial Original:");
        System.out.println(original);

        System.out.println("\nNueva Versión Clonada:");
        System.out.println(nuevaVersion);
    }
}