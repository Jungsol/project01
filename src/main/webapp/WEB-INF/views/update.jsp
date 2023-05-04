<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
    <form action="/member/update" method="post" name="updateForm">
        id: <input type="text" name="id" value="${member.id}"readonly>
        email: <input type="text" name="memberEmail" value="${member.memberEmail}"readonly>
        password: <input type="text" name="memberPassword" id="memberPassword">
        name: <input type="text" name="memberName" value="${member.memberName}" readonly>
        age: <input type="text" name="memberAge" value="${member.memberAge}">
        mobile: <input type="text" name="memberMobile" value="${member.memberMobile}">
        <input type="button" value="수정" onclick="update()">
        <%-- type이 버튼임. submit일 경우 버튼 클릭하자마자 바로 action("/member/update")으로전송됨.
            다른 기능(함수호출 등)을 주고싶을 때 type = button으로 작성함
            비슷한 기능으로는 preventdefault도 가능함--%>

    </form>
</div>
</body>
<script>
    <%-- update 함수의 기능 -> 사용자가 입력한 pw와 db에 있는 pw가 동일한지 확인하는 용--%>
    const update = () => {
        const passwordDB = '${member.memberPassword}'; <%-- db에서 조회해온 pw. 무조건 싱글쿼티로 묶어야함 --%>
        const password = document.getElementById("memberPassword").value;
        if (passwordDB == password) {
            document.updateForm.submit();
            <%-- 현재문서에 updateForm 이름을 submit하겠다는 의미--%>
        } else {
            alert("비밀번호가 일치하지 않습니다!");
        }
    }
</script>
</html>