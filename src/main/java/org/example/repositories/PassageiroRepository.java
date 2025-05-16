package org.example.repositories;

import org.example.entities.Passageiro;

import java.util.ArrayList;
import java.util.List;

public class PassageiroRepository {
        private final List<Passageiro> passageiros = new ArrayList<>();

        public void salvar (Passageiro passageiro){
            passageiros.add(passageiro);

        }

        public List<Passageiro> ListarTodos(){
            return passageiros;
        }
    }


