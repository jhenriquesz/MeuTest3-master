package org.example;
import org.example.entities.Passageiro;
import org.example.facade.PassageiroFacade;

import java.util.List;
import java.util.Scanner;


public class Main {

    // Fachada que encapsula a lógica de negócio
    private static final PassageiroFacade facade = new PassageiroFacade();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Loop do menu principal
        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Opção inválida. Digite um número: ");
                scanner.next(); // Consome entrada inválida
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1 -> cadastrarPassageiro(scanner);
                case 2 -> listarPassageiros();
                case 3 -> System.out.println("✅ Saindo do sistema. Até logo!");
                default -> System.out.println("❌ Opção inválida. Tente novamente.");
            }

        } while (opcao != 3);

        scanner.close();
    }

    // Exibe o menu principal
    private static void exibirMenu() {
        System.out.println("\n========= MENU PASSAGEIRO =========");
        System.out.println("1 - Cadastrar passageiro");
        System.out.println("2 - Listar passageiros");
        System.out.println("3 - Sair");
        System.out.println("===================================");
    }

    // Lê dados do usuário e tenta cadastrar um novo passageiro
    private static void cadastrarPassageiro(Scanner scanner) {
        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine().trim();

            System.out.print("E-mail: ");
            String email = scanner.nextLine().trim();

            facade.CadastrarPassageiro(nome, cpf, email);
            System.out.println("✅ Passageiro cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro ao cadastrar passageiro: " + e.getMessage());
        }
    }

    // Exibe todos os passageiros cadastrados
    private static void listarPassageiros() {
        List<Passageiro> passageiros = facade.listarPassageiros();
        if (passageiros.isEmpty()) {
            System.out.println("⚠️ Nenhum passageiro cadastrado.");
        } else {
            System.out.println("\n--- Lista de Passageiros ---");
            passageiros.forEach(System.out::println);
        }
    }
}
