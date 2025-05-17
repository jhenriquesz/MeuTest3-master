package org.example.facade;

import org.example.entities.Aviao;
import org.example.entities.Voo;
import org.example.services.AviaoService;
import org.example.services.VooService;

import java.time.LocalDateTime;
import java.util.List;

public class VooFacade {
    private final VooService vooService = new VooService();
    private final AviaoService aviaoService = new AviaoService();

    public VooFacade(AviaoFacade aviaoFacade) {
    }

    public void cadastrarVoo(String origem, String destino, LocalDateTime dataHora, int idAviao) {
        Aviao aviao = aviaoService.buscarPorId(idAviao);
        if (aviao == null) {
            throw new IllegalArgumentException("Avião não encontrado.");
        }

        Voo voo = new Voo(origem, destino, dataHora, aviao);
        vooService.adicionar(voo);
    }

    public List<Voo> listarVoos() {
        return vooService.buscarTodos();
    }

    public Voo buscarPorId(int id) {
        return vooService.buscarPorId(id);
    }

    public void cadastrarVoo(int id, String origem, String destino, LocalDateTime dataHora, Aviao aviao) {

    }
}
