package com.dao;

import com.sql.ConexaoMySQL;
import com.vo.Animal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class AnimalDAO {

    public void create(String nome, int idade, int sexo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        try {
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("INSERT INTO animal (nome, idade, sexo) VALUES (?, ?, ?)");
            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.setInt(3, sexo);

            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Animal animal) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("DELETE FROM animal WHERE id = ?");
            stmt.setInt(1, animal.getId());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Animal> retrieveAll() {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("SELECT * FROM animal");
            ResultSet rs = stmt.executeQuery();

            List<Animal> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                int sexo = rs.getInt("sexo");
                list.add(new Animal(id, nome, idade, sexo));
            }
            rs.close();
            stmt.close();
            conexao.FecharConexao();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Animal retrieve(int id) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("SELECT * FROM animal WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Animal animal = null;
            if (rs.next()) {
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                int sexo = rs.getInt("sexo");
                animal = new Animal(id, nome, idade, sexo);
            }
            rs.close();
            stmt.close();
            conexao.FecharConexao();
            return animal;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Animal animal) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("UPDATE animal SET nome = ?, idade = ?, sexo = ? WHERE id = ?");
            stmt.setString(1, animal.getNome());
            stmt.setInt(2, animal.getIdade());
            stmt.setInt(3, animal.getSexo());
            stmt.setInt(4, animal.getId());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
