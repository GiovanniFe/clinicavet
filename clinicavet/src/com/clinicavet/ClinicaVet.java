package com.clinicavet;

import com.sql.LoadDriver;

/**
 *
 * @author Giovanni
 */
public class ClinicaVet {

    public static void main(String[] args) {
        new LoadDriver().getConexaoMySQL();
    }

}
