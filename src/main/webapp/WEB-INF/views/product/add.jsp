<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
				  <h4>${board} WRITE</h4>
			</div>
		</div>
			
			<div id="list" class="row">
			<!-- 상품 리스트 ajax로 num, name, price, count-->
								
			</div>
			
			<form:form modelAttribute="productVO" method="POST" enctype="multipart/form-data">
			<div class="row mb-3">
			    <label class="col-sm-2 col-form-label">NAME</label>
			    <div class="col-sm-10">
			      <form:input id="productName" path="productName" cssClass="form-control"/>
			      <div>
			      	<form:errors path="productName"></form:errors>
			      </div>
			    </div>
			</div>
			
			<div class="row mb-3">
			    <label class="col-sm-2 col-form-label">PRICE</label>
			    <div class="col-sm-10">
			      <form:input id="productPrice" path="productPrice" cssClass="form-control"/>
			      <div>
			      	<form:errors path="productPrice"></form:errors>
			      </div>
			    </div>
			</div>
			
			<div class="row mb-3">
			    <label class="col-sm-2 col-form-label">COUNT</label>
			    <div class="col-sm-10">
			      <form:input id="productCount" path="productCount" cssClass="form-control"/>
			      <div>
			      	<form:errors path="productCount"></form:errors>
			      </div>
			    </div>
			</div>
		  
			<div class="row mt-3">
				<label class="col-sm-2 col-form-label">CONTENTS</label>
				<div class="col-sm-10">
					<form:textarea id="productDetail" path="productDetail" cssClass="form-control"/>
				</div>
				<div>
			      	<form:errors path="productDetail"></form:errors>
			    </div>
			</div>
			
			<div class="row mb-3">
				<div class="form-check">
				  <!-- <input class="form-check-input sale" type="radio" name="sale" id="flexRadioDefault1" value="1">  -->
				  <form:radiobutton id="flexRadioDefault1" path="sale" cssClass="form-check-input sale" value="1"/>
				  <label class="form-check-label" for="flexRadioDefault1">
				    판매
				  </label>
				</div>
				<div class="form-check">
				  <!-- <input class="form-check-input sale" type="radio" name="sale" id="flexRadioDefault2" value="0" checked>  -->
				  <form:radiobutton id="flexRadioDefault2" path="sale" cssClass="form-check-input sale" value="0"/>
				  <label class="form-check-label" for="flexRadioDefault2">
				    판매중지
				  </label>
				</div>
			</div>
			
	
			<div id="fileResult">
			
			</div>
			
			
			<div class="row mt-3 mb-3 justify-content-between">
				<button id="fileAdd" type="button" class="btn col-2 btn-secondary">FILE ADD</button>
				<button id="add2" type="submit" class="btn col-2 btn-outline-primary">WRITE</button>
			</div>
			</form:form>
</div>
			
</body>
<script type="text/javascript" src="../resources/js/fileAdd.js"></script>
<script type="text/javascript" src="../js/summernote.js"></script>
<script type="text/javascript">
	summernoteInit('productDetail', '');
	fileAddInit(${vo.productFilesVO.size()});
	fileDeleteInit();
	
	getList(1);
	
		// list ajax url : ajaxList, Get
		function getList(pn) {
			$.ajax({
				type:"GET",
				url:"./ajaxList",
				success : function(data){
					// div id="list"에 html 추가
					$("#list").html(data.trim());
				},
				data: {
					pn:pn,
					// 한 페이지에 5개 
					perPage:5
				}
			});
		}
		
	// 상품등록(add) ajax
	$('#add').click(function() {
		let formData = new FormData();
		let productName = $('#productName').val();
		let productPrice = $('#productPrice').val();
		let productCount = $('#productCount').val();
		let productDetail = $('#productDetail').summernote("code"); //$('#productDetail').val();
		
		let sale = 0;
		$('.sale').each(function(idx, item){
			if($(item).prop("checked")) {
				sale = $(item).val();
			}
		});
		
		$('.files').each(function(idx, item) {
			if(item.files.length > 0) {				
			console.log("index : " + idx);		// index 번호
			console.log("item : " + item);		// <input type="file">
			console.log(item.files);			// input 태그의 file List
			console.log(item.files[0]);			// files list 중 첫 번째 파일
			console.log("length: " + item.files.length);
			console.log(item.files[0].name);	// files list 중 첫 번째 파일의 이름
			// formData.append("파라미터명", 값);
			formData.append("files", item.files[0]);
			}
		});
		
		formData.append("productName", productName);
		formData.append("productPrice", productPrice);
		formData.append("productCount", productCount);
		formData.append("productDetail", productDetail);
		formData.append("sale", sale);
		
		$.ajax({
			type:"POST",
			url:"./add",
			processData:false,
			contentType:false,
			data: formData /* {
				productName: productName,
				productPrice: productPrice,
				productCount: productCount,
				productDetail: productDetail
			} */,
			success: function(data) {
				console.log(data.trim());
				if(data.trim() == '1') {
					alert("상품등록 완료");
					getList();
					$('#productName').val("");
					$('#productPrice').val("");
					$('#productCount').val("");
					$('#productDetail').summernote("code", "");
				} else {
					alert("상품등록 실패");
				}
			},
			error: function() {
				alert("error 발생");
			}
		});
	});
		
	
	// 이벤트 위임
	// let pn = 1;
	$('#list').on('click', '.pager', function() {
		// attr : JS의 getAttribute
		let checkPn = $(this).attr("data-pn");
		if(checkPn > 0) {
			//pn = checkPn;
			getList(checkPn);
		// 이전 또는 다음 Block이 없음
		} else if (checkPn < 0) {
			alert("이전 페이지가 없습니다");
		} else {
			alert("마지막 페이지 입니다.");
		}
	});
</script>
</html>