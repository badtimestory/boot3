<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
		<!-- items : requestScope / var : pageScore -->
		<c:forEach items="${vo.productFilesVO}" var="fileVO">
			<img alt="" src="../resources/upload/product/${fileVO.fileName}">
		</c:forEach>
	
	<div class="row">
		<div class="card">
			<ul class="list-group list-group-flush">
			   	<li class="list-group-item pName">${vo.productName}</li>
		   		<li class="list-group-item">${vo.id} </li>
			</ul>
		  
			<div class="card-body">
				${vo.productDetail}
	    	</div>
		</div>
	</div>
</div>
	

</body>
</html>