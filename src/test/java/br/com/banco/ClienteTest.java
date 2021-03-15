package br.com.banco;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    public void clienteValido() {
        Cliente cliente1 = new Cliente("Lucas", "55555555");
        String atual = cliente1.toString();
        Assertions.assertEquals("Cliente{nome='Lucas', cpfCnpj='55555555'}", atual);
    }

    @Test
    public void clienteNomeVazio() {
        Cliente cliente2 = new Cliente("", "55555555");
        String atual = cliente2.toString();
        Assertions.assertEquals("Cliente{nome='', cpfCnpj='55555555'}", atual);
    }

    @Test
    public void clienteCpfCnpjVazio() {
        Cliente cliente3 = new Cliente("Lucas", "");
        String atual = cliente3.toString();
        Assertions.assertEquals("Cliente{nome='Lucas', cpfCnpj=''}", atual);
    }
}
