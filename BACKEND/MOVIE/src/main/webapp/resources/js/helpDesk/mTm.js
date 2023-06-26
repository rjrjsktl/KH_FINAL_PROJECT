
$(document).ready(function () {

	   // 체크박스의 초기 상태 설정
    var isChecked = $('#checkbox1').is(':checked');
    updateOpenStatus(isChecked);

    // 체크박스의 상태가 변경될 때마다 메시지를 업데이트
    $('#checkbox1').change(function() {
        isChecked = $(this).is(':checked');
        updateOpenStatus(isChecked);
    });

    function updateOpenStatus(isChecked) {
        if (isChecked) {
            $('#openStatus').text('공개 글 입니다.');
            
        } else {
            $('#openStatus').text('비공개 글 입니다.');
        }
    }


  $('#submitButton').click(function (e) {
    var title = $('#titleInput').val();
    var inquiry = $('#inquirySelect').val();
    var content = $('#contentTextarea').val();
    var userNo = $('#userNo').val();
    var open = $('#checkbox1').is(':checked') ? 0 : 1111;
    
  
    
    // Check the inputs
    if (!title) {
      alert("제목을 입력해주세요");
      e.preventDefault(); // Prevent the form from submitting
      return;
    }
    if (!inquiry || inquiry === "문의 내용을 선택해주세요.") {
      alert("문의종류를 선택해주세요");
      e.preventDefault(); // Prevent the form from submitting
      return;
    }
    if (!content) {
      alert("내용을 입력해주세요");
      e.preventDefault(); // Prevent the form from submitting
      return;
    }

    $.ajax({
      type: 'POST',
      url: '/movie/helpDesk/mTm_form',
      data: {
        "titleInput": title,
        "inquirySelect": inquiry,
        "contentTextarea": content,
        "userNo": userNo,
        "open": open
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
    let cp = $("#cp").val(); // HTML에서 'cp' 값 가져오기
        let url = `/movie/helpDesk/deleteMtm/${mtmNo}?cp=`+cp; // URL에 'cp' 파라미터 값을 추가합니다.

        if( confirm("정말로 삭제 하시겠습니까?") ){
            window.location.href = url;
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

