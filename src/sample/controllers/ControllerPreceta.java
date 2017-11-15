package sample.controllers;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;
import sample.clases.listaNombres;
import sample.clases.setImage;
import sample.modelos.ModelPaciente;
import sample.objetos.Paciente;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;


public class ControllerPreceta implements Initializable {

    public MenuItem menuAction1Tipo, menuAction2Tipo, menuAction1Medida, menuAction2Medida;
    public MenuButton menuButtonTipo, menuButtonMedida;
    public TextField tfBuscarPaciente;
    public static int id;
    public Label labelNombrePx, labelEdadPx, labelHabitacionPx, labelCamaPx;

    @FXML
    public ImageView fotoPx;

    @FXML
    public void initialize (URL location, ResourceBundle resources) {
        //File file = new File("/sample/fotos/p1.jpg");
        Image image = new Image("/sample/fotos/p1.jpg", 145,135,false,false);
        fotoPx.setImage(image);
    }


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

    public void SearchPaciente() throws Exception {
        listaNombres d = new listaNombres();
        Map<String,Integer> possWords = d.nombres();
        Object[] nombreApellidos = new Object[possWords.size()];
        nombreApellidos = possWords.keySet().toArray();
        String[] stringArray = Arrays.copyOf(nombreApellidos, nombreApellidos.length, String[].class);
        AutoCompletionBinding<String> bind = TextFields.bindAutoCompletion(tfBuscarPaciente, stringArray);
        bind.setOnAutoCompleted(event -> {
            try {
                tfBuscarPaciente.setText(event.getCompletion());
                id = possWords.get(event.getCompletion());
                fillData(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void fillData(int id){
        ModelPaciente d = new ModelPaciente();
        Paciente p = d.getPaciente(id);

        labelNombrePx.setText(p.getNombre() + " " + p.getApellido());
        labelEdadPx.setText(String.valueOf(p.getEdad()));
        labelHabitacionPx.setText(String.valueOf(p.getNumero_cuarto()));
        labelCamaPx.setText(String.valueOf(p.getNumero_cama()));
        String path = "/sample/fotos/emilio.png";
        setImage dd = new setImage();
        Image img = dd.setUpImage(path);
        fotoPx.setImage(img);

    }

}
