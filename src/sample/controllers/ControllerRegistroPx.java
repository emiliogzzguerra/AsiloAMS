package sample.controllers;

import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import sample.clases.metodoArchivo;


import java.io.File;

public class ControllerRegistroPx {
    //fx:id="masivaButton" onAction="#altaMasiva" />
    //declaración del boton para test.
    public Button masivaButton;

    public void altaMasiva (){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar archivo para alta masiva de pacientes");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Archivos de texto", "*.txt"),
                new ExtensionFilter("Archivos csv", "*.csv"),
                new ExtensionFilter("Todos los archivos", "*.*"));
        Stage mainStage = new Stage();
        File selectedFile = fileChooser.showOpenDialog(mainStage);



        //Mandar método con el archivo
        metodoArchivo.hazAlgo(selectedFile, masivaButton);
    }
}

