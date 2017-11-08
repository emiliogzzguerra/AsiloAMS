package sample.clases;

import sample.objetos.Paciente;

import java.sql.*;
import java.util.ArrayList;

public class BaseDeDatos {
    public Number insertar(Paciente p) throws SQLException {
        Statement myStmt = conexion();
        if (myStmt != null){
            String query = "INSERT INTO ";
            query+= "paciente ";
            String sql = new StringBuilder()
                    .append("(sexo,fecha_nacimiento,nombre,apellido,ciudad,calle,codigo_postal,sangre,")
                    .append("numero_cuarto,numero_cama,estatus,paciente_medicado_manana,paciente_medicado_tarde,paciente_medicado_noche,asilo_id) VALUES (")
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
                    .append(p.getNumero_cuarto()) // numero_cuarto
                    .append(",")
                    .append(p.getNumero_cama()) // numero_cama
                    .append(",")
                    .append(p.isPaciente_medicado_manana()) // paciente_medicado_manana
                    .append(",")
                    .append(p.isPaciente_medicado_tarde()) // paciente_medicado_tarde
                    .append(",")
                    .append(p.isPaciente_medicado_noche()) // paciente_medicado_noche
                    .append(",")
                    .append(p.getEstatus()) // estatus
                    .append(",")
                    .append(p.getAsilo_id()) // asilo_id
                    .append(")")
                    .toString();
            query += sql;
            myStmt.executeUpdate(query);
            return 1;
        } else {
            System.out.println("Hubo un error con la base de datos");
            return 0;
        }
    }

    public Statement conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Get connection with MySQL database
            Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_asilo?useSSL=false",
                    "root", "1212");
            Statement stmt = mycon.createStatement();

            return stmt;
        } catch (Exception e) {
            System.out.println("Error with database connection");
            e.printStackTrace();
            return null;
        }
    }

    public void despliegaTabla(String tabla) throws SQLException {
        ArrayList data = new ArrayList();
        ArrayList columnNames = new ArrayList();

        String query = "select * from " + tabla;

        Statement myStmt = conexion();

        //Execute SQL query
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
    }

    public ResultSet getQuery(String query) throws SQLException {
        //Execute SQL query
        Statement myStmt = conexion();
        return myStmt.executeQuery(query);
    }

}
