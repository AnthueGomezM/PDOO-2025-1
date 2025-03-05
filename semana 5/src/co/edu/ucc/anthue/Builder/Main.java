package co.edu.ucc.anthue.Builder;

import java.util.Base64;

class Usuario {
    private String nombre;
    private int edad;
    private String direccion;
    private String telefono;

    private Usuario(UsuarioBuilder builder) {
        this.nombre = builder.nombre;
        this.edad = builder.edad;
        this.direccion = builder.direccion;
        this.telefono = builder.telefono;
    }

    public static class UsuarioBuilder {
        private String nombre;
        private int edad;
        private String direccion;
        private String telefono;

        public UsuarioBuilder(String nombre) {
            this.nombre = nombre;
        }

        public UsuarioBuilder setEdad(int edad) {
            this.edad = edad;
            return this;
        }

        public UsuarioBuilder setDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public UsuarioBuilder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }

    public String toString() {
        return "Usuario: " + nombre + ", Edad: " + edad + ", Dirección: " + direccion + ", Teléfono: " + telefono;
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
                  En una aplicación, los usuarios pueden configurarse con diferentes atributos como nombre,
                   edad, dirección y número de teléfono. No todos los atributos son obligatorios, por lo que es
                    conveniente usar Builder para evitar múltiples constructores.
                ---------------------------------------------------------------------------------------------------------------
                """;
    }

    public static String getIdentidad() {
        String nombreCompleto = "Anthue Edinson Yael Gomez Morales";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
    public static void main(String[] args) {
        System.out.println(encabezado());
        Usuario usuario = new Usuario.UsuarioBuilder("Juan Pérez")
                .setEdad(30)
                .setDireccion("Av. Principal 123")
                .setTelefono("123456789")
                .build();

        System.out.println(usuario);

        System.out.println("\nIdentidad codificada: " + getIdentidad());
    }
}
