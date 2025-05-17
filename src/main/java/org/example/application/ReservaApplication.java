package org.example.application;

import org.example.entities.Passageiro;
import org.example.entities.Reserva;
import org.example.entities.Voo;
import org.example.services.ReservaService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ReservaApplication {
    private final ReservaService reservaService;
    private final Scanner scanner;
    private final List<Passageiro> passageiros;
    private final List<Voo> voos;

    public ReservaApplication(ReservaService reservaService, Scanner scanner,
                              List<Passageiro> passageiros, List<Voo> voos) {
        this.reservaService = reservaService;
        this.scanner = scanner;
        this.passageiros = passageiros;
        this.voos = voos;
    }

    public void cadastrarReserva() {
        System.out.println("Digite o ID da reserva:");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Escolha o passageiro pelo ID:");
        for (Passageiro p : passageiros) {
            System.out.println(p.getId() + " - " + p.getName());
        }
        int idPassageiro = Integer.parseInt(scanner.nextLine());
        Passageiro passageiro = passageiros.stream()
                .filter(p -> p.getId() == idPassageiro)
                .findFirst()
                .orElse(null);

        if (passageiro == null) {
            System.out.println("Passageiro não encontrado.");
            return;
        }

        System.out.println("Escolha o voo pelo ID:");
        for (Voo v : voos) {
            System.out.println(v.getId() + " - " + v.getOrigem() + " -> " + v.getDestino());
        }
        int idVoo = Integer.parseInt(scanner.nextLine());
        Voo voo = voos.stream()
                .filter(v -> v.getId() == idVoo)
                .findFirst()
                .orElse(null);

        if (voo == null) {
            System.out.println("Voo não encontrado.");
            return;
        }

        LocalDateTime dataReserva = LocalDateTime.now();
        Reserva reserva = new Reserva(passageiro, voo, dataReserva);

        try {
            reservaService.cadastrarReserva(reserva);
            System.out.println("Reserva cadastrada com sucesso.");
        } catch (IllegalStateException e) {
            System.out.println("Erro ao cadastrar reserva: " + e.getMessage());
        }
    }
}
