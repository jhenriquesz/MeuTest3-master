package org.example.application;

import org.example.entities.Aviao;
import org.example.services.AviaoService;

import java.util.List;
import java.util.Scanner;

public class AviaoApplication {
    private final AviaoService aviaoService;
    private final Scanner scanner;

    public AviaoApplication(AviaoService aviaoService, Scanner scanner) {
        this.aviaoService = aviaoService;
        this.scanner = scanner;
    }

    public void cadastrarAviao() {
        System.out.println("Digite o ID do avião:");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite o modelo:");
        String modelo = scanner.nextLine();

        System.out.println("Digite a capacidade:");
        int capacidade = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite o fabricante:");
        String fabricante = scanner.nextLine();

        Aviao aviao = new Aviao(modelo, capacidade, fabricante);
        aviaoService.cadastrarAviao(aviao);

        System.out.println("Avião cadastrado com sucesso.");
    }

    public void listarAvioes() {
        List<Aviao> avioes = aviaoService.listarAvioes();
        if (avioes.isEmpty()) {
            System.out.println("Nenhum avião cadastrado.");
        } else {
            for (Aviao aviao : avioes) {
                System.out.println(aviao);
            }
        }
    }
}
