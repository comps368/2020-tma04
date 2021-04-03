$(document).ready(function(){
    //form validation
    var errTxt = $("span[id$='errors']");
    var errInput = errTxt.prev();
    errTxt.addClass("invalid-tooltip tmaFormErrTxt");
    errInput.addClass("tmaFormErrInput");

   var tableBtn = $(".table-striped td a");
   tableBtn.addClass("btn");
   tableBtn.addClass("btn-primary");
});

//function confirmDel(itemName, delPath){
//    $("#delItemBoxItemName").html(itemName);
//    
//    $("#delItemBoxConfirm").click(function() {
//        window.location.href=delPath;
//    });
//    
//    $("#delItemBox").modal({
//        show: true
//    });
//}