package project.security_study.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import project.security_study.config.auth.StudyDetails;
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
        studyService.sign(studyData);
        return "redirect:/login";
    }

    @GetMapping("/userInfo")
    @ResponseBody
    //@AuthenticationPrincipal: Authentication 정보를 가져옴
    public String getUserInfoCommon(Authentication authentication, @AuthenticationPrincipal StudyDetails studyDetails){
        //방법 1
        StudyDetails studyDetail1 = (StudyDetails)authentication.getPrincipal(); //형변환해서 두개 타입중 하나를 결정
        StudyData studyData = studyDetail1.getStudyData();
        System.out.println("형변환 방법1: "+ studyData);

        //방법 2
        StudyData studyData1 = studyDetails.getStudyData();
        System.out.println("간단한 방법2: "+ studyData1);
        return "유저 정보 가져오기!";
    }

    @GetMapping("/userInfo2")
    @ResponseBody
    public String getUserInfoOAuth(@AuthenticationPrincipal OAuth2User oAuth2User,Authentication authentication){
        //방법 1
        OAuth2User oAuth2User1 = (OAuth2User)authentication.getPrincipal(); //형변환
        System.out.println("형변환 방법1: "+ oAuth2User1.getAttributes());

        //방법2
        System.out.println("간단한 방법2: "+ oAuth2User.getAttributes());
        return "Oauth 유저 정보 가져오기!";
    }


}
