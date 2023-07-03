$(document).ready(function () {
  $(".selected_Cp").parent().css("border", "1px solid rgb(255, 196, 0)");
});

$(document).ready(function () {
  $("#lostArea").change(function () {
    var area = $(this).val();

    console.log(area);

    $.ajax({
      url: "/movie/helpDesk/lost_List/selectName",
      type: "GET",
      data: { area: area },
      success: function (response) {
        console.log(response);
        var options = "<option disabled selected>상영관선택</option>";
        for (var i = 0; i < response.cinemaNameList.length; i++) {
          var cinemaName = response.cinemaNameList[i].cinemaName;
          options +=
            '<option value="' + cinemaName + '">' + cinemaName + "점</option>";
        }

        $("#lostName").html(options);
      },
      error: function () {},
    });
  });

  $(".submitBTN").click(function () {
    var area = $("#lostArea").val();
    var name = $("#lostName").val();
    var keyword = $("input[name='keyword']").val();

    console.log(area, name, keyword);
  });
});

$(document).ready(function () {
  $(".btn_wraper button").hover(
    function () {
      $(this).find("a").addClass("hover");
    },
    function () {
      $(this).find("a").removeClass("hover");
    }
  );

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
      url: "uploadLostImage",
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

  // 체크박스의 초기 상태 설정
  var isChecked = $("#checkbox1").is(":checked");
  updateOpenStatus(isChecked);

  // 체크박스의 상태가 변경될 때마다 메시지를 업데이트
  $("#checkbox1").change(function () {
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

  $("#registLost").click(function (event) {
    event.preventDefault();

    var title = $("#titleInput").val();
    var item = $("#lostItem").val();
    var area = $("#lostArea").val();
    var date = $("#lostDate").val();
    var details = $("#contentTextarea").val();
    var open = $("#checkbox1").is(":checked") ? 0 : 1111;
    console.log(area);
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
      url: "/movie/helpDesk/lost_form",
      type: "POST",
      data: {
        titleInput: title,
        lostItem: item,
        lostArea: area,
        lostDate: date,
        contentTextarea: details,
        open: open,
        imageUrl1: imageUrl1,
      },
      success: function (response) {
        var lostNo = response.lostNo;
        alert("작성성공");
        var url = `/movie/helpDesk/lost_detail/${lostNo}`;
        location.href = url;
      },
      error: function (jqXHR, textStatus, errorMessage) {
        alert("오류 발생");
      },
    });
  });

  // update
  $("#updateButton").click(function (e) {
    var lostNo = $("#lostNo").val();
    var title = $("#titleInput").val();
    var item = $("#lostItem").val();
    var area = $("#lostArea").val();
    var date = $("#lostDate").val();
    var details = $("#contentTextarea").val();
    var open = $("#checkbox1").is(":checked") ? 0 : 1111;

    console.log(lostNo);
    console.log(title);
    console.log(item);
    console.log(area);
    console.log(date);
    console.log(details);
    console.log(open);

    if (!$("#fileInput").val() && $(".upimgList img").length > 0) {
      imageUrl1 = $(".upimgList img").attr("src");
    }
    console.log("hj");
    console.log(imageUrl1);

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
      type: "POST",
      url: "/movie/helpDesk/lost_form/" + lostNo,
      data: {
        titleInput: title,
        lostItem: item,
        lostArea: area,
        lostDate: date,
        contentTextarea: details,
        open: open,
        imageUrl1: imageUrl1,
      },
      success: function (response) {
        var lostNo = response.lostNo;
        alert("수정성공");
        var url = `/movie/helpDesk/lost_detail/${lostNo}`;
        location.href = url;
      },
      error: function (xhr, status, error) {
        alert("오류 발생");
      },
    });
  });
});

$(document).ready(function () {
  const deleteLost = $("#deleteLost");

  deleteLost.on("click", function () {
    let lostNo = $(this).data("lostno");
    let cp = $("#cp").val(); // HTML에서 'cp' 값 가져오기

    let url = `/movie/helpDesk/deleteLost/${lostNo}?cp=` + cp;

    if (confirm("정말로 삭제 하시겠습니까?")) {
      window.location.href = url; // get방식으로 url에 요청
    }
  });
});

const updateLost = $("#updateLost");
updateLost.on("click", function () {
  let lostNo = $(this).data("lostno");
  console.log(lostNo);
  let url = `/movie/helpDesk/lost_form/` + lostNo;
  window.location.href = url;
});

$(document).ready(function () {
  const replyDelete = $("#reply_deleteBtn");

  replyDelete.on("click", function () {
    const lostno = $(this).data("lostno");
    const url = `/movie/helpDesk/replyLostDelete/${lostno}`;

    if (confirm(" 답변을 정말로 삭제 하시겠습니까?")) {
      window.location.href = url; // get방식으로 url에 요청
    }
  });
});

$(document).ready(function () {
  const replyWrite = $("#reply_writeBtn");

  replyWrite.on("click", function () {
    const lostNo = $(this).data("lostno");
    const content = $("#contentTextarea").val();
    const url = `/movie/helpDesk/replyLostWrite/${lostNo}`;

    if (confirm("답변을 등록 하시겠습니까?")) {
      $.ajax({
        type: "POST",
        url: url,
        data: { contentTextarea: content },
        success: function (response) {
          var url = `/movie/helpDesk/lost_detail/${lostNo}`;
          location.href = url;
        },
        error: function (error) {
          console.error(error);
        },
      });
    }
  });
});

// 이미지 크게보기
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
