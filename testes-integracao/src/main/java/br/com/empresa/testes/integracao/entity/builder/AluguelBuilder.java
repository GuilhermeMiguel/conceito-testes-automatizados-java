package br.com.empresa.testes.integracao.entity.builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.empresa.testes.integracao.entity.AluguelEntity;
import br.com.empresa.testes.integracao.entity.ProdutoEntity;
import br.com.empresa.testes.integracao.entity.UsuarioEntity;

public class AluguelBuilder {

	/*
	   	PADRAO DATABUILDER PRA CRIAR OBJETOS, MUITO UTILIZADO EM TESTES
	*/
	
	private BigDecimal valor;

	private LocalDateTime dataInicial;
	
	private LocalDateTime dataFinal;
	
	private UsuarioEntity usuario;
	
	private ProdutoEntity produto;
	
	
	public AluguelBuilder comValor(BigDecimal valor) {
		this.valor = valor;
		return this;
	}
	
	public AluguelBuilder comDataInicial(LocalDateTime dataInicial) {
		this.dataInicial = dataInicial;
		return this;
	}
	
	public AluguelBuilder comDataFinal(LocalDateTime dataFinal) {
		this.dataFinal = dataFinal;
		return this;
	}
	
	public AluguelBuilder comUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
		return this;
	}
	
	
	public AluguelBuilder comProduto(ProdutoEntity produto) {
		this.produto = produto;
		return this;
	}
	
	
	public AluguelEntity criar() {
		return new AluguelEntity(valor, dataInicial, dataFinal, usuario, produto);
	}
}



