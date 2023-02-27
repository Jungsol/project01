<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%--jsp사용을 위한 문구(모델에서 담아온 값을 본다던지,jsp에서 제공하는 문법 사용가능 등)--%>
<html>
<head>
    <title>save</title>
</head>
<body>
    <form action="/member/save" method="post">
        <input type="text" name="memberEmail" placeholder="이메일" id="memberEmail" onblur="emailCheck()">
        <input type="text" name="memberPassword" placeholder="비밀번호">
        <input type="text" name="memberName" placeholder="이름">
        <input type="text" name="memberAge" placeholder="나이">
        <input type="text" name="memberMobile" placeholder="전화번호">
        <input type="submit" value="회원가입">
    </form>
</body>
</html>