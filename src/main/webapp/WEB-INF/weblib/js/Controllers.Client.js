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
Controllers.Client.getBooksByFeature = function(obj, urlString){
    var ulBox = $(obj).parent().parent();
    ulBox.find("li").each(function(){
        $(this).removeClass("active");
    });
	$.ajax({
		type : 'get',
        url : urlString,
        dataType : "json",
        success : function(){
        		Controllers.Client.getBooksByQuery(urlString);
        		$(obj).parent().addClass("active");
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
    	    "<div class = 'col-sm-5'>" +
    	        "<img alt='Embedded Image' src='data:image/jpg;base64," +
    	        book.title + "'/>" +
            "</div>" +
            "<div class = 'col-sm-7'>" +
                "<h4>" +
                    "<a href='" + Controllers.Client.booksUrl + "/" + book.id + "'>" +
                    book.name + "</a>" +
                "</h4>" +
                "<div class='row'>" +
                    "<div class='col-sm-4'>" +
                        "Автор" +
                    "</div>" +
                    "<div class='col-sm-8'>" +
                         book.author +
                    "</div>" +
                "</div>" +
                "<div class='row'>" +
                    "<div class='col-sm-4'>" +
                        "<p>Жанр</p>" +
                    "</div>" +
                    "<div class='col-sm-8'>" +
                        book.feature +
                    "</div>" +
                "</div>" +
                "<div class='row'>" +
                    "<div class='col-sm-4'>" +
                        "<p>Год</p>" +
                    "</div>" +
                    "<div class='col-sm-8'>" +
                        book.year +
                    "</div>" +
                "</div>" +
            "</div>" +
        "</div>";
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
    var featureList = $(Controllers.Client.featuresId).find("ul");
    featureList.empty();
    var string =
    "<li class='active'>" +
        "<a href='#' onclick='Controllers.Client.getBooksByFeature(this," +
         "\"" + Controllers.Client.booksUrl + "\")'>все жанры</a>" +
    "</li>";
    featureList.append(string);
	for (i = 0; i < features.length; i++){
		var feature = features[i].feature;
		var href = Controllers.Client.featuresUrlByQuery + feature;
    	string =
    	"<li>" +
            "<a href='#' onclick='Controllers.Client.getBooksByFeature(this," +
             "\"" + href + "\")'>" + feature + "</a>" +
        "</li>";
    	featureList.append(string);
	}
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