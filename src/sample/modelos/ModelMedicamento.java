package sample.modelos;

import sample.objetos.Medicamento;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class ModelMedicamento {
    public boolean insertar(Medicamento med) {
        Statement myStmt = GeneralModel.connect();
        Statement myStmt2 = GeneralModel.connect();
        String query = "INSERT INTO ";
        query += "medicamento";
        String sql = new StringBuilder()
                .append("(nombre, tipo) VALUES (")
                .append("'")
                .append(med.getNombre()) // nombre
                .append("','")
                .append(med.getTipo())  // tipo
                .append(",")
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
    public Medicamento[] getMedicamentos(Integer id) {


        String query = "select * from medicamento where id = " + id.toString();
        String query2 = "select * from paciente_medicamento where id = " + id.toString();

        Statement myStmt = GeneralModel.connect();
        Statement myStmt2 = GeneralModel.connect();


        try {
            ResultSet myRs = myStmt.executeQuery(query);
            ResultSet myRs2 = myStmt2.executeQuery(query2);
            ResultSetMetaData md = myRs.getMetaData();
            ResultSetMetaData md2 = myRs2.getMetaData();

            int columns = md.getColumnCount();
            int columns2 = md2.getColumnCount();


            Medicamento[] meds = new Medicamento[myRs.getFetchSize()];

            Integer i=0;
            while(myRs.next()){
                meds[i] = new Medicamento(myRs.getString("nombre"),
                        myRs.getString("tipo"),
                        myRs2.getInt("cantidad"),
                        myRs2.getString("dosis"),
                        myRs2.getBoolean("manana"),
                        myRs2.getBoolean("tarde"),
                        myRs2.getBoolean("noche"));
            }


            //Retornar objeto
            return meds;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}