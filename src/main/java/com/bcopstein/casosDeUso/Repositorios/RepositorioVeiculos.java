package com.bcopstein.casosDeUso.Repositorios;

import com.bcopstein.entidades.Veiculo;

public interface RepositorioVeiculos {
    Veiculo recuperaPorPlaca(String placa);
}