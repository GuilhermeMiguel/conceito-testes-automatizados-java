package br.com.empresa.testes.integracao.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Table(name = "aluguel")
@Data
public class AluguelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluguel")
	private Long id;

	@NotNull
	@Column(name = "valor")
	private BigDecimal valor;

	@NotNull
	@Column(name = "data_inicial")
	private LocalDateTime dataInicial;
	
	@NotNull
	@Column(name = "data_final")
	private LocalDateTime dataFinal;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private UsuarioEntity usuario;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private ProdutoEntity produto;
	

	@Deprecated
	public AluguelEntity() {
	}


	public AluguelEntity(BigDecimal valor, LocalDateTime dataInicial, LocalDateTime dataFinal, UsuarioEntity usuario,
			ProdutoEntity produto) {
		this.valor = valor;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.usuario = usuario;
		this.produto = produto;
	}









}
