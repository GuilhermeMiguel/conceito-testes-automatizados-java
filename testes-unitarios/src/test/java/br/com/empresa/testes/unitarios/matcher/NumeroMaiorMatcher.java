package br.com.empresa.testes.unitarios.matcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class NumeroMaiorMatcher extends TypeSafeMatcher<Integer> {

	/*
	 * Posso criar meus mathcers
	 */

	private final Integer anoMaior;

	public NumeroMaiorMatcher(Integer anoMaior) {
		this.anoMaior = anoMaior;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("Verifica se " + anoMaior + " é maior que o ano atual.");
	}

	@Override
	protected boolean matchesSafely(Integer item) {

		return anoMaior > item;
	}

	public static Matcher<Integer> ehAnoMaiorMatcher(Integer ano) {
		return new NumeroMaiorMatcher(ano);
	}

}
