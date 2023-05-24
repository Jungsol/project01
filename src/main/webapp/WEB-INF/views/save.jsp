<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--첫번째 줄은 jsp사용을 위한 문구(모델에서 담아온 값을 본다던지,jsp에서 제공하는 문법 사용가능 등)--%>

<html>
<head>
    <title>save</title>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body> <%--form  태그 안에 input 태그가 들어가야함--%>
    <form action="/member/save" method="post">
            <%--action : input태그의 값을 어디로 가져갈 건지? method : 보내는 방식--%>
        <input type="text" name="memberEmail" placeholder="이메일" id="memberEmail" onblur="emailCheck()">
            <%-- onblur : 입력창을 벗어났을 때 호출하는 함수 --%>
        <p id="check-result"></p>
        <input type="text" name="memberPassword" placeholder="비밀번호">
        <input type="text" name="memberName" placeholder="이름">
        <input type="text" name="memberAge" placeholder="나이">
        <input type="text" name="memberMobile" placeholder="전화번호">
        <input type="submit" value="회원가입">
    </form>
</body>
<script>
    // 1. 이메일 입력값 가져오기
    // 2. 입력값을 서버로 전송하고 똑같은 이메일이 있는지 체크
    // 3. 사용 가능 여부를 이메일 입력창 아래에 표시

    const emailCheck = () => {
        const email = document.getElementById("memberEmail").value;
        const checkResult = document.getElementById("check-result");
        <%--checkResult는 처리결과를 보여줄 용 --%>
        console.log("입력한 이메일: ", email);

        $.ajax({
            type : "post",
            url: "/member/email-check",
            data : {
                "memberEmail":email
            },
            success : function(res){
                console.log("요청성공", res);
                if(res == "ok"){
                    console.log("사용가능한 이메일");
                    checkResult.style.color = "green";
                    checkResult.innerHTML = "사용가능한 이메일";
                } else {
                    console.log("이미 사용중인 이메일");
                    checkResult.style.color = "red";
                    checkResult.innerHTML = "이미 사용중인 이메일";
                }
            },
            error : function(err){
                console.log("에러발생",err);
            }
        });
    }


</script>

</html>