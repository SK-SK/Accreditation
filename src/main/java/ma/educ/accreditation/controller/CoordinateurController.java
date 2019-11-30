package ma.educ.accreditation.controller;

import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.educ.accreditation.dao.CoordinateurRepository;
import ma.educ.accreditation.dao.DiplomeRepository;
import ma.educ.accreditation.dao.GradeRepository;
import ma.educ.accreditation.model.Coordinateur;
import ma.educ.accreditation.model.Diplome;
import ma.educ.accreditation.model.Grade;

@RestController
public class CoordinateurController {
	@Autowired
	private CoordinateurRepository coordinateurRepository;
	@Autowired
	private DiplomeRepository diplomeRepository;
	@Autowired
	private GradeRepository gradeRepository;
	
	@GetMapping("/api/coordinateurs")
	public List<Coordinateur> getCoordonnateur(){
		return coordinateurRepository.findAll();
	}
	
	@PostMapping("/api/coordinateur/{diplomeId}/{gradeId}")
	public Coordinateur createCoordonnateur(@PathVariable (value = "diplomeId") int diplomeId,
			@PathVariable (value = "gradeId") int gradeId, @Valid @RequestBody Coordinateur coordinateur) {
		
		//get diplome from table diplome and set it with coordinateur setter
		Optional<Diplome> optinalDiplome =  diplomeRepository.findById(diplomeId);
		Diplome cooDip = optinalDiplome.get();
		coordinateur.setDiplome(cooDip);
		
		//Set grade 
		Optional<Grade> optinalGrade =  gradeRepository.findById(gradeId);
		Grade cooGrad = optinalGrade.get();
		coordinateur.setGrade(cooGrad);

	   return coordinateurRepository.save(coordinateur);

	}
	
	/*@PostMapping("/Coordinateur/{diplomeId}")
    public Coordinateur createCourse(@PathVariable(value = "diplomeId") int diplomeId,
        @Valid @RequestBody Coordinateur coordinateur) {
        return diplomeRepository.findById(diplomeId).map(diplome - > {
        	coordinateur.setDiplome(diplome); });
        return coordinateurRepository.save(coordinateur);
    }
	*/
	@PostMapping("/Coordinateur/{diplomeId}/{gradeId}")
	 public Coordinateur create(@Valid @RequestBody Coordinateur coordinateur, @PathVariable(value = "diplomeId") Integer diplomeId,
			 @PathVariable(value = "graded") int gradeId)
	 {
		System.out.println("post method");
			diplomeRepository.findById(diplomeId)
                .map(diplome -> {
                	coordinateur.setDiplome(diplome);                  
                	return 	coordinateurRepository.save(coordinateur);
                    		
                });
			System.out.println(coordinateur+"diplome");
			gradeRepository.findById(gradeId)
            .map(grade -> {
            	coordinateur.setGrade(grade);                  
            	return 	coordinateurRepository.save(coordinateur);
                		
            });
			System.out.println(coordinateur);
		 return coordinateurRepository.save(coordinateur);
	 }
}
