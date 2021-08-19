package br.com.empresa.testes.integracao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.testes.integracao.dto.UsuarioDto;
import br.com.empresa.testes.integracao.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@Api("Controller que realiza o processo de gerenciamento de usuarios")
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping()
	@ApiOperation(value = "Realiza autenticação do usuário de acordo com as credenciais passadas")
	@ApiImplicitParam(name = "Authorization", paramType = "Header")
	public ResponseEntity<UsuarioDto> buscarUsuarioPorCredenciais(String nomeUsuario, String senha, HttpServletRequest request) {

		var result = usuarioService.buscarUsuarioPorCredenciais(nomeUsuario, senha);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
	@Transactional
	@DeleteMapping("/delete")
	@ApiOperation(value = "Remove o usuario")
	@ApiImplicitParam(name = "Authorization", paramType = "Header")
	public ResponseEntity<UsuarioDto> remove(String nomeUsuario, String senha, HttpServletRequest request) {

		usuarioService.removeUsuarioPorCredenciais(nomeUsuario, senha);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
