package project.security_study.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "User")
public class StudyData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //기본 키 생성을 DB에 위임 (Mysql)
    private String username;
    private String password;
    private String email;
    private String role; //security 권한

    @CreationTimestamp
    private Timestamp createTime;
}
