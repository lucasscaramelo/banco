package br.com.banco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Conta {
    public int numConta;
    protected String tipo;
    private Cliente cliente;
    private float saldo;
    private Boolean status;
    private int valorTarifa;

    public Conta(Cliente c) {
        this.cliente = c;
        this.saldo = 0;
        this.status = false;
        this.valorTarifa = 0;
    }

    public void abrirConta(String tipoConta) {
        this.setTipo(tipoConta);
        this.setStatus(true);

        if (tipoConta.equals("CC")) {
            this.setSaldo(50);
        }else if (tipoConta.equals("CP")) {
            this.setSaldo(150);
        }
    }

    public void fecharConta() {
        if (this.getSaldo() > 0){
            System.out.println("Fechamento inválido!\nAinda existe saldo!");
        }else if (this.getSaldo() < 0) {
            System.out.println("Fechamento inválido!\nAinda existem débitos!");
        }else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }

    public void depositar(float valor) {
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Depósito realizado na conta de "+this.getCliente());
        } else  {
            System.out.println("Não foi possível realizar o depósito em uma conta fechada.");
        }
    }

    public void sacar(float valor) {
        if (this.getStatus()) {
            if (this.getSaldo() >= valor) {
                this.setSaldo(this.getSaldo() - valor);
                System.out.println("Saque realizado na conta de "+this.getCliente());
            } else {
                System.out.println("Saldo insuficiente para saque");
            }
        } else {
            System.out.println("Impossível sacar de uma conta fechada!");
        }
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
}

