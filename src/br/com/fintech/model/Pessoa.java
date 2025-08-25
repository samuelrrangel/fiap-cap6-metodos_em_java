package br.com.fintech.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import br.com.fintech.enums.Sexo;

public class Pessoa {

    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;
    private Sexo sexo;

    public String getCpfFormatado() {
        if (cpf != null && cpf.length() == 11) {
            return cpf.substring(0, 3) + "." +
                    cpf.substring(3, 6) + "." +
                    cpf.substring(6, 9) + "-" +
                    cpf.substring(9, 11);
        }
        return cpf;
    }

    public int getIdade() {
        if (dataNascimento != null) {
            return Period.between(dataNascimento, LocalDate.now()).getYears();
        }
        return 0;
    }

    public void exibirDados() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("=== Dados da Pessoa ===");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + getCpfFormatado());
        System.out.println("Email: " + email);
        System.out.println("Sexo: " + sexo.getDescricao());
        if (dataNascimento != null) {
            System.out.println("Data de Nascimento: " + dataNascimento.format(formatter));
            System.out.println("Idade: " + getIdade() + " anos");
        }
    }

    public Pessoa(String nome, String email, String cpf, LocalDate dataNascimento, Sexo sexo) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public Sexo getSexo() { return sexo; }
}
