//send books
Controllers.Admin = new Object();
Controllers.Admin.sendId = "#send";
Controllers.Admin.isValid = function(){
    var feature = $(Controllers.Admin.sendId).serialize();
    var index = feature.indexOf("=");
    if (feature.length - 1 == index ){
        alert("Введите жанр книг (или выберите из списка)")
        return false;
    }
    var file = $(Controllers.Admin.sendId).find("input[type='file']");
    if (file.val() == ""){
        alert("Выберите книги")
        return false;
    }
    return true;
}
Controllers.Admin.sendBooks = function(){
    if (! Controllers.Admin.isValid() )
        return;
    var feature = $(Controllers.Admin.sendId).serialize();
    var index = feature.indexOf("=");
    feature = feature.substr(index + 1);
    var url = "../api/books/" + feature;
    $(Controllers.Admin.sendId).attr("action", url);
    $(Controllers.Admin.sendId).submit();
}
//features
Controllers.Admin.featuresId = "#features";
Controllers.Admin.featuresUrl = "/api/features";
Controllers.Admin.featuresUrlByQuery = "/api/books?feature=";
Controllers.Admin.getFeatures = function (){
	$.ajax({
		type : 'get',
        url : Controllers.Admin.featuresUrl,
        dataType : "json",
        success : function(obj){
        		Controllers.Admin.printFeatures(obj);
            }
        });
}
Controllers.Admin.printFeatures = function(features){
    $(Controllers.Admin.featuresId).find("ul").empty();
	for (i = 0; i < features.length; i++){
		var feature = features[i].feature;
		var href = Controllers.Admin.featuresUrlByQuery + feature;
    	var string =
    	"<li>" +
        "<a href='#' onclick='Controllers.Admin.setFeature(this)'>" + feature + "</a>" +
        "</li>";
    	$(Controllers.Admin.featuresId).find("ul").append(string);
	}
}
Controllers.Admin.setFeature = function(obj){
    var input = $(Controllers.Admin.sendId).find("input[type=text]");
    var feature = $(obj).text();
    input.val(feature);
}