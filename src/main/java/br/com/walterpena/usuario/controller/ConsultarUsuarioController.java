package br.com.walterpena.usuario.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
 
import br.com.walterpena.model.UsuarioModel;
import br.com.walterpena.repository.UsuarioRepository;
 
@Named(value="consultarUsuarioController")
@ViewScoped
public class ConsultarUsuarioController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	private UsuarioModel usuarioModel;
 
	@Produces 
	private List<UsuarioModel> usuarios;
 
	@Inject transient
	private UsuarioRepository usuarioRepository;
 
	public List<UsuarioModel> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<UsuarioModel> usuarios) {
		this.usuarios = usuarios;
	}		
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
 
	/***
	 * CARREGA OS USUÁRIOS NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
 
		//RETORNAR OS USUÁRIOS CADASTRADOS
		this.usuarios = usuarioRepository.GetUsuarios();
	}
	
	/***
	 * CARREGA INFORMAÇÕES PARA SER EDITADA
	 * @param usuarioModel
	 */
	public void Editar(UsuarioModel usuarioModel){
 		
		this.usuarioModel = usuarioModel;
 
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
 
		this.usuarioRepository.AlterarRegistro(this.usuarioModel);	
  
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param usuarioModel
	 */
	public void ExcluirUsuario(UsuarioModel usuarioModel){
 
		//EXCLUI DO BANCO DE DADOS
		this.usuarioRepository.ExcluirRegistro(usuarioModel.getCodigo());
 
		//REMOVENDO DA LISTA ONDE O DATATABLE É ATUALIZADO
		this.usuarios.remove(usuarioModel);
 
	}
 
 
}
