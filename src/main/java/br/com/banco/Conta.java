package br.com.banco;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Conta {
    private Cliente cliente;
    public int numConta;
    protected String tipo;
    private float saldo;
    private Boolean status;
    private int valorTarifa;

    public Conta(Cliente c) {
        this.cliente = c;
        this.saldo = 0;
        this.status = false;
        this.valorTarifa = 0;
    }

    public String abrirConta(String tipoConta) {
        String conta;
        this.setTipo(tipoConta);
        this.setStatus(true);

        if (tipoConta.equals("CC")) {
            conta = "Conta Corrente aberta com sucesso!";
            this.setSaldo(50);
        }else if (tipoConta.equals("CP")) {
            conta = "Conta Poupança aberta com sucesso!";
            this.setSaldo(150);
        }else   {
            conta = "Conta inválida!";
        }

        return conta;
    }

    public String fecharConta(String tipoConta) {
        String conta;

        if (tipoConta.equals("CC") || tipoConta.equals("CP")) {
            if (this.getSaldo() > 0 ){
                conta = "Fechamento inválido, ainda existe saldo!";
            }else if (this.getSaldo() < 0 ) {
                conta = "Fechamento inválido, ainda existem débitos!";
            }else {
                this.setStatus(false);
                conta = "Conta fechada com sucesso!";
            }
        }else {
            conta = "Conta inválida!";
        }

        return conta;
    }

    public void depositar(float valor) {
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Depósito realizado na conta de "+this.cliente.getNome());
        } else  {
            System.out.println("Não foi possível realizar o depósito em uma conta fechada.");
        }
    }

    public String sacar(float valor) {
        String saque;

        if (this.getStatus()) {
            if (this.getSaldo() >= valor) {
                this.setSaldo(this.getSaldo() - valor);
                saque = "Saque realizado na conta de "+this.cliente.getNome();
            } else {
                saque = "Saldo insuficiente para saque";
            }
        } else {
            saque = "Impossível sacar de uma conta fechada!";
        }

        return saque;
    }

    public void extrato() {
        DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println("\nSeu saldo é de: "+this.getSaldo()+" \nData da operação: "+data.format(agora));
    }

    public void tarifaMensal() {
        if (this.getTipo().equals("CC")){
             this.setValorTarifa(12);
        }else if (this.getTipo().equals("CP")){
            this.setValorTarifa(20);
        }
        if (this.getStatus()){
            this.setSaldo(this.getSaldo() - this.getValorTarifa());
            System.out.println("Mensalidade paga com sucesso!");
        }else {
            System.out.println("Impossível pagar de uma conta fechada!");
        }
    }

    public void tarifaAnual() {
        if (this.getTipo().equals("CC")){
            this.setValorTarifa(120);
        }else if (this.getTipo().equals("CP")){
            this.setValorTarifa(200);
        }
        if (this.getStatus()){
            this.setSaldo(this.getSaldo() - this.getValorTarifa());
            System.out.println("Mensalidade paga com sucesso!");
        }else {
            System.out.println("Impossível pagar de uma conta fechada!");
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "cliente=" + cliente +
                ", numConta=" + numConta +
                ", tipo='" + tipo + '\'' +
                ", saldo=" + saldo +
                ", status=" + status +
                ", valorTarifa=" + valorTarifa +
                '}';
    }
}

