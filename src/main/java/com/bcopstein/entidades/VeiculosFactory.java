package com.bcopstein.entidades;

public class VeiculosFactory {
    private static VeiculosFactory esta = null;

    private VeiculosFactory(){

    }

    public static VeiculosFactory getInstance(){
        if (esta == null){
            esta = new VeiculosFactory();
        }
        return esta;
    }

    public Veiculo createInstance(String placa,String marca, String cor,String cv){
        switch(cv){
            case "SIMPLES":
                return new VeiculoSimples(placa, marca, cor);
            case "NORMAL":
                return new VeiculoNormal(placa,marca,cor);
            case "LUXO":
                return new VeiculoLuxo(placa,marca,cor);
        }
        return null;
    }
}