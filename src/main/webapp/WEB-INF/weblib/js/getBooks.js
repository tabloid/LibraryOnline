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
	var book =
	var string = books[0];
	"<div class = 'row'>" +
	"<div class = 'col-sm-6'>" +
	"<img alt='Embedded Image' " +
    "src='data:image/jpg;base64," +
    book.title + "'/>" +
    "</div>" +
    "<div class = 'col-sm-6'>" +
    "<p>" + book.id + "</p>" +
    "<p>" + book.feature + "</p>" +
    "<p>" + book.name + "</p>" +
    "<p>" + book.author + "</p>" +
    "<p>" + book.year + "</p>" +
    "</div>" +
    "</div>";
	$(block).append(string);
}

$(document).ready(function(){
	getBooks();
})
