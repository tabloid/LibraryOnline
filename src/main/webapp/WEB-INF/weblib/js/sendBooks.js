var urlString = "/api/books/test/new";

function sendBooks(){
    var form =$("form");
    form.submit(function(event) {
        event.preventDefault(); // Prevent the form from submitting via the browser
        var form = $(this);
        $.ajax({
            type: "post",
            url: urlString,
            data: form.serialize(),
            contentType: "multipart/*"
        }).done(function(msg) {
            alert(msg);
        });
    });
}
$(document).ready(function(){
	sendBooks();
})