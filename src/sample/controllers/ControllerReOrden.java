package sample.controllers;

import sample.modelos.ModelMedicamento;
import sample.objetos.Medicamento;

public class ControllerReOrden {
    public Medicamento[] obtenerMedicamentos(Integer dias){
        ModelMedicamento mm = new ModelMedicamento();
        return mm.getMedicamentosReorden(2, dias);
    }
}
