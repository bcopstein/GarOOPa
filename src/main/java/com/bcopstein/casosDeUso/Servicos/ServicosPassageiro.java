package com.bcopstein.casosDeUso.Servicos;

import java.util.Random;

import com.bcopstein.entidades.Bairro;
import com.bcopstein.entidades.Cidade;
import com.bcopstein.entidades.Motorista;
import com.bcopstein.entidades.Passageiro;
import com.bcopstein.entidades.Roteiro;
import com.bcopstein.entidades.Veiculo;
import com.bcopstein.entidades.VeiculosFactory;
import com.bcopstein.entidades.Viagem;
import com.bcopstein.entidades.geometria.Ponto;

import org.springframework.stereotype.Service;

// Corresponde a fachada dos casos de uso dos clientes

// Precisa gerar excecoes de negocio. Exemplos: cpf inexi
@Service
public class ServicosPassageiro {
    public Viagem criarViagem(String cpf,String bairroOrigem,String bairroDestino,String formaPagamento,String catVeiculo){
        Random r = new Random();
        Passageiro passageiro = Passageiro.novoPassageiroCartao(cpf, "Ze"+r.nextInt(10)+1);
        // Refatorar o Factory para FactoryMethod
        Veiculo veiculo = VeiculosFactory.getInstance().createInstance("ABC123", "GM", "AZUL", "LUXO");
        Motorista motorista = Motorista.novoMotoristaCartao("23489896545", "Tonhao", veiculo);
        Bairro bOrig = Bairro.novoBairroQuadrado("Petropolis", new Ponto(10,150), 100, 10);
        Bairro bDest = Bairro.novoBairroQuadrado("Auxiliadora", new Ponto(50,260), 110, 10);
        Cidade cidade = Cidade.novaCidade("Porto Alegre");
        cidade.cadastraBairro(bOrig);
        cidade.cadastraBairro(bDest);
        Roteiro roteiro = Roteiro.criaRoteiro(cidade, bOrig, bDest);
        return Viagem.novaViagem(1, roteiro, motorista, passageiro, 10.0+r.nextInt(100));
    }

    // Ajusta pontuação do motorista em função de uma avaliação
    public Motorista pontuarMotorista(String cpfMotorista,int avaliacao){
        Veiculo veiculo = VeiculosFactory.getInstance().createInstance("ABC123", "GM", "AZUL", "LUXO");
        Motorista motorista = Motorista.novoMotoristaCartao("23489896545", "Tonhao", veiculo);
        motorista.infoPontuacao(avaliacao);
        return motorista;
    }
}