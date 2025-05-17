package org.example.services;

import org.example.entities.Reserva;
import org.example.entities.Voo;
import org.example.repositories.ReservaRepository;

import java.util.List;

public class ReservaService {
    private ReservaRepository reservaRepository = null;

    public ReservaService() {
        this.reservaRepository = reservaRepository;
    }

    public void cadastrarReserva(Reserva reserva) {
        Voo voo = reserva.getVoo();
        int reservasExistentes = (int) reservaRepository.contarPorVoo(voo.getId());
        int capacidade = voo.getAviao().getCapacidade();

        if (reservasExistentes >= capacidade) {
            throw new IllegalStateException("Voo sem vagas disponíveis.");
        }

        reservaRepository.salvar(reserva);
    }

    public void adicionar(Reserva reserva) {
        reservaRepository.adicionar(reserva);
    }

    public List<Reserva> buscarTodos() {
        return reservaRepository.buscarTodos();
    }
    public Voo buscarPorId(int id) {
        return reservaRepository.buscarPorId(id).getVoo();
    }
}
