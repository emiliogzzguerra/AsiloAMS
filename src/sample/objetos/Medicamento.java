package sample.objetos;

public class Medicamento {
    String nombre;
    String tipo;
    public Medicamento(){
        this.nombre = null;
        this.tipo = null;
    }
    public Medicamento(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
