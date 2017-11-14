package sample.controllers;

//import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
//import org.controlsfx.control.textfield.AutoCompletionBinding;
//mport org.controlsfx.control.textfield.TextFields;

public class ControllerPreceta {

    public MenuItem menuAction1Tipo, menuAction2Tipo, menuAction1Medida, menuAction2Medida;
    public MenuButton menuButtonTipo, menuButtonMedida;
    //public TextFields tfBuscarPaciente;
    //public Label labelNomprePx;

    public void onMenuSel (){
        menuAction1Tipo.setOnAction(event -> {
            menuButtonTipo.setText(menuAction1Tipo.getText());
        });
        menuAction2Tipo.setOnAction(event -> {
            menuButtonTipo.setText(menuAction2Tipo.getText());
        });
        menuAction1Medida.setOnAction(event -> {
            menuButtonMedida.setText(menuAction1Medida.getText());
        });
        menuAction2Medida.setOnAction(event -> {
            menuButtonMedida.setText(menuAction2Medida.getText());
        });
    }

    /*public void SearchPaciente() {
        String[] possWords = {"Jai", "Emilio", "Carlos", "Javier", "te la comes"};
        AutoCompletionBinding<String> bind = TextFields.bindAutoCompletion(tfBuscarPaciente, possWords);
        bind.setOnAutoCompleted(event -> {
            labelNomprePx.setText(String.valueOf(bind.getCompletionTarget()));
        });
    }*/

}
