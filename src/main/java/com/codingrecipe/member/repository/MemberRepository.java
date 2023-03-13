package com.codingrecipe.member.repository;

import com.codingrecipe.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository { /*mybatis의 기능별 쿼리 사용*/
    private final SqlSessionTemplate sql; /*mybatis에서 제공하는 클래스*/
    public int save(MemberDTO memberDTO) {
        /*save.jsp에서 입력한 값이 해당 soutp에 잘 출력되는지 보기 위한 코드*/
        System.out.println("memberDTO = " + memberDTO);

        /*memberMapper.xml의 namespace가 Member이고, Member 내의 태그(insert, select 등)에 부여된 id 중에 save를
        * 호출해서, memberDTO를 넘긴다! 라는 의미. 오타 체크 못함! 주의하기
        * mapper를 호출할 때 넘기는 뭔가가 있다? 그럼 해당 Member.save에서 parameterType이 필요하게 됨*/
        return sql.insert("Member.save", memberDTO);
    }
}
