package br.com.walterpena.usuario.controller;

import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.ArrayList;
import java.util.List;

import br.com.walterpena.model.TelefoneModel;
import br.com.walterpena.model.UsuarioModel;
//import br.com.walterpena.repository.TelefoneRepository;
import br.com.walterpena.repository.UsuarioRepository;
import br.com.walterpena.uteis.Uteis;

@Named(value = "cadastrarUsuarioController")
@RequestScoped
public class CadastrarUsuarioController {

	@Inject
	UsuarioModel usuarioModel;
	
	@Inject       
	TelefoneModel telefoneModel;
	
	private List<TelefoneModel> fones;
	
	@Inject
	UsuarioRepository usuarioRepository;	

	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}

	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
	
	@PostConstruct
    public void init() {
		this.fones = new ArrayList<TelefoneModel>();         
    }
	
	public TelefoneModel getTelefoneModel() {
        return this.telefoneModel;
    }
	
	public void setTelefoneModel(TelefoneModel telefoneModel) {
		this.telefoneModel = telefoneModel;
	}
 
    public List<TelefoneModel> getFones() {
        return this.fones;
    }

	/**
	 * SALVA UM NOVO REGISTRO
	 */
	public void SalvarNovoUsuario() {

		this.usuarioModel.setCodigo(usuarioRepository.SalvarNovoRegistro(this.usuarioModel));
		
		//TelefoneRepository telefoneRepository = new TelefoneRepository();
		TelefoneModel telefoneModel = new TelefoneModel();
		telefoneModel.setDdd(81);
		telefoneModel.setNumero("98745-6542");
		telefoneModel.setTipo("Celular");
		telefoneModel.setUsuarioModel(this.usuarioModel);
		
		//telefoneRepository.SalvarNovoRegistro(telefoneModel);

		this.usuarioModel = null;

		Uteis.MensagemInfo("Registro cadastrado com sucesso");

	}
	
	public void createNew() {
	   this.fones.add(this.telefoneModel);
	   this.telefoneModel = null;       
    }
	
	public String reinit() {
		this.telefoneModel = null;         
        return null;
    }
    

}