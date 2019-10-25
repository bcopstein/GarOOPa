package com.bcopstein.casosDeUso.Politicas;

import com.bcopstein.entidades.geometria.Reta;

public class CalculoCustoViagemPromocaoViagemLonga extends CalculoCustoViagemBasico {

    @Override
    public double descontoPontuacao() {
        double cb = calculoCustoBasico();
        return (getPassageiro().getPontuacaoMedia() > 9.0)? cb*0.1:0.0;
    }

    @Override
    public double descontoPromocaoSazonal() {
        Reta reta = getRoteiro().getRota();
        int qtdadeBairros = getCidade().bairrosPercoridos(reta).size();
        double cb = calculoCustoBasico();
        if (qtdadeBairros > 2){
            return cb*0.1;
        }else{
            return 0.0;
        }
    }  
}