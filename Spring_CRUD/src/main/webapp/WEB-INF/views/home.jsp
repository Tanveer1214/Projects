<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="./base.jsp" %>
</head>
<body>
	
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Well Come To Product APP</h1>
				<table class="table table-striped">
  					<thead class="thead-dark">
  				    <tr>
      					<th scope="col">S.No</th>
      					<th scope="col">Product Name</th>
      					<th scope="col">Description</th>
      					<th scope="col">Price</th>
      					<th scope="col">Action</th>
    				</tr>
  					</thead>
  					<tbody>
  						<c:forEach items="${list}" var="p">
    			    	<tr>
      						<th scope="row">${p.id}</th>
      						<td>${p.name}</td>
      						<td>${p.discription}</td>
      						<td class="font-weight-bold">&#8360; ${p.price}</td>
      						<td>
      							<a href="delete/${p.id }"><i class="bi bi-trash3-fill" style="color: red; font-size: 20px;"></i></a>
      							<a href="update/${p.id }"><i class="bi bi-pencil-square" style="color: green; font-size: 20px;"></i></a>
      						</td>
    					</tr>
    					</c:forEach> 
    			    </tbody>
				</table>
				<div class="container text-center">
					<a href="add-product" class="btn btn-outline-success">Add Product</a>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>