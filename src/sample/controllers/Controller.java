package sample.controllers;

import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.clases.RegistroPx;

public class Controller {


    public Button buscarButton;
    public TextField textBuscar;

    public void buscarPx () {
        String nombrePx = textBuscar.getText();
        buscarButton.setText(nombrePx);
        textBuscar.setText("");

    }

    public void abrirRegistraPx () throws Exception {
        RegistroPx registroPx = new RegistroPx();
        Stage stage = new Stage();
        try {
            registroPx.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}




