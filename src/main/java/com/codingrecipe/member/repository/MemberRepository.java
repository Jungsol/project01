package com.codingrecipe.member.repository;

import com.codingrecipe.member.dto.MemberDTO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository { /*mybatis의 기능별 쿼리 사용*/
    public int save(MemberDTO memberDTO) {
        /*save.jsp에서 입력한 값이 해당 soutp에 잘 출력되는지 보기 위한 코드*/
        System.out.println("memberDTO = " + memberDTO);

        return 0;
    }
}
