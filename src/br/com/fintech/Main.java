package br.com.fintech;

import java.time.LocalDate;
import br.com.fintech.model.*;
import br.com.fintech.enums.*;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(
                "João Silva",
                "12345678901",
                LocalDate.of(1990, 5, 20),
                Sexo.MASCULINO
        );

        Usuario u1 = new Usuario(
                p1,
                "joaosilva",
                "joao@email.com",
                "s3nh@Sup3rSegurA"
        );

        Conta c1 = new Conta(
                u1,
                TipoConta.CORRENTE
        );
        c1.visualizarConta();

        System.out.println("==================================================");

        c1.depositar(1500.00);
        c1.sacar(350.00);
        c1.depositar(600.00);
        c1.sacar(1200.32);

        System.out.println("==================================================");

        c1.exibirHistorico();
    }
}
