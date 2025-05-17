package org.example.application;

import org.example.entities.Aviao;
import org.example.entities.Reserva;
import org.example.entities.Voo;
import org.example.services.VooService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class VooApplication {
    private final VooService vooService;
    private final Scanner scanner;
    private final List<Aviao> avioes;

    public VooApplication(VooService vooService, Scanner scanner, List<Aviao> avioes) {
        this.vooService = vooService;
        this.scanner = scanner;
        this.avioes = avioes;
    }

    public void cadastrarVoo() {
        System.out.println("Digite o ID do voo:");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite a origem:");
        String origem = scanner.nextLine();

        System.out.println("Digite o destino:");
        String destino = scanner.nextLine();

        System.out.println("Digite a data e hora (YYYY-MM-DDTHH:MM):");
        LocalDateTime dataHora = LocalDateTime.parse(scanner.nextLine());

        System.out.println("Escolha o ID do avião:");
        for (Aviao aviao : avioes) {
            System.out.println(aviao.getId() + " - " + aviao.getModelo());
        }
        int aviaoId = Integer.parseInt(scanner.nextLine());

        Aviao aviaoSelecionado = avioes.stream()
                .filter(a -> a.getId() == aviaoId)
                .findFirst()
                .orElse(null);

        if (aviaoSelecionado == null) {
            System.out.println("Avião não encontrado.");
            return;
        }

        Voo voo = new Voo(origem, destino, dataHora, aviaoSelecionado);
        vooService.cadastrarVoo(voo);
        System.out.println("Voo cadastrado com sucesso.");
    }

    public void listarVoos() {
        List<Reserva> voos = vooService.listarVoos();
        if (voos.isEmpty()) {
            System.out.println("Nenhum voo cadastrado.");
        } else {
            for (Reserva voo : voos) {
                System.out.println(voo);
            }
        }
    }
}
