package br.com.empresa.testes.integracao.entity.builder;

import br.com.empresa.testes.integracao.entity.UsuarioEntity;

public class UsuarioBuilder {

	private String nome;
	private String email;
	private String senha;
	
	public UsuarioBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public UsuarioBuilder comEmail(String email) {
		this.email = email;
		return this;
	}
	
	public UsuarioBuilder comSenha(String senha) {
		this.senha = senha;
		return this;
	}
	
	public UsuarioEntity criar() {
		return new UsuarioEntity(nome, senha, email);
	}
}
