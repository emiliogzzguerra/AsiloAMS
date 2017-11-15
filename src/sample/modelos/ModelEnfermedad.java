package sample.modelos;

import sample.objetos.Enfermedad;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelEnfermedad {
    public boolean insertar(Enfermedad enfermedad) {
        Statement myStmt = GeneralModel.connect();

        String query = "INSERT INTO ";
        query += "enfermedad ";
        String sql = new StringBuilder()
                .append("(f, enfermera, descripcion, paciente_id) VALUES (")
                .append(",'")
                .append(enfermedad.getFecha()) // fecha_enfermedad
                .append("','")
                .append(enfermedad.getEnfermera())  // nombre_enfermera
                .append("','")
                .append(enfermedad.getDescripcion())  // nombre_enfermera
                .append("','")
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
    public Enfermedad getEnfermedad(Integer id) {
        Enfermedad enfermedadAuxiliar = new Enfermedad();
        String query = "select * from enfermedad where paciente_id = " + id.toString();
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
            //Enfermedad enfermedadAuxiliar = new Enfermedad(myRs.getString(1),myRs.getString(2),myRs.getString(3));

            while (myRs.next()){
                enfermedadAuxiliar.setFecha(myRs.getString("fecha"));
                enfermedadAuxiliar.setEnfermera(myRs.getString("enfermera"));
                enfermedadAuxiliar.setDescripcion(myRs.getString("descripcion"));
            }
            //enfermedadAuxiliar.setPaciente_id() = myRs.getInt(4);

            //Retornar objeto
            return enfermedadAuxiliar;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
