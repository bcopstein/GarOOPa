package com.bcopstein;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

import com.bcopstein.entidades.Bairro;
import com.bcopstein.entidades.Cidade;
import com.bcopstein.entidades.geometria.Area;
import com.bcopstein.entidades.geometria.Ponto;
import com.bcopstein.entidades.geometria.Reta;
import com.bcopstein.entidades.geometria.SituacaoReta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CidadeTest {
    private Cidade poopolis;
    
    /*
    @BeforeEach
    public void setup() {
        poopolis = new Cidade(10,"Poopolis");
        poopolis.cadastraBairro(new Bairro(10,"Petropolis",new Area(new Ponto(0,12),new Ponto(4,8)),10.0));
        poopolis.cadastraBairro(new Bairro(20,"Bom Fim",new Area(new Ponto(2,8),new Ponto(8,4)),10.0));
        poopolis.cadastraBairro(new Bairro(30,"BoaVista",new Area(new Ponto(5,4),new Ponto(10,0)),15.0));
        poopolis.cadastraBairro(new Bairro(40,"Alegria",new Area(new Ponto(0,4),new Ponto(5,0)),10.0));
    }

    @Disabled
    @DisplayName("Classifica pontos")
    @ParameterizedTest
    @CsvSource({ "3,9,8,3,3","3,6,3,3,2","6,1,8,1,1","11,1,13,1,0"})
    public void rotaTest(int x1,int y1,int x2,int y2,int rEsp) {
        Reta rota = new Reta(new Ponto(x1,y1),new Ponto(x2,y2));
        Collection<Bairro> percorridos = poopolis.bairrosPercoridos(rota);
        assertEquals(rEsp,percorridos.size());
    }    

    public static void main(String args[]){
        Cidade poopolis = new Cidade(10,"Poopolis");
        poopolis.cadastraBairro(new Bairro(10,"Petropolis",new Area(new Ponto(0,12),new Ponto(4,8)),10.0));
        poopolis.cadastraBairro(new Bairro(20,"Bom Fim",new Area(new Ponto(2,8),new Ponto(8,4)),10.0));
        poopolis.cadastraBairro(new Bairro(30,"BoaVista",new Area(new Ponto(5,4),new Ponto(10,0)),15.0));
        poopolis.cadastraBairro(new Bairro(40,"Alegria",new Area(new Ponto(0,4),new Ponto(5,0)),10.0));
        
        Reta rota = new Reta(new Ponto(3,9),new Ponto(8,3));
        Bairro b = poopolis.getBairroPorNome("Alegria");
        SituacaoReta sr = b.getArea().classifica(rota);
        System.out.println(sr);
    }
    */
}