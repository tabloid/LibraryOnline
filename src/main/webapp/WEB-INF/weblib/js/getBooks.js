function getBooks(){
	var urlString = "/api/books";
	$.ajax({
		type : 'get',
        url : urlString,
        dataType : "json",
        success : function(obj){
        		return obj;
            }
        });
}

function printBooks(){
	var books = getBooks();
	var block = $("#books");
	for (var i = 0; i <= books.length; i++){
		var string = "<div>" + books[i].name + "/div";
		$(block).add(string);
	}
}

$(document).ready(function(){
	printBooks();
})
