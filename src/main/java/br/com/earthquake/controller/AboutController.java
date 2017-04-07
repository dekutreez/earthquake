package br.com.earthquake.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.earthquake.dao.AboutDAO;
import br.com.earthquake.domain.Papel;
import br.com.earthquake.domain.Perfil;
import br.com.earthquake.domain.Usuario;
import br.com.earthquake.services.AboutService;
import br.com.earthquake.services.PapelService;
import br.com.earthquake.services.PerfilService;
import br.com.earthquake.services.UsuarioService;

@Controller
public class AboutController {
	
	@Autowired
    private AboutService aboutService;
	@Autowired
    private UsuarioService usuarioService;
	@Autowired
	private PerfilService perfilService;
	@Autowired
	private PapelService papelService;
	
	@Autowired
	private AboutDAO aboutDAO;
	
	
	@RequestMapping("/about")
	public ModelAndView about(Principal principal) {
		//TODO: Enum para o tipo da página (index, about)
		Usuario user = null;
		if(principal != null) {
			String name = principal.getName();
			user = usuarioService.getUsuarioByUsername(name);
		}
		
//		List<Perfil> perfis = new ArrayList<Perfil>();
//		List<Papel> papeis = new ArrayList<Papel>();
//		perfis.add(perfilService.recuperaPerfilByDescricao("ROLE_ADMIN"));
//		papeis.addAll(papelService.recuperaPapeisByPerfilInList(perfis));
		
//		usuarioService.listarUsuariosByPerfilAndPapel(perfis, papeis);
		
	    ModelAndView model = new ModelAndView("about");
	    model.addObject("about",aboutService.getAboutByTipo(1));
		model.addObject("usuarioLogado",user);
		return model;
	}
}