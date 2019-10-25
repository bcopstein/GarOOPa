package com.bcopstein.entidades;

import com.bcopstein.entidades.geometria.Ponto;
import com.bcopstein.entidades.geometria.Reta;

public class Roteiro {
    private Cidade cidade;
    private Bairro bairroOrigem;
    private Bairro bairroDestino;

    public static Roteiro criaRoteiro(Cidade cidade,Bairro origem,Bairro destino){
        return new Roteiro(cidade,origem,destino);
    }

    private Roteiro(Cidade cidade, Bairro bairroOrigem, Bairro bairroDestino) {
        this.cidade = cidade;
        this.bairroOrigem = bairroOrigem;
        this.bairroDestino = bairroDestino;
    }

    public Reta getRota(){
        Ponto pOrig = bairroOrigem.getArea().pontoCentral();
        Ponto pDest = bairroOrigem.getArea().pontoCentral();
        // TO DO: verificar necessidade de inverter início e fim se for o caso
        return new Reta(pOrig,pDest);
    }
    
    public Cidade getCidade() {
        return cidade;
    }

    public Bairro getBairroOrigem() {
        return bairroOrigem;
    }

    public Bairro getBairroDestino() {
        return bairroDestino;
    }

    @Override
    public String toString() {
        return "Roteiro [bairroDestino=" + bairroDestino + ", bairroOrigem=" + bairroOrigem + ", cidade=" + cidade
                + "]";
    }
}