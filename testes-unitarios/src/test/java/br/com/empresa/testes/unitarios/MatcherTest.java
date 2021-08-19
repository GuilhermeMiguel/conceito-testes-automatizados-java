package br.com.empresa.testes.unitarios;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hamcrest.Matchers;
import org.hamcrest.beans.HasProperty;
import org.hamcrest.object.HasToString;
import org.junit.Test;

import br.com.empresa.testes.unitarios.CalculadoraCalendario;
import br.com.empresa.testes.unitarios.Funcionario;
import br.com.empresa.testes.unitarios.matcher.NumeroMaiorMatcher;



public class MatcherTest {

	 /*
  	
  		O hamcrest faz testes com expressoes mais legiveis, ele nos proporciona Matchers que fazem testes em objetos 
  	
  			Um exemplo bem simples de melhora na escrita:
  			
	  */
	
	
	@Test
	public void ehAnoBissexto() {
		var ehAnoBis = new CalculadoraCalendario();
		
		boolean isBissexto = ehAnoBis.ehAnoBissexto(LocalDate.now().getYear());
		
		//Modo Normal de escrita
		assertEquals(isBissexto, false);
		
		
		assertFalse(isBissexto);
		
		//Com Hamcrest 
		assertThat(isBissexto, is(isBissexto));

		assertThat(isBissexto, equalTo(isBissexto));
	}
	
	
	/*
	  		UTILIZANDO O MEU MATCHER
	  	Se o numero passado é maior que o numero do ano atual
	*/
	
	@Test
	public void utilizaMeuMatcher() {
		Integer primeiroAno = LocalDate.now().getYear();
		
		//numero gerado entre 2000 e 2100
		Integer anoGerado = new Random().nextInt(101) + 2000;
		
		assertThat(primeiroAno, NumeroMaiorMatcher.ehAnoMaiorMatcher(anoGerado));
	}
	
	
	
	/**
	  	Verifica se a classe possui o toString daquela forma
	*/
	@Test
	public void verificaToString(){
	    var func = new Funcionario("Pedro", "Pedra", BigDecimal.valueOf(1000.00));
	    String funcStr = func.toString();
	    
	   
	    
	    assertThat(func, HasToString.hasToString(funcStr));
	}
	
	@Test
	public void verificaExistenciaDePropriedade() {
	    assertThat(Funcionario.class, HasProperty.hasProperty("name"));
	}
	
	
	@Test
	public void verificaSeObjetoEstaVazio() {
	    List<String> emptyList = new ArrayList<>();
	    assertThat(emptyList, Matchers.empty());
	}
	
	@Test
	public void verificaSeEhMaior() {
	    assertThat(1, Matchers.greaterThan(0));
	}
	
	@Test
	public void verificacoesComString() {
	    String str = null;
	    assertThat(str, Matchers.isEmptyOrNullString());
	}
}
