package br.com.earthquake.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.earthquake.domain.Video;

@Repository
public class VideoDAO {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean inserirVideo(Video video) {
		return false;
	}
	
	public List<Video> carregarVideos() {
		return null;
	}
	
	public List<Video> carregarVideosGeracao(Integer geracao) {
		Session session = getSessionFactory().getCurrentSession();
		session.getTransaction().begin();

		Criteria criteria = session.createCriteria(Video.class);
		criteria.add(Restrictions.eq("geracao", geracao));
		criteria.addOrder(Order.asc("ano"));
		criteria.addOrder(Order.asc("mes"));
		
		List<Video> videos = (List<Video>)criteria.list();
		session.getTransaction().commit();

		return videos;
	}
	
	public boolean deletarVideo(Video video) {
		return false;
	}
} 
