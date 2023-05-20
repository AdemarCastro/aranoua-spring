package model;

public class Conta {

    private double saldo;

    private boolean ativa;

    private boolean validade;

    public void cadastrandoPessoa() {

        Pessoa pessoa = new Pessoa();

        pessoa.setNome("Ademar Castro");
        pessoa.setCpf("999.999.999-00");
        pessoa.setEmail("ademar@gmail.com");
        pessoa.setValidade(true);
        this.validade = true;

    }


    public void validade(String validade) {

        if (validade == "Ativar") {
            ativar();
        } else if (validade == "Desativar") {
            desativar();
        } else {
            throw new RuntimeException("Ops! Validade só pode ser Ativar ou Desativar. Tente novamente.");
        }

    }

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

    public void depositar(double valor){

        if(this.ativa && this.validade;){

            saldo += valor;

        } else {

            throw new RuntimeException("Conta Inativa! Não é possível depositar.");

        }

    }

    public void sacar(double valor){

        if(!this.ativa && saldo < valor){

            throw new RuntimeException("Conta Inativa e Saldo menor que o valor de Saque!");

        } else if(!this.ativa){

            throw new RuntimeException("Conta Inativa!");

        } else if(saldo < valor){

            throw new RuntimeException("Saldo menor que o valor de Saque!");

        }

        saldo -= valor;

    }

}
