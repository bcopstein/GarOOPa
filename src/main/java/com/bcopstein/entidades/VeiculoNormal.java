package com.bcopstein.entidades;

public class VeiculoNormal extends Veiculo {
    private boolean atendeCorridaCatInferior;

    public VeiculoNormal(String placa, String marca, String cor) {
        super(placa, marca, cor);
        atendeCorridaCatInferior = true;
    }

    public boolean atendeCorridaCatInferior() {
        return atendeCorridaCatInferior;
    }

    public void setAtendeCorridaCatInferior(boolean atendeCorridaCatInferior) {
        this.atendeCorridaCatInferior = atendeCorridaCatInferior;
    }

}