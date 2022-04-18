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
			<div class="alert alert-primary" role="alert">
			  <h4 style="text-transform: uppercase;">${board} List</h4>
			</div>
		</div>
		
		<div class="row mt-4">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">NUM</th>
						<th scope="col">TITLE</th>
						<th scope="col">CONTENTS</th>
						<th scope="col">WRITER</th>
						<th scope="col">REGDATE</th>
						<th scope="col">HIT</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="vo">
					<tr>
						<th scope="row">${vo.num}</th>
						<th>${vo.title}</th>
						<th>${vo.contents}</th>
						<th>${vo.writer}</th>
						<th>${vo.regDate}</th>
						<th>${vo.hit}</th>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="row justify-content-end">
			<a href="./add" type="button" class="btn col-1 btn-outline-primary">WRITE</a>
		</div>
		
	</div>

</body>
</html>