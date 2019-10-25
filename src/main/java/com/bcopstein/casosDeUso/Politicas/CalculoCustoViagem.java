package com.bcopstein.casosDeUso.Politicas;

import com.bcopstein.entidades.Cidade;
import com.bcopstein.entidades.Passageiro;
import com.bcopstein.entidades.Roteiro;
import com.bcopstein.entidades.Veiculo;

interface CalculoCustoViagem {
    void defineCidade(Cidade cidade);
    void defineRoteiro(Roteiro roteiro);
    void definePassageiro(Passageiro passageiro);
    void defineVeiculo(Veiculo veiculo);
    public Cidade getCidade();
	public Roteiro getRoteiro();
	public Passageiro getPassageiro();
	public Veiculo getVeiculo();
    double calculoCustoBasico();
    double adicionalVeiculo();
    double descontoPontuacao();
    double descontoPromocaoSazonal();
    double custoViagem();
}