<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>staffLogin</title>
</head>

<script type="text/javascript">

</script>


<body>
<form action="login" method="post">


    아이디 <input type="text" name="staffId" id="staffId">
    <spring:hasBindErrors name="staffLoginForm">
        <c:if test="${errors.hasFieldErrors('staffId')}">
            <strong>${errors.getFieldError('staffId').defaultMessage }</strong>
        </c:if>
    </spring:hasBindErrors>
    <p></p>
    비밀번호 <input type="password" name="password">
    <spring:hasBindErrors name="staffLoginForm">
        <c:if test="${errors.hasFieldErrors('password')}">
            <strong>${errors.getFieldError('password').defaultMessage }</strong>
        </c:if>
    </spring:hasBindErrors>

    <p></p>
    <input type="submit" value="로그인">
    <button><a href="staffJoin">회원가입</a></button>
</form>
</body>
</html>

