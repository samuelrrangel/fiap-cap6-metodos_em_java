package br.com.fintech.enums;

import br.com.fintech.enums.Descritivel;

public enum Sexo implements Descritivel {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
