package sample.objetos;

public class Enfermedad {
    String nombre;
    String fecha_inicio;
    String fecha_final;
    public Enfermedad(String nombre,
                      String fecha_inicio,
                      String fecha_final){
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

}
