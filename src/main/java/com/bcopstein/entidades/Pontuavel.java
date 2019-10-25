package com.bcopstein.entidades;

public interface Pontuavel{
    int PTS_MIN = 0;
    int PTS_MAX = 10;

    default boolean validaPontos(int pontos){
        return (pontos >= PTS_MIN) && (pontos <= PTS_MAX);
    }
}