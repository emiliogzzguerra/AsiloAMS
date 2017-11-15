package sample.modelos;

import sample.objetos.Paciente;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

public class ModelPaciente {
    public int insertar(Paciente p) {
        Statement myStmt = GeneralModel.connect();

        Integer num_cuarto;
        Integer num_cama;

        if(p.getNumero_cuarto() != null){
            num_cuarto = p.getNumero_cuarto().get();
        } else {
            num_cuarto = null;
        }

        if(p.getNumero_cama() != null){
            num_cama = p.getNumero_cama().get();
        } else {
            num_cama = null;
        }

        String query = "INSERT INTO ";
        query += "paciente ";
        String sql = new StringBuilder()
                .append("(sexo,fecha_nacimiento,nombre,apellido,ciudad,calle,codigo_postal,sangre,")
                .append("numero_cuarto,numero_cama,estatus,foto,paciente_medicado_manana,paciente_medicado_tarde,paciente_medicado_noche,asilo_id) VALUES (")
                .append(p.getSexo()) // sexo
                .append(",'")
                .append(p.getFecha_nacimiento()) // fecha_nacimiento
                .append("','")
                .append(p.getNombre()) // nombre
                .append("','")
                .append(p.getApellido()) // apellido
                .append("','")
                .append(p.getCiudad()) // ciudad
                .append("','")
                .append(p.getCalle()) // calle
                .append("',")
                .append(p.getCodigo_postal()) // codigo_postal
                .append(",'")
                .append(p.getSangre()) // sangre
                .append("',")
                .append(num_cuarto) // numero_cuarto
                .append(",")
                .append(num_cama) // numero_cama
                .append(",")
                .append(p.isPaciente_medicado_manana()) // paciente_medicado_manana
                .append(",")
                .append(p.isPaciente_medicado_tarde()) // paciente_medicado_tarde
                .append(",")
                .append(p.isPaciente_medicado_noche()) // paciente_medicado_noche
                .append(",")
                .append(p.getEstatus()) // estatus
                .append(",")
                .append(p.getPath()) // path
                .append(",")
                .append(p.getAsilo_id()) // asilo_id
                .append(")")
                .toString();
        query += sql;
        try {
            myStmt.executeUpdate(query);
            ResultSet myRs = myStmt.executeQuery("select * from paciente");
            System.out.println(myRs.getFetchSize());
            return 1;
        } catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    public Paciente getPaciente(int id){

        Paciente p = new Paciente();

        String query = "select * from paciente WHERE id=" + id;
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
            while(myRs.next()){
                p.setSexo(myRs.getInt("sexo"));
                p.setFecha_nacimiento(myRs.getString("fecha_nacimiento"));
                p.setNombre(myRs.getString("nombre"));
                p.setApellido(myRs.getString("apellido"));
                p.setCiudad(myRs.getString("ciudad"));
                p.setCalle(myRs.getString("calle"));
                p.setCodigo_postal(myRs.getString("codigo_postal"));
                p.setSangre(myRs.getString("sangre"));
                Optional<Integer> opAux = Optional.of(myRs.getInt("numero_cuarto"));
                p.setNumero_cuarto(opAux);
                opAux = Optional.of(myRs.getInt("numero_cama"));
                p.setNumero_cama(opAux);
                p.setPaciente_medicado_manana(myRs.getBoolean("paciente_medicado_manana"));
                p.setPaciente_medicado_tarde(myRs.getBoolean("paciente_medicado_tarde"));
                p.setPaciente_medicado_noche(myRs.getBoolean("paciente_medicado_noche"));
                p.setEstatus(myRs.getInt("estatus"));
                p.setPath(myRs.getString("foto"));
                p.setAsilo_id(myRs.getInt("asilo_id"));
            }
            return p;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public int getRowsPacientes(){
        System.out.println("Holaaa");
        String query = "SELECT COUNT(*) AS rows FROM paciente";
        Statement stmt = GeneralModel.connect();
        try{
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            System.out.println("Rows = " + rs.getString("rows"));
            return rs.getInt("rows");
        } catch (Exception e){
            System.out.println(e);
            return -1;
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
