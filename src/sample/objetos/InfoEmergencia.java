package sample.objetos;

public class InfoEmergencia {
    String poliza_seguro;
    String hospital_preferente;
    String comentarios;
    String telefono;

    public InfoEmergencia(String poliza, String hospital, String comentarios, String telefono){
        this.poliza_seguro = poliza;
        this.hospital_preferente = hospital;
        this.comentarios = comentarios;
        this.telefono = telefono;
    }

    public String getPoliza_seguro() {
        return poliza_seguro;
    }

    public void setPoliza_seguro(String poliza_seguro) {
        this.poliza_seguro = poliza_seguro;
    }

    public String getHospital_preferente() {
        return hospital_preferente;
    }

    public void setHospital_preferente(String hospital_preferente) {
        this.hospital_preferente = hospital_preferente;
    }

    public String getComentarios() { return comentarios; }

    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }
}
