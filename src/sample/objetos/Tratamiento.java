package sample.objetos;

public class Tratamiento {
    String nombre_tratamiento;
    String descripcion_tratamiento;

    public Tratamiento(String nombre, String descripcion)
    {
        this.nombre_tratamiento = nombre;
        this.descripcion_tratamiento = descripcion;
    }

    public String getNombre_tratamiento() {
        return nombre_tratamiento;
    }

    public String getDescripcion_tratamiento() {
        return descripcion_tratamiento;
    }

    public void setNombre_tratamiento(String nombre_tratamiento) {
        this.nombre_tratamiento = nombre_tratamiento;
    }

    public void setDescripcion_tratamiento(String descripcion_tratamiento) {
        this.descripcion_tratamiento = descripcion_tratamiento;
    }
}
