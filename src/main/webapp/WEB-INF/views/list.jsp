<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- list를 가져오기 위해서 반복문 사용이 가능한 jstl(jsp에서 제공하는 태그들)을 불러옴--%>
<html>
<head>
    <title>list</title>
</head>
<body>
    <table>
        <tr>
            <th>id</th>
            <th>email</th>
            <th>password</th>
            <th>name</th>
            <th>age</th>
            <th>mobile</th>
            <th>조회</th>
            <th>삭제</th>
        </tr>
        <%--items : 반복대상, var : 반복변수 --%>
        <c:forEach items="${memberList}" var="member">
            <tr>
                <td>${member.id}</td>
                <td>
                    <a href="/member?id=${member.id}">${member.memberEmail}</a>
                </td>
                <td>${member.memberPassword}</td>
                <td>${member.memberName}</td>
                <td>${member.memberAge}</td>
                <td>${member.memberMobile}</td>
                <td>
                    <a href="/member?id=${member.id}">조회</a>
                </td>
                <td>
                    <button onclick="deleteMember('${member.id}')">삭제</button>
                    <%--삭제버튼을 누르면 deleteMember함수를 호출하는데, id값(pk)을 넘김.
                        파라미터(매개변수) 값을 자바스크립트로 보내야함. 이때 형식이나 값이 제대로 전달되지 않는 경우가 있으므로 작은 따옴표를 사용해야함
                        반드시 반복문(forEach)내에서 사용해야함--%>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
<script>
    const deleteMember = (id) => {
        console.log(id);
        location.href = "/member/delete?id="+id;
    }
</script>
</html>