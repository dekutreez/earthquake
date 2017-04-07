package br.com.earthquake.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.earthquake.domain.About;
import br.com.earthquake.domain.Intro;

@Repository
public class IntroDAO {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void inserirIntro(Intro intro) {
		// TODO implementar
	}
	
	public List<Intro> recuperarIntros() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Intro.class);
		
		List<Intro> intros = (List<Intro>) criteria.list();
		
		session.getTransaction().commit();
		
		return intros;
	}
}
