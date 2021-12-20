package uc.us_security.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uc.us_security.entity.Seminario;

public interface SeminarioRepository extends JpaRepository<Seminario, Integer>{
     
	   @Query(value = "{call List_Seminario}",nativeQuery = true)
	   List<Seminario> ListaSeminario();
	   
}
