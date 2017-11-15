package sample.modelos;

import sample.objetos.Familiar;
import sample.objetos.Medicamento;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class ModelMedicamento {

    public boolean insertar(Medicamento med, int id) {
        Statement myStmt = GeneralModel.connect();
        Statement myStmt2 = GeneralModel.connect();
        String query = "INSERT INTO ";
        query += "medicamento";
        String sql = new StringBuilder()
                .append("(nombre, tipo, paciente_id) VALUES (")
                .append("'")
                .append(med.getNombre()) // nombre
                .append("','")
                .append(med.getTipo())  // tipo
                .append(",")
                .append(id) //paciente id
                .append(")")
                .toString();
        String query2 = "INSERT INTO ";
        query2 += "paciente_medicamento";
        StringBuilder sql2 = new StringBuilder()
                .append("(cantidad, dosis, manana, tarde, noche) VALUES (")
                .append(med.getCantidad())
                .append(",'")
                .append(med.getDosis())
                .append("',")
                .append(med.isManana())
                .append(",")
                .append(med.isTarde())
                .append(",")
                .append(med.isNoche())
                .append("')");
        try{
            myStmt.executeQuery(query);
            myStmt2.executeQuery(query2);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Medicamento[] getMedicamentosReorden(Integer id,Integer dias){
        String query = "select * from paciente inner join paciente_medicamento where paciente.id = paciente_medicamento.paciente_id and paciente.id =" + id.toString();

        Statement myStmt = GeneralModel.connect();

        try {
            ResultSet myRs = myStmt.executeQuery(query);

            Medicamento[] meds = new Medicamento[myRs.getFetchSize()];


            Integer pastillas_actuales;
            Integer pastillas_dia;
            Integer dias_restantes;

            Integer i=0;
            while(myRs.next()){
                Integer sumaDias = 0;

                if(myRs.getBoolean("manana"))
                    sumaDias++;
                if(myRs.getBoolean("tarde"))
                    sumaDias++;
                if(myRs.getBoolean("noche"))
                    sumaDias++;

                pastillas_dia = sumaDias * myRs.getInt("dosis");
                pastillas_actuales = myRs.getInt("cantidad") - pastillas_dia;
                dias_restantes = pastillas_actuales/pastillas_dia;

                if(dias_restantes <= dias){
                    meds[i] = new Medicamento(myRs.getString("nombre"),
                            myRs.getString("tipo"),
                            myRs.getInt("cantidad"),
                            myRs.getString("dosis"),
                            myRs.getString("fecha_inicio"),
                            myRs.getString("fecha_final"),
                            myRs.getString("medida"),
                            myRs.getBoolean("manana"),
                            myRs.getBoolean("tarde"),
                            myRs.getBoolean("noche"),
                            dias_restantes);
                }
            }

            //Retornar objeto
            return meds;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public Medicamento[] getMedicamentos(Integer id) {


        String query = "SELECT * FROM medicamento INNER JOIN paciente_medicamento ON medicamento.paciente_id = paciente_medicamento.paciente_id AND paciente_medicamento.id =" + id.toString();

        Statement myStmt = GeneralModel.connect();

        try {
            ResultSet myRs = myStmt.executeQuery(query);

            Medicamento[] meds = new Medicamento[myRs.getFetchSize()];

            Integer i=0;
            while(myRs.next()){
                meds[i] = new Medicamento(myRs.getString("nombre"),
                                          myRs.getString("tipo"),
                                          myRs.getInt("cantidad"),
                                          myRs.getString("dosis"),
                                          myRs.getString("fecha_inicio"),
                                          myRs.getString("fecha_final"),
                                          myRs.getString("medida"),
                                          myRs.getBoolean("manana"),
                                          myRs.getBoolean("tarde"),
                                          myRs.getBoolean("noche"));
            }

            //Retornar objeto
            return meds;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}