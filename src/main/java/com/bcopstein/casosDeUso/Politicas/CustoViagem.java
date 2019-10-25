package com.bcopstein.casosDeUso.Politicas;

import com.bcopstein.entidades.Cidade;
import com.bcopstein.entidades.Passageiro;
import com.bcopstein.entidades.Roteiro;
import com.bcopstein.entidades.Veiculo;

public class CustoViagem {
    private CalculoCustoViagem ccv;

    public static CustoViagem criaCustoViagem(String tipo){
        switch(tipo){
            case "Basico":
            return new CustoViagem(new CalculoCustoViagemBasico()); 
            case "PromocaoViagemLonga":
            return new CustoViagem(new CalculoCustoViagemPromocaoViagemLonga());
            default:
            throw new IllegalArgumentException("Categoria de custo de viagem invalida");
        }
    }
    
    private CustoViagem(CalculoCustoViagem ccv){
        this.ccv = ccv;
    } 

    public double custoViagem(Cidade cidade,Roteiro roteiro,Passageiro passageiro,Veiculo veiculo){
        ccv.defineCidade(cidade);
        ccv.defineRoteiro(roteiro);
        ccv.definePassageiro(passageiro);
        ccv.defineVeiculo(veiculo);
        return ccv.custoViagem();
    }
}