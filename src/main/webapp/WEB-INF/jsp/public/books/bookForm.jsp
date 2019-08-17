<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
	<html lang="en">
	
	<head>
	
	  <meta charset="utf-8">
	  <meta path="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	  <meta path="description" content="">
	  <meta path="author" content="">
	
	  <title>EP - Public Books Save</title>
	  
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

	  <!-- TinyMCE -->
	  <script src="https://cloud.tinymce.com/5/tinymce.min.js"></script>
	  
	   <!--  Glyphicons  CSS-->
  	  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	
	  
	  <script src="${urlRoot}resources/scripts/bookForm.js"></script>
	   
	</head>
	<body>
		 <!-- Navigation -->
		 <jsp:include page="../commonIncludes/navigation.jsp"></jsp:include>
		 
		 <!-- Page Content -->
		 <div class="container" role="main">
		 
		<h2>Create a new book</h2>
		
		<spring:hasBindErrors name="bookFormModel">
			<div class='alert alert-danger' role='alert'>
				Please, replace the next information:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>
		
		<form:form id="searchForm" action="/AdministrativeBooksApp/publicBook/book/administrative/save" enctype="multipart/form-data" method="POST" modelAttribute="bookFormModel">
				  <div class="form-row">
				  
				    <div class="form-group col-md-5">
				      <label for="inputTitle">Title</label>
				      <form:hidden path="id"/>
				      <form:hidden path="descriptionId"/>
				      <form:hidden path="publisherId"/>  
				      <form:input type="text" path="title" class="form-control" id="inputTitle" placeholder="Title"/>
				      <form:errors path="title" cssStyle="color: #ff0000;"/>
				    </div>
				    
				    <div class="form-group col-md-5">
				      <label for="inputAuthor">Author</label>
				      <form:select id="inputAuthor" multiple="true" path="authorsId" class="form-control">
   						<form:options items="${displayAuthors}" itemValue="id" itemLabel="lastname"/>
					  </form:select>
				    </div>
				    
				    <div class="form-group col-md-2">
				      <label for="inputAuthor">New</label></br>
				        <button id="newAuthorButton" type="button" class="btn btn-success" ><i class="fas fa-plus-circle"></i></button>
				    </div> 
 				  </div>
 				  
 				 <div class="form-row" id="addNewAuthor" style="display: none">
 				   <div class="form-group col-md-5">
				      <label for="inputNewAuthorName">Name</label>
				      <form:input type="text" path="newAuthorsName" class="form-control" id="inputNewAuthorName" placeholder="Title"/>
				    </div>
				    
				    <div class="form-group col-md-5">
				      <label for="inputNewAuthorLastName">Last Name</label>
				      <form:input type="text" path="newAuthorsLastName" class="form-control" id="inputNewAuthorLastName" placeholder="Title"/>
				    </div>
 				  </div>
 				  
 				  <div class="row"> 
			          <div class="col-sm-12">
			            <div class="form-group">
			              <label for="detalle">Description</label>             
			              <form:textarea class="form-control" path="descriptionCoreConcept" id="inputDescription" rows="10"></form:textarea>
			            </div>  
			          </div>
       			  </div>
 				  
 				   <div class="form-row">		    
				    <div class="form-group col-md-4">
				  	<label for="inputCategory">Category</label>
					  <form:select id="inputCategory" multiple="true" path="categoriesId" class="form-control">
   						<form:options items="${displayCategories}" itemValue="id" itemLabel="title"/>
					  </form:select>
					 </div>
				    
				    <div class="form-group col-md-4">
				      <label for="inputLanguage">Language</label>
					      <form:select id="inputLanguage" path="" class="form-control" items="${displayLanguagues}"/>	     
								  <%-- <form:select id="inputLanguage" path="language" class="form-control">
							        <form:option value="English">English</form:option>
							        <form:option value="Spanish">Spanish</form:option>
							        <form:option value="Galician">Galician</form:option>
							        <form:option value="French">French</form:option>
			      				  </form:select> --%>
				    </div>
				    <div class="form-group col-md-4">
             				<label for="inputPublicationDate">Publication Date</label>             
              				<form:input type="text" class="form-control" path="publicationDate" id="inputPublicationDate" required="required"/>
          		   			<form:errors path="publicationDate" cssStyle="color: #ff0000;"/>
          		    </div>
 				  </div>
 				  
 				  <div class="form-row">
				    <div class="form-group col-md-4">
				      <label>ratingProvisionalValue</label></br>
					      <label><form:radiobutton path="" value="1"/> Malo</label>
					      <label><form:radiobutton path="" value="2"/> Regular</label>
					      <label><form:radiobutton path="" value="3"/> Aceptable</label>
					      <label><form:radiobutton path="" value="4"/> Bueno</label>
					      <label><form:radiobutton path="" value="5"/> Excelente</label>
				      <%--<form:input type="text" path="rating" class="form-control" id="inputTitle" placeholder="Rating"/>--%>
				    </div>
				    
				    <div class="form-group col-md-4">
				      <label for="inputISBN">ISBN10</label>
				      <form:input type="text" path="ISBN10" class="form-control" id="inputISBN10" placeholder="ISBN10"/>
				    </div>
				     
				    <div class="form-group col-md-4">
				      <label for="inputISBN">ISBN13</label>
				      <form:input type="text" path="ISBN13" class="form-control" id="inputISBN13" placeholder="ISBN13"/>
				    </div>
				 </div>   
				    
  
				<div class="form-row">
			            <div class="form-group col-md-4">
			              <label for="image">Image </label>
			              <input type="file" id="inputFileImage" name="fileImage" />
			             <!-- <p class="help-block">Image of the book</p>!-->
			            </div> 
 				  </div>
 				  
 				  <div class="form-row">
				    <div class="form-group col-md-6">
 				  		<button type="submit" class="btn btn-primary advancedSearch" name = "save" value="save">Sudmit</button>
 				  	</div>
 				  	<div class="form-group col-md-6">
 				  		<button type="submit" class="btn btn-primary advancedSearch" name = "cancel" value="cancel">Cancel</button>
 				  	</div>
 				 </div>	  
 		</form:form>
 		</div>
		 <!-- Footer -->
		 <jsp:include page="../commonIncludes/footer.jsp"></jsp:include>
			
		 <!-- Bootstrap core JavaScript -->
		 <script src="${urlBootstrap}jquery/jquery.min.js"></script>
		 <script src="${urlBootstrap}js/bootstrap.bundle.min.js"></script>
		 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	</body>
</html>