package sample.objetos;


import javafx.scene.control.TextField;

public class Receta {

    String identificador;
    String fecha_expedicion;

    public Receta(){
        this.identificador = "";
        this.fecha_expedicion = "Dummy";
    }

    public Receta(String identificador, String fecha_expedicion){
        this.identificador = identificador;
        this.fecha_expedicion = fecha_expedicion;

    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getFecha_expedicion() {
        return fecha_expedicion;
    }

    public void setFecha_expedicion(String fecha_expedicion) {
        this.fecha_expedicion = fecha_expedicion;
    }
}
