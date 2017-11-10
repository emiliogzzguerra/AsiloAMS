package sample.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class listaNombres {
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


    public String[] nombres() throws Exception {

        int ini = 0, count = numeroRows();
        String query = "Select * From paciente";
        Statement stmt = conexion();
        String[] myStringArray = new String[count];
        ResultSet p = stmt.executeQuery(query);
        while (p.next()) {
            String firstName = p.getString("nombre");
            myStringArray[ini] = firstName;
            ini++;

        }
        return nombresApellidos(myStringArray);
    }
    public String[] nombresApellidos(String[] myStringArray) throws Exception {
        int ini = 0;
        String query = "Select * From paciente";
        Statement stmt = conexion();
        ResultSet m = stmt.executeQuery(query);
        while (m.next()) {
            String firstName = m.getString("apellido");
            myStringArray[ini] += " " + firstName;
            ini++;
        }
        return myStringArray;
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
