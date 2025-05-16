package org.example.facade;

import org.example.entities.Passageiro;
import org.example.repositories.PassageiroRepository;
import org.example.services.PassageiroService;

import java.util.List;

public class PassageiroFacade {
    private final PassageiroRepository repository = new PassageiroRepository();
    private final PassageiroService service = new PassageiroService();
    private int proximoId = 1;

    public boolean CadastrarPassageiro(String name, String cpf, String email) throws IllegalArgumentException {
        if (!service.ValidarCpf(cpf)) {
            throw new IllegalArgumentException("cpf invalido!");
        }
        if (!service.validarEmail(email)) {
            throw new IllegalArgumentException("E-mail invalido!");
        }

        Passageiro passageiro = new Passageiro(proximoId++, name, cpf, email);
        repository.salvar(passageiro);
        return true;
    }


    public List<Passageiro> listarPassageiros() {
        return repository.ListarTodos();
    }
}
