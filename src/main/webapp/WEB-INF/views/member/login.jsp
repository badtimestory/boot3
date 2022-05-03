<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
			<!-- HTML Form tag 대신 Spring Form tag 사용 -->
			<form:form modelAttribute="memberVO" method="POST">
				<div class="row mb-3">
				    <label class="col-sm-2 col-form-label">ID</label>
				    <div class="col-sm-10">
				      <!-- <input type="text" class="form-control" name="id"> -->
				      <!-- cssClass : 일반적으로 css에서 사용하는 class -->
				      <form:input path="id" id="id" cssClass="form-control"/>
				    </div>
				    <div>
				    	<form:errors path="id"></form:errors>
				    </div>
				</div>
				
				<div class="row mb-3">
				    <label class="col-sm-2 col-form-label">PASSWORD</label>
				    <div class="col-sm-10">
				    <!-- <input type="password" class="form-control" name="pw"> -->
				    	<form:password path="pw" cssClass="form-control" name="pw"/>
				    </div>
				    <div>
				    	<!-- cssStyle : css를 직접 지정 -->
				    	<form:errors path="pw" cssStyle="color:red;"></form:errors>
				    </div>
				</div>
				
				<div class="row mt-3 d-grid gap-2 d-md-flex justify-content-end ">
					<button type="submit" class="btn col-1 btn-outline-primary">로그인</button>
					<button id="find" type="button" class="btn col-2 btn-outline-primary">아이디 찾기</button>
				</div>
			</form:form>
	</div>

<c:import url="../template/header_script.jsp"></c:import>
</body>
<script type="text/javascript">
	$('#find').click(function(){
		location.href='./findId';
	});
</script>
</html>