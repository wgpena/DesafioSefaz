package br.com.walterpena.telefone.controller;

import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
 
import br.com.walterpena.model.TelefoneModel;
import br.com.walterpena.repository.TelefoneRepository;
 
@Named(value="ConsultarTelefoneController")
@ViewScoped
public class ConsultarTelefoneController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	private TelefoneModel telefoneModel;
 
	@Produces 
	private List<TelefoneModel> fones;
 
	@Inject transient
	private TelefoneRepository telefoneRepository;
 
	public List<TelefoneModel> getFones() {
		return fones;
	}
	public void setFones(List<TelefoneModel> fones) {
		this.fones = fones;
	}		
	public TelefoneModel getTelefoneModel() {
		return telefoneModel;
	}
	public void setTelefoneModel(TelefoneModel telefoneModel) {
		this.telefoneModel = telefoneModel;
	}
 
	/***
	 * CARREGA OS FONES NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
 
		//RETORNAR OS TELEFONES CADASTRADAS
		this.fones = telefoneRepository.GetFones();
	}
	
	/***
	 * CARREGA INFORMAÇÕES PARA SER EDITADA
	 * @param telefoneModel
	 */
	public void Editar(TelefoneModel telefoneModel){
 
		this.telefoneModel = telefoneModel;
 
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 */
	public void AlterarRegistro(){
 
		this.telefoneRepository.AlterarRegistro(this.telefoneModel);	
  
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param telefoneModel
	 */
	public void ExcluirTelefone(TelefoneModel telefoneModel){
 
		//EXCLUI DO BANCO DE DADOS
		this.telefoneRepository.ExcluirRegistro(telefoneModel.getCodigo());
 
		//REMOVENDO o TELEFONE DA LISTA E O DATATABLE É ATUALIZADO
		this.fones.remove(telefoneModel);
 
	}
 
 
}
