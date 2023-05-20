package model;

public class Conta {

    private double saldo;

    private boolean ativa;

    public void ativar(){
        this.ativa = true;
    }

    public void desativar(){
        this.ativa = false;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean depositar(double valor){

        boolean validade = false;

        if(this.ativa) {
            saldo += valor;
            validade = true;
        }

        return validade;

    }

    public boolean sacar(double valor){

        boolean validade = false;

        if(saldo >= valor){
            saldo -= valor;
            validade = true;
        }

        return validade;

    }

}
