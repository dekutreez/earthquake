package br.com.earthquake.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.earthquake.domain.Usuario;
import br.com.earthquake.domain.Video;
import br.com.earthquake.services.UsuarioService;
import br.com.earthquake.services.VideoService;

@Controller
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	@Autowired
    private UsuarioService usuarioService;
	
	@RequestMapping("/videos")
	public ModelAndView video(Principal principal) {
		Usuario user = null;
		if(principal != null) {
			String name = principal.getName();
			user = usuarioService.getUsuarioByUsername(name);
		}
		
		//TODO: Enum para o tipo da página (index, about)
		List<Video> videosNew = videoService.carregarVideosGeracao(1);
	    List<Video> videosOld = videoService.carregarVideosGeracao(2);
	    
	    ModelAndView model = new ModelAndView("videos");
	    model.addObject("videosOld",videosOld);
	    model.addObject("videosNew",videosNew);
		model.addObject("usuarioLogado",user);
		return model;
	}
}
