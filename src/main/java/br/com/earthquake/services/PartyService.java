package br.com.earthquake.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.earthquake.dao.PartyDAO;
import br.com.earthquake.domain.Party;

@Service("partyService")
public class PartyService {

	private PartyDAO partyDAO;

	public PartyDAO getPartyDAO() {
		return partyDAO;
	}

	@Autowired
	public void setPartyDAO(PartyDAO partyDAO) {
		this.partyDAO = partyDAO;
	}
	
	public List<Party> getPartys() {
		return partyDAO.getPartys();
	}
	
}
