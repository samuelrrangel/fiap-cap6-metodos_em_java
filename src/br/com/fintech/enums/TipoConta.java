package br.com.fintech.enums;

import br.com.fintech.enums.Descritivel;

public enum TipoConta implements Descritivel {
    CORRENTE("Corrente"),
    POUPANCA("Poupança"),
    INVESTIMENTOS("Investimentos");

    private final String descricao;

    TipoConta(String descricao) { this.descricao = descricao; }

    public String getDescricao() { return descricao; }

    @Override
    public String toString() { return descricao; }
}