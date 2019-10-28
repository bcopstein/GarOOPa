package com.bcopstein.casosDeUso.Repositorios;

import com.bcopstein.entidades.Motorista;

public interface RepositorioMotoristas {
    Motorista recuperaPorNome(String nome);
}