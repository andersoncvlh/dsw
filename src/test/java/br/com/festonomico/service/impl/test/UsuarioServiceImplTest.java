package br.com.festonomico.service.impl.test;

import br.com.festonomico.modelo.Usuario;
import br.com.festonomico.service.UsuarioService;
import br.com.festonomico.service.impl.UsuarioServiceImpl;
import org.junit.Test;

public class UsuarioServiceImplTest {

	private UsuarioService usuarioService;
	
	@Test
	public void salvarUsuarioTest() {
		
		usuarioService = new UsuarioServiceImpl();
		
		Usuario usuario = new Usuario();
		usuario.setNome("test 12.11.15");
		usuario.setEmail("test@Gmail.com");
		usuario.setSenha("123112");
		
		usuarioService.salvarUsuario(usuario);
		
	}
	
}
