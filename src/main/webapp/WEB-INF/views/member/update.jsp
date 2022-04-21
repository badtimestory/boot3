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
				  <h4>${board} Update</h4>
			</div>
		</div>
		<form action="./update" method="POST" enctype="multipart/form-data">
			<div class="row mb-3">
			    <label class="col-sm-2 col-form-label">ID</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="id" value="${member.id}" readonly="readonly">
			    </div>
			</div>
			
		  
			<div class="row mt-3">
				<label class="col-sm-2 col-form-label">NAME</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="name" value="${vo.name}">
				</div>
			</div>
			
			<div class="row mt-3">
				<label class="col-sm-2 col-form-label">PHONE</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="phone" value="${vo.phone}">
				</div>
			</div>
			
			<div class="row mt-3">
				<label class="col-sm-2 col-form-label">EMAIL</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="email" value="${vo.email}">
				</div>
			</div>
			
			<div class="row mt-3">
			    <label class="col-sm-2 col-form-label">FILE</label>
			    <div class="col-sm-10">
			      <input type="file" class="form-control" name="files">
			    </div>
			</div>
			
			<div class="row mt-3 justify-content-end">
				<button class="btn col-1 btn-outline-primary">WRITE</button>
			</div>
		</form>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>