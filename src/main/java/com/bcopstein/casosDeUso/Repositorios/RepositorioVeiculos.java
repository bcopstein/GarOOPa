package com.bcopstein.casosDeUso.Repositorios;

import com.bcopstein.entidades.Veiculo;

interface RepositorioVeiculos {
    Veiculo recuperaPorPlaca(String placa);
}