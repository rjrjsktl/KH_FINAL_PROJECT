$(document).ready(function(){
    $('#gotoDetail').on('click', function(e) {
        console.log("시스템가동준비완료");
        
        var password = $('#checkPw-input').val();
        var mtmNo = $(this).data('mtmno');
        var url = `/movie/helpDesk/checkPw/${mtmNo}`;
        $.ajax({
            url: url,
            type: 'POST',
            data: {
                'password': password
            },
            success: function(data) {
                if (data === "success") {
                    window.location.href = '/movie/helpDesk/mtm_detail/' + mtmNo;
                } else {
                    alert("비밀번호 틀령");
                }
            }
        });
    });
    
    });