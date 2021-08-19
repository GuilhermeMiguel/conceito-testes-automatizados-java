package br.com.empresa.testes.integracao.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.empresa.testes.integracao.command.AluguelCommand;
import br.com.empresa.testes.integracao.entity.AluguelEntity;
import br.com.empresa.testes.integracao.entity.UsuarioEntity;

@Repository
public class AluguelDao {

	private EntityManager em;
	 
	
	@Autowired
	public AluguelDao(EntityManager em) {
		this.em = em;
	}


	public AluguelEntity novoAluguel(AluguelEntity aluguel) {
		return em.merge(aluguel);
	}

	public void deletar(UsuarioEntity usuario) {
		em.remove(usuario);
	}


	public List<AluguelEntity> buscaAluguelPorProdutoAndDatas(AluguelCommand aluguel) {
		StringBuilder query = new StringBuilder();
		
		query.append(" SELECT t1 FROM AluguelEntity t1 ");
		query.append(" join t1.produto t2 ");
		query.append(" WHERE t2.id = :idProduto AND ");
		query.append(" t1.dataInicial >= :dataInicial and t1.dataFinal <= :dataFinal ");
		
		
		return em.createQuery(query.toString(), AluguelEntity.class)
				.setParameter("idProduto", aluguel.getIdProduto())
				.setParameter("dataInicial", aluguel.getDataInicial())
				.setParameter("dataFinal", aluguel.getDataFinal())
				.getResultList();
	}


	public List<AluguelEntity>  buscaAlugueisComQuantidadeLimite(int quantidadeAlugueis) {
		return em.createQuery("SELECT u FROM AluguelEntity u", AluguelEntity.class)
				.setMaxResults(quantidadeAlugueis)
				.getResultList();
	}

}
