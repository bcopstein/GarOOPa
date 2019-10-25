package com.bcopstein.entidades;

public class Passageiro implements Pontuavel{
	private String cpf;
	private String nome;
	private FormaPagamento formaPgto;
	private int pontuacaoAcumulada;
	private int qtdadeAvaliacoes;

	public static Passageiro novoPassageiroCartao(String cpf, String nome){
		return new Passageiro(cpf,nome,FormaPagamento.CARTAO,8,1);
	}

	public static Passageiro novoPassageiro(String cpf, String nome,FormaPagamento formaPgto){
		return new Passageiro(cpf,nome,formaPgto,8,1);
	}

	public static Passageiro passageiroExistente(String cpf, String nome, FormaPagamento formaPgto, int pontuacaoAcumulada, int qtdadeAvaliacoes){
		return new Passageiro(cpf,nome,formaPgto,pontuacaoAcumulada,qtdadeAvaliacoes);
	}

	private Passageiro(String cpf, String nome, FormaPagamento formaPgto, int pontuacaoAcumulada, int qtdadeAvaliacoes) {
		this.cpf = cpf;
		this.nome = nome;
		this.formaPgto = formaPgto;
		this.pontuacaoAcumulada = pontuacaoAcumulada;
		this.qtdadeAvaliacoes = qtdadeAvaliacoes;
	}

	public String getCPF() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public FormaPagamento getFormaPgto() {
		return formaPgto;
	}

	public int getPontuacaoMedia() {
		return pontuacaoAcumulada / qtdadeAvaliacoes;
	}

	public void infoPontuacao(int pontuacao) {
		if (this.validaPontos(pontuacao)) {
			pontuacaoAcumulada += pontuacao;
			qtdadeAvaliacoes++;
		} else {
			throw new IllegalArgumentException("Pontucao invalida !");
		}
	}

	public int getPontuacaoAcumulada() {
		return pontuacaoAcumulada;
	}

	public int getQtdadeAvaliacoes() {
		return qtdadeAvaliacoes;
	}

	@Override
	public String toString() {
		return "Passageiro [cpf=" + cpf + ", formaPgto=" + formaPgto + ", nome=" + nome + 
			   ", pontuacaoAcumulada=" + pontuacaoAcumulada + ", qtdadeAvaliacoes=" + qtdadeAvaliacoes + "]";
	}
}
