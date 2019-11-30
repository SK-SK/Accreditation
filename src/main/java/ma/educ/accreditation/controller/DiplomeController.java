package ma.educ.accreditation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.educ.accreditation.dao.DiplomeRepository;
import ma.educ.accreditation.model.Diplome;
import ma.educ.accreditation.model.Grade;

@RestController
public class DiplomeController {
	@Autowired
	private DiplomeRepository diplomeRepository;
	
	@GetMapping("/api/diplomes")
	public List<Diplome> getDiplome(){
		return diplomeRepository.findAll();
	}
	@PostMapping("/api/diplomes")
	public Diplome createDiplome(@Valid @RequestBody Diplome diplome) {		
		return diplomeRepository.save(diplome);
	}
}
