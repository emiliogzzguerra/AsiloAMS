package sample.objetos;

public class Evento {
    String fecha;
    String enfermera;
    String descripcion;

    public Evento(String fecha, String enfermera, String descripcion){
        this.fecha = fecha;
        this.enfermera = enfermera;
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEnfermera() {
        return enfermera;
    }

    public void setEnfermera(String enfermera) {
        this.enfermera = enfermera;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
