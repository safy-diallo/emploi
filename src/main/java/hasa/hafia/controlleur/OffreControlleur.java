package hasa.hafia.controlleur;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hasa.hafia.dao.IOffre;
import hasa.hafia.entites.Offre;
@Controller
public class OffreControlleur {
	

	@Autowired
	private IOffre offredao;
	@RequestMapping(value="/Offre/liste")
	public String liste(ModelMap model)
	{	
		List<Offre> offre=offredao.findAll();		
		model.put("liste_offres",offre);
		model.put("offre",new Offre());
		return "offres/liste";
	}	
	@RequestMapping(value = "/Offre/add", method = { RequestMethod.GET, RequestMethod.POST })	
	public String add(int id,String nomEntreprise,String titreposte, String description) 
	{
		Offre offre= new Offre();
		offre.setId(id);		
		offre.setNomEntreprise(nomEntreprise);
		offre.setTitreposte(titreposte);
		offre.setDescription(description);
		
		System.out.println("======================================================");
		System.out.println(nomEntreprise+""+titreposte+""+description+"");
		System.out.println("======================================================");
		
		try {
			offredao.save(offre);//ajout ou mise à jour
			offredao.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/Offre/liste";
	}

	
	/*@RequestMapping(value="/Offre/edit",method = RequestMethod.GET)
	public String edit (int id,ModelMap model)
	{
		try {
			List<Offre> offre = offredao.findAll();
			model.put("liste_offres", offre);
			Offre offres=offredao.getOne(id);
			
			model.put("Offre", offres);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}				
		return "offres/liste";
	}*/

	@RequestMapping(value="/Offre/delete",method = RequestMethod.GET)
	public String delete (int id)
	{
		try {
			offredao.delete(offredao.getOne(id));
			offredao.flush();		
		} catch (Exception e) {
			e.printStackTrace();
		}
			return "redirect:/Offre/liste";
	}	
}
