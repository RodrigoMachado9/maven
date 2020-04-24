import java.sql.*;

public class Main{
// https://www.youtube.com/watch?v=CcQlZtYaxa4
    public static void main(String[] args){

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user =  "postgres";
        String password =  "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Successfuly connection database");
            Statement stat = conn.createStatement();
            ResultSet result  = stat.executeQuery("select * from \"public\".usuario");
            while (result.next()){
                System.out.println("id : " + result.getInt("id") + " nome: " + result.getString("nome"));

            }




        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error connection database");
        }


    }
}
