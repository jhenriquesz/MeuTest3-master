package org.example;

import org.example.entities.*;
import org.example.facade.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final PassageiroFacade passageiroFacade = new PassageiroFacade();
    private static final AviaoFacade aviaoFacade = new AviaoFacade();
    private static final VooFacade vooFacade = new VooFacade(aviaoFacade);
    private static final ReservaFacade reservaFacade = new ReservaFacade();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Opção inválida. Digite um número: ");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarPassageiro(scanner);
                case 2 -> listarPassageiros();
                case 3 -> cadastrarAviao(scanner);
                case 4 -> listarAvioes();
                case 5 -> cadastrarVoo(scanner);
                case 6 -> listarVoos();
                case 7 -> cadastrarReserva(scanner);
                case 8 -> listarReservas();
                case 0 -> System.out.println("✅ Saindo do sistema. Até logo!");
                default -> System.out.println("❌ Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n========= MENU PRINCIPAL =========");
        System.out.println("1 - Cadastrar passageiro");
        System.out.println("2 - Listar passageiros");
        System.out.println("3 - Cadastrar avião");
        System.out.println("4 - Listar aviões");
        System.out.println("5 - Cadastrar voo");
        System.out.println("6 - Listar voos");
        System.out.println("7 - Cadastrar reserva");
        System.out.println("8 - Listar reservas");
        System.out.println("0 - Sair");
        System.out.println("===================================");
    }

    private static void cadastrarPassageiro(Scanner scanner) {
        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine().trim();

            System.out.print("E-mail: ");
            String email = scanner.nextLine().trim();

            passageiroFacade.CadastrarPassageiro(nome, cpf, email);
            System.out.println("✅ Passageiro cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro ao cadastrar passageiro: " + e.getMessage());
        }
    }

    private static void listarPassageiros() {
        List<Passageiro> passageiros = passageiroFacade.listarPassageiros();
        if (passageiros.isEmpty()) {
            System.out.println("⚠️ Nenhum passageiro cadastrado.");
        } else {
            System.out.println("\n--- Lista de Passageiros ---");
            passageiros.forEach(System.out::println);
        }
    }

    private static void cadastrarAviao(Scanner scanner) {
        try {
            System.out.print("ID do avião: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Modelo: ");
            String modelo = scanner.nextLine().trim();

            System.out.print("Capacidade: ");
            int capacidade = Integer.parseInt(scanner.nextLine());

            System.out.print("Fabricante: ");
            String fabricante = scanner.nextLine().trim();

            aviaoFacade.cadastrarAviao(id, modelo, capacidade, fabricante);
            System.out.println("✅ Avião cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("❌ Erro ao cadastrar avião: " + e.getMessage());
        }
    }

    private static void listarAvioes() {
        List<Aviao> avioes = aviaoFacade.listarAvioes();
        if (avioes.isEmpty()) {
            System.out.println("⚠️ Nenhum avião cadastrado.");
        } else {
            System.out.println("\n--- Lista de Aviões ---");
            avioes.forEach(System.out::println);
        }
    }

    private static void cadastrarVoo(Scanner scanner) {
        try {
            System.out.print("ID do voo: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Origem: ");
            String origem = scanner.nextLine().trim();

            System.out.print("Destino: ");
            String destino = scanner.nextLine().trim();

            System.out.print("Data e hora (yyyy-MM-ddTHH:mm): ");
            String dataHoraStr = scanner.nextLine();
            var dataHora = java.time.LocalDateTime.parse(dataHoraStr);

            System.out.println("--- Aviões Disponíveis ---");
            listarAvioes();
            System.out.print("ID do avião a ser associado: ");
            int idAviao = Integer.parseInt(scanner.nextLine());
            Aviao aviao = aviaoFacade.buscarPorId(idAviao);

            vooFacade.cadastrarVoo(id, origem, destino, dataHora, aviao);
            System.out.println("✅ Voo cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("❌ Erro ao cadastrar voo: " + e.getMessage());
        }
    }

    private static void listarVoos() {
        List<Voo> voos = vooFacade.listarVoos();
        if (voos.isEmpty()) {
            System.out.println("⚠️ Nenhum voo cadastrado.");
        } else {
            System.out.println("\n--- Lista de Voos ---");
            voos.forEach(voo -> {
                System.out.println(voo);
                System.out.println("Vagas disponíveis: " + voo.getVagasDisponiveis());
                System.out.println("------------------------------------");
            });
        }
    }

    private static void cadastrarReserva(Scanner scanner) {
        try {
            System.out.print("ID da reserva: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.println("--- Passageiros Disponíveis ---");
            listarPassageiros();
            System.out.print("ID do passageiro: ");
            int idPassageiro = Integer.parseInt(scanner.nextLine());
            Passageiro passageiro = passageiroFacade.buscarPorId(idPassageiro);

            System.out.println("--- Voos Disponíveis ---");
            listarVoos();
            System.out.print("ID do voo: ");
            int idVoo = Integer.parseInt(scanner.nextLine());
            Voo voo = vooFacade.buscarPorId(idVoo);

            reservaFacade.cadastrarReserva(id, passageiro, voo);
            System.out.println("✅ Reserva cadastrada com sucesso!");
        } catch (Exception e) {
            System.out.println("❌ Erro ao cadastrar reserva: " + e.getMessage());
        }
    }

    private static void listarReservas() {
        List<Reserva> reservas = reservaFacade.listarReservas();
        if (reservas.isEmpty()) {
            System.out.println("⚠️ Nenhuma reserva cadastrada.");
        } else {
            System.out.println("\n--- Lista de Reservas ---");
            reservas.forEach(System.out::println);
        }
    }
}

