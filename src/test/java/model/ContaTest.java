package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    // Variaveis
    private static double valorDeposito = 100.00;
    private static double valorSaqueValido = 50.00;
    private static double valorSaqueInvalido = 150.00;
    private static double valorZerado = 0.00;

    private Conta conta;

    private void preparaPreCondicao(String validade){
        this.conta = new Conta();
        conta.validade(validade);
    }

    @Test
    public void deveDepositarComValorValido(){

        preparaPreCondicao("Ativar");

        // Retornou True? Então passa por esse condição de teste
        conta.depositar(valorDeposito);

        Assertions.assertEquals(valorDeposito,conta.getSaldo());

    }

    @Test
    public void deveSacarComValorMenorQueOSaldo(){

        preparaPreCondicao("Ativar");

        conta.depositar(valorDeposito);

        conta.sacar(valorSaqueValido);

        Assertions.assertEquals(valorDeposito-valorSaqueValido, conta.getSaldo());
    }

    @Test
    public void naoDeveSacarComValorValido(){

        preparaPreCondicao("Ativar");

        conta.depositar(valorDeposito);

        // Saldo é menor que o valor sacado
        // () -> = Vai ficar um objeto vazio e adiciona a exceção (Lambda)
        Assertions.assertThrows(RuntimeException.class, () -> conta.sacar(valorSaqueInvalido));

        Assertions.assertEquals(valorDeposito, conta.getSaldo());
    }

    @Test
    public void naoDeveDepositarComContaInativa(){

        preparaPreCondicao("Desativar");

        // Em uma exceção eu só verifico se deve lançar, caso contrario eu não a utilizo
        Assertions.assertThrows(RuntimeException.class, () -> conta.depositar(valorDeposito));

        Assertions.assertEquals(valorZerado, conta.getSaldo());

    }

    @Test
    public void naoDeveSacarComValorMaiorQueOSaldo(){

        preparaPreCondicao("Ativar");

        conta.depositar(valorDeposito);

        conta.sacar(valorSaqueInvalido);

        //Assertions.assertThrows(RuntimeException.class, () -> conta.sacar(100.00));

        Assertions.assertEquals(valorZerado, conta.getSaldo());

    }

    @Test
    public void naoDeveSacarComContaInativa(){

        preparaPreCondicao("Ativar");

        conta.depositar(valorDeposito);

        conta.desativar();

        conta.sacar(valorSaqueValido);

        //Assertions.assertThrows(RuntimeException.class, () -> conta.sacar(100.00));

        Assertions.assertEquals(valorZerado, conta.getSaldo());

    }

    @Test
    public void naoDeveSacarComContaInativaESaldoMenorQueOValorDeSaque(){

        preparaPreCondicao("Ativar");

        conta.depositar(valorDeposito);

        conta.desativar();

        conta.sacar(valorSaqueInvalido);

        //Assertions.assertThrows(RuntimeException.class, () -> conta.sacar(100.00));

        Assertions.assertEquals(valorZerado, conta.getSaldo());

    }

}
