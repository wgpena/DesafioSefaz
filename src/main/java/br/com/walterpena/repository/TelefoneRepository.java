package br.com.walterpena.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import br.com.walterpena.model.TelefoneModel;
import br.com.walterpena.model.UsuarioModel;
import br.com.walterpena.repository.entity.TelefoneEntity;
import br.com.walterpena.repository.entity.UsuarioEntity;
import br.com.walterpena.uteis.Uteis;
 
public class TelefoneRepository {
 
	@Inject
	TelefoneEntity telefoneEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UM NOVO TELEFONE
	 * @param telefoneModel
	 */
	public void SalvarNovoRegistro(TelefoneModel telefoneModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		telefoneEntity = new TelefoneEntity();
		telefoneEntity.setDdd(telefoneModel.getDdd());
		telefoneEntity.setNumero(telefoneModel.getNumero());
		telefoneEntity.setTipo(telefoneModel.getTipo());		
 
		UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, telefoneModel.getUsuarioModel().getCodigo()); 
 
		telefoneEntity.setUsuarioEntity(usuarioEntity);
 
		entityManager.persist(telefoneEntity);
 
	}
	
	/***
	 * MÉTODO PARA CONSULTAR TELEFONE
	 * @return
	 */
	public List<TelefoneModel> GetFones(){
 
		List<TelefoneModel> fonesModel = new ArrayList<TelefoneModel>();
 
		entityManager =  Uteis.JpaEntityManager();
 
		Query query = entityManager.createNamedQuery("PessoaEntity.findAll");
 
		@SuppressWarnings("unchecked")
		Collection<TelefoneEntity> fonesEntity = (Collection<TelefoneEntity>)query.getResultList();
 
		TelefoneModel telefoneModel = null;
 
		for (TelefoneEntity telefoneEntity : fonesEntity) {
 
			telefoneModel = new TelefoneModel();
			telefoneModel.setCodigo(telefoneEntity.getCodigo());
			telefoneModel.setDdd(telefoneEntity.getDdd());
			telefoneModel.setNumero(telefoneEntity.getNumero());
			telefoneModel.setTipo(telefoneEntity.getTipo());
						 
			UsuarioEntity usuarioEntity =  telefoneEntity.getUsuarioEntity();			
 
			UsuarioModel usuarioModel = new UsuarioModel();
			usuarioModel.setEmail(usuarioEntity.getEmail());
 
			telefoneModel.setUsuarioModel(usuarioModel);
 
			fonesModel.add(telefoneModel);
		}
 
		return fonesModel;
 
	}
	
	/***
	 * CONSULTA UM TELEFONE CADASTRADO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	private TelefoneEntity GetTelefone(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();
 
		return entityManager.find(TelefoneEntity.class, codigo);
	}
 
	/***
	 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
	 * @param telefoneModel
	 */
	public void AlterarRegistro(TelefoneModel telefoneModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		TelefoneEntity telefoneEntity = this.GetTelefone(telefoneModel.getCodigo());
 
		telefoneEntity.setDdd(telefoneModel.getDdd());
		telefoneEntity.setNumero(telefoneModel.getNumero());
		telefoneEntity.setTipo(telefoneModel.getTipo());		
 
		entityManager.merge(telefoneEntity);
	}
	
	/***
	 * EXCLUI UM REGISTRO DO BANCO DE DADOS
	 * @param codigo
	 */
	public void ExcluirRegistro(int codigo){
 
		entityManager =  Uteis.JpaEntityManager();		
 
		TelefoneEntity telefoneEntity = this.GetTelefone(codigo);
 
		entityManager.remove(telefoneEntity);
	}
}