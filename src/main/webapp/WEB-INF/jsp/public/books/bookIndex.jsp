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
	
	  <title>Education Project - Public Books</title>
	  
	  <spring:url value="/resources/bootstrap/" var="urlBootstrap"></spring:url>
	  <spring:url value="/resources/images/" var="urlImgs"></spring:url>
	  <spring:url value="/" var="urlRoot"></spring:url>
	
	  <!-- Bootstrap core CSS -->
	  <link href="${urlBootstrap}css/bootstrap.min.css" rel="stylesheet">
	  
	   <!--  Glyphicons  CSS-->
  	  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	
	  <!-- Custom styles for this template -->
	  <link href="${urlRoot}/resources/css/index.css" rel="stylesheet">
	
	</head>
	<body>
	 <!-- Navigation -->
	 <jsp:include page="../commonIncludes/navigation.jsp"></jsp:include>
	 
		<!-- Header -->
	    <header class="bg-primary py-5 mb-5 header">
		    <div class="container h-100">
		      <div class="row h-100 align-items-center">
		        <div class="col-lg-12">
		          <h1 class="display-4 text-white mt-5 mb-2">Public Books</h1>
		          <p class="lead mb-5 text-white-50">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Non possimus ab labore provident mollitia. Id assumenda voluptate earum corporis facere quibusdam quisquam iste ipsa cumque unde nisi, totam quas ipsam.</p>
		        </div>
		      </div>
		    </div>
	   </header>
	 
	 <!-- Page Content -->
 	 <div class="container">

    <!-- Page Features -->
    <div class="row text-center">
    
    	 <div class="col-md-4 mb-5">
	        <div class="card h-100">
	          <img class="card-img-top" src="${urlImgs}bookIndex/findBook.png" alt="">
	          	<!--<div class="card-body">
		            <h4 class="card-title">${book.getTitle()}</h4>
		            <p class="card-text">${book.getAuthors()}</p>
	         	 </div>-->
	          	<div class="card-footer">
	          		<a href="books" class="btn btn-primary" role="button" title="Find">
					     <i class="fas fa-search"> Find</i>
					</a>
	          </div>
	        </div>
	      </div>
	      
	      <div class="col-md-4 mb-5">
	        <div class="card h-100">
	          <img class="card-img-top" src="${urlImgs}bookIndex/addBook.png" alt="">
	          	<div class="card-footer">
	          		<a href="book/administrative/add" class="btn btn-success" role="button" title="Insert">
					    <i class="fas fa-plus-circle">  Insert</i>
					</a>
	          </div>
	        </div>
	      </div>
	      
	      <div class="col-md-4 mb-5">
	        <div class="card h-100">
	          <img class="card-img-top" src="${urlImgs}bookIndex/deleteBook.png" alt="">
	          	<div class="card-footer">
	          		<a href="books" class="btn btn-danger" role="button" title="Delete/Update">
					    <i class="fas fa-minus-circle">  Delete/Update</i>
					</a>
	          </div>
	        </div>
	      </div>

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
  
  <!-- Footer -->
  <jsp:include page="../commonIncludes/footer.jsp"></jsp:include>
	
  <!-- Bootstrap core JavaScript -->
  <script src="${urlBootstrap}jquery/jquery.min.js"></script>
  <script src="${urlBootstrap}js/bootstrap.bundle.min.js"></script>
</body>
</html>