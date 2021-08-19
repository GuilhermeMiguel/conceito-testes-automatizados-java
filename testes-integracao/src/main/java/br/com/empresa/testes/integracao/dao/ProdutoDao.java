package br.com.empresa.testes.integracao.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.empresa.testes.integracao.entity.ProdutoEntity;
import br.com.empresa.testes.integracao.exception.ProdutoException;

@Repository
public class ProdutoDao {

	private EntityManager em;

	@Autowired
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public ProdutoEntity findById(Long idProduto) {
		var produto = em.find(ProdutoEntity.class, idProduto);
		if (produto == null) 
			throw new ProdutoException("Não foi encontrado produto com esse ID: " + idProduto);

		return produto;
	}

	public void deletar(ProdutoEntity produto) {
		em.remove(produto);
	}

}
