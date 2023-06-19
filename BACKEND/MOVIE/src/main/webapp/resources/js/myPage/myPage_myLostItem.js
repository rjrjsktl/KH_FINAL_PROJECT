// innerTable을 누르면 그 속에 있는 input으로 이동하기 기능
$(document).ready(function() {
    $(".innerTable tr").click(function(){
        $(this).find("input").focus();
    });
});


