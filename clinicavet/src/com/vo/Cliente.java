package com.vo;

/**
 *
 * @author Giovanni
 */
public class Cliente {

    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private Long cep_cli;
    private String email_cli;

    public Cliente(int id, String nome, String endereco, String telefone, Long cep_cli, String email_cli) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cep_cli = cep_cli;
        this.email_cli = email_cli;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getCep_cli() {
        return cep_cli;
    }

    public void setCep_cli(Long cep_cli) {
        this.cep_cli = cep_cli;
    }

    public String getEmail_cli() {
        return email_cli;
    }

    public void setEmail_cli(String email_cli) {
        this.email_cli = email_cli;
    }

}
