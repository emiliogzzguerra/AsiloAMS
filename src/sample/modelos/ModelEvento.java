package sample.modelos;

import sample.objetos.Evento;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelEvento {
    public boolean insertar(Evento evento, int id) {
        Statement myStmt = GeneralModel.connect();


        String query = "INSERT INTO ";
        query += "evento ";
        String sql = new StringBuilder()
                .append("(fecha, enfermera, descripcion, paciente_id) VALUES (")
                .append("'")
                .append(evento.getFecha()) // fecha_evento
                .append("','")
                .append(evento.getEnfermera())  // nombre_enfermera
                .append("','")
                .append(evento.getDescripcion())  // nombre_enfermera
                .append("',")
                .append(id)
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
    public Evento[] getEventos(Integer id) {
        Evento eventoAuxiliar = new Evento();
        String query = "select * from evento where paciente_id = " + id.toString();
        ArrayList columnNames = new ArrayList();

        Statement myStmt = GeneralModel.connect();
        try {
            ResultSet myRs = myStmt.executeQuery(query);

            Evento[] eventos = new Evento[this.getCantidadEventos(id)];

            Integer i = 0;
            //Insertar informacion a objeto deseado
            while (myRs.next()){
                eventos[i] = new Evento(myRs.getString("fecha"),myRs.getString("enfermera"),myRs.getString("descripcion"));
            }

            //Retornar objeto
            return eventos;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public int getCantidadEventos(Integer id){
        String query = "select count(*) as rows from evento where paciente_id = " + id.toString();
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