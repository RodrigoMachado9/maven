package br.com.exemplo.jdbc;

import br.com.exemplo.beans.Usuario;

import javax.swing.event.ListDataEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection con = Conexao.getConnection();
    public void cadastro(Usuario usuario){
        String sql = "insert into usuario (nome, email, senha) values(?,?,?)";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, usuario.getNome());
            preparador.setString(2, usuario.getEmail());
            preparador.setString(3, usuario.getSenha());

            preparador.execute();
            preparador.close();
            System.out.println("Successfully included");

        }catch (SQLException e){
            System.out.println("Error - " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void alterar(Usuario usuario){
        String sql= "update usuario set nome=?, email=?, senha=? where id=?;";
        try{


            PreparedStatement preparador = con.prepareStatement(sql);


            preparador.setString(1, usuario.getNome());
            preparador.setString(2, usuario.getEmail());
            preparador.setString(3, usuario.getSenha());
            preparador.setInt(4, usuario.getId());

            preparador.executeUpdate();
             preparador.close();
            System.out.println("Successfully changed");
        }catch (SQLException e){
            System.out.println("Error - " + e);
        }
    }

    public  void deletar(Usuario usuario){
        String sql = "delete from usuario where id=?;";
        try{
            PreparedStatement preparador = con.prepareStatement(sql);

            preparador.setInt(1, usuario.getId());
            preparador.execute();
            preparador.close();
            System.out.println("Successfuly deleted!");
        }catch (SQLException e){
            System.out.println("Error - " + e.getMessage());
        }

    }
    public List<Usuario> listar(){
        String sql = "select * from usuario";
        List<Usuario> lista = new ArrayList<Usuario>();

        try{
            PreparedStatement preparador = con.prepareStatement(sql);
            ResultSet results = preparador.executeQuery();

            while (results.next()){
                Usuario user = new Usuario();
                user.setId(results.getInt("id"));
                user.setNome(results.getString("nome"));
                user.setEmail(results.getString("email"));
                lista.add(user);
            }

        }catch (SQLException e){
            System.out.println("Error - " + e);

        }
        return lista;
    }

}
