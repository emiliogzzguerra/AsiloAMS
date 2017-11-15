package sample.controllers;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.nio.Buffer;
import java.util.ResourceBundle;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.clases.setImage;
import sample.modelos.ModelEvento;
import sample.modelos.ModelPaciente;
import sample.objetos.Evento;
import sample.objetos.Paciente;

public class ControllerPdespliega implements Initializable {
    @FXML
    public Label desNombre, desDireccion, desEdad, desCuarto, desCama, desEstatus, desDescEvento;
    @FXML
    public ImageView fotoPx;
    @FXML
    public TextField desEdNombre, desEdDireccion, desEdEdad, desEdCuarto, desEdCama, desEdEstatus;
    @FXML
    public Button editarCampos, guardarCampos;
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        Controller iD = new Controller();
        Integer id = iD.id;
        ModelPaciente d = new ModelPaciente();
        ModelEvento me = new ModelEvento();
        Paciente p = d.getPaciente(id);
        Evento e = me.getEvento(id);
        String nombreCompleto = p.getNombre() + " " + p.getApellido();
        String direccionCompleta = p.getCalle()+ ", " + p.getCiudad() + ", " + p.getCodigo_postal();

        if(p.getPath() != null){
            setImage dd = new setImage();
            String path = p.getPath();
            Image img = dd.setUpImage(path);
            fotoPx.setImage(img);
        }else{
            Image image = new Image("/sample/fotos/p1.jpg", 145,135,false,false);
            fotoPx.setImage(image);
        }

        //PacientesModel
        desNombre.setText(nombreCompleto);
        desDireccion.setText(direccionCompleta);
        desEdad.setText(String.valueOf(p.getEdad()));
        desCuarto.setText(String.valueOf(p.getNumero_cuarto().get()));
        desCama.setText(String.valueOf((p.getNumero_cama()).get()));
        desEstatus.setText(String.valueOf(p.getEstatus()));



        //EventosModel
        String InfoEventos = "Fecha:     " + e.getFecha() + "\n" + "Descripcion:     " + e.getDescripcion() + "\n" + "Enfermera:     " + e.getEnfermera();
        desDescEvento.setText(InfoEventos);




    }
    @FXML
    public void crearEditar() {
        editarCampos.setVisible(false);

        desNombre.setVisible(false);
        desDireccion.setVisible(false);
        desCuarto.setVisible(false);
        desCama.setVisible(false);
        desEstatus.setVisible(false);

        guardarCampos.setVisible(true);

        desEdNombre.setVisible(true);
        desEdNombre.setText(desNombre.getText());

        desEdDireccion.setVisible(true);
        desEdDireccion.setText(desDireccion.getText());

        desEdCuarto.setVisible(true);
        desEdCuarto.setText(desCuarto.getText());

        desEdCama.setVisible(true);
        desEdCama.setText(desCama.getText());

        desEdEstatus.setVisible(true);
        desEdEstatus.setText(desEstatus.getText());

    }

    @FXML
    public void guardarCampos(){
        editarCampos.setVisible(true);

        desEdNombre.setVisible(false);
        desEdDireccion.setVisible(false);
        desEdCuarto.setVisible(false);
        desEdCama.setVisible(false);
        desEdEstatus.setVisible(false);

        desNombre.setVisible(true);
        desDireccion.setVisible(true);
        desCuarto.setVisible(true);
        desCama.setVisible(true);
        desEstatus.setVisible(true);

        desNombre.setText(desEdNombre.getText());
        desDireccion.setText(desEdDireccion.getText());
        desEdad.setText(desEdad.getText());
        desCuarto.setText(desEdCuarto.getText());
        desCama.setText(desEdCama.getText());
        desEstatus.setText(desEdEstatus.getText());



        guardarCampos.setVisible(false);
    }
}
