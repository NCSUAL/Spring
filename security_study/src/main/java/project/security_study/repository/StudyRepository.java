package project.security_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.security_study.model.StudyData;

public interface StudyRepository extends JpaRepository<StudyData, Integer> {

}
