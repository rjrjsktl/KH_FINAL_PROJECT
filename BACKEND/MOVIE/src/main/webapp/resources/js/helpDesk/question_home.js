$(document).ready(function(){
    $(".btn-quest").click(function(){
    
    $(".btn-wrap button").css({
      "background-color": "#151515",
      "color": "white"
    });

    // 현재 클릭된 버튼의 스타일을 변경합니다.
    $(this).css({
      "background-color": "white",
      "color": "#151515"
    });
    
    
    
        var questNum = $(this).data("quest-num");
        
        $.ajax({
            url: "/movie/helpDesk/question_home",
            type: "POST",
            data: {
                "questNum": questNum
            },
            success: function(response){
                $(".counts").text(response);
            }
        });
    });
});
