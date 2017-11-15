package sample.modelos;

import sample.objetos.Familiar;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelFamiliar {
     public boolean insertar(Familiar fam) {
            Statement myStmt = GeneralModel.connect();
            Statement myStmt2 = GeneralModel.connect();
            String query = "INSERT INTO ";
            query += "Familiar ";
            String sql = new StringBuilder()
                    .append("(nombre, apellido, email, parentesco) VALUES (")
                    .append("'")
                    .append(fam.getNombre()) // nombre
                    .append("','")
                    .append(fam.getApellido()) // apellido
                    .append("','")
                    .append(fam.getEmail()) // email
                    .append("','")
                    .append(fam.getParentesco()) // parentesco
                    .append("')")
                    .toString();
            String query2 = "INSERT INTO";
            query2 += "telefono_familiar";
            String sql2 = new StringBuilder()
                    .append("(telefono) VALUES (")
                    .append("'")
                    .append(fam.getTelefono()) // telefono
                    .append("')")
                    .toString();

            try{
                myStmt.executeUpdate(query);
                myStmt2.executeQuery(query2);
                return true;
            } catch (Exception e){
                System.out.println(e);
                return false;
            }
        }
        public Familiar[] getFamiliares(Integer id) {
            String query = "select * from familiar where id = " + id.toString();

            Statement myStmt = GeneralModel.connect();
            try {
                ResultSet myRs = myStmt.executeQuery(query);
                ResultSetMetaData md = myRs.getMetaData();

                int columns = md.getColumnCount();

                Familiar[] fams = new Familiar[columns];


                Integer i=0;
                while(myRs.next()){
                    fams[i] = new Familiar(myRs.getString("nombre"),
                                            myRs.getString("apellido"),
                                            myRs.getString("email"),
                                            myRs.getString("parentesco"),
                                            myRs.getString("telefono"));
                }


                //Retornar objeto
                return fams;
            } catch (Exception e){
                System.out.println(e);
                return null;
            }
        }

        public Familiar[] getFamiliaresReorden(Integer id){
             System.out.println("Entre a getFamiliaresReorden");
            String query = "select * from familiar where id = " + id.toString() + " and incumbencia = 'reorden'";
            System.out.println(query);
            Statement myStmt = GeneralModel.connect();
            try {
                System.out.println("Entre a try");
                ResultSet myRs = myStmt.executeQuery(query);

                Familiar[] fams = new Familiar[this.getRowsFamiliaresReorden(id)];

                System.out.println(fams.length);
                Integer i=0;
                while(myRs.next()){
                    fams[i] = new Familiar(myRs.getString("nombre"),
                            myRs.getString("apellido"),
                            myRs.getString("email"),
                            myRs.getString("parentesco"),
                            myRs.getString("telefono"));
                }


                //Retornar objeto
                return fams;
            } catch (Exception e){
                System.out.println(e);
                return null;
            }
        }

    public int getRowsFamiliaresReorden(Integer id){
        String query = "select count(*) as rows from familiar where id = " + id.toString() + " and incumbencia = 'reorden'";
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
