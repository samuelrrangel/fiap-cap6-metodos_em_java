package br.com.fintech.model;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import br.com.fintech.model.Usuario;
import br.com.fintech.enums.TipoTransacao;
import br.com.fintech.enums.TipoConta;
import br.com.fintech.model.Movimentavel;

public class Conta implements Movimentavel {

    private String numeroConta;
    private Usuario titular;
    private TipoConta tipo;
    private LocalDateTime dataCriacao;
    private double saldo;
    private List<Transacao> historico = new ArrayList<>();

    public Conta(Usuario titular, TipoConta tipo) {
        this.titular = titular;
        this.tipo = tipo;
        this.numeroConta = UUID.randomUUID().toString();
        this.dataCriacao = LocalDateTime.now();
        this.saldo = 0.0;
    }

    public void visualizarConta() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("=== Dados da Conta ===");
        System.out.println("Número da conta: " + numeroConta);
        System.out.println("Tipo da conta: " + tipo.getDescricao());
        System.out.println("Data de Criação: " + dataCriacao.format(formatter));
        System.out.println("=== Dados do Titular ===");
        titular.visualizarPerfil();
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        Transacao t = new Transacao(this, TipoTransacao.DEPOSITO, valor, "Depósito em conta");
        historico.add(t);
        System.out.println("Depósito de " + valor + " realizado. Saldo: " + saldo);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            Transacao t = new Transacao(this, TipoTransacao.SAQUE, valor, "Saque em conta");
            historico.add(t);
            System.out.println("Saque de " + valor + " realizado. Saldo: " + saldo);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public String getNumeroConta() { return numeroConta; }
    public Usuario getTitular() { return titular; }
    public TipoConta getTipo() { return tipo; }
    public double getSaldo() { return saldo; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void exibirHistorico() {
        System.out.println("=== Extrato da Conta ( " + numeroConta + " ) ===");
        for (Transacao t : historico) {
            t.exibirTransacao();
        }
    }
}
