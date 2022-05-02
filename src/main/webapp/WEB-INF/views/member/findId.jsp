<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<c:import url="../template/header.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
<h1>find ID</h1>

	<div class="container mt-4">
		<form action="./findId" method="POST" enctype="multipart/form-data">
			<div class="row mb-3">
			    <label class="col-sm-2 col-form-label">EMAIL</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="email">
			    </div>
			</div>
			<div class="row mt-4 justify-content-center ">
				<button class="btn col-3 btn-outline-danger">아이디 검색</button>
			</div>
		</form>
	</div>



<c:import url="../template/header_script.jsp"></c:import>
</body>
</html>