function getBooks(){
	var urlString = "/api/books";
	var result;
	$.ajax({
		type : 'get',
        url : urlString,
        dataType : "json",
        success : function(obj){
        		printBooks(obj);
            }
        });
}

function printBooks(books){
	var block = $("#books");
	var string = "<div>" + books[0].name + "</div>";
	$(block).append(string);
}

$(document).ready(function(){
	getBooks();
})
