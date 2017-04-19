package br.com.festonomico.service.impl;

import br.com.festonomico.dao.UsuarioDao;
import br.com.festonomico.dao.impl.UsuarioDaoImpl;
import br.com.festonomico.modelo.Usuario;
import br.com.festonomico.service.UsuarioService;
import org.apache.log4j.Logger;

/**
 * Classe responsável por prover serviços de inclusão, 
 * alteração e exclusão de Usuários e objetos relacionados
 * @author andersonmartins
 *
 */
public class UsuarioServiceImpl implements UsuarioService{

	Logger LOG = Logger.getLogger(UsuarioServiceImpl.class);
	
	private	UsuarioDao dao = new UsuarioDaoImpl();

	@Override
	public int obterIdUsuarioPorEmailNome(String email, String nome) {
		return 0;
	}
	
	/**
	 * Valida se os campos obrigatórios foram preenchidos;
	 * @param email
	 * @param nome
	 * @param senha
	 * @return
	 */
	
	private boolean validarCamposObrigatorios(String email, String nome, String senha) {
		return email != null && !email.equals("")
				&& senha != null && !senha.equals("")
				&& nome != null && !nome.equals("");
	}
	
	public UsuarioDao getDao() {
		return dao;
	}

	public Usuario obterUsuarPorId(int id) {
		Usuario usuario;
		
		usuario = getDao().obterUsuarPorId(id);
		
		
		return usuario;
	}

	public void salvarUsuario(Usuario usuario) {

		validarCamposObrigatorios(usuario.getEmail(), usuario.getNome(), usuario.getSenha());
		
		getDao().salvarUsuario(usuario);
		
	}

	public void excluirUsuario(Usuario usuario) {
		if (usuario.getCodUsuario() == null || usuario.getCodUsuario() <= 0) {
			int codUsuario = obterIdUsuarioPorEmailNome(usuario.getEmail(), usuario.getNome());
			usuario.setCodUsuario(codUsuario);
		}
		
		getDao().editarUsuario(usuario);
	}

	public void editarUsuario(Usuario usuario) {
		boolean camposValidos = validarCamposObrigatorios(usuario.getEmail(), usuario.getNome(), usuario.getSenha());
		if(camposValidos) {
			getDao().editarUsuario(usuario);
		}
	}

}
