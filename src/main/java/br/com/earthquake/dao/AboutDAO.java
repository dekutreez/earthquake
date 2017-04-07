package br.com.earthquake.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.earthquake.domain.About;

@Repository
public class AboutDAO {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void inserirAbout(About about) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(about);
		session.getTransaction().commit();
	}

	@Transactional
	public About getAboutByTipo(Integer tipo) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(About.class);
		
		About about = (About)criteria.add(Restrictions.eq( "pagina", tipo )).uniqueResult();
		
		session.getTransaction().commit();
		return about;
	}
}