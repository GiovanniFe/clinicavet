package com.vo;

import java.util.Date;

/**
 *
 * @author Giovanni
 */
public class Consulta {

    private int id;
    private Date data;
    private String historico;

    public Consulta(int id, Date data, String historico) {
        this.id = id;
        this.data = data;
        this.historico = historico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
