package uc.us_security.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.us_security.entity.Seminario;
import uc.us_security.repository.SeminarioRepository;
import uc.us_security.service.SeminarioService;


@Service
public class SeminarioServiceImpl implements SeminarioService{
	
	@Autowired
	private SeminarioRepository seminariorepository;

	@Override
	public List<Seminario> ListaSeminario() {
		// TODO Auto-generated method stub
		return seminariorepository.ListaSeminario();
	}

	@Override
	public Seminario create(Seminario semi) {
		// TODO Auto-generated method stub
		return seminariorepository.save(semi);
	}

	@Override
	public Seminario update(Seminario semi) {
		// TODO Auto-generated method stub
		return seminariorepository.save(semi);
	}

	@Override
	public Seminario read(int id) {
		// TODO Auto-generated method stub
		return seminariorepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		seminariorepository.deleteById(id);
	}

}
