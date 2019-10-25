package com.bcopstein.casosDeUso.Politicas;

import com.bcopstein.entidades.Cidade;
import com.bcopstein.entidades.Passageiro;
import com.bcopstein.entidades.Roteiro;
import com.bcopstein.entidades.Veiculo;
import com.bcopstein.entidades.geometria.Reta;

public class CalculoCustoViagemBasico implements CalculoCustoViagem {
    private Cidade cidade;
    private Roteiro roteiro;
    private Passageiro passageiro;
    private Veiculo veiculo;

    @Override
    public void defineRoteiro(Roteiro roteiro) {
        this.roteiro = roteiro;

    }

    @Override
    public void defineCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public void definePassageiro(Passageiro passageiro){
        this.passageiro = passageiro;
    }

    @Override
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
    
    @Override
    public double calculoCustoBasico() {
        Reta reta = roteiro.getRota();
        return cidade.bairrosPercoridos(reta)
                .stream()
                .mapToDouble(b->b.getCustoTransporte())
                .sum();
    }

    @Override
    public double adicionalVeiculo() {
        switch(veiculo.getClass().getName()){
            case "VeiculoSimples":
                return 0.0;
            case "VeiculoNormal":
                return calculoCustoBasico()*0.1;
            case "VeiculoLuxo":
                Reta reta = roteiro.getRota();
                int qtdadeBairros = cidade.bairrosPercoridos(reta).size();
                double percent = qtdadeBairros * 0.01;
                double cb = calculoCustoBasico();
                return cb*0.1 + cb*percent;
            default:
                return 0.0;
        }
    }

    @Override
    public double descontoPontuacao() {
        return 0.0;
    }

    @Override
    public double descontoPromocaoSazonal() {
        return 0.0;
    }

    @Override
    public double custoViagem() {
        return calculoCustoBasico() + 
                adicionalVeiculo() -
                descontoPontuacao() -
                descontoPromocaoSazonal();
    }
}