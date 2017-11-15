package sample.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import sample.clases.listaNombres;
import sample.clases.setImage;
import sample.modelos.ModelMedicamento;
import sample.modelos.ModelPaciente;
import sample.modelos.ModelReceta;
import sample.objetos.Medicamento;
import sample.objetos.Paciente;
import sample.objetos.Receta;

import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;


public class ControllerPreceta implements Initializable {

    public ChoiceBox dropdownTipo, dropdownMedida;
    public TextField tfBuscarPaciente, nombreMedicina, dosis, cantidad, identificadorReceta;
    public DatePicker fechaInicio, fechaFinal, fechaExpedicion;
    public static int id;
    public Label labelNombrePx, labelEdadPx, labelHabitacionPx, labelCamaPx;

    public Medicamento m  = new Medicamento();
    public Receta r = new Receta(identificadorReceta.getText(), fechaExpedicion.getValue().toString());

    ObservableList<String> tipoList = FXCollections.observableArrayList
            ("- Tipo -","Pastillas","Liquido", "Injeccion");
    ObservableList<String> medidaList = FXCollections.observableArrayList
            ("- Medida -","Mililitros","Gramos");

    @FXML
    public ImageView fotoPx;

    @FXML
    public void initialize (URL location, ResourceBundle resources) {
        Image image = new Image("/sample/fotos/p1.jpg", 145,135,false,false);
        fotoPx.setImage(image);
        dropdownMedida.setItems(medidaList);
        dropdownTipo.setItems(tipoList);
        dropdownTipo.setValue("- Tipo -");
        dropdownMedida.setValue("- Medida -");
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

        labelNombrePx.setText("Nombre: " + p.getNombre() + " " + p.getApellido());
        labelEdadPx.setText("Edad: " + String.valueOf(p.getEdad()) + " años");
        labelHabitacionPx.setText("Cuarto: " + String.valueOf(p.getNumero_cuarto()));
        labelCamaPx.setText("Cama: " + String.valueOf(p.getNumero_cama()));
        if(p.getPath() != null){
            setImage dd = new setImage();
            String path = p.getPath();
            Image img = dd.setUpImage(path);
            fotoPx.setImage(img);
        }else{
            Image image = new Image("/sample/fotos/p1.jpg", 145,135,false,false);
            fotoPx.setImage(image);
        }

    }

    public int guardaMedicina() throws SQLException {
        Medicamento medicamento = new Medicamento();
        Receta receta = new Receta(identificadorReceta.getText(), fechaExpedicion.getValue().toString());

        String medida = "- Medida -";
        String tipo = "- Tipo -";

        if (dropdownTipo.getValue() == "Pastillas")
            tipo = "Pastillas";
        if (dropdownTipo.getValue() == "Liquido")
            tipo = "Liquido";
        if (dropdownTipo.getValue() == "Injeccion")
            tipo = "Injeccion";
        if (dropdownTipo.getValue() == "- Tipo -")
            tipo = "- Tipo -";

        if (dropdownMedida.getValue() == "Mililitros")
            medida = "Mililitros";
        if (dropdownMedida.getValue() == "Gramos")
            medida = "Gramos";
        if (dropdownMedida.getValue() == "- Medida -")
            medida = "- Medida -";

        String warning = "Los campos: ";
        if (nombreMedicina.getAccessibleText().equals(m.getNombre())){
            warning += "Nombre medicina, ";
        } else {
            medicamento.setNombre(nombreMedicina.getText());
        }
        if (dosis.getAccessibleText().equals(m.getDosis())){
            warning += "Dosis, ";
        } else {
            medicamento.setDosis(dosis.getText());
        }
        if (identificadorReceta.getAccessibleText().equals(r.getIdentificador())){
            warning += "Numero de receta, ";
        } else {
            receta.setIdentificador(identificadorReceta.getText());
        }
        if (cantidad.getAccessibleText().equals(m.getCantidad())){
            warning += "Cantidad, ";
        } else {
            medicamento.setCantidad(Integer.valueOf(cantidad.getText()));
        }
        if (fechaInicio.getAccessibleText().equals(m.getFecha_inicio())){
            medicamento.setFecha_inicio("1970/01/01");
            warning += "fecha inicio, ";
        } else {
            medicamento.setFecha_inicio(fechaInicio.getValue().toString());
        }
        if (fechaFinal.getAccessibleText().equals(m.getFecha_final())){
            medicamento.setFecha_final("1970/01/01");
            warning += "fecha final, ";
        } else {
            medicamento.setFecha_final(fechaFinal.getValue().toString());
        }
        if (fechaExpedicion.getAccessibleText().equals(r.getFecha_expedicion())){
            receta.setFecha_expedicion("1970/01/01");
            warning += "fecha final, ";
        } else {
            receta.setFecha_expedicion(fechaExpedicion.getValue().toString());
        }
        if (dropdownTipo.getValue().equals("- Tipo -")){
            warning += "Tipo";
        } else {
            medicamento.setTipo(tipo);
        }
        if (dropdownMedida.getValue().equals("- Medida -")){
            warning += "Medida";
        } else {
            medicamento.setMedida(medida);
        }

        ModelMedicamento md = new ModelMedicamento();
        ModelReceta mr = new ModelReceta();

        if (warning.equals("Los campos: ")){
            boolean a = md.insertar(medicamento, id);
            System.out.print(a);
            boolean c = mr.insertar(receta, id);
            System.out.print(c);
            return 1;
        }else {
            warning += ". No fueron llenados, ¿Quiere proceder?";

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Uno o más campos faltantes");
            alert.setContentText(warning);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                boolean a = md.insertar(medicamento, id);
                System.out.print(a);
                boolean c = mr.insertar(receta, id);
                System.out.print(c);
                return 1;
            } else {
                return 0;
            }
        }


    }

}
