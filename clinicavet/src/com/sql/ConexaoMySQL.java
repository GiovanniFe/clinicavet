package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    
    public int getMaxId(String tableName) {
        int id = 0;
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("SELECT max(id) AS maxId FROM " + tableName);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
                id = rs.getInt("maxId");
            rs.close();
            stmt.close();
            conexao.FecharConexao();    
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return id;
    }
}
