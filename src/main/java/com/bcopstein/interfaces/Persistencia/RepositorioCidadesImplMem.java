package com.bcopstein.interfaces.Persistencia;

import java.util.HashMap;
import java.util.Map;

import com.bcopstein.casosDeUso.Repositorios.RepositorioBairros;
import com.bcopstein.casosDeUso.Repositorios.RepositorioCidades;
import com.bcopstein.entidades.Cidade;

public class RepositorioCidadesImplMem implements RepositorioCidades {
    private Map<String, Cidade> cidades;

    public RepositorioCidadesImplMem(RepositorioBairros bairros) {
        cidades = new HashMap<>();
        Cidade c = Cidade.novaCidade("POOPolis");
        c.cadastraBairro(bairros.recuperaPorNome("Petropolis"));
        c.cadastraBairro(bairros.recuperaPorNome("Ipiranga"));
        c.cadastraBairro(bairros.recuperaPorNome("Solidao"));
        c.cadastraBairro(bairros.recuperaPorNome("Bom Fim"));
        c.cadastraBairro(bairros.recuperaPorNome("Vila Nova"));
        c.cadastraBairro(bairros.recuperaPorNome("Alegria"));
        c.cadastraBairro(bairros.recuperaPorNome("Boa Vista"));
        c.cadastraBairro(bairros.recuperaPorNome("Gavea"));
        cidades.put(c.getNome(), c);
    }

    @Override
    public Cidade recuperaPorNome(String nomeCidade) {
        Cidade cidade = cidades.get(nomeCidade);
        if (cidade == null) {
            throw new IllegalArgumentException("Cidade inexistente: " + nomeCidade);
        }
        return cidade;
    }
}