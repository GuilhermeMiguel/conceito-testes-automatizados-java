package br.com.empresa.testes.unitarios;

public class Calculadora {

	
	public Integer multiplicar(int ...valores) {
		Integer mult = 1;
		
		for (int valorMult : valores) 
			mult *= valorMult;
		
		return mult;
	}
	
	
	
	public Double dividir(Double num1, Double num2) {
			
		return num1 / num2;
	}
}
