package org.example.services;

import org.example.entities.Aviao;
import org.example.repositories.AviaoRepository;

import java.util.List;

public class AviaoService {
    private final AviaoRepository aviaoRepository;

    public AviaoService() {
        AviaoRepository AviaoRepository = null;
        this.aviaoRepository = AviaoRepository;
    }

    public void cadastrarAviao(Aviao aviao) {
        if (aviao.getCapacidade() <= 0) {
            throw new IllegalArgumentException("A capacidade do avião deve ser maior que zero.");
        }
        aviaoRepository.salvar(aviao);
    }

    public List<Aviao> listarAvioes() {
        return aviaoRepository.listarTodos();
    }

    public void adicionar(Aviao aviao) {
        aviaoRepository.adicionar(aviao);
    }

    public List<Aviao> buscarTodos() {
        return aviaoRepository.buscarTodos();
    }

    public Aviao buscarPorId(int id) {
        return aviaoRepository.buscarPorId(id);
    }
}
