package hasa.hafia.controlleur;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import hasa.hafia.dao.IUsers;
import hasa.hafia.entites.Roles;
import hasa.hafia.entites.Users;

@Controller
public class UserControlleur {
	@Autowired
	private IUsers userdao;
	
	@RequestMapping(value = "/Users/add", method = { RequestMethod.GET, RequestMethod.POST })	
	public String add(String nom,String prenom, String email,String password,String etat,List<Roles> roles) 
	{
		Users users = new Users();
		
		users.setNom(nom);
		users.setPrenom(prenom);
		users.setEmail(email);
		users.setPassword(password);
		users.setEtat(etat);
		users.setRoles(roles);
		try {
			userdao.save(users);
			userdao.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/Users/inscription";
			
	}

	@RequestMapping(value = "/User/inscription")
	public String inscription() {
	
	    return "users/inscription";
	}
}
