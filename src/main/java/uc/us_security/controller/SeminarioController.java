package uc.us_security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uc.us_security.entity.Seminario;
import uc.us_security.service.SeminarioService;


@RestController
@RequestMapping("/api/seminario")
public class SeminarioController {
	@Autowired
	private SeminarioService seminarioservice;
	@PostMapping("/create")
	public ResponseEntity<Seminario> save(@RequestBody Seminario seminario){
		try {
			Seminario pac = seminarioservice.create(seminario);
			return new ResponseEntity<>(pac, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/all")
	public ResponseEntity<List<Seminario>> getPaciente(){
		try {
			List<Seminario> list = new ArrayList<>();
			list = seminarioservice.ListaSeminario();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/seminario/{id}")
	public ResponseEntity<Seminario> getUser(@PathVariable("id") int id){
		Seminario seminario = seminarioservice.read(id);
			if(seminario.getIdsem()>0) {
				return new ResponseEntity<>(seminario, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			seminarioservice.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Seminario> update(@RequestBody Seminario semi, @PathVariable("id") int id){
		try {
			Seminario semin = seminarioservice.read(id);
			if(semin.getIdsem()>0) {
				semin.setNombresem(semi.getNombresem());
				semin.setFechainicio(semi.getFechainicio());
				semin.setFechafin(semi.getFechafin());
				return new ResponseEntity<>(seminarioservice.create(semin),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
