package uc.us_security.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import uc.us_security.entity.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Integer>{
	@Query(value = "{call SP_LISTA_MODULOS}", nativeQuery   = true)
    List<Map<String, Object>> SP_LISTA_MODULOS();
}
