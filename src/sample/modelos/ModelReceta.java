package sample.modelos;

import sample.objetos.Receta;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelReceta {

    public boolean insertar(Receta receta, int id) {

        Statement myStmt = GeneralModel.connect();

        String query = "INSERT INTO ";
        query += "receta ";
        String sql = new StringBuilder()
                .append("(identificador, fecha_expedicion, paciente_id) VALUES (")
                .append(receta.getIdentificador()) // identificador
                .append(",'")
                .append(receta.getFecha_expedicion()) // fecha_expedicion
                .append(",'")
                .append(id) // paciente id
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

    public Receta getReceta (Integer id) {


        String query = "select * from receta where id = " + id.toString();
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

            //Insertar informacion a objeto deseado
            Receta recetaAuxiliar = new Receta(myRs.getString(1), myRs.getDate(2));

            recetaAuxiliar.setIdentificador(myRs.getString(1));
            recetaAuxiliar.setFecha_expedicion(myRs.getDate(2));
            //Retornar objeto
            return recetaAuxiliar;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
