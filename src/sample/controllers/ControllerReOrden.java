package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.modelos.ModelFamiliar;
import sample.modelos.ModelMedicamento;
import sample.objetos.Familiar;
import sample.objetos.Medicamento;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerReOrden implements Initializable {

    @FXML
    public ImageView fotoPx;
    public ListView listView;
    public Label nombrePaciente;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle){
        Image image = new Image("/sample/fotos/p1.jpg", 145,135,false,false);
        fotoPx.setImage(image);
    }

    public void Prueba (){
        Medicamento[] meds;
        ModelFamiliar mf = new ModelFamiliar();
        Familiar[] familiares = mf.getFamiliaresReorden(2);
        meds = obtenerMedicamentos(7);
        for (int i=0; i <= meds.length - 1; i++) {
            nombrePaciente.setText("Nombre: " + meds[i].getNombre());
            String sDiasRestantes = "Dias restantes: " + String.valueOf(meds[i].getDias_restantes());
            System.out.println(sDiasRestantes);
            System.out.println(familiares.length);
            System.out.println(familiares[0].getNombre());
            String familiar = "Nombre del familiar a contactar: " + familiares[i].getNombre();
            String celular = "Número celular: " + familiares[i].getTelefono();
            String nombreMed = "Nombre del medicamento: Advil";
            ObservableList<String> list = FXCollections.observableArrayList(nombreMed);
            list.add(sDiasRestantes);
            list.add(familiar);
            list.add(celular);
            listView.getItems().addAll(list);
        }
    }

    public Medicamento[] obtenerMedicamentos(Integer dias){
        ModelMedicamento mm = new ModelMedicamento();
        return mm.getMedicamentosReorden(2, dias);
    }

}
