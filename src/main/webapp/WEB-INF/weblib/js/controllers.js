var Controllers = new Object();
//books
Controllers.booksId =  "#books";
Controllers.booksUrl = "/api/books";
Controllers.getBooks = function (){
    $.ajax({
        type : 'get',
        url : Controllers.booksUrl,
        dataType : "json",
        success : function(obj){
            Controllers.printBooks(obj);
            }
    });
}
Controllers.getBooksByQuery = function(urlString){
    $(Controllers.booksId).empty();
	$.ajax({
		type : 'get',
        url : urlString,
        dataType : "json",
        success : function(obj){
        		Controllers.printBooks(obj);
            }
        });
}
Controllers.printBooks = function(books){
	for (i = 0; i < books.length; i++){
		var book = books[i];
    	var string =
    	"<div class = 'row'>" +
    	"<div class = 'col-sm-4'>" +
    	"<img alt='Embedded Image' " +
        "src='data:image/jpg;base64," +
        book.title + "'/>" +
        "</div>" +
        "<div class = 'col-sm-4'>" +
        "<p>" + book.feature + "</p>" +
        "<p>" + book.name + "</p>" +
        "<p>" + book.author + "</p>" +
        "<p>" + book.year + "</p>" +
        "<p><a href='" + Controllers.booksUrl + "/" + book.id + "'>download</a></p>" +
        "</div>" +
        "</div>";
    	$(Controllers.booksId).append(string);
	}
}
//features
Controllers.featuresId = "#features";
Controllers.featuresUrl = "/api/features";
Controllers.featuresUrlByQuery = "/api/books?feature=";
Controllers.getFeatures = function (){
	$.ajax({
		type : 'get',
        url : Controllers.featuresUrl,
        dataType : "json",
        success : function(obj){
        		Controllers.printFeatures(obj);
            }
        });
}
Controllers.printFeatures = function(features){
	for (i = 0; i < features.length; i++){
		var feature = features[i].feature;
		var href = Controllers.featuresUrlByQuery + feature;
    	var string =
    	"<div class = 'row'>" +
        "<a href='#' onclick='Controllers.getBooksByQuery(\"" + href + "\")'>" + feature + "</a>" +
        "</div>";
    	$(Controllers.featuresId).append(string);
	}
}
// search controllers
Controllers.searchId="#search";
Controllers.checkboxController = function (obj){
var input = $(obj).parent().parent().find("input[type='text']");
if ($(obj).is(":checked"))
    input.css("display","block");
else
    input.css("display","none");
}
Controllers.cleanInputs = function(){
$(Controllers.searchId).find("input[type='checkbox']").each(function(){
        this.checked = false;
    });
$(Controllers.searchId).find("input[type='text']").val("");
}
Controllers.searchController = function (){
var str = $(Controllers.searchId).serialize();
var result = "";
var array = str.split("&");
for (i = 0; i<array.length; i++){
    var a = array[i];
    var index = a.indexOf("=");
    if (a.length - 1 != index )
        result += a + "&";
}
result = result.substr(0, result.length - 1);
result = Controllers.booksUrl + "?" + result;
Controllers.getBooksByQuery(result);
}