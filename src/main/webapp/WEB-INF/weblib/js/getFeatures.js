var featuresId = "#features";
var featuresUrl = "/api/features";
var featuresUrlByQuery = "/api/books?feature=";

function getFeatures(){
	$.ajax({
		type : 'get',
        url : featuresUrl,
        dataType : "json",
        success : function(obj){
        		printFeatures(obj);
            }
        });
}

function printFeatures(features){
	for (i = 0; i < features.length; i++){
		var feature = features[i].feature;
		var href = featuresUrlByQuery + feature;
    	var string =
    	"<div class = 'row'>" +
        "<a href='#' onclick='getBooksByQuery(\"" + href + "\")'>" + feature + "</a>" +
        "</div>";
    	$(featuresId).append(string);
	}
}
