package sample.clases;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistroPx extends Application {

    @Override
    public void start (Stage secondaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/pantallas/PregistroPx.fxml"));
        Parent root2 = loader.load();
        secondaryStage.setTitle("Registro de Paciente");
        secondaryStage.setScene(new Scene(root2, 900, 700));
        secondaryStage.show();
    }

    public static void main(String[] args){ launch(args);}
}
