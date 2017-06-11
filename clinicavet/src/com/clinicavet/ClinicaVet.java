package com.clinicavet;

import com.dao.ExameDAO;
import com.dao.TratamentoDAO;
import com.dao.VeterinarioDAO;

/**
 *
 * @author Giovanni
 */
public class ClinicaVet {

    public static void main(String[] args) {
        new TratamentoDAO().create("2017-06-11", "2017-06-11");
        new ExameDAO().create("descricao");
        new VeterinarioDAO().create("giovanni", "Avenida Luiz Cavinatto", "3444-3494");
    }
}
