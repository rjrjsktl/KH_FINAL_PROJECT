$(document).ready(function(){
    $("#registLost").click(function(event){
        event.preventDefault();
        var title = $("#titleInput").val();
        var item = $("#lostItem").val();
        var area = $("#lostArea").val();
        var date = $("#lostDate").val();
        var file = $("#lostFile")[0].files[0];  // Gets the first selected file
        var details = $("#contentTextarea").val();

        $.ajax({
            url: "your_server_endpoint.php",  // Replace with your server-side script
            type: "POST",
            url: '/movie/helpDesk/lost_form',
            data:{
              "titleInput": title,
                "inquirySelect": inquiry,
                "contentTextarea": content,
                "userNo": userNo
            },
            success: function(response){
                alert("Form submitted successfully!");
            },
            error: function(jqXHR, textStatus, errorMessage){
                alert("Error: " + errorMessage);
            }
        });
    });
});