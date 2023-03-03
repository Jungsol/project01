package com.codingrecipe.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
    /*DTO 회원가입 받을 때 전달역할 또는 조회정보를 화면에 보여줄 때 전달하는 용도 등에 사용함
    회원과 관련된 모든 정보를 해당 파일에 다 표현해야 함*/
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private int memberAge;
    private String memberMobile;

}
