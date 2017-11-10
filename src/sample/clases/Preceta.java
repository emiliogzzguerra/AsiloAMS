package sample.clases;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Preceta extends Application {

    @Override
    public void start (Stage secondaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/pantallas/Preceta.fxml"));
        Parent root2 = loader.load();
        secondaryStage.setTitle("Registro de Receta");
        secondaryStage.setScene(new Scene(root2, 800, 600));
        secondaryStage.show();
    }

    public static void main(String[] args){ launch(args);}
}