package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

//Início da classe de conexão//
public class ConexaoMySQL {

    private String status;
    private String serverName = "localhost";
    private String mydatabase = "mysql";
    private String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
    private String username = "root";
    private String password = "";
    private String driverName = "com.mysql.jdbc.Driver";
    private Connection connection = null;

    public Connection getConexaoMySQL() {
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    //Método que retorna o status da sua conexão//
    public String statusConection() {
        return status;
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

}
