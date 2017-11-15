package sample.clases;

import javafx.util.Pair;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class listaNombres {
    //numero de rows (no en uso)
    public int numeroRows() throws Exception{
        int count = 0;
        String query = "Select * From paciente";
        Statement stmt = conexion();
        ResultSet n = stmt.executeQuery(query);
        while (n.next()) {
            count++;
        }
        return count;
    }


    public Map<String,Integer> nombres() throws Exception {
        Map<String,Integer> map = new HashMap<String,Integer>();
        String query = "Select * From paciente";
        Statement stmt = conexion();
        ResultSet p = stmt.executeQuery(query);
        while (p.next()) {
            Integer id = p.getInt("id");
            String nombre = p.getString("nombre");
            String apellido = p.getString("apellido");
            String nombreApellido = nombre + " " + apellido;
            map.put(nombreApellido, id);
        }
        return map;
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
}
