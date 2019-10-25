package com.bcopstein.casosDeUso.Repositorios;

import com.bcopstein.entidades.Passageiro;

public interface RepositorioPassageiros {
    Passageiro recuperaPorCPF(String cpf);
    void atualizaPassageiro(Passageiro passageiro);
}