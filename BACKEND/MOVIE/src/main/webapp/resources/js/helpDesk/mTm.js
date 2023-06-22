
$(document).ready(function () {
  $('#submitButton').click(function () {
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
      success: function (response) {
        var mtmNo = response.mtmNo; // mtmNo 값을 가져옵니다.
        alert("작성성공");
        var url = `/movie/helpDesk/mtm_detail/${mtmNo}`;
        location.href = url;
      },
      error: function (xhr, status, error) {
        alert("오류 발생");
      }
    });
  });
});

$(document).ready(function(){
    const deleteMtm = $("#deleteMtm"); 

        deleteMtm.on('click', function(){
      
            let mtmNo = $(this).data('mtmno');
            let url = `/movie/helpDesk/deleteMtm/${mtmNo}`;

            if( confirm("정말로 삭제 하시겠습니까?") ){
                window.location.href = url; // get방식으로 url에 요청
            }
        });
});



$(document).ready(function(){
    const replyDelete = $("#reply_deleteBtn"); 

        replyDelete.on('click', function(){
      
            const mtmNo = $(this).data('mtmno');
            const url = `/movie/helpDesk/replyDelete/${mtmNo}`;

            if( confirm(" 답변을 정말로 삭제 하시겠습니까?") ){
                window.location.href = url; // get방식으로 url에 요청
            }
        });
});


$(document).ready(function(){
    const replyWrite = $("#reply_writeBtn"); 

    replyWrite.on('click', function(){
        const mtmNo = $(this).data('mtmno');
        const content = $("#contentTextarea").val();
        const url = `/movie/helpDesk/replyWrite/${mtmNo}`;

        if(confirm("답변을 등록 하시겠습니까?")) {
            $.ajax({
                type: "POST",
                url: url,
                data: {contentTextarea: content},
                success: function(response) {
                var url = `/movie/helpDesk/mtm_detail/${mtmNo}`;
        location.href = url;
                },
                error: function(error) {
                    console.error(error);
                }
            });
        }
    });
});



$(document).ready(function() {
    $(".btn_wraper button").hover(function() {
        $(this).find("a").addClass("hover");
    }, function() {
        $(this).find("a").removeClass("hover");
    });
});

