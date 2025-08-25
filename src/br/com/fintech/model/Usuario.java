package br.com.fintech.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Usuario {

    private Pessoa pessoa;
    private String username;
    private String email;
    private String senha;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private boolean ativo;

    public void AtualizarCadastro(String email, String senha, boolean ativo) {
        this.email = email;
        this.senha = senha;
        this.dataAtualizacao = LocalDateTime.now();
        this.ativo = ativo;
    }

    public void visualizarPerfil() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("=== Perfil do Usuário ===");
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("CPF: " + pessoa.getCpfFormatado());
        System.out.println("Email: " + email);
        System.out.println("Data de Criação: " + dataCriacao.format(formatter));
        System.out.println("=== Dados da Pessoa ===");
        pessoa.exibirDados();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Usuario(Pessoa pessoa, String username, String senha) {
        this.pessoa = pessoa;
        this.username = username;
        this.senha = senha;
        this.dataCriacao = LocalDateTime.now();
        this.ativo = true;
    }
}