package sample.modelos;

import sample.objetos.Tratamiento;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelTratamiento {
    public boolean insertar(Tratamiento tratamiento) {
        Statement myStmt = GeneralModel.connect();
        String query = "INSERT INTO ";
        query += "padecimiento ";
        String sql = new StringBuilder()
                .append(" (nombre) VALUES (")
                .append("'")
                .append(tratamiento.getNombre_tratamiento()) // nombre_tratamiento
                .append(")")
                .toString();
        query += sql;

        try{
            myStmt.executeUpdate(query);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean insertarDes(Tratamiento tratamiento){
        Statement myStmt = GeneralModel.connect();
        String query = "INSERT INTO ";
        query += "paciente_padecimiento";
        String sql = new StringBuilder()
                .append(" (descripcion) VALUES (")
                .append("'")
                .append(tratamiento.getDescripcion_tratamiento()) // descripcion_tratamiento
                .append(")")
                .toString();
        query += sql;

        try{
            myStmt.executeUpdate(query);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Tratamiento getTratamiento(Integer id) {
        String query = "select * from tratamiento where id = " + id.toString();
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
            Tratamiento tratamientoAuxiliar = new Tratamiento(myRs.getString(1), myRs.getString(2));

            tratamientoAuxiliar.setDescripcion_tratamiento(myRs.getString(1));

            //Retornar objeto
            return tratamientoAuxiliar;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}