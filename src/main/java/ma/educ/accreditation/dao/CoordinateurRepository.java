package ma.educ.accreditation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.educ.accreditation.model.Coordinateur;
import ma.educ.accreditation.model.Diplome;
import ma.educ.accreditation.model.Grade;

@Repository
public interface CoordinateurRepository extends JpaRepository<Coordinateur, Integer>{
	List<Grade> findByGradeId(int gradeId);
	Optional<Grade> findByIdAndGradeId(int id, int gradeId);
	List<Diplome> findByDiplomeId(Diplome diplome);
	Optional<Diplome> findByIdAndDiplomeId(int id, int diplomeId);
}
