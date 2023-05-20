package model;

public class Pessoa {

    // nome, cpf, e-mail, pessoa ativa ou não - Vai fazer parte de uma Conta

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setValidade(Boolean validade) {
        this.validade = validade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getValidade() {
        return validade;
    }

    private String nome = "";
    private String cpf = "";
    private String email = "";
    private Boolean validade;

}
