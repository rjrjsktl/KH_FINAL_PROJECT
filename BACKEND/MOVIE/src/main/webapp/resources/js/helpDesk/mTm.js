$(document).ready(function() {
    $('#submitButton').click(function() {
        var title = $('#titleInput').val();
        var inquiry = $('#inquirySelect').val();
        var content = $('#contentTextarea').val();
        var userNo = $('#userNo').val();

        $.ajax({
            type: 'POST',
            url: '/movie/helpDesk/mTm_form',
            data: {
                "titleInput": title,
                "inquirySelect": inquiry,
                "contentTextarea": content,
                "userNo": userNo
            },
            success: function(response) {
                // Handle the success response
            },
            error: function(xhr, status, error) {
                // Handle the error response
            }
        });
    });
});