package com.bcopstein.interfaces.WebService;

import com.bcopstein.casosDeUso.Servicos.ServicosPassageiro;
import com.bcopstein.entidades.Viagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/garoopa")
public class ClienteFachadaRemota {
    private ServicosPassageiro servicosPassageiro;

    @Autowired
    public ClienteFachadaRemota(ServicosPassageiro servicosPassageiro){
        this.servicosPassageiro = servicosPassageiro;
    }

    @GetMapping("/solicitacaoviagem")
    public DadosViagemDTO getDadosViagem(@RequestParam String cpf,
                                         @RequestParam String bOrig,
                                         @RequestParam String bDest,
                                         @RequestParam String formaPgto,
                                         @RequestParam String catVeiculo){
        // Se este método lancar exceção o SpringBoot gera resposta de erro automática
        // lancar exceção, não retornar null
        Viagem viagem = servicosPassageiro.criarViagem(cpf, bOrig, bDest, formaPgto, catVeiculo);
        DadosViagemDTO dto = new DadosViagemDTO();
        dto.setCustoCorrida(viagem.getCusto());
        dto.setMarcaModelo(viagem.getMotorista().getVeiculo().getMarca()+
                           viagem.getMotorista().getVeiculo().getCor());
        dto.setNomeMotorista(viagem.getMotorista().getNome());
        dto.setPlacaVeiculo(viagem.getMotorista().getVeiculo().getPlaca());
        return dto;
    }

    @GetMapping("/pontuamotorista")
    public Boolean getDadosViagem(@RequestParam String nomeMotorista,
                                  @RequestParam int avaliacaoMotorista){
        Boolean resp = servicosPassageiro.pontuarMotorista(nomeMotorista, avaliacaoMotorista);
        return resp;
    }
}