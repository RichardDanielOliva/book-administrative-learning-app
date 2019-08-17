<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	  <link href="${urlRoot}resources/css/searchCollection.css" rel="stylesheet">

	</head>
	<body>
		<!-- Navigation -->
		<jsp:include page="commonIncludes/navigation.jsp"></jsp:include>
		
		<div class="container theme-showcase" role="main">
				
			 <div class="row text-center">
			  
			  <div class="form-group col-md-3" >
 			  </div>
				
			  <div class="form-group col-md-6" >
			  
			   <!-- <img src="${urlPublic}/images/login.png" width="136" height="136" class="center">-->
			  
			   <form class="form-signin " action="${urlRoot}perform_login" method="post"> 
			   
			   		<c:if test="${param.error!= null}">
						<!--<img src="${urlPublic}/images/error.png" width="48" height="48" class="center">-->
						<h4 class="form-signin-heading" style="color:red">Access denied</h4>
					</c:if>
			   	       
					<h3 class="form-signin-heading">BooksApp | Administrative</h3>        
					
					<hr class="featurette-divider">
					
					<label for="username" class="sr-only">User</label>
					<input type="text" id="username" name="username" class="form-control" placeholder="User" required autofocus> </br>
					<label for="password" class="sr-only">Password</label>
					<input type="password" id="password" name="password" class="form-control" placeholder="Password" required> </br>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
			  </form>
			 </div>
			 </div>
			</div> <!-- /container -->
			
		<!-- Footer -->
		<jsp:include page="commonIncludes/footer.jsp"></jsp:include>
		
		
		<!-- Bootstrap core JavaScript
	    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="${urlPublic}/bootstrap/js/bootstrap.min.js" ></script>
		
	</body>
	</html>