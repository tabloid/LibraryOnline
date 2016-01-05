var Controllers = new Object();

//for admin and client page
Controllers.cleanInputs = function(){
    $("input[type='checkbox']").each(function(){
        this.checked = false;
    });
    $("input[type='text']").val("");
    $("input[type='file']").val("");
}