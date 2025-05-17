package org.example.repositories;

import org.example.entities.Passageiro;
import org.example.entities.Reserva;
import org.example.entities.Voo;

import java.util.ArrayList;
import java.util.List;

public class ReservaRepository {
    private final List<Reserva> reservas = new ArrayList<>();

    public void salvar(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> listarTodas() {
        return new ArrayList<>(reservas);
    }

    public long contarPorVoo(int idVoo) {
        return reservas.stream()
                .filter(r -> r.getVoo().getId() == idVoo)
                .count();
    }
    public void adicionar(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> buscarTodos() {
        return new ArrayList<>(reservas);
    }

    public Reserva buscarPorId(int id) {
        return reservas.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
