package com.bcopstein.casosDeUso.Servicos;

import java.util.Random;

import com.bcopstein.casosDeUso.Politicas.CustoViagem;
import com.bcopstein.casosDeUso.Repositorios.RepositorioBairros;
import com.bcopstein.casosDeUso.Repositorios.RepositorioCidades;
import com.bcopstein.entidades.Bairro;
import com.bcopstein.entidades.Cidade;
import com.bcopstein.entidades.Motorista;
import com.bcopstein.entidades.Passageiro;
import com.bcopstein.entidades.Roteiro;
import com.bcopstein.entidades.Veiculo;
import com.bcopstein.entidades.VeiculosFactory;
import com.bcopstein.entidades.Viagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Corresponde a fachada dos casos de uso dos clientes
// Precisa gerar excecoes de negocio. Exemplos: cpf inexistente
// Deve receber no construtor as dependencias !!
@Service
public class ServicosPassageiro {
    private RepositorioCidades cidades;
    private RepositorioBairros bairros;
    private CustoViagem custoViagem;
    
    @Autowired
    public ServicosPassageiro(RepositorioCidades cidades,RepositorioBairros bairros){
        this.cidades = cidades;
        this.bairros = bairros;
        custoViagem = CustoViagem.criaCustoViagem("Basico");
    }

    public Viagem criarViagem(String cpf,String bairroOrigem,String bairroDestino,String formaPagamento,String catVeiculo){
        Passageiro passageiro = Passageiro.novoPassageiroCartao(cpf, "Ze"/*+r.nextInt(10)+1*/);
        // Refatorar o Factory para FactoryMethod
        Veiculo veiculo = VeiculosFactory.getInstance().createInstance("ABC123", "GM", "AZUL", "LUXO");
        Motorista motorista = Motorista.novoMotoristaCartao("23489896545", "Tonhao", veiculo);
        Cidade cidade = cidades.recuperaPorNome("POOPolis");
        Bairro bOrig = cidade.getBairroPorNome("Petropolis");
        Bairro bDest = cidade.getBairroPorNome("Ipiranga");
        Roteiro roteiro = Roteiro.criaRoteiro(cidade, bOrig, bDest);
        double custo = custoViagem.custoViagem(cidade, roteiro, passageiro, veiculo);
        return Viagem.novaViagem(1, roteiro, motorista, passageiro, 10.0/*+r.nextInt(100)*/);
    }

    // Ajusta pontuação do motorista em função de uma avaliação
    public boolean pontuarMotorista(String cpfMotorista,int avaliacao){
        Veiculo veiculo = VeiculosFactory.getInstance().createInstance("ABC123", "GM", "AZUL", "LUXO");
        Motorista motorista = Motorista.novoMotoristaCartao("23489896545", "Tonhao", veiculo);
        motorista.infoPontuacao(avaliacao);
        return true;
    }
}