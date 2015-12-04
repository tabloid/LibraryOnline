var urlString = "/api/books";

function getBooks(){
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
	var book = books[0];
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
    "<p><a href='" + urlString + "/" + book.id + "'>download</a></p>" +
    "</div>" +
    "</div>";
	$(block).append(string);
}

$(document).ready(function(){
	getBooks();
})
