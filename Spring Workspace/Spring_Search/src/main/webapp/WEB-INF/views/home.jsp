<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"></link>
	<script src="<c:url value="/resources/js/script.js"/>"></script>

    <title>Toogle</title>
  </head>
  <body background="<c:url value="/resources/images/tree.png"/>">

	<%-- <img alt="my image" src="<c:url value="/resources/images/tree.png"/>"> --%>

  	<div class="container">
  		<div class="card mx-auto mt-5 bg-light" style="width: 50%">
  			<div class="card-body">
  				
  				<h3 class="text-center text-primary">Toogle</h3>
  				<form action="search" class="mt-3">
  					
  					<div class="form-group">
  						<input type="text" placeholder="Search here" class="form-control" name="query">
  					</div>
  					
  					<div class="container text-center">
  						 <button class="btn btn-primary">Search</button>
  					</div>
  					
  				</form>
  				
  			</div>
  		</div>
  	</div>
  
  </body>
  
</html>