package uc.us_security.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.us_security.entity.Modulo;
import uc.us_security.repository.ModuloRepository;
import uc.us_security.service.ModuloService;

@Service
public class ModuloServiceImpl implements ModuloService{
	@Autowired
	private ModuloRepository modulorepository;

	@Override
	public Modulo create(Modulo mo) {
		// TODO Auto-generated method stub
		return modulorepository.save(mo);
	}

	@Override
	public List<Map<String, Object>> SP_LISTA_MODULOS() {
		// TODO Auto-generated method stub
		return modulorepository.SP_LISTA_MODULOS();
	}

	@Override
	public Modulo read(int id) {
		// TODO Auto-generated method stub
		return modulorepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		modulorepository.deleteById(id);
	}

	@Override
	public Modulo update(Modulo mo) {
		// TODO Auto-generated method stub
		return modulorepository.save(mo);
	}

	
	
}
