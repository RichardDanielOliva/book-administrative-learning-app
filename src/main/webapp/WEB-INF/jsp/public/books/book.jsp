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
	
	  <title>EP - Update Books Search</title>
	  
	  <spring:url value="/resources/bootstrap/" var="urlBootstrap"></spring:url>
	  <spring:url value="/resources/images/" var="urlImgs"></spring:url>
	  <spring:url value="/" var="urlRoot"></spring:url>
	
	  <!-- Bootstrap core CSS -->
	  <link href="${urlBootstrap}css/bootstrap.min.css" rel="stylesheet">
	
	  <!-- Custom styles for this template -->
	  <link href="${urlRoot}resources/css/searchCollection.css" rel="stylesheet">
	  
	  <!-- jquery -->
	  <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	  
	  <script src="${urlRoot}resources/scripts/bookList.js"></script>
	   
	</head>
	<body>
		 <!-- Navigation -->
		 <jsp:include page="../commonIncludes/navigation.jsp"></jsp:include>
		 
		 <div class="page-header">
		 	<h2 class="text-center">${Book.title}</h2> <br>
		 </div>
		 <div class="container" role="main">
				<div class="row">
					<div class="col-sm-3">
						<p class="text-center">
							<img class="img-fluid img-rounded img-thumbnail" src="${urlImgs}Books/${Book.imgUrl}" alt="Generic placeholder image" width="80%">            
						</p>
					</div>
					<div class="col-sm-9">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">Details</h3>
							</div>
							<div class="panel-body">                           
									<dl class="row">
									  <dt class="col-sm-3">Title</dt>
									  <dd class="col-sm-9">${Book.title}</dd>
									 </dl>
									  <dl class="row">
									  <dt class="col-sm-3">Authors</dt>
									  <dd class="col-sm-9">
									  	<c:forEach var = "author" items = "${book.authors}">
					      					${author.fullNameAuthor} </br>
					      				</c:forEach>
					      			  </dd>
									 </dl>
									  <dl class="row">
									  <dt class="col-sm-3">PublicationDate</dt>
									  <dd class="col-sm-3">${Book.publicationDate}</dd>
									  <dt class="col-sm-3">Publisher</dt>
									  <dd class="col-sm-3">${Book.publisherName}</dd>
									 </dl>
									 <dl class="row">
									  <dt class="col-sm-3">Category</dt>
									  <dd class="col-sm-3">
									  	<c:forEach var = "category" items = "${book.categories}">
					      					${category.title} </br>
					      				</c:forEach>
					      			  </dd>
									  <dt class="col-sm-3">Language</dt>
									  <dd class="col-sm-3"></dd>
									 </dl>
									 <dl class="row">
									  <dt class="col-sm-3">ISBN10</dt>
									  <dd class="col-sm-3">${Book.ISBN10}</dd>
									  <dt class="col-sm-3">ISBN13</dt>
									  <dd class="col-sm-3">${Book.ISBN13}</dd>
									 </dl>           
							</div>
						</div>                          
					</div>
				</div>
				<div class="col-sm-12">
						<div class="panel panel-default">
							<div class="panel-heading text-center">
								<h3 class="panel-title">Description</h3>
							</div>
							<div class="panel-body">
								<h3 class="panel-title">Core Concept</h3>
								<p>${Book.descriptionCoreConcept}</p>
							</div>
							<div class="panel-body">
								<h3 class="panel-title">Endoresement</h3>
								<p>${Book.descriptionEndoresement}</p>
							</div>
							<div class="panel-body">
								<h3 class="panel-title">Back Cover</h3>
								<p>${Book.descriptionBackCover}</p>
							</div>
						</div>                          
				</div>
		</div>			
		 <!-- Footer -->
		 <jsp:include page="../commonIncludes/footer.jsp"></jsp:include>
			
		 <!-- Bootstrap core JavaScript -->
		 <script src="${urlBootstrap}jquery/jquery.min.js"></script>
		 <script src="${urlBootstrap}js/bootstrap.bundle.min.js"></script>
	</body>
</html>