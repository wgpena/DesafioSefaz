package br.com.walterpena.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
 
@Entity
@Table(name="fones")
@NamedQueries({
	 
	@NamedQuery(name = "TelefoneEntity.findAll",query= "SELECT p FROM TelefoneEntity p")
 
})
public class TelefoneEntity {
 
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer codigo;
 
	@Column(name = "ddd")
	private Integer ddd;
 
	@Column(name = "numero")
	private String  numero;
	
	@Column(name = "tipo")
	private String  tipo;
 	 
	@OneToOne
	@JoinColumn(name="user_id")
	private UsuarioEntity usuarioEntity;
 	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getDdd() {
		return codigo;
	}
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}
	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}
 
}
