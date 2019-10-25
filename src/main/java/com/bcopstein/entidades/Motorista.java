package com.bcopstein.entidades;

import java.util.HashSet;
import java.util.Set;

public class Motorista implements Pontuavel{
	private String cpf;
	private String nome;
	private Veiculo veiculo;
	private Set<FormaPagamento> formasPgto;
	private int pontuacaoAcumulada;
	private int qtdadeAvaliacoes;

	public static Motorista novoMotoristaCartao(String cpf, String nome, Veiculo veiculo) {
		Set<FormaPagamento> formasPgto = new HashSet<>();
		formasPgto.add(FormaPagamento.CARTAO);
		return new Motorista(cpf, nome, veiculo, formasPgto, 8, 1);
	}

	public static Motorista novoMotoristaDinDebCredito(String cpf, String nome, Veiculo veiculo, boolean dinheiro,
			boolean debito, boolean credito) {
		Set<FormaPagamento> formasPgto = new HashSet<>();
		if (dinheiro) {
			formasPgto.add(FormaPagamento.DINHEIRO);
		}
		if (debito) {
			formasPgto.add(FormaPagamento.DEBITO);
		}
		if (credito) {
			formasPgto.add(FormaPagamento.CARTAO);
		}
		return new Motorista(cpf, nome, veiculo, formasPgto, 8, 1);
	}

	public static Motorista motoristaExistente(String cpf, String nome, Veiculo veiculo,
			Set<FormaPagamento> formasPgto, int pontuacao, int qtdadeAval) {
		return new Motorista(cpf, nome, veiculo, formasPgto, pontuacao, qtdadeAval);
	}

	private Motorista(String cpf, String nome, Veiculo veiculo, Set<FormaPagamento> formasPgto, int pontuacao,
			int qtdadeAval) {
		this.cpf = cpf;
		this.nome = nome;
		this.veiculo = veiculo;
		this.formasPgto = formasPgto;
		this.pontuacaoAcumulada = pontuacao;
		this.qtdadeAvaliacoes = qtdadeAval;
	}

	public String getCPF() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public Set<FormaPagamento> getFormasPgto() {
		return formasPgto;
	}

	public int getPontuacaoAcumulada() {
		return pontuacaoAcumulada;
	}

	public int getQtdadeAvaliacoes() {
		return qtdadeAvaliacoes;
	}

	public int getPontuacaoMedia() {
		return pontuacaoAcumulada / qtdadeAvaliacoes;
	}

	public void infoPontuacao(int pontuacao) {
		if (this.validaPontos(pontuacao)) {
			pontuacaoAcumulada += pontuacao;
			qtdadeAvaliacoes++;
		} else {
			throw new IllegalArgumentException("Pontuacao invalida ! Deve pertencer ao intervalo: [1;5]");

		}
	}

	@Override
	public String toString() {
		return "Motorista [cpf=" + cpf + ", formaPgto=" + formasPgto + ", nome=" + nome + ", placaVeiculo="
				+ veiculo + ", pontuacaoAcumulada=" + pontuacaoAcumulada + ", qtdadeAvaliacoes=" + qtdadeAvaliacoes
				+ "]";
	}

}
