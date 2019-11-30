package ma.educ.accreditation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.educ.accreditation.model.Diplome;

@Repository
public interface DiplomeRepository  extends JpaRepository<Diplome, Integer>{

}
