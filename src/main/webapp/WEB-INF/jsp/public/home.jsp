<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
	<html lang="en">
	
	<head>
	
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	  <meta name="description" content="">
	  <meta name="author" content="">
	
	  <title>Education Project - Administrative Books/Authors</title>
	  
	  <spring:url value="/resources/bootstrap/" var="urlBootstrap"></spring:url>
	   <!--<spring:url value="/resources/WEB-INF/jsp/public/" var="urlPublicJsp"></spring:url>-->
	  <spring:url value="/" var="urlRoot"></spring:url>
	
	  <!-- Bootstrap core CSS -->
	  <link href="${urlBootstrap}css/bootstrap.min.css" rel="stylesheet">
	
	  <!-- Custom styles for this template -->
	  <link href="${urlRoot}/resources/css/home.css" rel="stylesheet">
	  
	  <!--  Glyphicons  CSS-->
  	  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	
	</head>
	
	<body>
	<!-- Navigation -->
		  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-bottom">
		     <div class="container">
		       <a class="navbar-brand" href="#">Administrative Books App</a>
		       <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		         <span class="navbar-toggler-icon"></span>
		       </button>
		       <div class="collapse navbar-collapse" id="navbarResponsive">
		         <ul class="navbar-nav ml-auto">
		           <li class="nav-item active">
		             <a class="nav-link" href="#">Home
		               <span class="sr-only">(current)</span>
		             </a>
		           </li>
		           <li class="nav-item">
		             <a class="nav-link" href="#">Books</a>
		           </li>
		           <li class="nav-item">
		             <a class="nav-link" href="#">Authors</a>
		           </li>
		           <li class="nav-item">
		             <a class="nav-link" href="#">Administrative</a>
		           </li>
		         </ul>
		       </div>
		     </div>
		   </nav>
		
		  <!-- Page Content -->
		  <section>
		    <div class="container containerImg">
		      <div class="row">
		        <div class="col-lg-6">
		          <h1 class="mt-5">Books and authors collection</h1>
		          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deserunt voluptates rerum eveniet sapiente repellat esse, doloremque quod recusandae deleniti nostrum assumenda vel beatae sed aut modi nesciunt porro quisquam voluptatem.</p>
		        </div>
		      </div>
		      <div class="row card-section">
		        <div class="col-lg-3">
		        </div>
		        	<div class="col-lg-3 align-button">
			        	<a href="publicBook/" class="btn btn-primary btn-lg btn-block" role="button" title="Edit">
						    <i class="fas fa-book"></i>  Books
						</a>
		        	</div>
		        	<div class="col-lg-3 align-button">
			        	<a href="publicAuhtor/" class="btn btn-warning btn-lg btn-block disabled" role="button" aria-disabled="true" title="Delete">
						     <i class="fas fa-book-reader"></i>  Authors
						</a>
		      		</div>
		        <div class="col-lg-3">
		        </div>
		      </div>
		    </div>
		  </section>
	
	  <!-- Bootstrap core JavaScript -->
	  <script src="${urlBootstrap}jquery/jquery.min.js"></script>
	  <script src="${urlBootstrap}js/bootstrap.bundle.min.js"></script>
	
	</body>

</html>