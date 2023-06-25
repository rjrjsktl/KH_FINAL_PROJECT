$(document).ready(function() {
    $(".btn_wraper button").hover(function() {
        $(this).find("a").addClass("hover");
    }, function() {
        $(this).find("a").removeClass("hover");
    });
});

$(document).ready(function() {
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

    $("#registLost").click(function(event) {
        event.preventDefault();

        var title = $("#titleInput").val();
        var item = $("#lostItem").val();
        var area = $("#lostArea").val();
        var date = $("#lostDate").val();
        var file = $("#lostFile")[0].files[0];  // Gets the first selected file
        var details = $("#contentTextarea").val();
        var open = $('#checkbox1').is(':checked') ? 0 : 1111;

        if (!title) {
            alert("제목을 입력해주세요");
            return;
        }
        if (!item) {
            alert("잃어버린 제품을 입력해주세요");
            return;
        }
        if (!area) {
            alert("잃어버린 극장을 입력해주세요");
            return;
        }
        if (!date) {
            alert("잃어버린 날짜를 선택해주세요");
            return;
        }
        if (!details) {
            alert("내용을 입력해주세요");
            return;
        }

        $.ajax({
            url: '/movie/helpDesk/lost_form',
            type: "POST",
            data: {
                "titleInput": title,
                "lostItem": item,
                "lostArea": area,
                "lostDate": date,
                "lostFile": file,
                "contentTextarea": details,
                "open": open
            },
            success: function(response) {
                var lostNo = response.lostNo;
                alert("작성성공");
                var url = `/movie/helpDesk/lost_detail/${lostNo}`;
                location.href = url;
            },
            error: function(jqXHR, textStatus, errorMessage) {
                alert("오류 발생");
            }
        });
    });
});


$(document).ready(function(){
    const deleteLost = $("#deleteLost"); 

        deleteLost.on('click', function(){
      
            let lostNo = $(this).data('lostno');
            let cp = $("#cp").val(); // HTML에서 'cp' 값 가져오기
            
            let url = `/movie/helpDesk/deleteLost/${lostNo}?cp=`+cp;

            if( confirm("정말로 삭제 하시겠습니까?") ){
                window.location.href = url; // get방식으로 url에 요청
            }
        });
});

$(document).ready(function(){
    const replyDelete = $("#reply_deleteBtn"); 

        replyDelete.on('click', function(){
      
            const lostno = $(this).data('lostno');
            const url = `/movie/helpDesk/replyLostDelete/${lostno}`;

            if( confirm(" 답변을 정말로 삭제 하시겠습니까?") ){
                window.location.href = url; // get방식으로 url에 요청
            }
        });
});


$(document).ready(function(){
    const replyWrite = $("#reply_writeBtn"); 

    replyWrite.on('click', function(){
        const lostNo = $(this).data('lostno');
        const content = $("#contentTextarea").val();
        const url = `/movie/helpDesk/replyLostWrite/${lostNo}`;

        if(confirm("답변을 등록 하시겠습니까?")) {
            $.ajax({
                type: "POST",
                url: url,
                data: {contentTextarea: content},
                success: function(response) {
                var url = `/movie/helpDesk/lost_detail/${lostNo}`;
        location.href = url;
                },
                error: function(error) {
                    console.error(error);
                }
            });
        }
    });
});