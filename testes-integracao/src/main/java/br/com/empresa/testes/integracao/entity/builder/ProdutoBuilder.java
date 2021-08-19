package br.com.empresa.testes.integracao.entity.builder;

import java.math.BigDecimal;

import br.com.empresa.testes.integracao.entity.ProdutoEntity;

public class ProdutoBuilder {

	private BigDecimal valorDiaria;

	private String nome;
	
	
	public ProdutoBuilder comValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
		return this;
	}
	
	public ProdutoBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public ProdutoEntity criar() {
		return new ProdutoEntity(valorDiaria, nome);
	}
}



