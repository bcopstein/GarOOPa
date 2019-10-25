package com.bcopstein.entidades;

public abstract class Veiculo {
    private String placa;
    private String marca;
    private String cor;

    public Veiculo(String placa, String marca, String cor){
        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return getClass().getName()+" [ Cor=" + cor + ", marca=" + marca + ", placa=" + placa + "]";
    }
}