// 이벤트 슬라이더*******************************************************************
$(document).ready(function() {
    var swiper = new Swiper('.event-wrap > div >  .swiper-container', {
        slidesPerView:3,
        spaceBetween: 32,
        navigation: {
            nextEl: '.event-wrap .swiper-button-next',
            prevEl: '.event-wrap .swiper-button-prev',
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
