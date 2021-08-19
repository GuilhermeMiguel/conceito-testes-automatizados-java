package br.com.empresa.testes.integracao.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.testes.integracao.command.AluguelCommand;
import br.com.empresa.testes.integracao.dao.AluguelDao;
import br.com.empresa.testes.integracao.dao.ProdutoDao;
import br.com.empresa.testes.integracao.dao.UsuarioDao;
import br.com.empresa.testes.integracao.dto.AluguelDto;
import br.com.empresa.testes.integracao.entity.AluguelEntity;
import br.com.empresa.testes.integracao.exception.AluguelException;

@Service
public class AluguelService {

	private ProdutoDao produtoDao;

	private UsuarioDao usuarioDao;
	
	private AluguelDao aluguelDao;
	
	@Autowired
	public AluguelService(ProdutoDao produtoDao, UsuarioDao usuarioDao, AluguelDao aluguelDao) {
		this.produtoDao = produtoDao;
		this.usuarioDao = usuarioDao;
		this.aluguelDao = aluguelDao;
	}

	public AluguelDto realizaAluguel(AluguelCommand aluguel) {
		
		verificarDisponibilidade(aluguel);
		
		var usuario = usuarioDao.findById(aluguel.getIdUsuario());

		var produto = produtoDao.findById(aluguel.getIdProduto());
		
		var valor = calculaValorAluguel(aluguel, produto.getValorDiaria());

		var novoAluguel = new AluguelEntity(valor, aluguel.getDataInicial(), aluguel.getDataFinal(), usuario, produto);
		
		novoAluguel = aluguelDao.novoAluguel(novoAluguel);
		
		return new AluguelDto(novoAluguel.getId(), valor, produto.getNome(), aluguel.getDataInicial(), aluguel.getDataFinal());
		
	}

	private void verificarDisponibilidade(AluguelCommand aluguel) {
		try {
			var dataInicial = aluguel.getDataInicial();

			var dataFinal = aluguel.getDataFinal();
			
			var dataAtual = LocalDateTime.now();

			if (dataFinal.isBefore(dataInicial) || dataInicial.isEqual(dataFinal) || dataInicial.isBefore(dataAtual))
				throw new AluguelException("Datas inválidas!");
			
			var resultadoPesquisa = aluguelDao.buscaAluguelPorProdutoAndDatas(aluguel);
			
			if(resultadoPesquisa != null && resultadoPesquisa.size() > 0)
				throw new AluguelException("Produto indisponível no momento!");
			
		} catch (NoResultException ex) {
			ex.printStackTrace();
		}

	}
	
	
	private BigDecimal calculaValorAluguel(AluguelCommand aluguel, BigDecimal valorDiaria) {

		var quantidadeDias = ChronoUnit.DAYS.between(aluguel.getDataInicial(), aluguel.getDataFinal());

		var valorFinal = valorDiaria.multiply(BigDecimal.valueOf(quantidadeDias));

		return valorFinal;
	}

	public List<AluguelDto> buscaAlugueisComQuantidadeLimite(int quantidadeAlugueis) {
		var resultadoComLimite = aluguelDao.buscaAlugueisComQuantidadeLimite(quantidadeAlugueis);
				
		List<AluguelDto> alugueis = new ArrayList<>();
		
		resultadoComLimite.forEach( x-> 
		{
			alugueis.add(new AluguelDto(x.getId(), x.getValor(), x.getProduto().getNome(), x.getDataInicial(), x.getDataFinal()));
		});
		
		
		return alugueis;
	}
	
	

}
