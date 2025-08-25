package br.com.fintech.model;

public interface Movimentavel {
    void depositar(double valor);
    void sacar(double valor);
}