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
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
		<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-secondary" role="alert">
				  <h4>SIGN</h4>
			</div>
		</div>
		<form:form modelAttribute="memberVO" method="POST" enctype="multipart/form-data">
			<div class="row mb-3">
			    <label class="col-sm-2 col-form-label">ID</label>
			    <div class="col-sm-10">
			    	<form:input id="id" path="id" cssClass="form-control"/>
				    <div>
				    	<form:errors path="id"></form:errors>
				    </div>
			    </div>
			</div>
			
			<div class="row mb-3">
			    <label class="col-sm-2 col-form-label">PW</label>
			    <div class="col-sm-10">
			    	<form:password id="pw" path="pw" cssClass="form-control"/>
				    <div>
				    	<form:errors path="pw"></form:errors>
				    </div>
			    </div>
			</div>
			
			<div class="row mb-3">
			    <label class="col-sm-2 col-form-label">PW 확인</label>
			    <div class="col-sm-10">
			    	<!-- <input type="text" class="form-control">  -->
			    	<form:password id="checkPw" path="checkPw" cssClass="form-control"/>
			    </div>
			    <div>
			    	<form:errors path="checkPw"></form:errors>
			    </div>
			</div>
		  
			<div class="row mt-3">
				<label class="col-sm-2 col-form-label">NAME</label>
				<div class="col-sm-10">
					<form:input id="name" path="name" cssClass="form-control"/>
					<div>
						<form:errors path="name"></form:errors>
					</div>
				</div>
			</div>
			
			<div class="row mt-3">
				<label class="col-sm-2 col-form-label">PHONE</label>
				<div class="col-sm-10">
					<form:input id="phone" path="phone" cssClass="form-control"/>
				</div>
			</div>
			
			<div class="row mt-3">
				<label class="col-sm-2 col-form-label">EMAIL</label>
				<div class="col-sm-10">
					<form:input id="email" path="email" cssClass="form-control"/>
					<div>
						<form:errors path="email"></form:errors>
					</div>
				</div>
			</div>
			
			<div class="row mt-3">
			    <label class="col-sm-2 col-form-label">FILE</label>
			    <div class="col-sm-10">
			      <input type="file" class="form-control" name="file">
			    </div>
			</div> 
	
			<div class="row mt-3 justify-content-end">
				<button class="btn col-1 btn-outline-primary">WRITE</button>
			</div>
		</form:form>
		<!-- 약관 -->
		<div class="form-check">
		  <input id="all" class="form-check-input" type="checkbox" value="">
		  <label class="form-check-label" for="all">
		    전체 동의
		  </label>
		</div>
		<div class="form-check">
		  <input id="check1" class="form-check-input ch" type="checkbox" value="">
		  <label class="form-check-label" for="check1">
		    약관 1
		  </label>
		</div>
		<div class="form-check">
		  <input id="check2" class="form-check-input ch" type="checkbox" value="">
		  <label class="form-check-label" for="check2">
		    약관 2
		  </label>
		</div>
		<div class="form-check">
		  <input id="check3" class="form-check-input ch" type="checkbox" value="">
		  <label class="form-check-label" for="check3">
		    약관 3
		  </label>
		</div>
	</div>
<c:import url="../template/header_script.jsp"></c:import>
<script type="text/javascript">
	$('#all').click(function(){
		$('.ch').prop('checked', $('#all').prop("checked"));
	});
	
	$('.ch').on('click', function(){
		let check = true;
		
		$('.ch').each(function(index, item) {
			// 변수명
			if(!$(item).prop('checked')) {
				check = false;
			}
		});
		
		$('#all').prop('checked', check);
		
	});
	
</script>
</body>
</html>