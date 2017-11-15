package sample.modelos;

import sample.objetos.Padecimiento;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModelPadecimiento {
    public boolean insertar(Padecimiento padecimiento,Integer paciente_id) {
        Statement myStmt = GeneralModel.connect();
        String query = "INSERT INTO ";
        String table = query + "padecimiento ";
        String aux = new StringBuilder()
                .append("(nombre) VALUES (")
                .append("'")
                .append(padecimiento.getNombre())
                .append("'")
                .append(")")
                .toString();

        String sqlPadecimiento = table + aux;
        System.out.println(sqlPadecimiento);
        try{
            myStmt.executeUpdate(sqlPadecimiento);
        } catch (Exception e){
            System.out.println(e);
        }

        Integer id_padecimiento = 0;
        try{
            ResultSet myRs = myStmt.executeQuery("SELECT COUNT(*) FROM paciente");
            myRs.next();
            id_padecimiento = myRs.getInt(1);
        } catch (Exception e){
            System.out.println(e);
        }

        String table2 = query + "paciente_padecimiento ";
        String aux2 = new StringBuilder()
                .append("(descripcion,paciente_id,padecimiento_id) VALUES (")
                .append("'")
                .append(padecimiento.getDescripcion())
                .append("',")
                .append(paciente_id)
                .append(",")
                .append(id_padecimiento)
                .append(")")
                .toString();

        String sqlDescripcion = table2 + aux2;

        try{
            myStmt.closeOnCompletion();
            myStmt.executeUpdate(sqlDescripcion);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public Padecimiento[] getPadecimientos(Integer id) {
        String queryPadecimiento = "SELECT * FROM paciente INNER JOIN paciente_padecimiento ON paciente.id = paciente_padecimiento.paciente_id AND paciente.id =" + id.toString();

        Statement myStmt = GeneralModel.connect();
        try {
            ResultSet myRs = myStmt.executeQuery(queryPadecimiento);
            ResultSetMetaData md = myRs.getMetaData();

            Padecimiento[] pads = new Padecimiento[myRs.getFetchSize()];

            Integer i = 0;
            while(myRs.next()){
                //pads[i] = new Padecimiento(myRs.getString("nombre"));
            }

            //Retornar objeto
            return pads;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}