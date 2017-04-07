package br.com.earthquake.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.earthquake.domain.GuildStuff;
import br.com.earthquake.enums.TipoStuffEnum;

@Repository
public class GuildStuffDAO {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<GuildStuff> getGuildStuffByTipo(List<TipoStuffEnum> tiposStuff) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(GuildStuff.class);
		List<GuildStuff> rankingStuff = (List<GuildStuff>)criteria.add(Restrictions.in("tipoStuff", tiposStuff))
																	.addOrder(Order.asc("nome")).list();
		session.getTransaction().commit();
		
		return rankingStuff;
	}
}
