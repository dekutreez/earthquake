package br.com.earthquake.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.earthquake.dao.UsuarioDAO;
import br.com.earthquake.domain.Papel;
import br.com.earthquake.domain.Perfil;
import br.com.earthquake.domain.Usuario;

@Service("usuarioService")
public class UsuarioService {
	
	private UsuarioDAO usuarioDAO;
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}
	
	@Autowired
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public boolean inserirUsuario(Usuario usuario) {
		return getUsuarioDAO().inserirUsuario(usuario);
	}
	
	public Usuario getUsuarioByUsername(String login) {
		return getUsuarioDAO().getUsuarioByUsername(login);
	}
	
	public Usuario getUsuarioById(Long codigoUsuario) {
		return getUsuarioDAO().getUsuarioById(codigoUsuario);
	}
	
	public List<Usuario> listarUsuarios() {
		return getUsuarioDAO().listarUsuarios();
	}
	
	public List<Usuario> listarUsuariosByPerfilAndPapel(List<Perfil> perfis, List<Papel> papeis) {
		return getUsuarioDAO().listarUsuariosByPerfilAndPapel(perfis, papeis);
	}
}