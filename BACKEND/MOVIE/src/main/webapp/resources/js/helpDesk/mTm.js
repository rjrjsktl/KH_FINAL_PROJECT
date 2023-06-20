
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