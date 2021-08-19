package br.com.empresa.testes.integracao.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Table(name = "produto")
@Data
public class ProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;

	@NotNull
	@Column(name = "valor_diaria")
	private BigDecimal valorDiaria;

	@NotNull
	@NotBlank
	private String nome;
	
	@Deprecated
	public ProdutoEntity() {
	}

	public ProdutoEntity(BigDecimal valorDiaria, @NotBlank String nome) {
		this.valorDiaria = valorDiaria;
		this.nome = nome;
	}


}
