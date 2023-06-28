$(document).ready(function () {
  let fileInput = $("#fileInput");

  $("#fileInput").on("change", function () {
    if (this.files && this.files[0]) {
      // Clear the previous image
      $(".addfileList").empty();

      var file = this.files[0];
      var reader = new FileReader();

      reader.onload = function (e) {
        // 이미지를 브라우저에 표시합니다.
        // Add the delete button (x) to the image
        $(".addfileList").append(
          '<div class="upimgList">' +
            '<span class="deleteImage">X</span>' +
            '<img src="' +
            e.target.result +
            '">' +
            "</div>"
        );
      };

      // 이미지 파일을 읽습니다.
      reader.readAsDataURL(file);
    }
  });

  $(document).on("click", ".deleteImage", function () {
    $(this).parent().remove();
    $("#fileInput").val("");
  });

  fileInput.on("change", function (e) {
    console.log(e.target.files); // 파일 목록 출력

    // 파일 업로드(다중업로드를 위해 반복문 사용)
    for (var i = 0; i < e.target.files.length; i++) {
      if (!checkExtension(e.target.files[i].name, e.target.files[i].size)) {
        movie_image1.val("");
        return false;
      }
      uploadImageFile1(e.target.files[i]); // 파일 전달
    }
  });

  let regex = new RegExp("(.*?.(png|jpg|gif|jpeg)$)");
  let maxSize = 5000000; // 5MB 제한

  function checkExtension(fileName, fileSize) {
    if (fileSize >= maxSize) {
      alert("파일 사이즈 초과");
      return false;
    }
    if (!regex.test(fileName)) {
      alert(
        "해당 종류 파일은 업로드 안됨.\n PNG, JPG, GIF, JPEG 만 가능합니다."
      );
      return false;
    }
    return true;
  }

  let imageUrl1;

  function uploadImageFile1(file) {
    var data = new FormData();
    data.append("file", file);
    $.ajax({
      url: "uploadImage",
      type: "POST",
      data: data,
      cache: false,
      contentType: false,
      processData: false,
      success: function (data1) {
        console.log("성공 후 반환 메시지11", data1);
        let jsonObject = JSON.parse(data1); // JSON 문자열을 파싱하여 객체로 변환
        imageUrl1 = jsonObject.url; // "url" 키에 해당하는 이미지 URL 선택
        console.log("이미지 URL:", imageUrl1);
      },
      error: function (e) {
        console.log(e);
      },
    });
  }

  $(".btn_wraper button").hover(
    function () {
      $(this).find("a").addClass("hover");
    },
    function () {
      $(this).find("a").removeClass("hover");
    }
  );

  var isChecked = $("#checkbox1").is(":checked");
  updateOpenStatus(isChecked);

  $("#checkbox1").change(function () {
    isChecked = $(this).is(":checked");
    updateOpenStatus(isChecked);
  });

  function updateOpenStatus(isChecked) {
    if (isChecked) {
      $("#openStatus").text("공개 글 입니다.");
    } else {
      $("#openStatus").text("비공개 글 입니다.");
    }
  }

  const replyWrite = $("#reply_writeBtn");

  replyWrite.on("click", function () {
    const mtmNo = $(this).data("mtmno");
    const content = $("#contentTextarea").val();
    const url = `/movie/helpDesk/replyWrite/${mtmNo}`;

    if (confirm("답변을 등록 하시겠습니까?")) {
      $.ajax({
        type: "POST",
        url: url,
        data: { contentTextarea: content },
        success: function (response) {
          var url = `/movie/helpDesk/mtm_detail/${mtmNo}`;
          location.href = url;
        },
        error: function (error) {
          console.error(error);
        },
      });
    }
  });

  const replyDelete = $("#reply_deleteBtn");

  replyDelete.on("click", function () {
    const mtmNo = $(this).data("mtmno");
    const url = `/movie/helpDesk/replyDelete/${mtmNo}`;

    if (confirm(" 답변을 정말로 삭제 하시겠습니까?")) {
      window.location.href = url; // get방식으로 url에 요청
    }
  });

  const deleteMtm = $("#deleteMtm");

  deleteMtm.on("click", function () {
    let mtmNo = $(this).data("mtmno");
    let cp = $("#cp").val(); // HTML에서 'cp' 값 가져오기
    let url = `/movie/helpDesk/deleteMtm/${mtmNo}?cp=` + cp; // URL에 'cp' 파라미터 값을 추가합니다.

    if (confirm("정말로 삭제 하시겠습니까?")) {
      window.location.href = url;
    }
  });

  $(document).on("click", ".deleteImage", function () {
    $(this).parent().remove();
    $("#fileInput").val("");
  });

  $("#submitButton").click(function (e) {
    console.log("이미지 : " + imageUrl1);
    var title = $("#titleInput").val();
    var inquiry = $("#inquirySelect").val();
    var content = $("#contentTextarea").val();
    var userNo = $("#userNo").val();
    var open = $("#checkbox1").is(":checked") ? 0 : 1111;

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
      type: "POST",
      url: "/movie/helpDesk/mTm_form",
      data: {
        titleInput: title,
        inquirySelect: inquiry,
        contentTextarea: content,
        userNo: userNo,
        open: open,
        imageUrl1: imageUrl1,
      },
      success: function (response) {
        var mtmNo = response.mtmNo;
        alert("작성성공");
        var url = `/movie/helpDesk/mtm_detail/${mtmNo}`;
        location.href = url;
      },
      error: function (xhr, status, error) {
        alert("오류 발생");
      },
    });
  });
});

function showImage(imgName) {
  var img = new Image();
  img.onload = function () {
    var width = this.width;
    var height = this.height;
    var win = window.open(
      "",
      "Image",
      "width=" + width + ",height=" + height + ",resizable=1"
    );

    win.document.write("<html><head><title>Image</title></head><body>");
    win.document.write(
      "<img src='" +
        imgName +
        "' style='position:absolute; left:0; top:0; width:100%; height:100%; cursor:pointer;' onclick='window.close();' />"
    );
    win.document.write("</body></html>");
    win.document.close();
  };
  img.src = imgName;
}
