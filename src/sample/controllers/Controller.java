package sample.controllers;

import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.clases.BuscarId;
import org.controlsfx.control.textfield.TextFields;
import sample.clases.Pdespliega;
import sample.clases.RegistroPx;

public class Controller {


    public Button buscarButton;
    public TextField textBuscar;


    public void advancedSearch(){
        String[] possWords = {"Jai","Emilio","Carlos","Javier","te la comes"};
        TextFields.bindAutoCompletion(textBuscar, possWords);
    }

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

    public void abrirPdespliega () throws Exception {
        Pdespliega pdespliega = new Pdespliega();
        Stage stage = new Stage();
        try {
            pdespliega.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}




