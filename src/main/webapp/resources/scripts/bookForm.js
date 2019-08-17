$(document).ready(function(){
	tinymce.init({
        selector: '#inputDescription',
        plugins: "textcolor, table lists code",
        toolbar: " undo redo | bold italic | alignleft aligncenter alignright alignjustify \n\
                  | bullist numlist outdent indent | forecolor backcolor table code"
    });
	
	$("#newAuthorButton").click(function(){
        $("#addNewAuthor").slideToggle();
    });
	
	
	$("#inputPublicationDate").datepicker({dateFormat: 'dd-mm-yy'});
	
	

});


