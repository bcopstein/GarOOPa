package com.bcopstein.entidades;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.bcopstein.entidades.geometria.Reta;
import com.bcopstein.entidades.geometria.SituacaoReta;


public class Cidade {
    private String nome;
    private Map<String,Bairro> bairros;

    public static Cidade novaCidade(String nome){
        return new Cidade(nome);
    }
    
    private Cidade(String nome) {
        this.nome = nome;
        bairros = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void cadastraBairro(Bairro bairro){
        bairros.put(bairro.getNome(), bairro);
    }

    public Bairro getBairroPorNome(String nomeBairro){
        return bairros.get(nomeBairro);
    }
    
    public Collection<String> getNomesDosBairros(){
        return bairros.keySet();
    }

    public Collection<Bairro> bairrosPercoridos(Reta rota){
        Collection<Bairro> percorridos = new LinkedList<>();
        for(Bairro bairro:bairros.values()){
            SituacaoReta sr = bairro.getArea().classifica(rota);
            if (sr != SituacaoReta.TODA_FORA){
                percorridos.add(bairro);
            }
        }
        return percorridos;
    }
}