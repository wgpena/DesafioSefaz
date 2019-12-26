package br.com.walterpena.telefone.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.walterpena.model.TelefoneModel;
import br.com.walterpena.repository.TelefoneRepository;
import br.com.walterpena.uteis.Uteis;

@Named(value = "cadastrarTelefoneController")
@RequestScoped
public class CadastrarTelefoneController {

	@Inject
	TelefoneModel telefoneModel;
	
	@Inject
	TelefoneRepository telefoneRepository;
	
	public TelefoneModel getTelefoneModel() {
		return telefoneModel;
	}

	public void setTelefoneModel(TelefoneModel telefoneModel) {
		this.telefoneModel = telefoneModel;
	}

	/**
	 * SALVA UM NOVO REGISTRO
	 */
	public void SalvarNovoTelefone() {
		
		telefoneRepository.SalvarNovoRegistro(this.telefoneModel);

		this.telefoneModel = null;

		Uteis.MensagemInfo("Registro cadastrado com sucesso");

	}	

}