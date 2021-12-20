package uc.us_security.service;

import java.util.List;
import java.util.Map;

import uc.us_security.entity.Modulo;

public interface ModuloService {
	Modulo create(Modulo mo);
	List<Map<String, Object>> SP_LISTA_MODULOS();
	Modulo read(int id);
	void delete(int id);
	Modulo update(Modulo mo);
}
