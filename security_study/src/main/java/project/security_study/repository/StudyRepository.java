package project.security_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.security_study.model.StudyData;

import java.util.Optional;

public interface StudyRepository extends JpaRepository<StudyData, Integer> {
    Optional<StudyData> findByUsername(String username);
}
