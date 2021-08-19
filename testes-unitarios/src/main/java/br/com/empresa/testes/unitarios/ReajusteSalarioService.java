package br.com.empresa.testes.unitarios;

public class ReajusteSalarioService {

	
	public void ReajustaSalario(Funcionario funcionario, DesempenhoFuncionario desempenho) {
		
		var porcentagem = desempenho.getPorcentagemDeReajuste();
		
		var salarioAjustado = funcionario.getSalario().add(funcionario.getSalario().multiply(porcentagem));
		
		funcionario.setSalario(salarioAjustado.setScale(2));
	}
}
