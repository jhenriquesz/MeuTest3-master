package org.example.facade;

import org.example.entities.Aviao;
import org.example.services.AviaoService;

import java.util.List;

public class AviaoFacade {
    private final AviaoService aviaoService = new AviaoService();

    public void cadastrarAviao(int id, String modelo, int capacidade, String fabricante) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }

        Aviao aviao = new Aviao(modelo, capacidade, fabricante);
        aviaoService.adicionar(aviao);
    }

    public List<Aviao> listarAvioes() {
        return aviaoService.buscarTodos();
    }

    public Aviao buscarPorId(int id) {
        return aviaoService.buscarPorId(id);
    }
}
