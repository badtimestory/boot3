<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<c:import url="../template/header.jsp"></c:import>
<c:import url="../template/header_script.jsp"></c:import>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

</head>
<body>

<div class="container mt-4">
	<div class="row mt-4">
		<div class="alert alert-secondary" role="alert">
			  <h4>${board} UPDATE</h4>
		</div>
	</div>
		
		<div id="list" class="row">
		<!-- 상품 리스트 ajax로 num, name, price, count-->
							
		</div>
		
		<form action="./update" method="POST" enctype="multipart/form-data">
		<input hidden="hidden" name="productNum" value="${vo.productNum}">
		<div class="row mb-3">
		    <label class="col-sm-2 col-form-label">상품이름</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="productName" name="productName" value="${vo.productName}">
		    </div>
		</div>
		
		<div class="row mb-3">
		    <label class="col-sm-2 col-form-label">상품가격</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="productPrice" name="productPrice" value="${vo.productPrice}">
		    </div>
		</div>
		
		<div class="row mb-3">
		    <label class="col-sm-2 col-form-label">상품수량</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="productCount" name="productCount" value="${vo.productCount}">
		    </div>
		</div>
	  
		<div class="row mt-3">
			<label class="col-sm-2 col-form-label">상세내용</label>
			<div class="col-sm-10">
				<textarea id="productDetail" class="form-control" name="productDetail"></textarea>
			</div>
		</div>
		
		<div class="row mb-3">
			<div class="form-check">
			  <input class="form-check-input sale" type="radio" ${vo.sale eq 1 ? 'checked' : ""}
			  name="sale" id="flexRadioDefault1" value="1">
			  <label class="form-check-label" for="flexRadioDefault1">
			    판매
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input sale" type="radio" ${vo.sale eq 0 ? 'checked' : ""}
			  name="sale" id="flexRadioDefault2" value="0">
			  <label class="form-check-label" for="flexRadioDefault2">
			    판매중지
			  </label>
			</div>
		</div>
		
		<div>
			<c:forEach items="${vo.productFilesVO}" var="fileVO">
				<h5>${fileVO.oriName}<button class="del"
				 data-num="${fileVO.fileNum}" type="button">X</button></h5>
			</c:forEach>
		</div>
		
		<div id="fileResult">
		
		</div>
		
		
		<div class="row mt-3 mb-3 justify-content-between">
			<button id="fileAdd" type="button" class="btn col-2 btn-secondary">FILE ADD</button>
			<button id="add" type="submit" class="btn col-2 btn-outline-primary">WRITE</button>
		</div>
		</form>
	</div>
</body>
<script src="../resources/js/fileAdd.js"></script>
<script src="../js/summernote.js"></script>
<script type="text/javascript">
	summernoteInit("productDetail", "${vo.productDetail}");
	fileAddInit(${vo.productFilesVO.size()});
	fileDeleteInit();
</script>
</html>