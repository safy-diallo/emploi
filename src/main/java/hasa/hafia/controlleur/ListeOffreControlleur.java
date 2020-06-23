package hasa.hafia.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import hasa.hafia.dao.ICandidat;
import hasa.hafia.dao.IOffre;
import hasa.hafia.entites.Candidat;
import hasa.hafia.entites.Offre;

@Controller
public class ListeOffreControlleur {
	
	@Autowired
	private IOffre offredao;
	@RequestMapping(value="/Offre/listeoffre")
	public String liste(ModelMap model)
	{
		List<Offre> offre=offredao.findAll();
		//List<Users> users=userdao.findAll();
		model.put("liste_offres",offre);
		model.put("listedemande",new Offre());
		
		
		
		
		return "page/listeoffre";
	}

}
