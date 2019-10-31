package com.bcopstein.casosDeUso.Politicas;

import com.bcopstein.entidades.Cidade;
import com.bcopstein.entidades.Passageiro;
import com.bcopstein.entidades.Roteiro;
import com.bcopstein.entidades.Veiculo;

public abstract class CalculoCustoViagem {
    private Cidade cidade;
    private Roteiro roteiro;
    private Passageiro passageiro;
    private Veiculo veiculo;

    public void defineRoteiro(Roteiro roteiro) {
        this.roteiro = roteiro;

    }

    public void defineCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public void definePassageiro(Passageiro passageiro){
        this.passageiro = passageiro;
    }

    public void defineVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }

	public Cidade getCidade() {
		return cidade;
	}

	public Roteiro getRoteiro() {
		return roteiro;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}
    
    public double custoViagem() {
        return calculoCustoBasico() + 
                adicionalVeiculo() -
                descontoPontuacao() -
                descontoPromocaoSazonal();
    }

    public abstract double calculoCustoBasico();
    public abstract double adicionalVeiculo();
    public abstract double descontoPontuacao();
    public abstract double descontoPromocaoSazonal();
}