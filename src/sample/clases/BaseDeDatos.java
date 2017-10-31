package sample.clases;

import java.sql.*;
import java.util.ArrayList;

public class BaseDeDatos {
    public Number insertar(String tabla, String query) throws SQLException {
        Statement myStmt = conexion();
        if (myStmt != null){
            String runQuery = "INSERT INTO ";
            runQuery+=tabla;
            runQuery+= " ";
            runQuery += query;
            myStmt.executeUpdate(runQuery);

            return 1;
        } else {
            System.out.println("Hubo un error con la base de datos");
            return 0;
        }
    }

    private Statement conexion(){
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

}
