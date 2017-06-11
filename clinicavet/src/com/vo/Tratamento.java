package com.vo;

import java.util.Date;

/**
 *
 * @author Giovanni
 */
public class Tratamento {

    private int id;
    private Date dataInicial;
    private Date dataFinal;

    public Tratamento(int id, Date dataInicial, Date dataFinal) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

}
