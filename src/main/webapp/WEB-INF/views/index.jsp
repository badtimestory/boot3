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
  	<input type="text" id="d1">
  	<button type="button" id="btn" class="btn btn-dark">CLICK</button>
  	<button type="button" id="btn2" class="btn btn-warning">CLICK2</button>
  	<button type="button" id="btn3" class="btn btn btn-light">CLICK3</button>
  	  
  	  <input type="checkbox" name="ch" class="ch" value="1">
  	  <input type="checkbox" name="ch" class="ch" value="2">
  	  <input type="checkbox" name="ch" class="ch" value="3">
  	  <input type="checkbox" name="ch" class="ch" value="4">
	
	  <div id="result">
	  	
	  </div>
	</div>
  
 <!-- Script 호출 -->
<c:import url="./template/header_script.jsp"></c:import>
<script type="text/javascript">
	/*
	// jquery 기본문법
	$('#btn').on('click', function(){
		alert("jquery");
	});
	
	
	$('#btn2').click(function() {
		alert("클릭2를 눌렀습니다")
	});
	*/
	
	/*
	const ch = document.getElementsByClassName('ch')	// 배열
	
	for(c of ch) {
		c.addEventListener('click', function(){
			alert(this.value);
		});
	}
	*/
	
	/*
	$('.ch').click(function() {
		console.log(this.value);
	});
	*/
	
	/*
	$('.ch').on({
		click:function(){
			console.log('click');
		},
		change:function(){
			console.log('change');
		}
	});
	*/
	
	$('.ch').click(function(e){
		let c = $(this).prop('checked');
		this.checked
		console.log(c);
		$('.ch').prop("checked", true);
	});
	
	$('.ch').change(function(){
		console.log('change Test');
	});

	
	$('#btn').click(function(){
		let v = $('#d1').val();
		console.log(v);
	});
	
	$('#btn2').click(function(){
		$(".ch").each(function(idx, item) {
			console.log("index : ", idx);
			console.log("Item : ", item);
			console.log("value : ", $(item).val());
		})
	});
	
	$('#btn3').click(function() {
		// $("#result").append('<input type="checkbox" name="ch" class="ch" value="1">');
		console.log('btn3 click');
		
		let r = "<div>";
		r = r + '<input type="checkbox" name="ch" class="ch" value="1">';
		r = r + "</div>";
		
		$("#result").append(r);
		
	});
	
</script>
</body>
</html>