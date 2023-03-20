package com.codingrecipe.member.controller;

import com.codingrecipe.member.dto.MemberDTO;
import com.codingrecipe.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member") //("/member")라는 공통주소를 사용할 경우
@RequiredArgsConstructor
public class MemberController {
  private final MemberService memberService; // 의존성 주입
//    @GetMapping("/member/save") // 짝꿍 : @Controller //링크를 타고 오기때문에 GetMapping사용
  @GetMapping("/save") // 짝꿍 : @RequestMapping("/member")
  public String saveForm() { //save.jsp를 띄워주는 메소드
      return "save";
  }

  @PostMapping("/save")
  public String save(@ModelAttribute MemberDTO memberDTO){
    /*memberDTO 객체로 받음. -> 결국 dto에 담긴 값의 최종목적지는 DB임.*/
    int saveResult = memberService.save(memberDTO);
    /*저장한 정보를 int 타입으로 리턴을 받고 0보다 크면 login(성공) 아닐 경우 실패(save)*/
    if(saveResult > 0){
      return "login";
    }else {
      return "save";
    }
  }

  @GetMapping("/login")
  public String loginForm(){
    return "login";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){ /*값이 다 없어도 DTO로 받는건 상관없음*/
    boolean loginResult = memberService.login(memberDTO);
    if(loginResult){
      /*login 이후 내 정보가 따라다녀야하므로 session을 추가*/
      session.setAttribute("loginEmail", memberDTO.getMemberEmail());/*session에 로그인한 메일정보 저장*/
      return "main";/*login을 성공하면 main.jsp를 띄운다*/
    } else {
      return "login";
    }
  }
}
