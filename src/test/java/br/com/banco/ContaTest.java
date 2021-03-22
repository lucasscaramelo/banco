package br.com.banco;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    Cliente cliente = new Cliente("Lucas", "55555555");
    Conta conta = new Conta(cliente);

    @Test
    public void abrirConta() {
        Assertions.assertEquals("Conta Corrente aberta com sucesso!", conta.abrirConta("CC"));
        Assertions.assertEquals("Conta Poupança aberta com sucesso!", conta.abrirConta("CP"));
    }


    @Test
    public void abrirContaInválida() {
        Assertions.assertEquals("Conta inválida!", conta.abrirConta("100"));
        Assertions.assertEquals("Conta inválida!", conta.abrirConta("ÇÇ"));
        Assertions.assertEquals("Conta inválida!", conta.abrirConta("**"));
    }

    @Test
    public void fecharConta() {
        Assertions.assertEquals("Conta fechada com sucesso!", conta.fecharConta("CC"));
        Assertions.assertEquals("Conta fechada com sucesso!", conta.fecharConta("CP"));
    }

    @Test
    public void fecharContaInválida() {
        Assertions.assertEquals("Conta inválida!", conta.fecharConta("XX**"));
    }

    @Test
    public void saque() {
        Assertions.assertEquals("Impossível sacar de uma conta fechada!", conta.sacar(100000));
    }

}
