package hasa.hafia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hasa.hafia.entites.Offre;

@Repository
public interface IOffre extends JpaRepository<Offre, Integer>{

}
