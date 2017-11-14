package sample.objetos;

public class InfoEmergencia {
    String poliza_seguro;
    String hospital_preferente;
    public InfoEmergencia(String poliza, String hospital){
        this.poliza_seguro = poliza;
        this.hospital_preferente = hospital;
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
}
