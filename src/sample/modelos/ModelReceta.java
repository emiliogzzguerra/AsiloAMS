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

    public Receta[] getRecetas(Integer id) {
        String query = "select * from receta where id = " + id.toString();

        Statement myStmt = GeneralModel.connect();
        try {
            ResultSet myRs = myStmt.executeQuery(query);

            //Insertar informacion a objeto deseado
            Receta[] recetaAuxiliar = new Receta[this.getRowsRecetas(id)];

            Integer i = 0;
            while(myRs.next()){
                recetaAuxiliar[i] = new Receta(myRs.getString("identificador"),myRs.getString("fecha"));
            }

            return recetaAuxiliar;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public int getRowsRecetas(Integer id){
        String query = "select count(*) from receta where id = " + id.toString();
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
