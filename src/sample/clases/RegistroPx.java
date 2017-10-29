package sample.clases;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistroPx extends Application {

    @Override
    public void start (Stage secondaryStage) throws Exception{
        Parent root2 = FXMLLoader.load(getClass().getResource("pantallas/PregistroPx.fxml"));
        secondaryStage.setTitle("Registro de Paciente");
        secondaryStage.setScene(new Scene(root2, 900, 700));
        secondaryStage.show();
    }

    public static void main(String[] args){ launch(args);}
}
