package org.example.facade;

import org.example.entities.Passageiro;
import org.example.entities.Reserva;
import org.example.entities.Voo;
import org.example.services.PassageiroService;
import org.example.services.ReservaService;
import org.example.services.VooService;

import java.time.LocalDateTime;
import java.util.List;

public class ReservaFacade {

    private final ReservaService reservaService = new ReservaService();
    private final PassageiroService passageiroService = new PassageiroService();
    private final VooService vooService = new VooService();

    public void cadastrarReserva(int idPassageiro, int idVoo) {
        Passageiro passageiro = passageiroService.buscarPorId(idPassageiro);
        if (passageiro == null) {
            throw new IllegalArgumentException("Passageiro não encontrado.");
        }

        Voo voo = vooService.buscarPorId(idVoo);
        if (voo == null) {
            throw new IllegalArgumentException("Voo não encontrado.");
        }

        if (voo.getVagasDisponiveis() <= 0) {
            throw new IllegalStateException("Não há vagas disponíveis neste voo.");
        }

        Reserva reserva = new Reserva(passageiro, voo, LocalDateTime.now());
        reservaService.adicionar(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservaService.buscarTodos();
    }

    public void cadastrarReserva(int id, Passageiro passageiro, Voo voo) {
    }
}
