function getBooks(){
	var urlString = "/api/books";
	var result;
	$.ajax({
		type : 'get',
        url : urlString,
        async: false,
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
	var string = "<div>" + books[0].name + "</div>";
	$(block).add(string);
}

$(document).ready(function(){
	printBooks();
})
