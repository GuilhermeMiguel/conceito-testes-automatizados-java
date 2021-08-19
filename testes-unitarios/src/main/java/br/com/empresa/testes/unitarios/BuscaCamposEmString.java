package br.com.empresa.testes.unitarios;

public class BuscaCamposEmString {

	public String[] retornaValorCampo(String mensagemObservacao, String ...campos) {
		String[] valoresCampos = new String[2];
		
		int i = 0;
		
		for(String campo : campos) {
			
			Integer indexChave = mensagemObservacao.indexOf(campo);
							
			if(indexChave != -1) {
				String mensagemCortada = mensagemObservacao.substring(indexChave + campo.length());
				
				 valoresCampos[i] = mensagemCortada.substring(0 , mensagemCortada.indexOf(".")).trim();
			}
			else {
				valoresCampos[i] = null;
			}
			i++;
		}
		
		return valoresCampos;
	}
	
}
