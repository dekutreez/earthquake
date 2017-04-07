package br.com.earthquake.controller;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.earthquake.domain.Usuario;
import br.com.earthquake.enums.JobEnum;
import br.com.earthquake.enums.PalleteEnum;
import br.com.earthquake.services.AboutService;
import br.com.earthquake.services.IntroService;
import br.com.earthquake.services.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private AboutService aboutService;
	@Autowired
	private IntroService introService;	
	
	@RequestMapping(value = { "/", "/index**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage(Principal principal) {
		Usuario user = null;
		if(principal != null) {
			String name = principal.getName();
			user = usuarioService.getUsuarioByUsername(name);
		}
		
		ModelAndView model = new ModelAndView();
		model.addObject("intros", introService.recuperarIntros());
		model.addObject("usuarioLogado",user);
		model.setViewName("index");
		return model;

	}

	@RequestMapping(value = "/login**", method = RequestMethod.GET)
	public ModelAndView memberPage(Principal principal) {
		Usuario user = null;
		if(principal != null) {
			String name = principal.getName();
			user = usuarioService.getUsuarioByUsername(name);
		}
		
		ModelAndView model = new ModelAndView();
		model.addObject("usuarioLogado",user);
		model.setViewName("login");
		return model;

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	        SecurityContextHolder.clearContext();
	        HttpSession session= request.getSession(false);
	        session= request.getSession(false);
	        if(session != null) {
	            session.invalidate();
	        }
	        for(Cookie cookie : request.getCookies()) {
	        	if(cookie.getName().equals("JSESSIONID") || cookie.getName().equals("JSESSIONIDEQ"))
	        		cookie.setMaxAge(0);
	        }
	    }
	    
		return new ModelAndView("redirect:/login?logout");
	}
	
	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView("../templates/cadastrar/signup");
		mv.addObject("jobs", JobEnum.values());
		mv.addObject("palletes", PalleteEnum.values());
		mv.addObject("color", "yellow");
		return mv;
	}
	
	@RequestMapping("/changeColor")
	public ModelAndView changeColor(Integer colorCode) {
		ModelAndView model = new ModelAndView("../templates/cadastrar/sprite");
		model.addObject("jobs", JobEnum.values());
		model.addObject("palletes", PalleteEnum.values());
		model.addObject("color", PalleteEnum.fromInt(colorCode).getDescricao());
		return model;
	}
	
	@RequestMapping("/cadastrar")
	public ModelAndView cadastrar(Usuario usuario, Integer codigoJob, Integer pallete, Integer head) {
		if(codigoJob != null) usuario.setJob(JobEnum.fromInt(codigoJob));
		if(pallete != null) usuario.setPalleteEnum(PalleteEnum.fromInt(pallete));
		if(head != null) usuario.setCodigoCharacter(++head);
		
		ModelAndView model = new ModelAndView("login");
		if(usuarioService.inserirUsuario(usuario)) {
			model.addObject("msgSuccess","Usuário registrado com sucesso!");
		} else {
			model.addObject("msgError", "Usuário já cadastrado, clique em 'Esqueceu a senha?' para recuperar sua senha.");
		}
		
		return new ModelAndView("redirect:/login");
	}
}