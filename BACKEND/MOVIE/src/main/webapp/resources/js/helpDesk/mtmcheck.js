
	$(document).ready(function() {
	    $(".btn_wraper button").hover(function() {
	        $(this).find("a").addClass("hover");
	    }, function() {
	        $(this).find("a").removeClass("hover");
	    });
	});


	$(document).ready(function(){
  $('#checkPw-input').on('input', function(){
    var inputValue = $(this).val();
    var regExp = /^\d{4}$/; // 정규표현식: 숫자 4자리

    if(!regExp.test(inputValue)){ // 입력 값이 정규표현식에 부합하지 않는 경우
      $('#pw-checker').text('비밀번호는 숫자 네자리 입니다.');
    } else { // 입력 값이 정규표현식에 부합하는 경우
      $('#pw-checker').text('');
    }
  });
});


$(document).ready(function(){

const gotoDetail = $('#gotoDetail'); 

gotoDetail.on('click', function() {
    console.log("시스템가동준비완료");
    
    var password = $('#checkPw-input').val();
    var mtmNo = $(this).data('mtmno');
    var url = `/movie/helpDesk/checkPw/`+mtmNo;
    
    $.ajax({
        url: url,
        type: 'POST',
        data: {
            'password': password
        },
        success: function(result) {
        
        
        if ( result > 0 ) {
        	 alert("본인이 작성한 글만 봅시다 네?")
        	 var url = `/movie/`;
        	 location.href = url;
        
        }else{
            alert("본인이 작성한 글만 봅시다 네?")
        	 var url = `/movie/`;
        	 location.href = url;
        }
        
        },
        error: function(result) {
             	alert("실패ㅗ");
                }
    });
});

});