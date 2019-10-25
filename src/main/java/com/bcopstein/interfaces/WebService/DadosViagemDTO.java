package com.bcopstein.interfaces.WebService;

public class DadosViagemDTO {
    private String nomeMotorista;
    private String placaVeiculo;
    private String marcaModelo;
    private double custoCorrida;

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public double getCustoCorrida() {
        return custoCorrida;
    }

    public void setCustoCorrida(double custoCorrida) {
        this.custoCorrida = custoCorrida;
    }
}