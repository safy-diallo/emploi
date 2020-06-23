package hasa.hafia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import hasa.hafia.entites.Candidat;



@Repository
public interface ICandidat extends JpaRepository<Candidat, Integer> {
	  @Query("select c from Candidat c where c.nom = :nom")
	    public Candidat getCandidatByNom(@Param("nom") String e);

}
