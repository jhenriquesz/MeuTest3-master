package org.example.repositories;

import org.example.entities.Reserva;
import org.example.entities.Voo;

import java.util.ArrayList;
import java.util.List;

public class VooRepository {
    private final List<Reserva> reservas = new ArrayList<>();
    private org.example.entities.Voo Voo;

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

    private final List<Voo> voos = new ArrayList<>();
    private int proximoId = 1;

    public void adicionar(Voo voo) {
        voo.setId(proximoId++);
        voos.add(voo);
    }

    public List<Voo> buscarTodos() {
        return new ArrayList<>(voos);
    }

    public Voo buscarPorId(int id) {
        return voos.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void salvar() {
        if (Voo.getId() == 0) {
            Voo.setId(proximoId++);
            voos.add(Voo);
        } else {
            for (int i = 0; i < voos.size(); i++) {
                if (voos.get(i).getId() == Voo.getId()) {
                    voos.set(i, Voo);
                    return;
                }
            }
            voos.add(Voo);
        }
    }
}
