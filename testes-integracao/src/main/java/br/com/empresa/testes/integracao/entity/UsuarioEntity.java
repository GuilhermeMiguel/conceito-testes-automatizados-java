package br.com.empresa.testes.integracao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@NotNull
	@NotBlank
	@Column(name = "username")
	private String nome;

	@NotNull
	@NotBlank
	@Column(name = "password")
	private String senha;

	@NotNull
	@NotBlank
	@Email
	private String email;
	
	@Deprecated
	public UsuarioEntity() {
	}
	
	public UsuarioEntity(@NotNull @NotBlank String nome, @NotNull @NotBlank String senha, @NotNull @NotBlank @Email String email) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEntity other = (UsuarioEntity) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
