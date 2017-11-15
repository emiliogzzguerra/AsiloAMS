package sample.objetos;

public class Medicamento {
    String nombre;
    String tipo;
    Integer cantidad;
    String dosis;
    boolean manana;
    boolean tarde;
    boolean noche;

    public Medicamento(String nombre, String tipo, Integer cantidad, String dosis, boolean manana, boolean tarde, boolean noche){
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.dosis = dosis;
        this.manana = manana;
        this.tarde = tarde;
        this.noche = noche;
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

    public Integer getCantidad() { return cantidad; }

    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public String getDosis() { return dosis; }

    public void setDosis(String dosis) { this.dosis = dosis; }

    public boolean isManana() { return manana; }

    public void setManana(boolean manana) { this.manana = manana; }

    public boolean isTarde() { return tarde; }

    public void setTarde(boolean tarde) { this.tarde = tarde; }

    public boolean isNoche() { return noche; }

    public void setNoche(boolean noche) { this.noche = noche; }

}
