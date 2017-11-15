package sample.objetos;

public class Medicamento {
    String nombre;
    String tipo;
    Integer cantidad;
    String dosis;
    String fecha_inicio;
    String fecha_final;
    String medida;
    boolean manana;
    boolean tarde;
    boolean noche;

    public Medicamento(){
        this.nombre = "Dummy";
        this.tipo = "Dummy";
        this.cantidad = 0;
        this.dosis = "Dummy";
        this.fecha_inicio = "Dummy";
        this.fecha_final = "Dummy";
        this.medida = "Dummy";
        this.manana = false;
        this.tarde = false;
        this.noche = false;
    }

    public Medicamento(String nombre,
                       String tipo,
                       Integer cantidad,
                       String dosis,
                       String fecha_inicio,
                       String fecha_final,
                       String medida,
                       boolean manana,
                       boolean tarde,
                       boolean noche){
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.dosis = dosis;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.medida = medida;
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

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
}
