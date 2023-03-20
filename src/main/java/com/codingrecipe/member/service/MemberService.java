package com.codingrecipe.member.service;

import com.codingrecipe.member.dto.MemberDTO;
import com.codingrecipe.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //lombok어노테이션임. 해당 어노테이션은 final이 붙은 필드만 생성자를 만듦(final이 필수임)
public class MemberService {
    private final MemberRepository memberRepository;

    public int save(MemberDTO memberDTO) {
        return memberRepository.save(memberDTO);
    }

    public boolean login(MemberDTO memberDTO) {
        MemberDTO loginMember = memberRepository.login(memberDTO);
        /*Repository로 부터 login을 수행하고 결과를 DTO 객체로 받아오기로 함*/
        if(loginMember != null){
            return true;
        }else {
            return false;
        }
    }
}
