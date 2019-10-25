package com.bcopstein.casosDeUso.Repositorios;

import com.bcopstein.entidades.Cidade;

public interface RepositorioCidades {
    Cidade recuperaPorNome(String nomeCidade);
}