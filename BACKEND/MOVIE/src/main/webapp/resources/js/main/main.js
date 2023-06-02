function zoomIn(event) {
    event.target.style.transform = "scale(1.05)"; //1.2배 확대
    event.target.style.zIndex = 1;
    event.target.style.transition = "all 0.5s";// 속도
}
  function zoomOut(event) {
    event.target.style.transform = "scale(1)";
    event.target.style.zIndex = 0;
    event.target.style.transition = "all 0.5s";
}

// 메인 이미지 무한 슬라이더************************************************************
$(document).ready(function() {
    var swiper = new Swiper('main section:nth-of-type(1) .swiper-container', {
        slidesPerView : 1,
        spaceBetween: 100,
        navigation: {
            nextEl: ' main section:nth-of-type(1) .swiper-button-next',
            prevEl: ' main section:nth-of-type(1) .swiper-button-prev',
        },
        autoplay: {
            delay: 10000,
            disableOnInteraction: false,
        },
        loop: true,  // Enable infinite sliding
    });
    swiper.el.addEventListener('mouseenter', function () {
    swiper.autoplay.stop();
   });
   swiper.el.addEventListener('mouseleave', function () {
    swiper.autoplay.start();
   });
});
// 메인 이미지 무한 슬라이더************************************************************


// 상영목록 슬라이더*******************************************************************
$(document).ready(function() {
var swiper = new Swiper('main section:nth-of-type(2) .swiper-container', {
    slidesPerView:4,
    spaceBetween: 32,
    navigation: {
        nextEl: 'main section:nth-of-type(2) .swiper-button-next',
        prevEl: 'main section:nth-of-type(2) .swiper-button-prev',
    },
    
   
    touchMoveStopPropagation: false,  
    touchReleaseOnEdges: false,  
    threshold: 20,  // 일정 거리를 조절하는 값
    on: {
        touchEnd: function () {
            if (this.snapIndex === this.previousIndex) {
                swiper.slideTo(this.snapIndex);
            }
        },
    },
    
});
});
// 상영목록 슬라이더*******************************************************************


// 이벤트 슬라이더*******************************************************************
$(document).ready(function() {
    var swiper = new Swiper('main section:nth-of-type(3) > div >  .swiper-container', {
        slidesPerView:3,
        spaceBetween: 32,
        navigation: {
            nextEl: 'main section:nth-of-type(3) .swiper-button-next',
            prevEl: 'main section:nth-of-type(3) .swiper-button-prev',
        },
       
        touchMoveStopPropagation: false,  
        touchReleaseOnEdges: false,  
        threshold: 20,  // 일정 거리를 조절하는 값
        on: {
            touchEnd: function () {
                if (this.snapIndex === this.previousIndex) {
                    swiper.slideTo(this.snapIndex);
                }
            },
        },
        autoplay: {
            delay: 10000,
            disableOnInteraction: false,
        },
    });
    swiper.el.addEventListener('mouseenter', function () {
    swiper.autoplay.stop();
   });
   swiper.el.addEventListener('mouseleave', function () {
    swiper.autoplay.start();
   });
    });

// 이벤트 슬라이더*******************************************************************
// 슬라이더 끗-


// --------------------------------------------------------------------------------
// 구현해야할 JS 리스트


// 1. for문 배열 돌려서..............................
//    해당클래스에 해당하는 특별관들 display:none


$(document).ready(function() {
    var theater = $(".stheater");
    var rightSide = $('.deleteUnderline');

    var lastActiveTheater = theater.first();  // 마지막으로 활성화된 stheater
    var lastActiveUnderline = null; // 마지막으로 활성화된 underline
 
    theater.css("display", "none");
    theater.first().css("display", "block");

    for(var i = 0; i < theater.length; i++){
        (function(i) {
            var underlineSpan = $(rightSide[i]).children('span').first();
            
            $(rightSide[i]).on("mouseenter", function() {
                theater.css("display", "none");
                $(theater[i]).css("display", "block");
                // 마지막에 활성화된 
                if(lastActiveUnderline && lastActiveUnderline !== $(rightSide[i])) {
                    lastActiveUnderline.css("border-radius", "0px");
                    lastActiveUnderline.css("border-left", "0px");
                    lastActiveUnderline.css("border-right", "0px");
                    lastActiveUnderline.css("border-bottom", "0px");
                    lastActiveUnderline.children('span').first().css("font-weight","normal");
                   
                }

                underlineSpan.css("font-weight","bold");
                $(rightSide[i]).css("border", "1px solid #a3a3a3");  // 4면 border 추가
                $(rightSide[i]).css("border-radius", "10px");  // 4면 border 추가
                $(rightSide[i+1]).css("border-top", "none");  // 4면 border 추가
                lastActiveTheater = $(theater[i]);  // 마지막으로 활성화된 stheater를 업데이트
                lastActiveUnderline = $(rightSide[i]); // 마지막으로 활성화된 underline 업데이트
            });

       
        })(i);
    }
});

// 즉시 실행 함수(속도 빠름, 변수명 중복 문제 해결)
(function(){
    selectAll(); // 함수 호출 -> 회원 목록을 먼저 조회
	window.console.log("slectAll 실행")
    //window.setInterval(함수, 딜레이(ms))
    window.setInterval(selectAll, 10000); // 10초
    // 함수 이름만 작성 -> 함수 코드가 대입
    // -> 10초마다 selectAll 함수 수행

    // setInterval()은 지연 -> 수행 -> 지연 -> 수행 ... 반복
    // --> 처음에 함수가 수행되지 않아서 공백인 상태가 있음

})();

