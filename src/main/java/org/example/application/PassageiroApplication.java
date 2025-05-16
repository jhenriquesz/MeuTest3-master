package org.example.application;


import org.example.entities.Passageiro;
import org.example.facade.PassageiroFacade;

import java.util.List;
import java.util.Scanner;

public class PassageiroApplication {

    private static final PassageiroFacade facade = new PassageiroFacade();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU PASSAGEIRO ===");
            System.out.println("1 - Cadastrar passageiro");
            System.out.println("2 - Listar passageiros");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1 -> cadastrar(scanner);
                case 2 -> listar();
                case 3 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 3);
    }

    private static void cadastrar(Scanner scanner) {
        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("E-mail: ");
            String email = scanner.nextLine();

            facade.CadastrarPassageiro(nome, cpf, email);
            System.out.println("Passageiro cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listar() {
        List<Passageiro> passageiros = facade.listarPassageiros();
        if (passageiros.isEmpty()) {
            System.out.println("Nenhum passageiro cadastrado.");
        } else {
            System.out.println("--- Lista de Passageiros ---");
            passageiros.forEach(System.out::println);
        }
    }
}
