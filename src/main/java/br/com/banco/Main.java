package br.com.banco;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Lucas", "5555555555");
        Conta conta = new Conta(cliente);

        conta.abrirConta("CC");
        conta.depositar(100);
        conta.sacar(500);
        conta.tarifaMensal();
        conta.extrato();
    }
}
