package com.codingrecipe.member.service;

import com.codingrecipe.member.dto.MemberDTO;
import com.codingrecipe.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //해당 어노테이션은 final이 붙은 필드만 생성자를 만듦(final이 필수임)
public class MemberService {
    private final MemberRepository MemberRepository;

    public int save(MemberDTO memberDTO) {
    }
}
