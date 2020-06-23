package hasa.hafia.controlleur;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hasa.hafia.dao.IUsers;
import hasa.hafia.entites.Roles;
import hasa.hafia.entites.Users;

@Controller
@RequestMapping("/login")
public class LoginControlleur {
	@Autowired private IUsers service;
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Users user = service.getUserByEmail(username);
		
		System.out.println("***************************************************");
		
		user.getRoles().forEach(r -> System.out.println(r.getNom()));
		System.out.println("***************************************************");

		
		Roles role = user.getRoles().stream().findFirst().orElseThrow(() -> new RuntimeException("something"));
		
		if(role.getNom().equalsIgnoreCase("role_demandeur")) {
			
			return new ModelAndView("candidature/ajoutCandidature");
		}
		
		if(role.getNom().equalsIgnoreCase("role_recruteur")) {
			
			return new ModelAndView("offres/ajoutOffres");
		}
		return new ModelAndView("403");
		
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String login() {
		
		return "login";
	}
}
