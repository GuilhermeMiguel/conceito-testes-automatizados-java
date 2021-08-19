package br.com.empresa.testes.unitarios;

public class CalculadoraCalendario {

	public boolean ehAnoBissexto(int ano) {
		
		if (((ano % 4) == 0) && ((ano % 100) != 0)) 
			return true; 
        else if ((ano % 400) == 0) 
        	return true; 
        else 
        	return false; 
	}
}
