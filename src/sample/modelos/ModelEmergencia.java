package sample.modelos;

import sample.objetos.InfoEmergencia;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelEmergencia {
    public boolean insertar (InfoEmergencia emer) {
        Statement myStmt = GeneralModel.connect();
        String query = "INSERT INTO ";
        query +=  "informacion_emergencia";
        String sql = new StringBuilder()
                .append("(poliza_seguro, hospital_preferente, comentarios, telefono) VALUES (")
                .append("'")
                .append(emer.getPoliza_seguro())
                .append("','")
                .append(emer.getHospital_preferente())
                .append("','")
                .append(emer.getComentarios())
                .append("')")
                .toString();

        try{
            myStmt.executeUpdate(query);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public InfoEmergencia getInfoEmergencia (Integer id) {
        String query = "select * from Emergencia where id = " + id.toString();
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
            myRs.next();
            InfoEmergencia emer = new InfoEmergencia(myRs.getString("poliza_seguro"), myRs.getString("hospital_preferente"), myRs.getString("comentarios"), myRs.getString("telefono"));


            //Retornar objeto
            return emer;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
