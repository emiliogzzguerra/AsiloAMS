package sample.objetos;

import java.util.Optional;

public class Familiar {
    String nombre;
    String apellido;
    String email;
    String parentesco;
    String telefono;
    public Familiar(String nombre,
                    String apellido,
                    String email,
                    String parentesco,
                    String telefono){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.parentesco = parentesco;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParentesco() { return parentesco; }

    public void setParentesco(String parentesco) { this.parentesco = parentesco; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }
}
