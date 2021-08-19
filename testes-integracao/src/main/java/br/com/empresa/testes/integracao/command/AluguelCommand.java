package br.com.empresa.testes.integracao.command;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AluguelCommand {

	@NotNull
	@NotBlank
	private Long idProduto;

	@NotNull
	@NotBlank
	private Long idUsuario;

	
	@NotNull
	@NotBlank
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dataInicial;
	
	@NotNull
	@NotBlank
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dataFinal;
	
}
