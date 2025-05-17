package org.example.repositories;

import org.example.entities.Aviao;

import java.util.ArrayList;
import java.util.List;

public class AviaoRepository {
    private final List<Aviao> avioes = new ArrayList<>();
    private int proximoId = 1;

    public void salvar(Aviao aviao) {
        avioes.add(aviao);
    }

    public List<Aviao> listarTodos() {
        return new ArrayList<>(avioes);
    }

    public void adicionar(Aviao aviao) {
        aviao.setId(proximoId++);
        avioes.add(aviao);
    }

    public List<Aviao> buscarTodos() {
        return new ArrayList<>(avioes);
    }

    public Aviao buscarPorId(int id) {
        return avioes.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
