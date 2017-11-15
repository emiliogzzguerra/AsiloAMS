package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import sample.clases.metodoArchivo;
import sample.modelos.GeneralModel;
import sample.modelos.ModelEnfermedad;
import sample.modelos.ModelPaciente;
import sample.modelos.ModelPadecimiento;
import sample.objetos.Enfermedad;
import sample.objetos.Paciente;
import sample.objetos.Padecimiento;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ControllerRegistroPx {

    //fx:id="masivaButton" onAction="#altaMasiva" />
    //declaración del boton para test.
    public Button masivaButton;
    public TextField nombreTratamiento;
    //General
    public TextField campoNombrePaciente;
    public TextField campoFechaDeNacimiento;
    public TextField campoApellidoPaciente;
    public TextField campoCiudad;
    public TextField campoCalle;
    public TextField campoCodigoPostal;
    public TextField campoCuartoPaciente;
    public TextField campoCamaPaciente;
    public TextField campoSangrePaciente;
    public ChoiceBox dropdownSexo;
    //Tratamientos
    public Label tituloTratamientos;
    public Label infoTratamientos;
    public TextField campoNombreTratamiento;
    public TextArea campoDescripcionTratamiento;
    public Button botonGuardaTratamientos;
    //Familiares
    public TextField campoNombreFamiliar;
    public TextField campoParentesco;
    public TextField campoIncumbencia;
    public TextField campoTelCasa;
    public TextField campoTelCelular;
    public TextField campoEmail;
    //Emergencia
    public TextField campoPoliza;
    public TextField campoFechaVencimiento;
    public TextField campoTelAmbulancia;
    public TextField campoHospital;
    public TextArea areaInfoEmergencia;
    //Expediente
    public TextField campoNombreEnfermedad;
    public TextField campoFechaInicio;
    public TextField campoFechaFinal;
    public TextField campoDescrEvento;
    public TextField campoFechaEvento;
    //Medicamentos
    public TextField campoNombreMedicina;
    public TextField campoCantMedicina;
    public ChoiceBox dropdownMedicionMedicina;
    public ChoiceBox dropdownTipoMedicina;

    public boolean proceed = false;

    public Paciente p  = new Paciente();

    ObservableList<String> sexoList = FXCollections.observableArrayList
            ("- Sexo -","Masculino","Femenino");


    @FXML
    private void initialize() throws SQLException {
        dropdownSexo.setItems(sexoList);
        dropdownSexo.setValue("- Sexo -");

        String myQry = "select distinct tipo from medicamento";
        GeneralModel gm = new GeneralModel();
        ResultSet myRs = gm.getQuery(myQry);

        ObservableList<String> medicinasList = FXCollections.observableArrayList();
        while(myRs.next()){
            medicinasList.add(myRs.getString(1));
        }
        dropdownTipoMedicina.setItems(medicinasList);

        myQry = "select distinct medida from paciente_medicamento";
        myRs = gm.getQuery(myQry);

        ObservableList<String> medicionList = FXCollections.observableArrayList();
        while(myRs.next()){
            medicionList.add(myRs.getString(1));
        }
        dropdownMedicionMedicina.setItems(medicionList);


        p.setNombre(campoNombrePaciente.getText());
        p.setFecha_nacimiento(campoFechaDeNacimiento.getText());
        p.setApellido(campoApellidoPaciente.getText());
        p.setCiudad(campoCiudad.getText());
        p.setCalle(campoCalle.getText());
        p.setCodigo_postal(campoCodigoPostal.getText());
        p.setSangre(campoSangrePaciente.getText());
        p.setNumero_cuarto(null);
        p.setNumero_cama(null);
        p.setPaciente_medicado_manana(false);
        p.setPaciente_medicado_tarde(false);
        p.setPaciente_medicado_noche(false);
        p.setEstatus(1);
        p.setAsilo_id(1);
        p.setSexo(2);
    }

    public int guardaInfoGeneral() throws SQLException {
        Paciente pGuardar = new Paciente();

        String estatus = "activo";
        int asilo_id = 1;
        int sexo = 2;

        if (dropdownSexo.getValue() == "Masculino")
            sexo = 0;
        if (dropdownSexo.getValue() == "Femenino")
            sexo = 1;
        if (dropdownSexo.getValue() == "- Sexo -")
            sexo = 2;

        String warning = "Los campos: ";
        if (campoNombrePaciente.getText().equals(p.getNombre())){
            warning += "Nombre, ";
        } else {
            pGuardar.setNombre(campoNombrePaciente.getText());
        }

        if (campoApellidoPaciente.getText().equals(p.getApellido())){
            warning += "Apellido, ";
        } else {
            pGuardar.setApellido(campoApellidoPaciente.getText());
        }

        if (campoCiudad.getText().equals(p.getCiudad())){
            warning += "Ciudad, ";
        } else {
            pGuardar.setCiudad(campoCiudad.getText());
        }

        if (campoCalle.getText().equals(p.getCalle())){
            warning += "Calle, ";
        } else {
            pGuardar.setCalle(campoCalle.getText());
        }

        if (campoCodigoPostal.getText().equals(p.getCodigo_postal())){
            pGuardar.setCodigo_postal("000000");
            warning += "Código Postal, ";
        } else {
            pGuardar.setCodigo_postal(campoCodigoPostal.getText());
        }

        if (campoFechaDeNacimiento.getText().equals(p.getFecha_nacimiento())){
            pGuardar.setFecha_nacimiento("1970/01/01");
            warning += "Fecha de nacimiento, ";
        } else {
            pGuardar.setFecha_nacimiento(campoFechaDeNacimiento.getText());
        }

        if (campoSangrePaciente.getText().equals(p.getSangre())){
            pGuardar.setSangre("X");
            warning += "Tipo de Sangre, ";
        } else {
            pGuardar.setSangre(campoSangrePaciente.getText());
        }

        if (campoCuartoPaciente.getText().equals("Cuarto del Paciente")){
            pGuardar.setNumero_cuarto(null);
            warning += "Número de cuarto, ";
        } else {
            Optional<Integer> op = Optional.ofNullable(Integer.valueOf(campoCuartoPaciente.getText()));
            pGuardar.setNumero_cuarto(op);
        }

        if (campoCamaPaciente.getText().equals("Cama del Paciente")){
            pGuardar.setNumero_cama(null);
            warning += "Número de cama, ";
        } else {
            Optional<Integer> op = Optional.ofNullable(Integer.valueOf(campoCamaPaciente.getText()));
            pGuardar.setNumero_cama(op);
        }

        if (dropdownSexo.getValue().equals("- Sexo -")){
            warning += "Sexo";
        } else {
            pGuardar.setSexo(sexo);
        }
        ModelPaciente mp = new ModelPaciente();

        if(warning.equals("Los campos: ")){
            int a = mp.insertar(pGuardar);
            System.out.print(a);
            return 1;
        } else {
            warning += ". No fueron llenados, ¿Quiere proceder?";

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Advertencia");
            alert.setHeaderText("Uno o más campos faltantes");
            alert.setContentText(warning);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                int a = mp.insertar(pGuardar);
                System.out.print(a);
                return 1;
            } else {
                return 0;
            }
        }
    }


    public int guardaTratamientos(){
        ModelPadecimiento mpadecimiento = new ModelPadecimiento();
        ModelPaciente mp = new ModelPaciente();
        Integer pacienteId = mp.getRowsPacientes();
        Padecimiento p = new Padecimiento("sifilis","Despues de su viaje a sudan");

        mpadecimiento.insertar(p,pacienteId);

        return 0;
    }

    public int guardaFamiliares(){

        return 0;
    }

    public int guardaEmergencia(){


        return 0;
    }

    public int guardaExpediente(){
        ModelEnfermedad me = new ModelEnfermedad();
        Enfermedad EnfDummy = new Enfermedad("Lepra", "1/1/2017", "15/1/2017");
        me.insertar(EnfDummy,1);
        return 0;
    }

    public int guardaMedicamentos(){
        return 0;
    }

    public void altaMasiva (){

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar archivo para alta masiva de pacientes");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Archivos de texto", "*.txt"),
                new ExtensionFilter("Archivos csv", "*.csv"),
                new ExtensionFilter("Todos los archivos", "*.*"));
        Stage mainStage = new Stage();
        File selectedFile = fileChooser.showOpenDialog(mainStage);
        //Mandar método con el archivo
        metodoArchivo.hazAlgo(selectedFile, masivaButton);
    }
}

