package com.codingrecipe.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")/*가장 기본 주소에 대한 설정*/
    public String index() {
        return "index"; // -> index.jsp 출력하겠다는 의미
    }
}
