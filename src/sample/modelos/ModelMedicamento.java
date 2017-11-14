package sample.modelos;

import sample.objetos.Medicamento;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class ModelMedicamento {
    public boolean insertar(Medicamento medicamento) {
        Statement myStmt = GeneralModel.connect();
        String query = "INSERT INTO ";
        query += "medicamento ";
        String sql = new StringBuilder()
                .append("() VALUES (")
                .append(")")
                .toString();
        try{
            myStmt.executeUpdate(query);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public Medicamento[] getMedicamentos(Integer id) {
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
                medicamentoAuxiliar.setNombre(myRs.getString(2));
                arregloMedicamentos[row] = medicamentoAuxiliar;
            }


            //Retornar objeto
            return arregloMedicamentos;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}