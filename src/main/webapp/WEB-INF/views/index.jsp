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
<c:import url="./template/header.jsp"></c:import>

<div class="container mt-4">
	  <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
	  <div class="carousel-indicators">
	    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
	    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
	    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
	  </div>
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="../resources/images/bg1.jpg" class="d-block w-100" alt="image1">
	    </div>
	    <div class="carousel-item">
	      <img src="../resources/images/bg2.jpg" class="d-block w-100" alt="image2">
	    </div>
	    <div class="carousel-item">
	      <img src="../resources/images/bg3.jpg" class="d-block w-100" alt="image3">
	    </div>
	  </div>
	  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Previous</span>
	  </button>
	  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Next</span>
	  </button>
	</div>
  </div>
  
  <div class="container mt-3">
  	<input type="text" id="v1">
  	
  	<input type="checkbox" class="num" name="num" value="a">
  	<input type="checkbox" class="num" name="num" value="b">
  	<input type="checkbox" class="num" name="num" value="c">
  	<input type="checkbox" class="num" name="num" value="d">
  	
  	<button id="btn1">GET</button>
  	<button id="btn2">POST</button>
  	<button id="btn3">AJAX</button>
  </div>
  
 <!-- Script 호출 -->
<c:import url="./template/header_script.jsp"></c:import>
<script type="text/javascript">
	
	$('#btn1').click(function(){
		let v = $('#v1').val();
		console.log(v);
		$.get("./getTest?msg="+v, function(data){
			console.log("응답 완료");
			console.log(data.trim());
		});
	});
	
	// btn2를 click하면 v1의 입력된 값을 /postTest 요청시 parameter로 전송
	// 응답으로 getResult.jsp를 받기
	$('#btn2').click(function(){
		let v = $('#v1').val();
		console.log(v);
		$.post("./postTest", {msg:v}, function(event){
			console.log("응답 완료");
			console.log(event.trim());
		});
	})
	
	$('#btn3').click(function(){
		let ar = [1, 2, 3];
		let nums = [];
		
		$(".num").each(function(idx, item) {
			if($(item).prop("checked")) {
				console.log($(item).val());
				// 배열 끝에 요소를 추가하고 새로운 길이(length) 반환
				nums.push($(item).val());
			}
		})
		
		let v = $('#v1').val();
		$.ajax({
			type : "POST",
			url : "./arrayTest",
			traditional: true,
			data : {
				msg : v,
				numbers : ar,
				// 파라미터 이름 : 파라미터 값
				nums:nums
			}, 
			success : function(d){
				console.log(d.trim());
			},
			error : function(){
				alert('에러 발생');
			}
		});
	});	
	
</script>
</body>
</html>