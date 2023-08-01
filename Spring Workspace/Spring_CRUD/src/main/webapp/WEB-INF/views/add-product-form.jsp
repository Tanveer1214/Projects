<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp" %>
</head>
<body style="background: #e2e2e2;">
	
	<div class="container mt-3">

		<div class="row">
			<div class="col-md-6 offset-md-3">
			<h1 class="text-center mb-3">Fill the product details</h1>
			
			<form action="handle-product" method="post">
			
				<div class="form-group">
					<label for="exampleInputEmail">Product Name</label> <input
					name="name" type="text" class="form-control"
					id="exampleInputEmail" aria-describedby="emailhelp"
					placeholder="Enter Product Name">
				</div>
				
				<div class="form-group">
    				<label for="exampleFormControlTextarea1">Product Description</label>
    				<textarea class="form-control" id="description" rows="3" name="discription"></textarea>
  			    </div>
				
				<div class="form-group">
					<label for="exampleInputEmail">Product Price</label> <input name="price"
					type="text" class="form-control" id="exampleInputEmail"
					aria-describedby="emailhelp" placeholder="Enter Product Price">
				</div>
				
				<div class="container text-center">
					<a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
					
					<button type="submit" class="btn btn-outline-primary">Add</button>
				</div>
				
			</form>
			
			</div>
		</div>
		
	</div>
	
</body>
</html>