$(document).ready(function () {

  $('#summernote').summernote({
    toolbar: [
      //글씨 사이즈, 폰트 선택
      ['fontsize', ['fontsize', 'fontname']],
      //정렬 
      ['para', ['ul', 'ol', 'paragraph']],
      //글씨체 굵게, 기울임, 밑줄, 지우기, 색상
      ['style', ['bold', 'italic', 'underline', 'clear', 'color']],
      //글씨 취소선, 위에, 아래
      ['font', ['strikethrough', 'superscript', 'subscript']],
      // 되돌리기, 되살리기
      ['undo', ['undo', 'redo']],
      // 이미지
      ['picture', ['picture']],
      // 테이블, 코드 뷰
      ['table', ['table', 'codeview']],
      //줄 높이 
      ['height', ['height']]],
    height: 450, // 에디터 높이 
    minHeight: null, // 최소 높이 
    maxHeight: null, // 최대 높이 
    lang: "ko-KR", //한글 설정 
    placeholder: '최대 2048자까지 쓸 수 있습니다', //placeholder 설정 
    disableResizeEditor: true,
    focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부

    fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', '맑은 고딕', '궁서', '굴림체', '굴림', '돋움체', '바탕체'],
    fontSizes: ['8', '9', '10', '11', '12', '14', '16', '18', '20', '22', '24', '28', '30', '36', '50', '72'],
    callbacks: {
      onImageUpload: function (files, editor, welEditable) {

        // 파일 업로드(다중업로드를 위해 반복문 사용)
        for (var i = files.length - 1; i >= 0; i--) {
          uploadImageFile(files[i], this);
        }
      }
    }
  });
  const jsonArray = [];

  function uploadImageFile(file, el) {
    var data = new FormData();
    data.append("file", file);
    $.ajax({
      url: 'event_add/uploadImageFile',
      type: "POST",
      enctype: 'multipart/form-data',
      data: data,
      cache: false,
      contentType: false,
      processData: false,
      success: function (data) {
        var json = JSON.parse(data);
        $(el).summernote('editor.insertImage', json["url"]);
        jsonArray.push(json["url"]);
        jsonFn(jsonArray);
      },
      error: function (e) {
        console.log(e);
      }
    });
  }

  function jsonFn(jsonArray) {
    console.log(jsonArray);
  }

  let fileInput = $("#fileInput");

  fileInput.on("change", function (e) {
    console.log(e.target.files); // 파일 목록 출력

    // 파일 업로드(다중업로드를 위해 반복문 사용)
    for (var i = 0; i < e.target.files.length; i++) {


      if (!checkExtension(e.target.files[i].name, e.target.files[i].size)) {
        movie_image1.val('');
        return false;
      }
      uploadImageFile1(e.target.files[i]); // 파일 전달
    }
  });

  let regex = new RegExp("(.*?\.(png|jpg|gif|jpeg)$)");
  let maxSize = 5000000; // 5MB 제한

  function checkExtension(fileName, fileSize) {
    if (fileSize >= maxSize) {
      alert("파일 사이즈 초과");
      return false;
    }
    if (!regex.test(fileName)) {
      alert("해당 종류 파일은 업로드 안됨.\n PNG, JPG, GIF, JPEG 만 가능합니다.");
      return false;
    }
    return true;
  };

  let imageUrl1;

  function uploadImageFile1(file) {
    var data = new FormData();
    data.append("file", file);
    $.ajax({
      url: 'uploadImage',
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
      }
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
    // var title = $("#titleInput").val();
    // var inquiry = $("#inquirySelect").val();
    // var content = $("#contentTextarea").val();
    // var userNo = $("#userNo").val();
    // var open = $("#checkbox1").is(":checked") ? 0 : 1111;

    // // Check the inputs
    // if (!title) {
    //   alert("제목을 입력해주세요");
    //   e.preventDefault(); // Prevent the form from submitting
    //   return;
    // }
    // if (!inquiry || inquiry === "문의 내용을 선택해주세요.") {
    //   alert("문의종류를 선택해주세요");
    //   e.preventDefault(); // Prevent the form from submitting
    //   return;
    // }
    // if (!content) {
    //   alert("내용을 입력해주세요");
    //   e.preventDefault(); // Prevent the form from submitting
    //   return;
    // }

    // $.ajax({
    //   type: "POST",
    //   url: "/movie/helpDesk/mTm_form",
    //   data: {
    //     titleInput: title,
    //     inquirySelect: inquiry,
    //     contentTextarea: content,
    //     userNo: userNo,
    //     open: open,
    //   },
    //   success: function (response) {
    //     var mtmNo = response.mtmNo; // mtmNo 값을 가져옵니다.
    //     alert("작성성공");
    //     var url = `/movie/helpDesk/mtm_detail/${mtmNo}`;
    //     location.href = url;
    //   },
    //   error: function (xhr, status, error) {
    //     alert("오류 발생");
    //   },
    // });
  });
});