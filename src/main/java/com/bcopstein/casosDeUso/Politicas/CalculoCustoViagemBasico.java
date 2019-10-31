package com.bcopstein.casosDeUso.Politicas;

import com.bcopstein.entidades.geometria.Reta;

public class CalculoCustoViagemBasico extends CalculoCustoViagem {
    @Override
    public double calculoCustoBasico() {
        Reta reta = getRoteiro().getRota();
        return getCidade().bairrosPercoridos(reta)
                .stream()
                .mapToDouble(b->b.getCustoTransporte())
                .sum();
    }

    @Override
    public double adicionalVeiculo() {
        switch(getVeiculo().getClass().getName()){
            case "VeiculoSimples":
                return 0.0;
            case "VeiculoNormal":
                return calculoCustoBasico()*0.1;
            case "VeiculoLuxo":
                Reta reta = getRoteiro().getRota();
                int qtdadeBairros = getCidade().bairrosPercoridos(reta).size();
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
}