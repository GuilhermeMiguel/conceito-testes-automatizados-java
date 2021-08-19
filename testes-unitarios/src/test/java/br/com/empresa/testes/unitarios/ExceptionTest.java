package br.com.empresa.testes.unitarios;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionTest {

	
	
	/*
	 		----------------------------------------
	 					1� FORMA
	 		----------------------------------------
	 		
	  		O expected nos permite especificar uma excecao que esperamos que seja lancada pelo codigo testado. 
	  	
	  	O teste tera sucesso se a excecao for lancada, caso contraio temos uma falha.
	  	
	  		IMPORTANTE RESSALTAR QUE NAO SAO NECESSARIOS ASSERTS NESSE CASO
	*/
	
	@Test(expected = IndexOutOfBoundsException.class) 
	public void empty() { 
	     List<String> listaVazia = new ArrayList<>();
	     
	     listaVazia.get(0); 
	}
	
	
	
	/*
	  
	  			----------------------------------------
	 					2� FORMA
	 			----------------------------------------
	  
	 
				Caso seja necessario capturar a mensagem da exception, podemos utilizar um bloco try/catch 
		 	Mas utilizado ate a verso 3 do JUnit.
		
		
			+ Assert.fail() -> se o codigo de teste executar essa linha, indica que ele falhou, pois, o teste deveria lancar uma excecao;
		
			+ No catch()  que esperamos que aconteca a execucao do teste. 
			Utiliza-se o assertEquals para verificar se a mensagem da excecao (ex.getMessage()) e a esperada.
	 */
	
	@Test
	public void testExceptionMessage() {
	    try {
	        new ArrayList<Object>().get(0);
	        
	        /*
	          	Se passar pela linha abaixo significa que o teste falhou
	        */
	        
	        fail("Esperado que IndexOutOfBoundsException seja lancada");
	    } catch (IndexOutOfBoundsException ex) {
	    	
	    	/*
	    	 		Como o teste estava esperando que uma excecao fosse lancada
	    	 	
	    	 	caindo dentro do catch quer dizer que deu certo
	    	*/
	    	
	        assertThat(ex.getMessage(), is("Index 0 out of bounds for length 0"));
	    }
	}
	
	
	
	
	
	/*
	  		----------------------------------------
	 					3� FORMA
	 		----------------------------------------
	  	
	  	
	  		Uma ExpectedException � uma rule que nos permite verificar se o nosso c�digo lan�a uma determinada exce�ao.
	*/
	
	@Rule
	public ExpectedException excecaoEsperada = ExpectedException.none();
	
	/*
	  	 	A variavel excecaoEsperada � inicializada com o valor ExpectedException.none(); 
	  	 	
	  	 essa inicializa��o informa que por padr�o nenhuma exce��o � esperada.
	*/

	@Test
	public void shouldTestExceptionMessage() throws IndexOutOfBoundsException {
	    List<Object> listaVazia = new ArrayList<>();
	 
	    //excecaoEsperada.expect() modifica o comportamento padr�o definido anteriormente, informando qual o tipo de exce��o esperamos: IndexOutOfBoundsException;
	    excecaoEsperada.expect(IndexOutOfBoundsException.class);
	    
	    //Mensagem esperada
	    excecaoEsperada.expectMessage("Index 0 out of bounds for length 0");
	    
	    listaVazia.get(0); 
	}
	

	
	
	/*
		----------------------------------------
					4� FORMA
		----------------------------------------
	
	
		assertThrows, passamos a exception e o m�todo chamado.
		
		presente no -> org.junit.jupiter -- <version>5.0.0</version>
	 */
	
	@Test
	public void testAssertThrows() {
		//List<String> listaVazia = new ArrayList<>();
		
//		assertThrows(IndexOutOfBoundsException.class, () -> listaVazia.get(0));
	}
	

}
