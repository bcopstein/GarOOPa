package com.bcopstein.interfaces.Persistencia;

import java.util.HashMap;
import java.util.Map;

import com.bcopstein.casosDeUso.Repositorios.RepositorioVeiculos;
import com.bcopstein.entidades.Veiculo;
import com.bcopstein.entidades.VeiculosFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositorioVeiculosImplMem implements RepositorioVeiculos {
    private Map<String,Veiculo> veiculos;
    
    @Autowired
    public RepositorioVeiculosImplMem(VeiculosFactory veicFac){
        veiculos = new HashMap<>();
        
        Veiculo veiculo;

        veiculo = veicFac.createInstance("ABC1234", "GM", "Verde", "NORMAL");
        veiculos.put(veiculo.getPlaca(),veiculo);

        veiculo = veicFac.createInstance("XYZ5678", "WW", "Cinza", "SIMPLES");
        veiculos.put(veiculo.getPlaca(),veiculo);

        veiculo = veicFac.createInstance("AKK7336", "Honda", "Azul", "LUXO");
        veiculos.put(veiculo.getPlaca(),veiculo);
    }

    @Override
    public Veiculo recuperaPorPlaca(String placa) {
        Veiculo veiculo = veiculos.get(placa);
        if (veiculo == null){
            throw new IllegalArgumentException("Veiculo inexistente: "+placa);
        }
        return veiculo;
    }
    
}