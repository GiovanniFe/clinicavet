package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

//Início da classe de conexão//
public class ConexaoMySQL {

    private String status;
    private String serverName = "localhost";
    private String mydatabase = "giovanni";
    private String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
    private String username = "root";
    private String password = "";
    private String driverName = "com.mysql.jdbc.Driver";
    private Connection connection = null;

    public Connection getConexaoMySQL() {
        try {
            Class.forName(driverName);
            return connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
        }
        return null;
    }

    //Método que fecha sua conexão//
    public boolean FecharConexao() {
        try {
            this.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    //Método que reinicia sua conexão//
    public java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return this.getConexaoMySQL();
    }

    public void executeQuery(String query, String... parameters) {
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
}
