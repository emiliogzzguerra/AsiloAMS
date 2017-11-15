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
    public Label desNombre, desCalle, desEdad, desCuarto, desCama, desEstatus, desDescEvento, desCodigo, desCiudad, desApellido;
    @FXML
    public ImageView fotoPx;
    @FXML
    public TextField desEdNombre, desEDApellido, desEdCalle,desEdCodigo, desEdCiudad, desEdEdad, desEdCuarto, desEdCama, desEdEstatus;
    @FXML
    public Button editarCampos, guardarCampos;
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        Controller iD = new Controller();
        Integer id = iD.id;
        ModelPaciente d = new ModelPaciente();
        ModelEvento me = new ModelEvento();
        Paciente p = d.getPaciente(id);
        Evento[] e = me.getEventos(id);

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
        desNombre.setText(p.getNombre());
        desApellido.setText(p.getApellido());
        desCalle.setText(p.getCalle());
        desCodigo.setText(p.getCodigo_postal());
        desCiudad.setText(p.getCiudad());
        desEdad.setText(String.valueOf(p.getEdad()));
        desCuarto.setText(String.valueOf(p.getNumero_cuarto().get()));
        desCama.setText(String.valueOf((p.getNumero_cama()).get()));
        desEstatus.setText(String.valueOf(p.getEstatus()));

/*
        //EventosModel
        String[] InfoEventos = new String[me.getCantidadEventos(id)];
        for (int i = 0; i<me.getCantidadEventos(id); i++){
            InfoEventos[i] = new String("Fecha:     " + e[i].getFecha() + "\n" + "Descripcion:     " + e[i].getDescripcion() + "\n" + "Enfermera:     " + e[i].getEnfermera());
        }

        desDescEvento.setText(InfoEventos[0]);
*/



    }
    @FXML
    public void crearEditar() {
        editarCampos.setVisible(false);

        desNombre.setVisible(false);
        desApellido.setVisible(false);
        desCalle.setVisible(false);
        desCodigo.setVisible(false);
        desCiudad.setVisible(false);
        desCuarto.setVisible(false);
        desCama.setVisible(false);
        desEstatus.setVisible(false);

        guardarCampos.setVisible(true);

        desEdNombre.setVisible(true);
        desEdNombre.setText(desNombre.getText());

        desEDApellido.setVisible(true);
        desEDApellido.setText(desApellido.getText());

        desEdCalle.setVisible(true);
        desEdCalle.setText(desCalle.getText());

        desEdCodigo.setVisible(true);
        desEdCodigo.setText(desCodigo.getText());

        desEdCiudad.setVisible(true);
        desEdCiudad.setText(desCiudad.getText());

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
        desEDApellido.setVisible(false);
        desEdCalle.setVisible(false);
        desEdCodigo.setVisible(false);
        desEdCiudad.setVisible(false);
        desEdCuarto.setVisible(false);
        desEdCama.setVisible(false);
        desEdEstatus.setVisible(false);

        desNombre.setVisible(true);
        desApellido.setVisible(true);
        desCalle.setVisible(true);
        desCodigo.setVisible(true);
        desCiudad.setVisible(true);
        desCuarto.setVisible(true);
        desCama.setVisible(true);
        desEstatus.setVisible(true);

        desNombre.setText(desEdNombre.getText());
        desApellido.setText(desEDApellido.getText());
        desCalle.setText(desEdCalle.getText());
        desCodigo.setText(desEdCodigo.getText());
        desCiudad.setText(desEdCiudad.getText());
        desEdad.setText(desEdad.getText());
        desCuarto.setText(desEdCuarto.getText());
        desCama.setText(desEdCama.getText());
        desEstatus.setText(desEdEstatus.getText());



        guardarCampos.setVisible(false);
    }
}
