package br.com.earthquake.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.earthquake.dao.AboutDAO;
import br.com.earthquake.domain.About;

@Service("aboutService")
public class AboutService {
	
	private AboutDAO aboutDAO;
	
	public AboutDAO getAboutDAO() {
		return aboutDAO;
	}
	
	@Autowired
	public void setAboutDAO(AboutDAO aboutDAO) {
		this.aboutDAO = aboutDAO;
	}
	
	public void adicionarAbout(About about) {
		getAboutDAO().inserirAbout(about);
	}
	
	public About getAboutByTipo(Integer tipo) {
		return getAboutDAO().getAboutByTipo(tipo);
	}
}
