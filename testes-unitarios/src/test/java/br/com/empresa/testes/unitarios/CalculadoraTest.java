package br.com.empresa.testes.unitarios;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.empresa.testes.unitarios.Calculadora;

public class CalculadoraTest {

private Calculadora calc;
	
	/*
	  	Before -- Metodo executado uma vez antes de cada metodo de teste
	*/
	
	@Before
	public void instanciaCalculadora() {
		this.calc = new Calculadora(); 	
		System.out.println("==========================================");
		System.out.println("Metodo executado uma vez antes de cada metodo de teste");
	}
	
	
	/*
	  		Utilizamos métodos @After quando nossos testes consomem recursos que precisam ser finalizados. 
	  	Exemplos podem ser testes que acessam banco de dados, abrem arquivos, abrem sockets, e etc.
	*/
	
	@After
	public void finalizaCalculoAtual() {
		System.out.println("------------------ ** ------------------------");
		System.out.println("Método executado após cada metodo de teste");
		System.out.println("------------------ ** ------------------------");
	}
	
	/*
	 
	  Exemplo basico de teste, estou passando 12 como resultado esperado e passo após isso o resultado da minha operação 
	
	*/
	
	@Test
	public void testeMultiplicar() {
		int mult = calc.multiplicar(2, 2, 3);
		System.out.println("Mult: " + mult);
		assertEquals(12, mult);
	}
	
	
	@Test
	public void testeDividir() {
		Double div = calc.dividir(10.0, 5.0);
		System.out.println("Mult: " + div);
		assertEquals(Double.valueOf(2), div);
	}
	
	
	/*
	  	
	  	Mocks basicamente sao valores forcados em testes
	  	
	*/
	
	@Test
	public void testeMultiplicarComMock() {
		
		/*
		  		Estou mockando a classe calculadora
		  	
		  	Para meu código achar que está instanciando ela, mas na verdade não está
		*/
		
		var calculadora = mock(Calculadora.class);
		
		/*
				Quando eu passar 1, 5, 2 -- o mock faz o return ser 15, mesmo que o certo seria 10, pois eu estou definindo que quero 15 
		*/
		
		when(calculadora.multiplicar(1, 5, 2)).thenReturn(15);
		
		/*
		 	Trazendo o resultado mockado
		*/
		
		int resultado = calculadora.multiplicar(1, 5, 2);
		
		System.out.println("Multiplicação com resultado mockado : " + resultado);
		
		/*
			No exemplo abaixo ele vai zerar o retorno, pois eu estou passando algo diferente do que o mock espera
		*/
		
		int resultado2 = calculadora.multiplicar(2, 5);
		
		assertEquals(15, resultado2);
		
		
	}
}
