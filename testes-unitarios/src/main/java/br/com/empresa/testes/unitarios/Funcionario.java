package br.com.empresa.testes.unitarios;

import java.math.BigDecimal;

public class Funcionario {
	
	private String nome;
	private String sobrenome;
	private BigDecimal salario;
	
	public Funcionario(String nome, String sobrenome, BigDecimal salario) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	
	
}
