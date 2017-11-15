package sample.clases;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Pdespliega extends Application{


    @Override
    public void start (Stage thirdStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/pantallas/Pdespliega.fxml"));
        Parent root3 = loader.load();
        thirdStage.setTitle("Perfil de Paciente");
        thirdStage.setScene(new Scene(root3, 900, 700));
        thirdStage.show();

    }
    public static void main(String[] args){ launch(args);}

}
