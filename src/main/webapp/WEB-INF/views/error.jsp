<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
</head>
<body>
    <p>오류</p>
    <c:forEach items="${exception}" var="stack">
        <p>${stack}</p>
    </c:forEach>
    <button onclick="history.back()">뒤로가기</button>
</body>
</html>
