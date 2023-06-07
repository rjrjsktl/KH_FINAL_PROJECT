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
        height: 540, // 에디터 높이 
        minHeight: null, // 최소 높이 
        maxHeight: null, // 최대 높이 
        lang: "ko-KR", //한글 설정 
        placeholder: '최대 2048자까지 쓸 수 있습니다', //placeholder 설정 
        disableResizeEditor: true,
        focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부

        callbacks: {
            onImageUpload: function (files, editor, welEditable) {
                for (var i = files.length - 1; i >= 0; i--) {
                    sendFile(files[i], this);
                }
            }
        }
    });

    function sendFile(file, el) {
        var form_data = new FormData();
        form_data.append('file', file);
        $.ajax({
            data: form_data,
            type: "POST",
            url: '/imgUpload',
            cache: false,
            contentType: false,
            enctype: 'multipart/form-data',
            processData: false,
            success: function (img_name) {
                //항상 업로드된 파일의 url이 있어야 한다.
                $(el).summernote('editor.insertImage', img_name);
            }
        });
    }
});

const tableBtn = $('.table_bottom');
const eventTitle = $('.enter_Title > input');
const textArea = $('#summernote');

tableBtn.on('click', () => {
    console.log(eventTitle.val());
    console.log(textArea.val());

});


// =========================================================================

$('#summernote').summernote({
    height: 300,                 // 에디터 높이
    minHeight: null,             // 최소 높이
    maxHeight: null,             // 최대 높이
    focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
    lang: "ko-KR",					// 한글 설정
    placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
    callbacks: {	//여기 부분이 이미지를 첨부하는 부분
        onImageUpload: function (files) {
            uploadSummernoteImageFile(files[0], this);
        },
        onPaste: function (e) {
            var clipboardData = e.originalEvent.clipboardData;
            if (clipboardData && clipboardData.items && clipboardData.items.length) {
                var item = clipboardData.items[0];
                if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
                    e.preventDefault();
                }
            }
        }
    }
});



/**
* 이미지 파일 업로드
*/
function uploadSummernoteImageFile(file, editor) {
    data = new FormData();
    data.append("file", file);
    $.ajax({
        data: data,
        type: "POST",
        url: "/uploadSummernoteImageFile",
        contentType: false,
        processData: false,
        success: function (data) {
            //항상 업로드된 파일의 url이 있어야 한다.
            $(editor).summernote('insertImage', data.url);
        }
    });
}