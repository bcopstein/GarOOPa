package com.bcopstein.entidades;

import java.time.LocalDateTime;

public class Viagem{
    private int id;
    private LocalDateTime dataHora;
    private Roteiro roteiro;
    private Motorista motorista;
    private Passageiro passageiro;
    private double custo;

    public static Viagem novaViagem(int id,Roteiro roteiro,Motorista motorista,Passageiro passageiro, double custo){
        return new Viagem(id,LocalDateTime.now(),roteiro,motorista,passageiro,custo);
    }

    public static Viagem viagemExistente(int id, LocalDateTime dataHora, Roteiro roteiro, Motorista motorista, Passageiro passageiro, double custo){
        return new Viagem(id,dataHora,roteiro,motorista,passageiro,custo);
    }

    private Viagem(int id, LocalDateTime dataHora, Roteiro roteiro, Motorista motorista, Passageiro passageiro,
            double custo) {
        this.id = id;
        this.dataHora = dataHora;
        this.roteiro = roteiro;
        this.motorista = motorista;
        this.passageiro = passageiro;
        this.custo = custo;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDataHora() { // LocalDateTime é imutavel
        return dataHora;
    }

    public Roteiro getRoteiro() {
        return roteiro;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public double getCusto() {
        return custo;
    }

    @Override
    public String toString() {
        return "Viagem [custo=" + custo + ", dataHora=" + dataHora + ", id=" + id + ", motorista=" + motorista
                + ", passageiro=" + passageiro + ", roteiro=" + roteiro + "]";
    }
}