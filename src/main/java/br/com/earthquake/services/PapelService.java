package br.com.earthquake.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.earthquake.dao.PapelDAO;
import br.com.earthquake.domain.Papel;
import br.com.earthquake.domain.Perfil;
import br.com.earthquake.domain.Usuario;

@Service("papelService")
public class PapelService {

	private PapelDAO papelDAO;

	public PapelDAO getPapelDAO() {
		return papelDAO;
	}

	@Autowired
	public void setPapelDAO(PapelDAO papelDAO) {
		this.papelDAO = papelDAO;
	}
	
	public Papel recuperaPapelById(Integer id) {
		return papelDAO.recuperaPapelById(id);
	}
	
	public List<Papel> recuperaPapeisByPerfilInList(List<Perfil> perfis) {
		return papelDAO.recuperaPapeisByPerfilInList(perfis);
	}
	
	public List<Papel> recuperaPapeisByUsuario(Usuario usuario) {
		return papelDAO.recuperaPapeisByUsuario(usuario);
	}
	
	public List<Papel> listarPapeis() {
		return papelDAO.listarPapeis();
	}
	
	
}
