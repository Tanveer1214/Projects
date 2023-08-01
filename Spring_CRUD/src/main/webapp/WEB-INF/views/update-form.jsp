<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="./base.jsp" %>
</head>
<body>
	<div class="container mt-3">

		<div class="row">
			<div class="col-md-6 offset-md-3">
			<h1 class="text-center mb-3">Change Product Detail</h1>
			
			<form action="${pageContext.request.contextPath }/handle-product" method="post">
			
				<div class="form-group">
					<label for="exampleInputEmail">Product Id</label>
					<input class="form-control" type="text" value="${product.id }" name="id" readonly>
				</div>
			
				<div class="form-group">
					<label for="exampleInputEmail">Product Name</label> <input
					name="name" type="text" class="form-control"
					id="exampleInputEmail" aria-describedby="emailhelp"
					placeholder="Enter Product Name"
					value="${product.name }">
				</div>
				
				<div class="form-group">
    				<label for="exampleFormControlTextarea1">Product Description</label>
    				<textarea class="form-control" id="description" rows="3" name="discription">${product.discription }</textarea>
  			    </div>
				
				<div class="form-group">
					<label for="exampleInputEmail">Product Price</label> <input name="price"
					type="text" class="form-control" id="exampleInputEmail"
					aria-describedby="emailhelp" placeholder="Enter Product Price" value="${product.price }">
				</div>
				
				<div class="container text-center">
					<a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
					
					<button type="submit" class="btn btn-outline-primary">Update</button>
				</div>
				
			</form>
			
			</div>
		</div>
		
	</div>
</body>
</html>