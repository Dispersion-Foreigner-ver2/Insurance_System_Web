<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="com.example.InsuranceSystem_Web.domain.Staff.Position" %>
<%@page import="com.example.InsuranceSystem_Web.domain.Staff.Department" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>staffJoin</title>
</head>
<body>
<form action="/staffJoin" method="post">
    아이디
    <input type="text" id="id" name="id">
    <spring:hasBindErrors name="staffJoinForm">
        <c:if test="${errors.hasFieldErrors('id')}">
            <strong>${errors.getFieldError('id').defaultMessage }</strong>
        </c:if>
    </spring:hasBindErrors>
    <p></p>
    비밀번호
    <input type="password" name="pw">
    <spring:hasBindErrors name="staffJoinForm">
        <c:if test="${errors.hasFieldErrors('pw')}">
            <strong>${errors.getFieldError('pw').defaultMessage }</strong>
        </c:if>
    </spring:hasBindErrors>
    <p></p>
    이름
    <input type="text" name="name">
    <spring:hasBindErrors name="staffJoinForm">
        <c:if test="${errors.hasFieldErrors('name')}">
            <strong>${errors.getFieldError('name').defaultMessage }</strong>
        </c:if>
    </spring:hasBindErrors>
    <p></p>
    주민등록번호
    <input type="text" name="SSN">
    <spring:hasBindErrors name="staffJoinForm">
        <c:if test="${errors.hasFieldErrors('SSN')}">
            <strong>${errors.getFieldError('SSN').defaultMessage }</strong>
        </c:if>
    </spring:hasBindErrors>
    <p></p>
    이메일
    <input type="text" name="eMail">
    <spring:hasBindErrors name="staffJoinForm">
        <c:if test="${errors.hasFieldErrors('eMail')}">
            <strong>${errors.getFieldError('eMail').defaultMessage }</strong>
        </c:if>
    </spring:hasBindErrors>
    <p></p>
    핸드폰 번호
    <input type="text" name="phoneNum">
    <spring:hasBindErrors name="staffJoinForm">
        <c:if test="${errors.hasFieldErrors('phoneNum')}">
            <strong>${errors.getFieldError('phoneNum').defaultMessage }</strong>
        </c:if>
    </spring:hasBindErrors>
    <p></p>
    부서
    <select name="department">
        <c:forEach items="${Department.values()}" var="department">
            <option value="${department}">${department.label}</option>
        </c:forEach>
    </select>
    <p></p>
    직급
    <select name="position">
        <c:forEach items="${Position.values()}" var="position">
            <option value="${position}">${position.label}</option>
        </c:forEach>
    </select>
    <p></p>
    성별 <select name="gender">
        <option value=true>남자</option>
        <option value=false>여자</option>
    </select>
    <p></p>
    <input type="submit" value="회원가입"></input>
</form>
</body>
</html>
