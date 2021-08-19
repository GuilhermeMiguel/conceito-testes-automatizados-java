package br.com.empresa.testes.integracao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

	private Long id;
	
	private String email;
	
	private String nomeUsuario;
	
	private String senha;
	
}
