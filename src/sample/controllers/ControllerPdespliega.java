package sample.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.clases.Pdespliega;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.controlsfx.control.textfield.TextFields;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;


public class ControllerPdespliega implements Initializable {
    @FXML
    public Label desNombre;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        desNombre.setText("LOLas");
    }
}
