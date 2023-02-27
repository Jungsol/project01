package com.codingrecipe.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/member") //("/member")라는 공통주소를 사용할 경우
public class MemberController {
    @GetMapping("/member/save") // 짝꿍 : @Controller
/*  @GetMapping("/save") // 짝꿍 : @RequestMapping("/member")*/
    public String saveForm() { //save.jsp를 띄워주는 메소드
        return "save";
    }
}
