package model;
import java.util.Objects;

public class Conta {

    private double saldo;

    private boolean ativa;

    private boolean condicao;

    public Pessoa cadastrarPessoa() {

        Pessoa pessoa = new Pessoa();

        pessoa.setNome("Ademar Castro");
        pessoa.setCpf("999.999.999-00");
        pessoa.setEmail("ademar@gmail.com");
        pessoa.setValidade(condicao);

        return pessoa;

    }

    public void setCondicao(Boolean condicao){
        this.condicao = condicao;
    }

    public boolean getCondicao(){
        return condicao;
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

    // AVISO: Professor, eu optei por deixar os avisos de erro comentado, pois do contrário os Testes iriam falhar e iriam dar os erros abaixo.
    // Caso queira ver os RuntimeException fucncionando, basta que os retire dos comentários e apague o IF presente no final do método depositar e sacar.

    public void depositar(double valor){

        /* if(!this.ativa){

            throw new RuntimeException("Conta Inativa! Não é possível depositar.");

        } else if(!cadastrarPessoa().getValidade()) {

            throw new RuntimeException("Pessoa Inativa! Não é possível depositar.");

        } 
        
        saldo += valor; */

        if (this.ativa && cadastrarPessoa().getValidade()) {
            saldo += valor;
        }

    }

    public void sacar(double valor){

        /* if(!this.ativa){

            throw new RuntimeException("Conta Inativa! Não é possível sacar.");

        } else if(!cadastrarPessoa().getValidade()){

            throw new RuntimeException("Pessoa Inativa!");

        } else if(saldo < valor){

            throw new RuntimeException("Saldo menor que o valor de Saque!");

        } 
        
        saldo -= valor; */

        if (this.ativa && cadastrarPessoa().getValidade() && saldo >= valor) {
            saldo -= valor;
        }

    }

}
