var urlString = "/api/features";

function getFeatures(){
	var result;
	$.ajax({
		type : 'get',
        url : urlString,
        dataType : "json",
        success : function(obj){
        		printFeatures(obj);
            }
        });
}

function printFeatures(features){
	var block = $("#features");
	for (i = 0; i < features.length; i++){
		var feature = features[i];
    	var string =
    	"<div class = 'row'>" +
        "<p>" + feature.feature + "</p>" +
        "</div>";
    	$(block).append(string);
	}
}
