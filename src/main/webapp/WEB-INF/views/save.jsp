<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--첫번째 줄은 jsp사용을 위한 문구(모델에서 담아온 값을 본다던지,jsp에서 제공하는 문법 사용가능 등)--%>
<html>
<head>
    <title>save</title>
</head>
<body> <%--form  태그 안에 input 태그가 들어가야함--%>
    <form action="/member/save" method="post"><%--action : input태그의 값을 어디로 가져갈 건지? method : 보내는 방식--%>
        <input type="text" name="memberEmail" placeholder="이메일" id="memberEmail" onblur="emailCheck()">
        <input type="text" name="memberPassword" placeholder="비밀번호">
        <input type="text" name="memberName" placeholder="이름">
        <input type="text" name="memberAge" placeholder="나이">
        <input type="text" name="memberMobile" placeholder="전화번호">
        <input type="submit" value="회원가입">
    </form>
</body>
</html>