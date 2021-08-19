package br.com.empresa.testes.integracao.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.empresa.testes.integracao.command.AluguelCommand;
import br.com.empresa.testes.integracao.dao.AluguelDao;
import br.com.empresa.testes.integracao.dao.ProdutoDao;
import br.com.empresa.testes.integracao.dao.UsuarioDao;
import br.com.empresa.testes.integracao.entity.ProdutoEntity;
import br.com.empresa.testes.integracao.entity.UsuarioEntity;
import br.com.empresa.testes.integracao.entity.builder.ProdutoBuilder;
import br.com.empresa.testes.integracao.entity.builder.UsuarioBuilder;
import br.com.empresa.testes.integracao.util.JpaUtil;

public class AluguelServiceTest {


	/*
	  	É UMA BOA PRATICA UTILIZARMOS BANCO DE DADOS DIFERENTES NOS NOSSOS TESTE, PARA NÃO CORRERMOS O RISCO DE SUJAR OS REGISTROS
	*/
	
	private UsuarioDao usuarioDao;
	
	private ProdutoDao produtoDao;
	
	private AluguelDao aluguelDao;
	
	private AluguelService aluguelService;
	
	private EntityManager em;
	
	@BeforeEach
	public void inicializaAtributos() {
		this.em = JpaUtil.criaEntityManager();
	
		this.usuarioDao = new UsuarioDao(em);
		
		this.produtoDao = new ProdutoDao(em);
		
		this.aluguelDao = new AluguelDao(em);
		
		this.aluguelService = new AluguelService(produtoDao, usuarioDao, aluguelDao);
		
		em.getTransaction().begin();
	}
	
	
	@AfterEach
	public void afterEach() {
		em.getTransaction().rollback();
	}
	
	@Test
	public void testeDeveriaCadastrarUmAluguel() {
			
		var usuario = criaUsuario();
		
		var produto = criaProduto();
		
		var dataInicio = LocalDateTime.now().plusDays(1);
		var dataFinal = dataInicio.plusDays(3);
		
		
		var aluguel = new AluguelCommand(produto.getId(), usuario.getId(), dataInicio, dataFinal);
		
		var novoAluguel = aluguelService.realizaAluguel(aluguel);
		
		Assert.assertNotNull(novoAluguel);
	}
	
	
	private ProdutoEntity criaProduto() {
		var produto = new ProdutoBuilder()
				.comNome("Voyage 1.6")
				.comValorDiaria(new BigDecimal("120"))
				.criar();
		
		return em.merge(produto);
	}
	
	private UsuarioEntity criaUsuario() {
		var usuario = new UsuarioBuilder()
				.comNome("fulano")
				.comSenha("123")
				.comEmail("fulano@email.com")
				.criar();
		
		
		return em.merge(usuario);
	}
	
}
