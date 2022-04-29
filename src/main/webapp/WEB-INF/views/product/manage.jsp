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
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		
		<div class="row mt-3">
			<c:import url="../common/productList.jsp"></c:import>
			<form action="./manage" id="frm">
				<input type="hidden" id="pn" name="pn" value="${pager.pn}">
			</form>
		</div>
		
		<div class="row justify-content-end">
			<a href="./add" type="button" class="btn col-1 btn-outline-primary">WRITE</a>
		</div>
	</div>

	

<c:import url="../template/header_script.jsp"></c:import>
</body>
<script type="text/javascript">
	$('.pager').click(function() {
		let pn = $(this).attr("pn");
		$('#pn').val(pn);
		$('#frm').submit();
	})
</script>
</html>