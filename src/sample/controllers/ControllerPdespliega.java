package sample.controllers;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

import sample.modelos.ModelEvento;
import sample.modelos.ModelPaciente;
import sample.objetos.Evento;
import sample.objetos.Paciente;

public class ControllerPdespliega implements Initializable {
    @FXML
    public Label desNombre;
    @FXML
    public Label desDireccion;
    @FXML
    public Label desEdad;
    @FXML
    public Label desCuarto;
    @FXML
    public Label desCama;
    @FXML
    public Label desEstatus;
    @FXML
    public Label desDescEvento;
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


        //PacientesModel
        desNombre.setText(nombreCompleto);
        desDireccion.setText(direccionCompleta);
        desEdad.setText(String.valueOf(p.getEdad()));
        desCuarto.setText(String.valueOf(p.getNumero_cuarto()));
        desCama.setText(String.valueOf((p.getNumero_cama())));
        desEstatus.setText(String.valueOf(p.getEstatus()));



        //EventosModel
        String InfoEventos = "Fecha:     " + e.getFecha() + "\n" + "Descripcion:     " + e.getDescripcion() + "\n" + "Enfermera:     " + e.getEnfermera();
        desDescEvento.setText(InfoEventos);



    }
}
