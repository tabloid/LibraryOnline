function getBooks(){
	var urlString = "/api/books";
	var result;
	return $.ajax({
		type : 'get',
        url : urlString,
        dataType : "json",
        success : function(obj){
        		result = obj;
            }
        });
    return result;
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
