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
                .append(")");
        try{
            myStmt.executeUpdate(query);
            myStmt2.executeQuery(query2);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public Medicamento[] getMedicamentos(Integer id) {

        Medicamento m = new Medicamento();

        String query = "select * from medicamento where id = " + id.toString();
        ArrayList columnNames = new ArrayList();

        Statement myStmt = GeneralModel.connect();

        try {
            ResultSet myRs = myStmt.executeQuery(query);
            ResultSetMetaData md = myRs.getMetaData();
            int columns = md.getColumnCount();

            //Get column names
            for (int i = 1; i<= columns; i++){
                columnNames.add(md.getColumnName(i));
            }

            Medicamento[] arregloMedicamentos = new Medicamento[myRs.getFetchSize()];

            //Insertar informacion a arreglo de medicamentos
            Integer row = 0;
            Medicamento medicamentoAuxiliar = new Medicamento();
            while (myRs.next()){
                System.out.println(myRs.getString(0));
                medicamentoAuxiliar.setNombre(myRs.getString(1));
                medicamentoAuxiliar.setTipo(myRs.getString(2));
                //medicamentoAuxiliar.set(myRs.getInt(3));
                //medicamentoAuxiliar.setReceta_id(myRs.getInt(4));

                arregloMedicamentos[row] = medicamentoAuxiliar;
            }


            //Retornar objeto
            return arregloMedicamentos;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public void despliegaTabla(String tabla){
        ArrayList data = new ArrayList();
        ArrayList columnNames = new ArrayList();

        String query = "select * from " + tabla;

        Statement myStmt = GeneralModel.connect();

        //Execute SQL query


        try {
            ResultSet myRs = myStmt.executeQuery(query);
            ResultSetMetaData md = myRs.getMetaData();
            int columns = md.getColumnCount();

            //Get column names
            for (int i = 1; i<= columns; i++){
                columnNames.add(md.getColumnName(i));
            }
            //Get row data
            while (myRs.next()){
                ArrayList row = new ArrayList(columns);
                for (int i = 1; i<= columns; i++){
                    System.out.println(myRs.getObject(i));
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

}