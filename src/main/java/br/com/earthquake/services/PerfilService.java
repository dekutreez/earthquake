package br.com.earthquake.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.earthquake.dao.PerfilDAO;
import br.com.earthquake.domain.Perfil;
import br.com.earthquake.domain.Usuario;

@Service("perfilService")
public class PerfilService {
	
	private PerfilDAO perfilDAO;

	public PerfilDAO getPerfilDAO() {
		return perfilDAO;
	}

	@Autowired
	public void setPerfilDAO(PerfilDAO perfilDAO) {
		this.perfilDAO = perfilDAO;
	}
	
	public Perfil recuperaPerfilById(Long id) {
		return perfilDAO.recuperaPerfilById(id);
	}
	
	public Perfil recuperaPerfilByDescricao(String descricao) {
		return perfilDAO.recuperaPerfilByDescricao(descricao);
	}
	
	public List<Perfil> listarPerfis() {
		return perfilDAO.listarPerfis();
	}
	
	public List<Perfil> recuperaPerfisByUsuario(Usuario usuario) {
		return perfilDAO.recuperaPerfisByUsuario(usuario);
	}
}
