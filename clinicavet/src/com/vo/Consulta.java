package com.vo;

import java.util.Date;

/**
 *
 * @author Giovanni
 */
public class Consulta {

    private Date data;
    private String historico;

    public Consulta(Date data, String historico) {
        this.data = data;
        this.historico = historico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    
}
