package project.security_study.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import project.security_study.Repository.StudyRepository;
import project.security_study.model.StudyData;
import project.security_study.service.StudyService;

@Controller
public class TestController {

    private final StudyService studyService;
    public TestController(StudyService studyService){
        this.studyService = studyService;
    }

    @GetMapping("/test")
    public String test(){
        return "index";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user(){
        return "user";
    }

    @GetMapping("/manager")
    @ResponseBody
    public String manager(){
        return "manager";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(){
        return "admin";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/joinForm")
    public String join(){
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinForm(StudyData studyData){
        studyService.login(studyData);
        return "redirect:/login";
    }


}
