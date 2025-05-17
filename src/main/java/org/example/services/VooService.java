package org.example.services;

import org.example.entities.Reserva;
import org.example.entities.Voo;
import org.example.repositories.VooRepository;

import java.util.List;

public class VooService {
    private VooRepository vooRepository = null;

    public VooService() {
        this.vooRepository = vooRepository;
    }

    public void cadastrarVoo(Voo voo) {
        if (Voo.getAviao() == null) {
            throw new IllegalArgumentException("O voo deve estar vinculado a um avião.");
        }

        vooRepository.salvar();
    }

    public List<Reserva> listarVoos() {
        return vooRepository.listarTodas();
    }

    public int calcularVagasDisponiveis(Voo voo, int totalReservas) {
        return voo.getAviao().getCapacidade() - totalReservas;
    }
    public void adicionar(Voo voo) {
        vooRepository.adicionar(voo);
    }

    public List<Voo> buscarTodos() {
        return vooRepository.buscarTodos();
    }

    public Voo buscarPorId(int id) {
        return vooRepository.buscarPorId(id);
    }
}
