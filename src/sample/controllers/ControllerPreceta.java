package sample.controllers;


import javafx.event.EventHandler;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class ControllerPreceta {

    public MenuItem menuAction1Tipo, menuAction2Tipo, menuAction1Medida, menuAction2Medida;
    public MenuButton menuButtonTipo, menuButtonMedida;

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
}
