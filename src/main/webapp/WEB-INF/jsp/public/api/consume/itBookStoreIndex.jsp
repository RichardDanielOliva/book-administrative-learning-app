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
	
	  <title>EP - Public Books Search</title>
	  
	  <spring:url value="/resources/bootstrap/" var="urlBootstrap"></spring:url>
	  <spring:url value="/resources/images/" var="urlImgs"></spring:url>
	  <spring:url value="/" var="urlRoot"></spring:url>
	
	  <!-- Bootstrap core CSS -->
	  <link href="${urlBootstrap}css/bootstrap.min.css" rel="stylesheet">
	
	  <!-- Custom styles for this template -->
	  <link href="${urlRoot}resources/css/searchCollection.css" rel="stylesheet">
	  
	  <!-- jquery -->
	  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
	  <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	  
	  <!--  Glyphicons  CSS-->
  	  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	  
	  <script src="${urlRoot}resources/scripts/bookList.js"></script>
	  <script src="${urlRoot}resources/scripts/bookListJQ.js"></script>
	   
	</head>
	<body>
		 <!-- Navigation -->
		 <jsp:include page="../../commonIncludes/navigation.jsp"></jsp:include>
		 
		 <!-- Page Content -->
		 <div class="container" role="main">
		 
		<h2>Filterable Table</h2>
		
		<form action="/AdministrativeBooksApp/api/consume/ITBookstore/book" method="GET">
		  ISBN:<br>
		  <input type="text" name="isbn">
		  <br>
		  Last name:<br>
		  <input type="submit" value="Submit">
		</form> 
		
			
		</div>
		 <!-- Footer -->
		 <jsp:include page="../../commonIncludes/footer.jsp"></jsp:include>
			
		 <!-- Bootstrap core JavaScript -->
		 <script src="${urlBootstrap}jquery/jquery.min.js"></script>
		 <script src="${urlBootstrap}js/bootstrap.bundle.min.js"></script>
		  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	</body>
</html>