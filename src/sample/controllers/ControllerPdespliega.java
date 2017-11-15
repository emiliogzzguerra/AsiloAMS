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
    public void initialize(URL location, ResourceBundle resources) {
        Controller iD = new Controller();
        Integer id = iD.id;
        System.out.println(id);


        Paciente p = new Paciente();
        ModelPaciente d = new ModelPaciente();

        p = d.getPaciente(id);
        System.out.println(p.getNombre());
        //System.out.println(d.getPaciente(18).getSexo());
        //p = d.getPaciente(18);
        //System.out.print(p.getNombre());
        desNombre.setText(p.getNombre());
        //System.out.println(p.getSexo());

    }
}
