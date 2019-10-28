package com.bcopstein.interfaces.Persistencia;

import java.util.HashMap;
import java.util.Map;

import com.bcopstein.casosDeUso.Repositorios.RepositorioMotoristas;
import com.bcopstein.casosDeUso.Repositorios.RepositorioVeiculos;
import com.bcopstein.entidades.Motorista;
import com.bcopstein.entidades.Veiculo;

public class RepositorioMotoristasImplMem implements RepositorioMotoristas {
    private Map<String,Motorista> motoristas;
    
    public RepositorioMotoristasImplMem(RepositorioVeiculos repV){
        Motorista motorista;
        Veiculo veiculo;

        motoristas = new HashMap<>();
        
        veiculo = repV.recuperaPorPlaca("ABC1234");
        motorista = Motorista.novoMotoristaCartao("349983409-88", "Jose Luis", veiculo);
        motoristas.put(motorista.getCPF(),motorista);

        veiculo = repV.recuperaPorPlaca("XYZ5678");
        motorista = Motorista.novoMotoristaCartao("786234902-33", "Aline Monteiro", veiculo);
        motoristas.put(motorista.getCPF(),motorista);

        veiculo = repV.recuperaPorPlaca("AKK7336");
        motorista = Motorista.novoMotoristaCartao("098276140-99", "Luciane Swork", veiculo);
        motoristas.put(motorista.getCPF(),motorista);
    }

    @Override
    public Motorista recuperaPorNome(String nome) {
        Motorista motorista = motoristas.get(nome);
        if (motorista == null){
            throw new IllegalArgumentException("Motorista inexistente: "+nome);
        }
        return motorista;
    }
}