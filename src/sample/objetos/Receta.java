package sample.objetos;

import java.sql.Date;

public class Receta {

    String identificador;
    Date fecha_expedicion;


    public Receta(String identificador, Date fecha_expedicion){
        this.identificador = identificador;
        this.fecha_expedicion = fecha_expedicion;

    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Date getFecha_expedicion() {
        return fecha_expedicion;
    }

    public void setFecha_expedicion(Date fecha_expedicion) {
        this.fecha_expedicion = fecha_expedicion;
    }
}
