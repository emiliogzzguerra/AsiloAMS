package sample.controllers;


import javafx.scene.control.*;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import sample.clases.*;

import java.sql.*;

public class Controller {

    public Button buscarButton;
    public TextField textBuscar;
    public CheckBox TcheckBox;



    public void advancedSearch() throws Exception {
        listaNombres d = new listaNombres();
        String[] possWords = d.nombres();
        AutoCompletionBinding<String> bind = TextFields.bindAutoCompletion(textBuscar, possWords);
        bind.setOnAutoCompleted(event -> {
            try {
                abrirPdespliega();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
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

    public void selectionCB (){
        if(TcheckBox.isSelected()){
            String nm = "checkbox";
            buscarButton.setText(nm);
        }
    }

    public void abrirPreceta() throws Exception {
        Preceta preceta = new Preceta();
        Stage stage = new Stage();
        try {
            preceta.start(stage);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void abrirPxPorMedicar() throws Exception {
        PxPorMedicar pxPorMedicar = new PxPorMedicar();
        Stage stage = new Stage();
        try{
            pxPorMedicar.start(stage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void abrirReOrden() throws Exception {
        ReOrden reOrden = new ReOrden();
        Stage stage = new Stage();
        try{
            reOrden.start(stage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public Statement conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Get connection with MySQL database
            Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_asilo?useSSL=false",
                    "root", "1212");
            Statement stmt = mycon.createStatement();

            return stmt;
        } catch (Exception e) {
            System.out.println("Error with database connection");
            e.printStackTrace();
            return null;
        }
    }

}




