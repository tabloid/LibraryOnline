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
	var string =
	"<img alt='Embedded Image' " +
    "src='data:image/jpg;base64," +
    books[0].title +
    "'/>";
	$(block).append(string);
}

$(document).ready(function(){
	getBooks();
})
