package com.vo;

/**
 *
 * @author Giovanni
 */
public class Consulta {

    private int id;
    private String data;
    private String historico;

    public Consulta(int id, String data, String historico) {
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

}
