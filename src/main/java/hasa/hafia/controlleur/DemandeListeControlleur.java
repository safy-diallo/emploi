package hasa.hafia.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import hasa.hafia.dao.ICandidat;
import hasa.hafia.entites.Candidat;
@Controller
public class DemandeListeControlleur {
	@Autowired
	private ICandidat candidatdao;
	@RequestMapping(value="/Candidat/listedemande")
	public String liste(ModelMap model)
	{
		List<Candidat> candidat=candidatdao.findAll();
		//List<Users> users=userdao.findAll();
		model.put("liste_candidats",candidat);
		model.put("candidat",new Candidat());
		
		
		
		
		return "page/listedemande";
	}


}
