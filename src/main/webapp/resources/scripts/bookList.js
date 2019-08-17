function filterByColumnTitleAuthor() {
	  var tdTitle, tdAuthor;
	  
	  var inputTitle = document.getElementById("inputTitle");
	  var inputTitleTxt = inputTitle.value.toUpperCase();
	  
	  var inputAuthor = document.getElementById("inputAuthor");
	  var inputAuthorTxt = inputAuthor.value.toUpperCase();
	  
	  var bookTable = document.getElementById("booksTable");
	  var rowsBookTable = bookTable.getElementsByTagName("tr");
	  

	  // Loop through all table rows, and hide those who don't match the search query
	  for (i = 0; i < rowsBookTable.length; i++) {
	    tdTitle = rowsBookTable[i].getElementsByTagName("td")[0];
	    tdAuthor = rowsBookTable[i].getElementsByTagName("td")[1];
	    if (tdTitle) {
	      txtTdTitle = tdTitle.textContent || tdTitle.innerText;
	      txtTdAuthor = tdAuthor.textContent || tdAuthor.innerText;
	      if (txtTdTitle.toUpperCase().indexOf(inputTitleTxt) > -1 && txtTdAuthor.toUpperCase().indexOf(inputAuthorTxt) > -1) {
	    	rowsBookTable[i].style.display = "";
	      } else {
	    	rowsBookTable[i].style.display = "none";
	      }
	    } 
	  }
	}

function advancedSearch() {
	var advancedSearch = document.getElementById("advancedSearch");
	var simpleField = document.getElementById("simpleSearch");
	
	advancedSearch.style.display = "";
	simpleField.style.display = "none";
}

function simpleSearch() {
	var advancedSearch = document.getElementById("advancedSearch");
	var simpleField = document.getElementById("simpleSearch");
	
	advancedSearch.style.display = "none";
	simpleField.style.display = "";
}
