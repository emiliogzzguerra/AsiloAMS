package sample.objetos;


import javafx.scene.control.TextField;

public class Receta {

    TextField identificador;
    String fecha_expedicion;

    public Receta(){
        TextField dummy = null;
        this.identificador = dummy;
        this.fecha_expedicion = "Dummy";
    }

    public Receta(TextField identificador, String fecha_expedicion){
        this.identificador = identificador;
        this.fecha_expedicion = fecha_expedicion;

    }

    public TextField getIdentificador() {
        return identificador;
    }

    public void setIdentificador(TextField identificador) {
        this.identificador = identificador;
    }

    public String getFecha_expedicion() {
        return fecha_expedicion;
    }

    public void setFecha_expedicion(String fecha_expedicion) {
        this.fecha_expedicion = fecha_expedicion;
    }
}
