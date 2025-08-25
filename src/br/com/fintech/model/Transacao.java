package br.com.fintech.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import br.com.fintech.enums.TipoTransacao;

public class Transacao {

    private TipoTransacao tipo;
    private double valor;
    private LocalDateTime dataHora;
    private String descricao;

    private Conta conta;

    public Transacao(Conta conta, TipoTransacao tipo, double valor, String descricao) {
        this.conta = conta;
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
        this.dataHora = LocalDateTime.now();
    }

    public void exibirTransacao() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("=== Transação ===");
        System.out.println("Tipo: " + tipo.getDescricao());
        System.out.println("Valor: " + valor);
        System.out.println("Data/Hora: " + dataHora.format(formatter));
        System.out.println("Descrição: " + descricao);
        if (conta != null) {
            System.out.println("Conta: " + conta.getNumeroConta());
        }
    }

    public TipoTransacao getTipo() { return tipo; }
    public double getValor() { return valor; }
    public LocalDateTime getDataHora() { return dataHora; }
    public String getDescricao() { return descricao; }
    public Conta getConta() { return conta; }
}
