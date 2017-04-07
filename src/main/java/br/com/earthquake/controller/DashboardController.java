package br.com.earthquake.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.earthquake.domain.Usuario;
import br.com.earthquake.enums.TipoStuffEnum;
import br.com.earthquake.services.DonationService;
import br.com.earthquake.services.GuildStuffService;
import br.com.earthquake.services.PartyService;
import br.com.earthquake.services.UsuarioService;

@Controller
public class DashboardController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private DonationService donationService;
	@Autowired
	private GuildStuffService guildStuffService;
	@Autowired
	private PartyService partyService;

	@RequestMapping(value = { "/dashboard**" }, method = RequestMethod.GET)
	public ModelAndView dashboard(Principal principal) {
		Usuario user = null;
		if(principal != null) {
			String name = principal.getName();
			user = usuarioService.getUsuarioByUsername(name);
		}
		
		List<TipoStuffEnum> tipoStuffsConsumiveisEtc = Arrays.asList(TipoStuffEnum.ITEM, TipoStuffEnum.ETC);
		List<TipoStuffEnum> tipoStuffsGears = Arrays.asList(TipoStuffEnum.GEAR);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("dashboard");
		model.addObject("donations", donationService.getWeekDonationsByUser(user));
		model.addObject("guildConsumiveisEtc", guildStuffService.getGuildStuffByTipos(tipoStuffsConsumiveisEtc));
		model.addObject("guildGears", guildStuffService.getGuildStuffByTipos(tipoStuffsGears));
		model.addObject("donationsRank", donationService.getRankingDonation());

		model.addObject("user", user);
		return model;
	}
	
	@RequestMapping(value = { "/dashboard/partys" }, method = RequestMethod.GET)
	public ModelAndView dashboardPartys(Principal principal) {
		Usuario user = null;
		if(principal != null) {
			String name = principal.getName();
			user = usuarioService.getUsuarioByUsername(name);
		}
		
		
		
		ModelAndView model = new ModelAndView();
		model.setViewName("dashboard/partys");
		model.addObject("partys", partyService.getPartys());
		model.addObject("user", user);
		return model;

	}
}
