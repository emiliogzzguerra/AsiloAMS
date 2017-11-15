package sample.objetos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

public class Paciente {

    String fecha_nacimiento;
    String nombre;
    String apellido;
    String ciudad;
    String calle;
    String codigo_postal;
    String sangre;
    Optional<Integer> numero_cuarto;
    Optional<Integer> numero_cama;
    boolean paciente_medicado_manana;
    boolean paciente_medicado_tarde;
    boolean paciente_medicado_noche;
    int estatus;
    int asilo_id;
    int sexo;

    public Paciente()
    {
        this.estatus = 1;
        this.asilo_id = 1;
        this.sexo = 2;
    }

    public Paciente(String fecha_nacimiento,
                    String nombre,
                    String apellido,
                    String ciudad,
                    String calle,
                    String codigo_postal,
                    String sangre,
                    Optional<Integer> numero_cuarto,
                    Optional<Integer> numero_cama,
                    int estatus,
                    int asilo_id,
                    int sexo)
    {
        this.fecha_nacimiento = fecha_nacimiento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.calle = calle;
        this.codigo_postal = codigo_postal;
        this.sangre = sangre;
        this.numero_cuarto = numero_cuarto;
        this.numero_cama = numero_cama;
        this.paciente_medicado_manana = false;
        this.paciente_medicado_tarde = false;
        this.paciente_medicado_noche = false;
        this.estatus = estatus;
        this.asilo_id = asilo_id;
        this.sexo = sexo;
    }


    public int getEdad(){
        LocalDateTime now = LocalDateTime.now();
        return now.getYear() -  Integer.valueOf(this.fecha_nacimiento.substring(0,4)) ;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getNombre() { return nombre; }

    public String getApellido() {
        return apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public String getSangre() {
        return sangre;
    }

    public Optional<Integer> getNumero_cuarto() {
        return numero_cuarto;
    }

    public Optional<Integer> getNumero_cama() {
        return numero_cama;
    }

    public int getEstatus() {
        return estatus;
    }

    public int getAsilo_id() {
        return asilo_id;
    }

    public int getSexo() {
        return sexo;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public void setSangre(String sangre) {
        this.sangre = sangre;
    }

    public void setNumero_cuarto(Optional<Integer> numero_cuarto) {
        this.numero_cuarto = numero_cuarto;
    }

    public void setNumero_cama(Optional<Integer> numero_cama) {
        this.numero_cama = numero_cama;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public void setAsilo_id(int asilo_id) {
        this.asilo_id = asilo_id;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public boolean isPaciente_medicado_manana() {
        return paciente_medicado_manana;
    }

    public void setPaciente_medicado_manana(boolean paciente_medicado_manana) {
        this.paciente_medicado_manana = paciente_medicado_manana;
    }

    public boolean isPaciente_medicado_tarde() {
        return paciente_medicado_tarde;
    }

    public void setPaciente_medicado_tarde(boolean paciente_medicado_tarde) {
        this.paciente_medicado_tarde = paciente_medicado_tarde;
    }

    public boolean isPaciente_medicado_noche() {
        return paciente_medicado_noche;
    }

    public void setPaciente_medicado_noche(boolean paciente_medicado_noche) {
        this.paciente_medicado_noche = paciente_medicado_noche;
    }
}
