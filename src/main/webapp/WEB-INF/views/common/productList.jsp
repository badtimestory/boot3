<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<table class="table table-success table-striped">
			<thead>
				<tr>
					<th>Num</th>
					<th>Name</th>
					<th>Price</th>
					<th>Count</th>
				</tr>
			</thead>
		
			<c:forEach items="${list}" var="vo">
				<tbody>
					<tr>
						<th scope="row">${vo.productNum}</th>
						<td>${vo.productName}</td>
						<td>${vo.productPrice}</td>
						<td>${vo.productCount}</td>
					</tr>
				</tbody>
			</c:forEach>
			</tbody>
		</table>

		<nav aria-label="Page navigation example">
		  <ul class="mt-3 pagination justify-content-center">
		    <li class="page-item">
			    <a data-pn="${pager.pre ? pager.startNum-1 : -1}" class="page-link pager" 
			    href="#" aria-label="Previous">
	        	<span aria-hidden="true">&laquo;</span>
	      		</a>
      		</li>
      		
		    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		    	<li class="page-item"><a data-pn="${i}" class="page-link pager" 
		    	href="#">${i}</a></li>
		    </c:forEach>
		    
		    <li class="page-item">
			    <a data-pn="${pager.next ? pager.lastNum+1 : 0}" class="page-link pager" href="#" aria-label="Next">
	        	<span aria-hidden="true">&raquo;</span>
	      		</a>
      		</li>
		  </ul>
		</nav>