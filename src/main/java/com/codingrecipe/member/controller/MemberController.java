package com.codingrecipe.member.controller;

import com.codingrecipe.member.dto.MemberDTO;
import com.codingrecipe.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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

  @GetMapping("/")
  public String findAll(Model model) {
    List<MemberDTO> memberDTOList = memberService.findAll();
    model.addAttribute("memberList", memberDTOList);
    return "list";
  }

  // member?id=1로 요청이 오기 때문에 /member 이후에 뭐가 없는 상태임. 그래서 GetMapping 뒤에 ("/") 작성안함
  // 위와같은 주소로 요청이 오기 때문에 RequestParam을 활용함
  @GetMapping
  public String findById(@RequestParam("id") Long id, Model model){
    MemberDTO memberDTO = memberService.findById(id);
    model.addAttribute("member", memberDTO);
    return "detail";
  }

  @GetMapping("/delete")
  public String delete(@RequestParam("id") Long id){
    memberService.delete(id);
    return "redirect:/member/";
    /*redirect 뒤에 오는 값은 주소값이 와야함(jsp이름이 오면 안됨!)*/
  }

  //수정화면 요청
  // 무엇을 수정할지 기본정보가 필요한데, 위쪽에서 session에 정보를 담아놨었으므로 session을 활용
  @GetMapping("/update")
  public String updateForm(HttpSession session, Model model){
    //세션에 저장된 나의 이메일 가져오기
    String loginEmail = (String) session.getAttribute("loginEmail");
      //session.getAttribute는 object를 돌려주려고 하는데, 우리는 String을 받아와야함. 그래서 (String)를 작성해서 형변환해서 가져옴
    MemberDTO memberDTO = memberService.findByMemberEmail(loginEmail);
    model.addAttribute("member", memberDTO);
    return  "update";

  }

  //수정처리
  @PostMapping("/update")
  public String update(@ModelAttribute MemberDTO memberDTO){
    boolean result = memberService.update(memberDTO);
    if(result){
      return "redirect:/member?id="+memberDTO.getId();
    } else {
      return "index";
    }
  }

}
