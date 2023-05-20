package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    @Test
    public void deveDepositarComValorValido(){

        Conta conta = new Conta();
        conta.ativar();

        // Retornou True? Então passa por esse condição de teste
        Assertions.assertTrue(conta.depositar(100.00));

        Assertions.assertEquals(100.00,conta.getSaldo());

    }

    @Test
    public void deveSacarComValorMenorQueOSaldo(){

        Conta conta = new Conta();
        conta.ativar();


        Assertions.assertTrue(conta.depositar(100.00));

        Assertions.assertTrue(conta.sacar(50.00));

        Assertions.assertEquals(50.00, conta.getSaldo());
    }

    @Test
    public void naoDeveSacarComValorValido(){

        Conta conta = new Conta();
        conta.ativar();

        // Saldo é menor que o valor sacado
        Assertions.assertTrue(conta.depositar(99.00));

        Assertions.assertEquals(100.00, conta.getSaldo());
    }

}
