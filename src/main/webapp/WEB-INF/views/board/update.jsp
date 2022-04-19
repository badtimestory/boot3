<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-secondary" role="alert">
				  <h4>${board} Update</h4>
			</div>
		</div>
		<form action="./add" method="POST" enctype="multipart/form-data">
			<div class="row mb-3">
			    <label class="col-sm-2 col-form-label">TITLE</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="title" value="${vo.title}">
			    </div>
			</div>
			
			<div class="row mb-3">
			    <label class="col-sm-2 col-form-label">WRITER</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="writer" readonly="readonly" value="${vo.writer}">
			    </div>
			</div>
		  
			<div class="row mt-3">
				<label class="col-sm-2 col-form-label">CONTENTS</label>
				<div class="col-sm-10">
					<textarea class="form-control" name="contents">${vo.contents}</textarea>
				</div>
			</div>
			
			<div class="row mt-3">
			    <label class="col-sm-2 col-form-label">FILE1</label>
			    <div class="col-sm-10">
			      <input type="file" class="form-control" name="files">
			    </div>
			</div>
			
			<div class="row mt-3">
			    <label class="col-sm-2 col-form-label">FILE2</label>
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