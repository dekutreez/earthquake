package br.com.earthquake.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.earthquake.dao.DonationDAO;
import br.com.earthquake.domain.Donation;
import br.com.earthquake.domain.Usuario;

@Service("donationService")
public class DonationService {

	private DonationDAO donationDAO;

	public DonationDAO getDonationDAO() {
		return donationDAO;
	}

	@Autowired
	public void setDonationDAO(DonationDAO donationDAO) {
		this.donationDAO = donationDAO;
	}
	
	public List<Donation> getWeekDonationsByUser(Usuario usuario) {
		return donationDAO.getWeekDonationsByUser(usuario);
	}
	
	public Map<Usuario, Long> getRankingDonation() {
		return donationDAO.getRankingDonation();
	}
	
}
