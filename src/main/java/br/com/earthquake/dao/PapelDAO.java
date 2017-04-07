package br.com.earthquake.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.earthquake.domain.Papel;
import br.com.earthquake.domain.Perfil;
import br.com.earthquake.domain.Usuario;

@Repository
public class PapelDAO {
private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Papel recuperaPapelById(Integer id) {
		return null;
	}
	
	public List<Papel> recuperaPapeisByPerfilInList(List<Perfil> perfis) {
		return null;
	}
	
	public List<Papel> recuperaPapeisByUsuario(Usuario usuario) {
		return null;
	}
	
	public List<Papel> listarPapeis() {
		return null;
	}
}
