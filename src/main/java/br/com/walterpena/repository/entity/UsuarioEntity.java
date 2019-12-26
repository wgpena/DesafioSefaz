package br.com.walterpena.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
 
@Table(name="users")
@Entity
@NamedQueries({	 
	@NamedQuery(name = "UsuarioEntity.findAll",query= "SELECT p FROM UsuarioEntity p"),
	@NamedQuery(
			name = "UsuarioEntity.findUser", 
			query= "SELECT u FROM UsuarioEntity u WHERE u.email = :email AND u.senha = :senha")	
})
public class UsuarioEntity implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer codigo;
	
	@Column(name = "nome")
	private String  nome;
 
	@Column(name="email")
	private String email;
 
	@Column(name="senha")
	private String senha;
 
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
 
}
