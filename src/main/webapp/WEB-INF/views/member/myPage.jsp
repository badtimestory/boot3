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
	<h1>${board} Detail Page</h1>

	<div class="row">
	  <div class="col-2 text-truncate">
	    ID : ${member.id}
	  </div>
	</div>
	
	<div class="row">
	  <div class="col-2 text-truncate">
	    NAME : ${vo.name}
	  </div>
	</div>
	
	<div class="row">
	  <div class="col-2 text-truncate">
	    PHONE : ${vo.phone}
	  </div>
	</div>
	
	<div class="row">
	  <div class="col-2 text-truncate">
	    EMAIL : ${vo.email}
	  </div>
	</div>
	
	<div class="row">
	  <div class="col-2 text-truncate">
	    FILE : <a href="./fileDown?fileNum=${vo.memberFileVO.fileNum}">${vo.memberFileVO.oriName}</a>
	  </div>
	</div>
		
	<div class="d-grid gap-2 d-md-block">
		<a href="./update" type="button" class="btn btn-success btn-sm">수정</a>
		<a href="./delete" type="button" class="btn btn-danger btn-sm">탈퇴</a>
	</div>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>