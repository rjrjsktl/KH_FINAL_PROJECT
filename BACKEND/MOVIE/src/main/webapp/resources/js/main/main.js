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

// 메뉴창 슬라이더
$(document).ready(function () {
    $('.navBar, .dummy').hover(
        function () {
            $('.navBar ul').stop().slideDown(0);
            $('.dummy').css('display', 'flex');
        },
        function () {
            $('.navBar ul').stop().slideUp(0);
            $('.dummy').css('display', 'none');
        }
    );
});

// 메인 이미지 슬라이더
// $(document).ready(function() {
//     var slideIndex = 0;
//     var timer = null; 
//     var startX = 0;
//     var endX = 0;

//     function showSlides() {
//         var slides = $(".mySlides");
//         slides.css("display", "none");
//         slideIndex++;
//         if (slideIndex > slides.length) {slideIndex = 1}
//         slides.eq(slideIndex-1).css("display", "block");
//         clearTimeout(timer);
//         timer = setTimeout(showSlides, 10000);
//     }
//     showSlides();

//     $(".prev, .next").click(function() {
//         changeSlides($(this).hasClass('prev') ? -1 : 1);
//     });

//     function changeSlides(n) {
//         var slides = $(".mySlides");
//         slideIndex += n;
//         if (slideIndex < 1) { slideIndex = slides.length }
//         if (slideIndex > slides.length) { slideIndex = 1 }
//         slides.css("display", "none");
//         slides.eq(slideIndex-1).css("display", "block");
//         clearTimeout(timer);
//         timer = setTimeout(showSlides, 10000);
//     }

//     $(".mySlides").on('mousedown', function(e) {
//         e.preventDefault();
//         startX = e.pageX;
//     });

//     $(".mySlides").on('mouseup', function(e) {
//         e.preventDefault();
//         endX = e.pageX;
//         var difference = startX - endX;
//         if(Math.abs(difference) > 50) {
//             if (difference > 0) {
//                 changeSlides(1); 
//             } else {
//                 changeSlides(-1); 
//             }
//         }
//     });
// });


var swipers = new Swiper('.mainImg-container', {
    slidesPerView: 1,
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
        },
    },
});




var swiper = new Swiper('.swiper-container', {
    slidesPerView: 4,
    spaceBetween: 32,
    navigation: {
        nextEl: '.swiper-card-next',
        prevEl: '.swiper-card-prev',
    },
    pagination: {
        el: '.swiper-pagination',
        clickable: false,
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


