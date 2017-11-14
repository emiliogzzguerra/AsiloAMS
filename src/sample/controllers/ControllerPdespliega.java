package sample.controllers;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


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
