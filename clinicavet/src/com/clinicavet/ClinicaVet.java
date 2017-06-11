package com.clinicavet;

import com.sql.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Giovanni
 */
public class ClinicaVet {

    public static void main(String[] args) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection conn = conexao.getConexaoMySQL();
        try {
            PreparedStatement preparedStmt = conn.prepareStatement("INSERT INTO teste VALUES (1)");
            preparedStmt.execute();
            conn.close();
        } catch(Exception e){
        
        }
    }

}
