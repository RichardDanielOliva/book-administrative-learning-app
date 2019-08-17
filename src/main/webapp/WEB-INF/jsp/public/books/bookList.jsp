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
		 <jsp:include page="../commonIncludes/navigation.jsp"></jsp:include>
		 
		 <!-- Page Content -->
		 <div class="container" role="main">
		 
		<h2>Filterable Table</h2>
		
		
		<spring:hasBindErrors name="bookSearchModel">
			<div class='alert alert-danger' role='alert'>
				Please, replace the next information:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>
		
		<form:form id="searchForm" action="/AdministrativeBooksApp/publicBook/books/advancedSearch" method="GET" modelAttribute="bookSearchModel">
				  <div class="form-row">
				  
				    <div class="form-group col-md-6">
				      <label for="inputTitle">Title</label>
				      <form:input type="text" path="title" class="form-control" id="inputTitle" onkeyup="filterByColumnTitleAuthor()" placeholder="Title"/>
				    </div>
				    
				    <div class="form-group col-md-6">
				      <label for="inputAuthor">Author</label>
				      <form:input type="text" path="author" class="form-control" id="inputAuthor" onkeyup="filterByColumnTitleAuthor()" placeholder="Author"/>
				    </div>
 				  </div>
 				  
 				  <div id="advancedSearch" style="display: none;">
 				   <div class="form-row">
 				   
				    <div class="form-group col-md-4">
				      <label for="inputISBN">ISBN</label>
				      <form:input type="text" path="ISBN13" class="form-control" id="inputISBN" placeholder="ISBN"/>
				    </div>
				    
				    <div class="form-group col-md-4">
				      <label for="inputCategory">Category</label>
					  <form:select id="inputCategory" multiple="true" path="categoriesId" class="form-control">
   						<form:options items="${displayCategories}" itemValue="id" itemLabel="title"/>
					  </form:select>
				    </div>
				    
				    <div class="form-group col-md-4">
             				<label for="inputPublicationDate">Publication Date</label>   
             				<form:input type="text" class="form-control" path="publicationDate" id="inputPublicationDate"/>          
              				<br>
              				<label><form:radiobutton path="publicationDateBeforeAfter" value="-1" checked="checked"/> Before </label> 
              				<label><form:radiobutton path="publicationDateBeforeAfter" value="0" checked="checked"/> Exact date </label> 
							<label><form:radiobutton path="publicationDateBeforeAfter" value="1" /> After </label>
          		    </div>
 				  </div>
 				  
 				   <div class="form-row">
				    <div class="form-group col-md-6">
				      <label>Language</label> <br>
				      <form:select id="genero" path="searchLanguages" multiple="multiple" class="form-control"  items="${displayLanguagues}"/>
				    </div>
				    
				    <div class="form-group col-md-6">
				      <label>Rating</label> <br>
					      <label><form:checkbox path="searchRating" value="1" checked="checked" /> Malo</label> </br>
						  <label><form:checkbox path="searchRating" value="2" checked="checked" /> Regular</label> </br>
					      <label><form:checkbox path="searchRating" value="3" checked="checked" /> Aceptable</label> </br>
					      <label><form:checkbox path="searchRating" value="4" checked="checked" /> Bueno</label> </br>
					      <label><form:checkbox path="searchRating" value="5" checked="checked" /> Excelente</label> </br>
				    </div>
 				  </div>
 				  
 				  <div class="form-row">
				    <div class="form-group col-md-6">
 				  		<button type="submit" class="btn btn-primary advancedSearch">Search</button>
 				  	</div>
 				  </div>
 				  <div class="form-row">
 				  	<div class="form-group col-md-6">
 						<button class="btn btn-primary advancedSearch" onClick="simpleSearch()">Simple Search</button>
 					</div>
 				  </div>
 			 </div>
 				  
 		</form:form>
 		
 		<div class="form-group col-md-6" id="simpleSearch">
 			<button class="btn btn-primary" onClick="advancedSearch()">Advanced Search</button>
 		</div>
 		
 		<c:if test="${itIsAnAdvancedSearch}">
	 		<div class="form-group col-md-6" id="searchAll">
	 			<a href="/AdministrativeBooksApp/publicBook/books" class="btn btn-primary" role="button">Display All</a>
	 		</div>
 		</c:if>
 		
		 <h2>Results</h2>
		 
		 <c:if test="${bookCreateMessage!=null }">
      		<div class='alert alert-success' role="alert">${bookCreateMessage}</div>
     	 </c:if>
		 
		 <div class="table-responsive">
			 <table id="booksTable" class="table table-striped table-bordered table-sm" cellspacing="0" width="80%">
				  <thead>
					    <tr>
					      <th class="th-sm text-center"><i class="fas fa-book"></i>	Title</th>
					      <th class="th-sm text-center"><i class="fas fa-user"></i> Author</th>
					      <th class="th-sm text-center"><i class="fas fa-sort-numeric-down"></i> ISBN13</th>
					      <th class="th-sm text-center"><i class="fas fa-clone"></i> Category</th>
					      <th class="th-sm text-center"><i class="fas fa-info"></i> Language</th>
					      <th class="th-sm"><i class="fas fa-info"></i> Options</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach var = "book" items = "${Books.content}">
					    <tr>
					      <td><a href="book/${book.id}">${book.title}</a></td>
					      <td>
					      		<c:forEach var = "fullNameAuthor" items = "${book.fullNameAuthors}">
					      			${fullNameAuthor}</br>
					      		</c:forEach>
					      </td>
					      <td>${book.getISBN13()}</td>
					      <td>
					      		<c:forEach var = "categoryTitle" items = "${book.categoriesTitle}">
					      			${categoryTitle} </br>
					      		</c:forEach>
					      </td>
					      <td>${book.publicationLanguage}</td>
					      <td>
					      	<a href="book/administrative/${book.id}/update" class="btn btn-success btn-sm" role="button" title="Edit">
					      		<i class="fas fa-pen-nib"></i>
					      	</a>
					      	<a href="book/administrative/${book.id}/delete" class="btn btn-danger btn-sm" role="button" title="Delete">
					      		<i class="fas fa-minus-circle"></i> 
					      	</a>
					      </td>
					    </tr>
					 </c:forEach>
			  	  </tbody>
				  <tfoot>
				    <tr class="text-center">
				      <th>Title
				      </th>
				      <th>Author
				      </th>
				      <th>ISBN13
				      </th>
				      <th>Category
				      </th>
				      <th>Language
				      </th>
				      <th>Rating
				      </th>
				    </tr>
				  </tfoot>
				</table>
			</div>
			
			<nav aria-label="">
				<ul class="pager">
					<li><a href="/AdministrativeBooksApp/publicBook/books?page=${Books.number -1 }">Anterior</a></li>
					<li><a href="/AdministrativeBooksApp/publicBook/books?page=${Books.number + 1 }">Siguiente</a></li>
				</ul>
			</nav>
			
		</div>
		 <!-- Footer -->
		 <jsp:include page="../commonIncludes/footer.jsp"></jsp:include>
			
		 <!-- Bootstrap core JavaScript -->
		 <script src="${urlBootstrap}jquery/jquery.min.js"></script>
		 <script src="${urlBootstrap}js/bootstrap.bundle.min.js"></script>
		  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	</body>
</html>