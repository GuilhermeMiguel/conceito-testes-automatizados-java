package br.com.empresa.testes.integracao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.testes.integracao.command.AluguelCommand;
import br.com.empresa.testes.integracao.dto.AluguelDto;
import br.com.empresa.testes.integracao.service.AluguelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@Api("Controller que realiza o processo de gerenciamento dos alugueis")
@RequestMapping("/aluguel")
@AllArgsConstructor
public class AluguelController {

	@Autowired
	private AluguelService aluguelService;
	
	@Transactional
	@PostMapping("/novo")
	@ApiOperation(value = "Realiza um aluguel")
	@ApiImplicitParam(name = "Authorization", paramType = "Header")
	public ResponseEntity<AluguelDto> realizaAluguel(@RequestBody AluguelCommand aluguel, HttpServletRequest request) {

		var result = aluguelService.realizaAluguel(aluguel);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/busca")
	@ApiOperation(value = "Busca alugueis com quantidade limite")
	@ApiImplicitParam(name = "Authorization", paramType = "Header")
	public ResponseEntity<List<AluguelDto>> buscaAlugueisComQuantidadeLimite(int quantidadeAlugueis, HttpServletRequest request) {

		var result = aluguelService.buscaAlugueisComQuantidadeLimite(quantidadeAlugueis);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
}
