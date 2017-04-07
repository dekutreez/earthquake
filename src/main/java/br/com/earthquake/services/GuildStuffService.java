package br.com.earthquake.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.earthquake.dao.GuildStuffDAO;
import br.com.earthquake.domain.GuildStuff;
import br.com.earthquake.enums.TipoStuffEnum;

@Service("rankingStuffService")
public class GuildStuffService {
	
	private GuildStuffDAO guildStuffDAO;

	public GuildStuffDAO getRankingStuffDAO() {
		return guildStuffDAO;
	}

	@Autowired
	public void setRankingStuffDAO(GuildStuffDAO rankingStuffDAO) {
		this.guildStuffDAO = rankingStuffDAO;
	}
	
	public List<GuildStuff> getGuildStuffByTipos(List<TipoStuffEnum> tiposStuff) {
		return this.guildStuffDAO.getGuildStuffByTipo(tiposStuff);
	}

}
