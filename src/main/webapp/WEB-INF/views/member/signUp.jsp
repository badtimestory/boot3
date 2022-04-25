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
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
		<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-secondary" role="alert">
				  <h4>SIGN</h4>
			</div>
		</div>
		<form action="./signUp" method="POST" enctype="multipart/form-data">
			<div class="row mb-3">
			    <label class="col-sm-2 col-form-label">ID</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="id">
			    </div>
			</div>
			
			<div class="row mb-3">
			    <label class="col-sm-2 col-form-label">PW</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" name="pw">
			    </div>
			</div>
		  
			<div class="row mt-3">
				<label class="col-sm-2 col-form-label">NAME</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="name">
				</div>
			</div>
			
			<div class="row mt-3">
				<label class="col-sm-2 col-form-label">PHONE</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="phone">
				</div>
			</div>
			
			<div class="row mt-3">
				<label class="col-sm-2 col-form-label">EMAIL</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="email">
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
		</form>
	</div>
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