package com.bcopstein.casosDeUso.Repositorios;

import java.util.stream.Stream;
import com.bcopstein.entidades.Viagem;

public interface RepositorioViagens {
    void cadastrarViagem(Viagem umaViagem);
    Stream<Viagem> getViagens();
}