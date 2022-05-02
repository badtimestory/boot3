<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<c:import url="../template/header.jsp"></c:import>
</head>
<body>

<div class="container">
	<h1>ID 찾기 결과 page</h1>
		<div class="row">
			<c:choose>
				<c:when test="${not empty idResult}">
					<spring:message code="member.findId" arguments="${idResult.id}"></spring:message>
				</c:when>
				<c:otherwise>
					<spring:message code="member.notFindId"></spring:message>
				</c:otherwise>
			</c:choose>
		</div>
</div>

<c:import url="../template/header_script.jsp"></c:import>
</body>
</html>