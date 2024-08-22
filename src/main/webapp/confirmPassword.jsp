<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>비밀번호 확인</title>
</head>
<body>
    <h2>비밀번호를 입력해 주세요</h2>
    <form method="post" action="${pageContext.request.contextPath}/confirmPassword">
        <input type="hidden" name="num" value="${num}">
        <input type="hidden" name="action" value="${action}">
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password">
        <input type="submit" value="확인">
    </form>
    <p>${errorMessage}</p>
</body>
</html>
