package hasa.hafia.controlleur;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import hasa.hafia.dao.ICandidat;
import hasa.hafia.entites.Candidat;
import hasa.hafia.entites.MyUploadForm;


@Controller
public class CandidatControlleur {
	

	@Autowired
	private ICandidat candidatdao;
	//recuperation de la liste au niveau de le db
	
	@RequestMapping(value="/Candidat/liste")
	public String liste(ModelMap model)
	{	
		List<Candidat> candidat=candidatdao.findAll();
		
		model.put("liste_candidats",candidat);
		model.put("candidat",new Candidat());
		System.out.println("Je teste l'ajout sur la liste");
		
		return "candidature/liste";
	}
@RequestMapping(value = "/Candidat/add", method = { RequestMethod.GET, RequestMethod.POST })
	
	public String add(int id,String nom, String prenom,String experience,String Disponibilite,Date date,String niveauEtude,String motivation) 
	{
	
	
		Candidat candidat=new Candidat();
		candidat.setId(id);
		candidat.setNom(nom);
		candidat.setPrenom(prenom);
		candidat.setExperience(Integer.parseInt(experience));
		candidat.setDisponibilite(Disponibilite);
		candidat.setMotivation(motivation);
		candidat.setNiveauEtude(niveauEtude);
		
candidat.setDate(date);
		System.out.println("======================================================");
		System.out.println(Integer.parseInt(experience)+""+Disponibilite+""+date+""+motivation+"");
		System.out.println("======================================================");

		
		
		try {
			candidatdao.save(candidat);//ajout ou mise à jour
			candidatdao.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "candidature/liste";
		
	}

@RequestMapping(value="/Candidat/edit",method = RequestMethod.GET)
public String edit (int id,ModelMap model)
{
	try {
		List<Candidat> candidats = candidatdao.findAll();
		model.put("liste_candidats", candidats);
		Candidat candidat=  candidatdao.getOne(id);
		model.put("candidat", candidat);
	} 
	catch (Exception e) {
		e.printStackTrace();
	}		
	return "candidature/liste";
}


@RequestMapping(value="/Candidat/delete",method = RequestMethod.GET)
public String delete (int id)
{
	try {
		candidatdao.delete(candidatdao.getOne(id));
		candidatdao.flush();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return "redirect:/Candidat/liste";
}

/**
 * Spring security
 */
@RequestMapping(value = "/Candidat/login")
	public String login() {
	
	    return "login";
	}
	
@RequestMapping(value = "/Candidat/presentation")
public String presentation() {
	return "index";

}



@RequestMapping(value = "/")
public String index() {
    return "redirect:/Candidat/logon";
}

@RequestMapping(value = "/Candidat/logon")
public String logon(HttpServletRequest req, HttpServletResponse resp) {
    return "redirect:/Candidat/liste";
}
@RequestMapping(value="/Candidat/logout", method = RequestMethod.GET)
public String logout (HttpServletRequest request, HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null){
        new SecurityContextLogoutHandler().logout(request, response, auth);
    }

    return "redirect:/Candidat/login?logout";
}


@RequestMapping(value="/Candidat/403")
public String accessDenied(){
    return "403";
}


}

