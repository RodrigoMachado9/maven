package br.com.exemplo.testes;

import br.com.exemplo.beans.Usuario;
import br.com.exemplo.jdbc.UsuarioDAO;

import java.util.List;

public class TestDAO {
    public static void main(String[] args){
//        testCadastro();
//        testAlterar();
//        testDeletar();
        testBuscarTodos();
    }

    public static void testCadastro(){
        Usuario user = new Usuario();
        user.setNome("Ana Claudia");
        user.setEmail("anaclaudia@gmail.com");
        user.setSenha("12345");

        UsuarioDAO userDao  = new UsuarioDAO();
        userDao.cadastro(user);

    }

    public static void testAlterar(){
        Usuario user = new Usuario();
        user.setNome("Alibaba");
        user.setEmail("alibaba@hotmail.com");
        user.setSenha("666");
        user.setId(3);

        UsuarioDAO userDao = new UsuarioDAO();
        userDao.alterar(user);

    }
    public static void testDeletar(){
        Usuario user = new Usuario();
        user.setId(3);
        UsuarioDAO userDao = new UsuarioDAO();
        userDao.deletar(user);

    }

    public static void testBuscarTodos(){
        UsuarioDAO userDao = new UsuarioDAO();

        List<Usuario> resultList = userDao.listar();
        for (Usuario user: resultList){
            System.out.println("\nId: " + user.getId() + "\nNome: " + user.getNome()+ "\nEmail: " + user.getEmail() + "\n");
        }


    }

}
