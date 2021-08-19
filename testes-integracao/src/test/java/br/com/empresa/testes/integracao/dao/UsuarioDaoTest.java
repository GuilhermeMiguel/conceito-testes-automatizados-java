package br.com.empresa.testes.integracao.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.empresa.testes.integracao.entity.UsuarioEntity;
import br.com.empresa.testes.integracao.entity.builder.UsuarioBuilder;
import br.com.empresa.testes.integracao.util.JpaUtil;

public class UsuarioDaoTest {

	/*
	  	É UMA BOA PRATICA UTILIZARMOS BANCO DE DADOS DIFERENTES NOS NOSSOS TESTE, PARA NÃO CORRERMOS O RISCO DE SUJAR OS REGISTROS
	*/
	
	private UsuarioDao dao;
	
	private EntityManager em;
	
	
	//Metodo executado uma vez antes de cada método de testes
	
	@BeforeEach
	public void inicializaAtributos() {
		this.em = JpaUtil.criaEntityManager();
		this.dao = new UsuarioDao(em);
		em.getTransaction().begin();
	}
	
	
	//metodo executado uma vez depois de cada método de testes
	@AfterEach
	public void afterEach() {
		//volta o banco de testes ao estado original
		em.getTransaction().rollback();
	}
	
	@Test
	public void testeDeveriaEncontarUsuarioCadastrado() {
			
		var usuario = criaUsuario();
						
		var UsuarioEncontrado = this.dao.buscarUsuarioPorCredenciais(usuario.getNome(), usuario.getSenha());
		
		Assert.assertNotNull(UsuarioEncontrado);
	}
	
	
	@Test
	public void testeNaoDeveriaEncontarUsuarioCadastrado() {
		
		//O metodo do hibernate que busca o valor, se nao encontrar nada laça uma exception -> NoResultaException
		criaUsuario();
		
		Assert.assertThrows(NoResultException.class, () -> this.dao.buscarUsuarioPorCredenciais("beltranoNaoExiste", "123"));
	}
	
	/*
	  		Esses métodos onde a gente testa somente a funcionalidade da JPA, sem nenhuma lógica nossa, não precisam ser necessáriamente testados
	  	
	  	pois se a conexão com o banco está correta, a JPA vai funcionar
	  	
	*/
	
	@Test
	public void testeDeveriaRemoverUmUsuario() {
		
		/*
		  	Para testar a exclusão primeiramente eu crio um usuário, depois eu deleto, e depois procuro por ele, obviamente ele não pode existir
		*/
		
		var usuario = criaUsuario();
		
		this.dao.deletar(usuario);
		
		Assert.assertThrows(NoResultException.class, () -> this.dao.buscarUsuarioPorCredenciais(usuario.getNome(), usuario.getSenha()));
	}
	
	
	private UsuarioEntity criaUsuario() {
		var usuario = new UsuarioBuilder()
				.comNome("fulano")
				.comSenha("123")
				.comEmail("fulano@email.com")
				.criar();
		
		em.persist(usuario);
		return usuario;
	}

}
