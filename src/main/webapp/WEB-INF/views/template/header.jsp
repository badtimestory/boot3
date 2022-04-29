<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

<header class=container-fluid>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	  <div class="container-fluid">
	    <a class="navbar-brand active" href="/board/list">Board</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="/">Home</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" href="/product/list">Product</a>
	        </li>
    	    <c:forEach items="${member.roleVOs}" var="vo">
		        <c:if test="${vo.roleName eq 'ROLE_ADMIN'}">
    	      <li class="nav-item">    
	            <a class="nav-link active" href="/admin/manage">관리자 설정</a>
	          </li>
	         	</c:if> 
	        </c:forEach>
	        <c:forEach items="${member.roleVOs}" var="vo">
		        <c:if test="${vo.roleName eq 'ROLE_SALLER'}">
    	      <li class="nav-item">    
	            <a class="nav-link active" href="/product/manage">Product 관리</a>
	          </li>
	         	</c:if> 
	        </c:forEach>
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            Dropdown
	          </a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	            <li><a class="dropdown-item" href="#">Action</a></li>
	            <li><a class="dropdown-item" href="#">Another action</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="#">Something else here</a></li>
	          </ul>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link disabled">Disabled</a>
	        </li>
	      </ul>
	      
	      <ul class="navbar-nav me-3 mb-2 mb-lg-0">
	      		<c:choose>
	      			<c:when test="${not empty member}">
			      		<li class="nav-item">
				          <a class="nav-link active" aria-current="page" href="/member/myPage">My Page <i class="bi bi-easel2-fill"></i></a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link active" href="/member/logout">Logout <i class="bi bi-box-arrow-right"></i></a>
				        </li>
				    </c:when>
		 			<c:otherwise>     	
				      	<li class="nav-item">
				          <a class="nav-link active" aria-current="page" href="/member/signUp">Sign <i class="bi bi-person-plus-fill"></i></a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link active" href="/member/login">Login <i class="bi bi-door-open"></i></a>
				          
				        </li>
			        </c:otherwise>
		        </c:choose>
	      </ul>
	      
	      
	      <form class="d-flex">
		    <select id="kind" name="kind" class="form-select me-2" aria-label="Default select example">
				<option value="col1">제목</option>
				<option value="col2">글쓴이</option>
				<option value="col3">내용</option>
			</select>
	        <input class="form-control me-2" id="search" name="search" type="search" aria-label="Search">
	        <button class="btn btn-outline-light" type="submit">Search</button>
	      </form>
	    </div>
	  </div>
	</nav>
</header>