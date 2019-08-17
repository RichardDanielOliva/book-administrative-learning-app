<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
	<html lang="en">
	
	<head>
	
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	  <meta name="description" content="">
	  <meta name="author" content="">
	
	  <title>Education Project - Public Authors</title>
	  
	  <spring:url value="/resources/bootstrap/" var="urlBootstrap"></spring:url>
	   <!--<spring:url value="/resources/WEB-INF/jsp/public/" var="urlPublicJsp"></spring:url>-->
	  <spring:url value="/" var="urlRoot"></spring:url>
	
	  <!-- Bootstrap core CSS -->
	  <link href="${urlBootstrap}css/bootstrap.min.css" rel="stylesheet">
	
	  <!-- Custom styles for this template -->
	  <link href="${urlBootstrap}css/themes/full-width-pics.css" rel="stylesheet">
	
	</head>
<body>
	 <!-- Navigation -->
	 <jsp:include page="../commonIncludes/navigation.jsp"></jsp:include>
	 
	 <!-- Page Content -->
  <div class="container">

    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">
      <h1 class="display-3">Public Authors</h1>
      <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, ipsam, eligendi, in quo sunt possimus non incidunt odit vero aliquid similique quaerat nam nobis illo aspernatur vitae fugiat numquam repellat.</p>
      <a href="#" class="btn btn-primary btn-lg">Call to action!</a>
    </header>

    <!-- Page Features -->
    <div class="row text-center">
    
		<c:forEach var = "i" begin = "0" end = "3">
	      <div class="col-lg-3 col-md-6 mb-4">
	        <div class="card h-100">
	          <img class="card-img-top" src="http://placehold.it/500x325" alt="">
	          <div class="card-body">
	            <h4 class="card-title">Card title</h4>
	            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
	          </div>
	          <div class="card-footer">
	            <a href="#" class="btn btn-primary">Find Out More!</a>
	          </div>
	        </div>
	      </div>
		</c:forEach>

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
  
  <!-- Footer -->
  <jsp:include page="../commonIncludes/footer.jsp"></jsp:include>
	
  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>