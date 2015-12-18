var booksId = "#books";
var booksUrl = "/api/books";

function getBooks(){
	$.ajax({
		type : 'get',
        url : booksUrl,
        dataType : "json",
        success : function(obj){
        		printBooks(obj);
            }
        });
}

function getBooksByQuery(urlString){
    $(booksId).empty();
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
	for (i = 0; i < books.length; i++){
		var book = books[i];
    	var string =
    	"<div class = 'row'>" +
    	"<div class = 'col-sm-6'>" +
    	"<img alt='Embedded Image' " +
        "src='data:image/jpg;base64," +
        book.title + "'/>" +
        "</div>" +
        "<div class = 'col-sm-6'>" +
        "<p>" + book.feature + "</p>" +
        "<p>" + book.name + "</p>" +
        "<p>" + book.author + "</p>" +
        "<p>" + book.year + "</p>" +
        "<p><a href='" + booksUrl + "/" + book.id + "'>download</a></p>" +
        "</div>" +
        "</div>";
    	$(booksId).append(string);
	}
}
