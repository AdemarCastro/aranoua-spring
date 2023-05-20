package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    // Variaveis
    private static double valorDeposito = 100.00;
    private static double valorSaqueValido = 50.00;
    private static double valorSaqueInvalido = 150.00;
    private static double valorZerado = 0.00;

    private static Conta conta;

    private void preparaPreCondicao(String validade){
        this.conta = new Conta();
        conta.validade(validade);
    }

    @Test
    public void deveDepositarComValorValido(){

        preparaPreCondicao("Ativar"); // Ativar = Conta Ativa; Desativar = Conta Inativa.

        // Retornou True? Então passa por esse condição de teste
        conta.depositar(valorDeposito);

        Assertions.assertEquals(valorDeposito,conta.getSaldo());

    }

    @Test
    public void deveSacarComValorMenorQueOSaldo(){

        preparaPreCondicao("Ativar"); // Ativar = Conta Ativa; Desativar = Conta Inativa.

        conta.depositar(valorDeposito);

        conta.sacar(valorSaqueValido);

        Assertions.assertEquals(valorDeposito-valorSaqueValido, conta.getSaldo());
    }

    @Test
    public void naoDeveSacarComValorValido(){

        preparaPreCondicao("Ativar"); // Ativar = Conta Ativa; Desativar = Conta Inativa.

        conta.depositar(valorDeposito);

        // Saldo é menor que o valor sacado
        // () -> = Vai ficar um objeto vazio e adiciona a exceção (Lambda)
        Assertions.assertThrows(RuntimeException.class, () -> conta.sacar(valorSaqueInvalido));

        Assertions.assertEquals(valorDeposito, conta.getSaldo());
    }

    @Test
    public void naoDeveDepositarComContaInativa(){

        preparaPreCondicao("Desativar"); // Ativar = Conta Ativa; Desativar = Conta Inativa.

        // Em uma exceção eu só verifico se deve lançar, caso contrario eu não a utilizo
        Assertions.assertThrows(RuntimeException.class, () -> conta.depositar(valorDeposito));

        Assertions.assertEquals(valorZerado, conta.getSaldo());

    }

    // AVISO: Os métodos abaixo

    @Test
    public void naoDeveSacarComValorMaiorQueOSaldo(){

        preparaPreCondicao("Ativar"); // Ativar = Conta Ativa; Desativar = Conta Inativa.

        conta.setCondicao(true);

        conta.depositar(valorDeposito);

        conta.sacar(valorSaqueInvalido);

        //Assertions.assertThrows(RuntimeException.class, () -> conta.sacar(100.00));

        Assertions.assertEquals(valorDeposito, conta.getSaldo());

    }

    

    @Test
    public void naoDeveSacarComContaInativa(){

        preparaPreCondicao("Ativar"); // Ativar = Conta Ativa; Desativar = Conta Inativa.

        conta.setCondicao(true);

        conta.depositar(valorDeposito);

        conta.desativar();

        conta.sacar(valorSaqueValido);

        //Assertions.assertThrows(RuntimeException.class, () -> conta.sacar(100.00));

        Assertions.assertEquals(valorDeposito, conta.getSaldo());

    }

    @Test
    public void naoDeveDepositarComPessoaInativa(){

        preparaPreCondicao("Ativar"); // Ativar = Conta Ativa; Desativar = Conta Inativa.

        conta.setCondicao(true); // Esse é o método para declarar se a Pessoa criada na classe Conta é ou não Ativa.

        conta.depositar(valorDeposito); 

        Assertions.assertEquals(valorDeposito, conta.getSaldo());

    }

    @Test
    public void naoDeveSacarComPessoaInativa(){

        preparaPreCondicao("Ativar"); // Ativar = Conta Ativa; Desativar = Conta Inativa.

        conta.setCondicao(true); // Setei a Pessoa como Ativa para que possa Depositar.

        conta.depositar(valorDeposito);

        conta.setCondicao(false); // Agora não pode mais ser realizada a operação de Sacar.

        conta.sacar(valorSaqueValido);

        Assertions.assertEquals(valorDeposito, conta.getSaldo());

    }

}
