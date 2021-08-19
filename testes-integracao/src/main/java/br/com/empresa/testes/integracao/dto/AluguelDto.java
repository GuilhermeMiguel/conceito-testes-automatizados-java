package br.com.empresa.testes.integracao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AluguelDto {

	private Long idAluguel;
	
	private BigDecimal valor;
	
	private String nomeProduto;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dataInicial;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dataFinal;
	
}
