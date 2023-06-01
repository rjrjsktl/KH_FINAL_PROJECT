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

<<<<<<< HEAD
var swipers = new Swiper('.mainImg-container', {
    slidesPerView:1,
    spaceBetween: 32,
    navigation: {
        nextEl: '.swiper-main-next',
        prevEl: '.swiper-main-prev',
    },
    touchMoveStopPropagation: false,  
    touchReleaseOnEdges: false,  
    threshold: 20,  
    on: {
        touchEnd: function () {
            if (this.snapIndex === this.previousIndex) {
                swipers.slideTo(this.snapIndex);
            }
=======

// 메뉴창 하버
$(document).ready(function() {
    $('.navBar, .dummy').hover(
        function() {
            $('.navBar ul').stop().slideDown(150); 
            $('.dummy').css('display', 'flex'); 
>>>>>>> 0728a5e5e144ea625939e31f9622d61e77164d2d
        },
    },
});




var swiper = new Swiper('.swiper-container', {
    slidesPerView:4,

    spaceBetween: 32,
    navigation: {
        nextEl: '.swiper-card-next',
        prevEl: '.swiper-card-prev',
    },
    pagination: {
        el: '.swiper-pagination',
        clickable: false,
    },
<<<<<<< HEAD
=======

>>>>>>> 0728a5e5e144ea625939e31f9622d61e77164d2d
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

      
      
      
      

