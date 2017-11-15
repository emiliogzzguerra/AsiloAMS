package sample.modelos;

import sample.objetos.Enfermedad;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelEnfermedad {
    public boolean insertar(Enfermedad enfermedad,Integer id) {
        Statement myStmt = GeneralModel.connect();
        String query = "INSERT INTO ";
        query += "enfermedad ";
        String sql = new StringBuilder()
                .append("(nombre_enfermedad, fecha_inicio, fecha_final, paciente_id) VALUES (")
                .append("'")
                .append(enfermedad.getNombre())
                .append("','")
                .append(enfermedad.getFecha_inicio()) // fecha_inicial
                .append("','")
                .append(enfermedad.getFecha_final())  // fecha_final
                .append("','")
                .append(id)  // paciente_id
                .append("'")
                .append(")")
                .toString();
        try{
            myStmt.executeUpdate(query + sql);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public Enfermedad[] getEnfermedades(Integer id) {
        String query = "select * from enfermedad where paciente_id = " + id.toString();
        Statement myStmt = GeneralModel.connect();
        try {
            ResultSet myRs = myStmt.executeQuery(query);

            //Insertar informacion a objeto deseado
            Enfermedad[] enfs = new Enfermedad[this.getCantidadEnfermedades(id)];

            Integer i = 0;
            while (myRs.next()){
                enfs[i] = new Enfermedad(myRs.getString("nombre_enfermedad"),
                                         myRs.getString("fecha_inicial"),
                                         myRs.getString("fecha_final"));
            }

            //Retornar objeto
            return enfs;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public int getCantidadEnfermedades(Integer id){
        String query = "select count(*) as rows from enfermedad where paciente_id = " + id.toString();
        Statement stmt = GeneralModel.connect();
        try{
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            return rs.getInt("rows");
        } catch (Exception e){
            System.out.println(e);
            return -1;
        }
    }

}
