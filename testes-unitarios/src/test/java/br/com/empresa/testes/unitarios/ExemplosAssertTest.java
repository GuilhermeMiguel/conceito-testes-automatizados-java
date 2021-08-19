package br.com.empresa.testes.unitarios;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;


import org.junit.Test;

import br.com.empresa.testes.unitarios.Funcionario;

public class ExemplosAssertTest {
	
	
	/*
	  	Junit sobrecarrega assertions para tipos primitivos, objetos e arrays
	*/
	
	
	/**
	  	Teste de array de bytes
	*/
	@Test
	public void testAssertArrayEquals() {
		byte[] esperado = "esseTexto".getBytes();
		byte[] atual = "esseTexto".getBytes();
		assertArrayEquals(esperado, atual);
	}

	/**
  		Teste de strings
	*/
	@Test
	public void testAssertEquals() {
		assertEquals("esseTexto", "esseTexto");
	}

	
	@Test
	public void testAssertFalse() {
		assertFalse(false);
	}

	@Test
	public void testAssertNotNull() {
		assertNotNull(new Object());
	}

	@Test
	public void testAssertSame() {
		Integer aNumber = Integer.valueOf(768);
		assertSame(aNumber, aNumber);
	}

	@Test
	public void testAssertNotSame() {
		var func1 = new Funcionario("LeBron", "James", BigDecimal.valueOf(20000.00));
		var func2 = new Funcionario("LeBron", "James", BigDecimal.valueOf(20000.00));
		
//		assertNotSame(func1, func1);
		assertNotSame(func1, func2);
	}

	@Test
	public void testAssertNull() {
		assertNull(null);
	}
	
	
	
	/**
  	
  			AssertJ --> Permite escrever asserts de mais facil compreensao
  		
  		Oferece asserts para N objetos
	*/
	
	@Test
	public void checkEquidade() {
		var func1 = new Funcionario("Michael", "Jordan", BigDecimal.valueOf(1000.00));
		//var func2 = new Funcionario("Michael", "Jordan", BigDecimal.valueOf(1000.00));
	    
		/*
		 		
		 		Mesmo tendo todos valores iguais, são objetos diferentes
		 		
		 */
		
		//assertThat(func1).isEqualTo(func2);
		
		assertThat(func1).isEqualTo(func1);
	}
	
	
	
	

}
