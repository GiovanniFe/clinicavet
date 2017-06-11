package com.vo;

/**
 *
 * @author Giovanni
 */
public class Tratamento {

    private int id;
    private String dataInicial;
    private String dataFinal;

    public Tratamento(int id, String dataInicial, String dataFinal) {
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

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

}
