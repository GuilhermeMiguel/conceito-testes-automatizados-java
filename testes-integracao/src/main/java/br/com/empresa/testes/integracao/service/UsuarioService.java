package br.com.empresa.testes.integracao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.testes.integracao.dao.UsuarioDao;
import br.com.empresa.testes.integracao.dto.UsuarioDto;
import br.com.empresa.testes.integracao.exception.UsuarioException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	public UsuarioDto buscarUsuarioPorCredenciais(String nomeUsuario, String senha) {
		
		try{
			
			var usuario = usuarioDao.buscarUsuarioPorCredenciais(nomeUsuario, senha);
			
			return new UsuarioDto(
					usuario.getId(), 
					usuario.getEmail(), 
					usuario.getNome(), 
					usuario.getSenha());
		}
		catch(Exception ex) {
			throw new UsuarioException("Usuario nao encontrado");	
		}
				
	}

	public void removeUsuarioPorCredenciais(String nomeUsuario, String senha) {
		
		var usuario = usuarioDao.buscarUsuarioPorCredenciais(nomeUsuario, senha);
		
		usuarioDao.deletar(usuario);
		
	}

}
