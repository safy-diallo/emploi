package hasa.hafia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hasa.hafia.entites.Users;


@Repository
public interface IUsers extends JpaRepository<Users, Integer>{
	/*@Query("select p from Users p where p.email = :email and p.password = :password")
    public Users chercher(@Param("email") String e, @Param("password") String p);*/


    @Query("select p from Users p where p.email = :email")
    public Users getUserByEmail(@Param("email") String e);
}
