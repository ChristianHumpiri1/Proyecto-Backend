package uc.us_security.service;

import java.util.List;


import uc.us_security.entity.Seminario;

public interface SeminarioService {
	List<Seminario> ListaSeminario();
	Seminario create(Seminario semi);
	Seminario update(Seminario semi);
	Seminario read(int id);
	void delete(int id);
} 
