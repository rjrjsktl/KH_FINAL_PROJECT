$(document).ready(function() {
    // 이벤트 위임을 사용해 동적으로 생성된 요소들에 대한 이벤트를 처리합니다.
    $('#questListContainer').on('click', '.qList', function() {
        var qListDetail = $(this).next('.qList_detail');
        
        if (qListDetail.hasClass('none')) {
            $('.qList_detail').slideUp().addClass('none').removeClass('block');
            qListDetail.slideDown().removeClass('none').addClass('block');
        } else {
            qListDetail.slideUp().removeClass('block').addClass('none');
        }
    });
});

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
		$(".counts").text(response.qescount);
		$('#questListContainer').empty();
		

		var questListHtml = '';
		$.each(response.questList.questList, function(index, quest) {
			if (index < 10) {
				questListHtml += '<li><div class="qList"><p>' + quest.questType + '</p><p><span><strong>Q</strong> ' + quest.questTitle + '</span> <span><i class="fa-solid fa-chevron-down"></i></span></p></div><ul class="qList_detail none"><li>' + quest.questContent + '</li></ul></li>';
			}
		});
		$('#questListContainer').html(questListHtml);
		
	    // Pagination 처리
    if (questNum == 0) {
        var paginationHtml = '';
        var pagination = response.questList.pagination;
        var url = "?cp=";

        paginationHtml += '<div><a href="' + url + '1">&lt;&lt;</a></div>';
        paginationHtml += '<div><a href="' + url + pagination.prevPage + '">&lt;</a></div>';

        for (var i = pagination.startPage; i <= pagination.endPage; i++) {
            if (i === pagination.currentPage) {
                paginationHtml += '<div><a class="selected_Cp">' + i + '</a></div>';
            } else {
                paginationHtml += '<div><a href="' + url + i + '">' + i + '</a></div>';
            }
        }

        paginationHtml += '<div><a href="' + url + pagination.nextPage + '">&gt;</a></div>';
        paginationHtml += '<div><a href="' + url + pagination.maxPage + '">&gt;&gt;</a></div>';

        $('.page_Nation').html(paginationHtml);
    } else {
        $('.page_Nation').empty();
    }
		
	}
});
    });
});
