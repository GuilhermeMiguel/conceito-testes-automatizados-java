package br.com.empresa.testes.integracao.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.empresa.testes.integracao.entity.UsuarioEntity;
import br.com.empresa.testes.integracao.exception.UsuarioException;

@Repository
public class UsuarioDao {

	/*
	  	
	  		Quando fazemos testes de integração, onde existem chamadas a apis, chamdas ao banco de dados
	  	nós temos grandes chances de tomar uma nullpointerexception, pois esses atibutos como o:
	  	
	  	 private EntityManager em estão sendo instanciados por injeção de dependencia, e nos nossos testes comuns, em aplicações legadas
	  	 
	  	 não temos essa possibilidade de injeção
	  	 
	  	 Atualmente com spring, até existem anotações que fazem essa injeção, mas em aplicações legadas não, então temos que buscar alternativas para tal
	  	 
	  	 
	  	 Obs: esse projeto utiliza spring, mas nesse exemplo, vamos mudar a injeção de dependencia para simular um projeto legado
	  	 
	  	 
	*/
	
	
	
	/*
	  	@PersistenceContext -- retirando essa injeção do spring, vou receber do construtor
	*/
	
	private EntityManager em;
	 
	
	/*
	 		Eu posso utilizar o autowired no construtor, ai o spring injeta quando eu rodar o servidor
	 	 
	 	 e os testes eu passo pro construtor a instancia do EntityManager
	 	 
	 	 
	 	 A classe com constutor fica muito mais fácil de ser testada
	 	 
	*/
	
	@Autowired
	public UsuarioDao(EntityManager em) {
		this.em = em;
	}



	public UsuarioEntity buscarUsuarioPorCredenciais(String nomeUsuario, String senha) {
		return em.createQuery("SELECT u FROM UsuarioModel u WHERE u.nome = :nomeUsuario AND u.senha = :senha", UsuarioEntity.class)
				.setParameter("nomeUsuario", nomeUsuario)
				.setParameter("senha", senha)
				.getSingleResult();
	}

	
	public UsuarioEntity findById(Long idUsuario) {
		var usuario = em.find(UsuarioEntity.class, idUsuario);
		if (usuario == null) 
			throw new UsuarioException("Não foi encontrado usuário com esse ID: " + idUsuario);

		return usuario;
	}


	public void deletar(UsuarioEntity usuario) {
		em.remove(usuario);
	}

}
