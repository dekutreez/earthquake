package br.com.earthquake.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.earthquake.domain.Papel;
import br.com.earthquake.domain.Perfil;
import br.com.earthquake.domain.Usuario;


@Repository
public class UsuarioDAO {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean inserirUsuario(Usuario usuario) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(usuario);
		session.getTransaction().commit();
		return true;
	}
	
	public Usuario getUsuarioByUsername(String login) {
		if(login == null) return null;
		
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Usuario.class);
		Usuario usuarioLogado = (Usuario)criteria.add(Restrictions.eq("login", login)).uniqueResult();
		session.getTransaction().commit();
		
		return usuarioLogado;
	}
	
	public Usuario getUsuarioById(Long codigoUsuario) {
		if(codigoUsuario == null) return null;
		
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Usuario.class);
		Usuario usuarioLogado = (Usuario)criteria.add(Restrictions.eq("id", codigoUsuario)).uniqueResult();
		session.getTransaction().commit();
		
		return usuarioLogado;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Usuario.class);
		List<Usuario> usuarios = (List<Usuario>) criteria.list();
		session.getTransaction().commit();
		
		return usuarios;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuariosByPerfilAndPapel(List<Perfil> perfis, List<Papel> papeis) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Usuario.class);
		List<Usuario> usuarios = (List<Usuario>) criteria.add(Restrictions.in("perfis", perfis)).list();
		session.getTransaction().commit();
		
		return usuarios;
	}
}
