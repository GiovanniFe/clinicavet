package com.dao;

import com.sql.ConexaoMySQL;
import com.vo.Animal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class AnimalDAO {

    public void create(String nome, int idade, int sexo) {
        ConexaoMySQL conexao = new ConexaoMySQL();

        try {
            // cria um preparedStatement
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("insert into contatos (nome,email,endereco) values (?,?,?)");
            
            // preenche os valores
            stmt.setString(1, "xxx");
            stmt.setString(2, "contato@xxx.com.br");
            stmt.setString(3, "R.xxxx 12");
            
            // executa
            stmt.execute();
            stmt.close();
            System.out.println("Gravado!");

            /*************fecha a conexao aqui bb*/
     
            conexao.FecharConexao();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Animal animal) {

    }

    public List<Animal> retrieveAll() {

    }

    public Animal retrieve(int id) {

    }

    public void update(Animal animal) {
    
    }
}
