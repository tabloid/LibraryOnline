//books
Controllers.Client = new Object();
Controllers.Client.booksId =  "#books";
Controllers.Client.booksUrl = "/api/books";
Controllers.Client.getBooks = function (){
    $.ajax({
        type : 'get',
        url : Controllers.Client.booksUrl,
        dataType : "json",
        success : function(obj){
            Controllers.Client.printBooks(obj);
            }
    });
}
Controllers.Client.getBooksByQuery = function(urlString){
	$.ajax({
		type : 'get',
        url : urlString,
        dataType : "json",
        success : function(obj){
        		Controllers.Client.printBooks(obj);
            }
        });
}
Controllers.Client.printBooks = function(books){
    $(Controllers.Client.booksId).empty();
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
        "<div class='row'><h3>" + book.name + "</h3></div>" +
        "<div class='row'>" + book.feature + "</div>" +
        "<p>" + book.author + "</p>" +
        "<p>" + book.year + "</p>" +
        "<p><a href='" + Controllers.Client.booksUrl + "/" + book.id + "'>download</a></p>" +
        "</div>" +
        "</div><br>";
    	$(Controllers.Client.booksId).append(string);
	}
}
//features
Controllers.Client.featuresId = "#features";
Controllers.Client.featuresUrl = "/api/features";
Controllers.Client.featuresUrlByQuery = "/api/books?feature=";
Controllers.Client.getFeatures = function (){
	$.ajax({
		type : 'get',
        url : Controllers.Client.featuresUrl,
        dataType : "json",
        success : function(obj){
        		Controllers.Client.printFeatures(obj);
            }
        });
}
Controllers.Client.printFeatures = function(features){
    $(Controllers.Client.featuresId).find("ul").empty();
	for (i = 0; i < features.length; i++){
		var feature = features[i].feature;
		var href = Controllers.Client.featuresUrlByQuery + feature;
    	var string =
    	"<li>" +
        "<a href='#' onclick='Controllers.Client.getBooksByQuery(\"" + href + "\")'>" + feature + "</a>" +
        "</li>";
    	$(Controllers.Client.featuresId).find("ul").append(string);
	}
    string =
    "<li><a href='#' onclick='Controllers.Client.getBooks()'>все жанры</a></li>";
    $(Controllers.Client.featuresId).find("ul").append(string);
}
// search controllers
Controllers.Client.searchId="#search";
Controllers.Client.checkboxController = function (obj){
    var input = $(obj).parent().parent().find("input[type='text']");
    if ($(obj).is(":checked"))
        input.css("display","block");
    else{
        input.css("display","none");
        input.val("");
    }
}
Controllers.Client.searchController = function (){
    var str = $(Controllers.Client.searchId).serialize();
    var result = "";
    var array = str.split("&");
    for (i = 0; i<array.length; i++){
        var a = array[i];
        var index = a.indexOf("=");
        if (a.length - 1 != index )
            result += a + "&";
    }
    result = result.substr(0, result.length - 1);
    result = Controllers.Client.booksUrl + "?" + result;
    Controllers.Client.getBooksByQuery(result);
}