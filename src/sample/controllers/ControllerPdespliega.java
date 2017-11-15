package sample.controllers;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import sample.modelos.ModelPaciente;
import sample.objetos.Paciente;

public class ControllerPdespliega implements Initializable {
    @FXML
    public Label desNombre;
    @FXML
    public Label desDireccion;
    @FXML
    public Label desEdad;
    @FXML
    public Label desCuarto;
    @FXML
    public Label desCama;
    @FXML
    public Label desEstatus;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        Controller iD = new Controller();
        Integer id = iD.id;
        ModelPaciente d = new ModelPaciente();
        Paciente p = d.getPaciente(id);

        String nombreCompleto = p.getNombre() + " " + p.getApellido();
        String direccionCompleta = p.getCalle()+ ", " + p.getCiudad() + ", " + p.getCodigo_postal();

        desNombre.setText(nombreCompleto);
        desDireccion.setText(direccionCompleta);
        desEdad.setText(String.valueOf(p.getEdad()));
        desCuarto.setText(String.valueOf(p.getNumero_cuarto()));
        desCama.setText(String.valueOf((p.getNumero_cama())));
        desEstatus.setText(String.valueOf(p.getEstatus()));

    }
}
