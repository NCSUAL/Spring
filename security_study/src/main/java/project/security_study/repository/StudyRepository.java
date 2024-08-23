package project.security_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.security_study.model.StudyData;

import java.util.Optional;

//CRUD 함수를 JPArepository가 들고 있음
//@repository 어노테이션 없어도 loc 됨, jpaRepository를 상속했기 때문에
@Repository
public interface StudyRepository extends JpaRepository<StudyData, Integer> {

    //SELECT * FROM USER WHERE USERNAME = ?
    Optional<StudyData> findByUsername(String username);
}
