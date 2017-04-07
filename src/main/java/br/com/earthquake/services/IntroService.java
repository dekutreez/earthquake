package br.com.earthquake.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.earthquake.dao.IntroDAO;
import br.com.earthquake.domain.Intro;

@Service("introService")
public class IntroService {
	
	private IntroDAO introDAO;

	public IntroDAO getIntroDAO() {
		return introDAO;
	}

	@Autowired
	public void setIntroDAO(IntroDAO introDAO) {
		this.introDAO = introDAO;
	}
	
	public List<Intro> recuperarIntros() {
		return introDAO.recuperarIntros();
	}
	
}
