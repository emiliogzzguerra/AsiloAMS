package sample.clases;

import java.io.File;
import javafx.scene.control.*;

public class metodoArchivo {

    //fx:id="masivaButton" onAction="#altaMasiva" />
    //Test altamasiva poner path en boton

    public static void hazAlgo(File selectedFile, Button masivaButton) {
        //Testing
        //Test de que si agarra el archivo
        masivaButton.setText(selectedFile.getAbsolutePath());
    }
}
