package br.com.earthquake.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.earthquake.domain.Donation;
import br.com.earthquake.domain.Usuario;
import br.com.earthquake.services.UsuarioService;

@Repository
public class DonationDAO {
	
	@Autowired
	private UsuarioService usuarioService;
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Donation> getWeekDonationsByUser(Usuario usuario) {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Donation.class);
		
		List<Donation> donations = (List<Donation>)criteria.add(Restrictions.eq( "usuario", usuario)).list();
		
		session.getTransaction().commit();
		
		return donations;
	}
	
	@SuppressWarnings("unchecked")
	public Map<Usuario, Long> getRankingDonation() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
				
		StringBuilder sb = new StringBuilder();
		sb.append("select u.codusr, sum(d.qtddoa * item.ptsdon) as total ");
		sb.append("from Usuario u ");
		sb.append("inner join doacoes d on d.codusr = u.codusr ");
		sb.append("inner join donate_item item on item.coddon = d.coddon ");
		sb.append("group by u.codusr, u.nomusr");
		
		Query hQuery = session.createSQLQuery(sb.toString());
		List result = hQuery.list();
		session.getTransaction().commit();
		Iterator iterator = result.iterator();

		Map<Usuario, Long> mapaRanking = new HashMap<Usuario, Long>();
		while (iterator.hasNext()) {
		    Object[] row = (Object[])iterator.next();
		    Long codigoUsuario = Long.valueOf(String.valueOf(row[0]));
		    Long pontuacao = Long.valueOf(String.valueOf(row[1]));
		    mapaRanking.put(usuarioService.getUsuarioById(codigoUsuario), pontuacao);
		}
	    
		
		return mapaRanking;
	}
}
