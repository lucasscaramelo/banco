package br.com.banco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
    private Pessoa fisica;
    private Pessoa juridica;
    private String cpfCnpj;

    public Cliente(Pessoa f, Pessoa j, String cpfCnpj) {
        this.fisica = f;
        this.juridica = j;
        this.cpfCnpj = cpfCnpj;
    }

}
