package uc.us_security.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uc.us_security.entity.Modulo;
import uc.us_security.service.ModuloService;

@RestController
@RequestMapping("/api/modulos")
public class ModuloController {
	@Autowired
	private ModuloService moduloService;
	@GetMapping("/all")
	public ResponseEntity <List<Map<String, Object>>>   SP_LISTA_MODULOS(){
		try {
			List<Map<String, Object>>  list = new ArrayList<>();
			list = moduloService.SP_LISTA_MODULOS();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/create")
	public ResponseEntity<Modulo> save(@Validated @RequestBody Modulo modulo){
		try {
			Modulo modu = moduloService.create(modulo);  
			return new ResponseEntity<>(modu, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Modulo> getTBL_Modulo(@PathVariable("id") int id){
		Modulo modu = moduloService.read(id);
			if(modu.getIdmo()>0) {
				return new ResponseEntity<>(modu, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			moduloService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Modulo> update(@RequestBody Modulo mo, @PathVariable("id") int id){
		try {
			Modulo modu = moduloService.read(id);
			if(modu.getIdmo()>0) {
				modu.setNombremo(mo.getNombremo());
				modu.setNu_recursos_totales(mo.getNu_recursos_totales());
				return new ResponseEntity<>(moduloService.create(modu),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
