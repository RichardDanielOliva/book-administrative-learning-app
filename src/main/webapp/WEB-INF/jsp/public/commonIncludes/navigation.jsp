<!-- Navigation 
================================================== -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<spring:url value="/" var="urlRoot" />

   <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
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
           
           <sec:authorize access="isAnonymous()">  
           
           	 <li class="nav-item">
           	 	<a class="nav-link" href="${urlRoot}admin/formLogin">Login</a>
           	 </li>            
     	   </sec:authorize>  
     	   
     	   <sec:authorize access="!isAnonymous()"> 
		     <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Administrative
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">Books</a>
					<a class="dropdown-item" href="#">Authors</a>
					<a class="dropdown-item" href="#">Administrative Option</a>
		        </div>
		      </li>
     	   
	           <li class="nav-item">
	             <a class="nav-link" href="/AdministrativeBooksApp/admin/logout">Logout</a>
	           </li>           
     	   </sec:authorize>
           
         </ul>
       </div>
     </div>
  </nav>