
function getBooks(){
	var urlString = "/api/books";
	$.ajax({
		type : 'get',
        url : urlString,
        dataType : "json",
        success : function(obj){
			alert(obj.getName);
            }
        });
}

$(document).ready(function(){
	getBooks();
})
