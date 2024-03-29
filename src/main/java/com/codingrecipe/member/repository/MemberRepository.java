package com.codingrecipe.member.repository;

import com.codingrecipe.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public MemberDTO login(MemberDTO memberDTO) { /*memberDTO 타입으로 값을 넘기겠다*/
        return sql.selectOne("Member.login", memberDTO); /*selectOne = 조회결과가 하나 / selectList = 여러개일 경우*/
        /*조회결과가 여러개인데 selecOne을 사용시 500 에러가 날 수 있다. 테이블 잘 짜야함.*/
    }

    public List<MemberDTO> findAll() { /*전체 data를 끌어오는게 목적이기때문에 매개변수 없음*/
        return sql.selectList("Member.findAll");
    }

    public MemberDTO findById(Long id) {
        return sql.selectOne("Member.findById", id);
    }

    public void delete(Long id) {
        sql.delete("Member.delete", id);
        /*delete 매소드가 int타입의 return을 주긴 함. 1이상의 값이면 정상삭제된 것.*/
    }

    public MemberDTO findByMemberEmail(String loginEmail) {
        return sql.selectOne("Member.findByMemberEmail", loginEmail);
    }

    public int update(MemberDTO memberDTO) {
        return sql.update("Member.update",memberDTO);
        /*update 매소드가 int타입의 return을 주긴 함. 1이상의 값이면 정상삭제된 것.*/
    }
}
