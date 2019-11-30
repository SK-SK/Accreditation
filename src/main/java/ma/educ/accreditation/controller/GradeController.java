package ma.educ.accreditation.controller;

import ma.educ.accreditation.model.Grade;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.educ.accreditation.dao.GradeRepository;

@RestController
public class GradeController {

	@Autowired
	private GradeRepository gradeRepository;
	
	@GetMapping("/api/grades")
	public List<Grade> getGrade(){
		return gradeRepository.findAll();
	}
	
	@PostMapping("/api/grades")
	public Grade createGrade(@Valid @RequestBody Grade grade) {
		
		return gradeRepository.save(grade);
	}
}
