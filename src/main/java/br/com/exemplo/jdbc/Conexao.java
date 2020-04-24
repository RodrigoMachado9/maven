package br.com.exemplo.jdbc;

import java.sql.*;

public class Conexao {

    public static Connection getConnection(){

        Connection conn  = null;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user =  "postgres";
        String password =  "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Successfuly connection database");

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error connection database" + throwables.getMessage());
        }
        return conn;
    }

}
