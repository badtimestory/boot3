<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<c:import url="../template/header.jsp"></c:import>
</head>
<body>

<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-secondary" role="alert">
				  <h4>LOGIN</h4>
			</div>
		</div>
		<form action="./login" method="POST" enctype="multipart/form-data">
			<div class="row mb-3">
			    <label class="col-sm-2 col-form-label">ID</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="id">
			    </div>
			</div>
			
			<div class="row mb-3">
			    <label class="col-sm-2 col-form-label">PASSWORD</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" name="pw">
			    </div>
			</div>
			
			<div class="row mt-3 d-grid gap-2 d-md-flex justify-content-end ">
				<button class="btn col-1 btn-outline-primary">로그인</button>
				<button id="find" type="button" class="btn col-2 btn-info">아이디 찾기</button>
			</div>
			
			<div class="row mt-3 justify-content-end">
				
			</div>
		</form>
	</div>

<c:import url="../template/header_script.jsp"></c:import>
</body>
<script type="text/javascript">
	$('#find').click(function(){
		location.href='./findId';
	});
</script>
</html>