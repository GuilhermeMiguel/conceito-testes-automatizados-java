package br.com.empresa.testes.unitarios;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReajusteSalarioTest {

	private Funcionario funcionario;
	private ReajusteSalarioService reajustaService;


	
	/*
	  		� IMPORTANTE ESCREVERMOS TESTES BEM
	  	
	  		At� mesmo refatorar os nossos testes, para serem faceis de serem entendidos e
	  	
	  	n�o perdermos tempo nos testes
	  	
	*/
	
	
	/*
	 			Junit5 -- @BeforeAll() -- � Chamado antes de todos os metodos 
	*/
	
	@BeforeClass
	public static void primeiroMetodoChamado() {
		System.out.println("Primeiro m�todo chamado");
	}
	
	
	/*
		Junit5 -- @AfterAll() -- � Chamado depois de todos os metodos 
*/

	@AfterClass
	public static void ultimoMetodoChamado() {
		System.out.println("�ltimo m�todo chamado");
	}
	
	
	/**
	  	Iniciando a vari�vel antes de chamar os m�todos
	*/
	
	@Before
	public void inicializarVariaveis() {
		funcionario = new Funcionario("Ronaldo", "Nazario", BigDecimal.valueOf(1000.00));

		reajustaService = new ReajusteSalarioService();
	}

	/**
	 * 
	 * Assert com metodo void
	 * 
	 */

	@Test
	public void checkReajusteDeSalario_ADesejar() {
	
		//inicializarVariaveis();
		
		reajustaService.ReajustaSalario(funcionario, DesempenhoFuncionario.A_DESEJAR);

		assertEquals(BigDecimal.valueOf(1000.00).setScale(2), funcionario.getSalario());

	}
	
	
	@Test
	public void checkReajusteDeSalario_Bom() {

		//inicializarVariaveis();
		
		reajustaService.ReajustaSalario(funcionario, DesempenhoFuncionario.BOM);

		assertEquals(BigDecimal.valueOf(1050.00).setScale(2), funcionario.getSalario());

	}
	
	
	
	@Test
	public void checkReajusteDeSalario_Otimo() {

		//inicializarVariaveis();
		
		reajustaService.ReajustaSalario(funcionario, DesempenhoFuncionario.OTIMO);

		assertEquals(BigDecimal.valueOf(1100.00).setScale(2), funcionario.getSalario());

	}
}
