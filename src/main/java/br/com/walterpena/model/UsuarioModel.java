package br.com.walterpena.model;

import java.io.Serializable;
import java.util.List;

public class UsuarioModel implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private Integer codigo;
	private String nome;
	private String email;
	private String senha;
	private List<TelefoneModel> telefoneModel;
 
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
	public List<TelefoneModel> getTelefoneModel() {
		return telefoneModel;
	}
	public void setTelefoneModel(List<TelefoneModel> telefoneModel) {
		this.telefoneModel = telefoneModel;
	}
 
}
