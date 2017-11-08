package sample.controllers;

import javafx.scene.control.*;
import javafx.stage.Stage;
//import sample.clases.BuscarId;
import sample.clases.Pdespliega;
import sample.clases.RegistroPx;

public class Controller {


    public Button buscarButton;
    public TextField textBuscar;


    public void advancedSearch(){
        //String[] possWords = {"Jai","Emilio","Carlos","Javier","te la comes"};
        //TextFields.bindAutoCompletion(textBuscar, possWords);
        //String nameSelected = textBuscar.getText();
        //Metodo para buscar el id con el nombre y apellido del paciente usando el nuevo string en textBuscar
        //BuscarId buscarId = new BuscarId();
        //int ID = buscarId.buscarPxId(nameSelected);
        //Metodo para abrir nueva ventana del Px dando el id del paciente
        //PerfilPaciente nuevoPerfil = PerfilPaciente();
        //nuevoPerfil.abrir(ID);

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




