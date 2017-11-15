package sample.modelos;

import java.sql.*;

public class GeneralModel {
    public static Statement connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Get connection with MySQL database
            Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_asilo?useSSL=false",
                    "root", "1212");
            Statement stmt = mycon.createStatement();

            if(stmt != null){
                return stmt;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error with database connection");
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getQuery(String query) throws SQLException {
        //Execute SQL query
        Statement myStmt = connect();
        return myStmt.executeQuery(query);
    }
}
