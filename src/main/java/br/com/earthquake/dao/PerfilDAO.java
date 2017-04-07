package br.com.earthquake.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.earthquake.domain.Perfil;
import br.com.earthquake.domain.Usuario;

@Repository
public class PerfilDAO {
private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Perfil recuperaPerfilById(Long id) {
		return null;
	}
	
	public Perfil recuperaPerfilByDescricao(String descricao) {
		return null;
	}
	
	public List<Perfil> listarPerfis() {
		return null;
	}
	
	public List<Perfil> recuperaPerfisByUsuario(Usuario usuario) {
		return null;
	}
}
