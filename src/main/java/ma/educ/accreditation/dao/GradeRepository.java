package ma.educ.accreditation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.educ.accreditation.model.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer>{
	

}
