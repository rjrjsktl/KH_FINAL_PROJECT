function zoomIn(event) {
  event.target.style.transform = "scale(1.05)"; //1.2배 확대
  event.target.style.zIndex = 1;
  event.target.style.transition = "all 0.5s"; // 속도
}
function zoomOut(event) {
  event.target.style.transform = "scale(1)";
  event.target.style.zIndex = 0;
  event.target.style.transition = "all 0.5s";
}

// 메인 이미지 무한 슬라이더************************************************************
$(document).ready(function () {
  var swiper = new Swiper("main section:nth-of-type(1) .swiper-container", {
    slidesPerView: 1,
    spaceBetween: 100,
    navigation: {
      nextEl: " main section:nth-of-type(1) .swiper-button-next",
      prevEl: " main section:nth-of-type(1) .swiper-button-prev",
    },
    autoplay: {
      delay: 10000,
      disableOnInteraction: false,
    },
    loop: true, // Enable infinite sliding
  });
  swiper.el.addEventListener("mouseenter", function () {
    swiper.autoplay.stop();
  });
  swiper.el.addEventListener("mouseleave", function () {
    swiper.autoplay.start();
  });
});
// 메인 이미지 무한 슬라이더************************************************************

// 상영목록 슬라이더*******************************************************************
$(document).ready(function () {
  var swiper = new Swiper("main section:nth-of-type(2) .swiper-container", {
    slidesPerView: 4,
    spaceBetween: 32,
    navigation: {
      nextEl: "main section:nth-of-type(2) .swiper-button-next",
      prevEl: "main section:nth-of-type(2) .swiper-button-prev",
    },

    touchMoveStopPropagation: false,
    touchReleaseOnEdges: false,
    threshold: 20, // 일정 거리를 조절하는 값
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
$(document).ready(function () {
  var swiper = new Swiper(
    "main section:nth-of-type(3) > div >  .swiper-container",
    {
      slidesPerView: 3,
      spaceBetween: 32,
      navigation: {
        nextEl: "main section:nth-of-type(3) .swiper-button-next",
        prevEl: "main section:nth-of-type(3) .swiper-button-prev",
      },

      touchMoveStopPropagation: false,
      touchReleaseOnEdges: false,
      threshold: 20, // 일정 거리를 조절하는 값
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
    }
  );
  swiper.el.addEventListener("mouseenter", function () {
    swiper.autoplay.stop();
  });
  swiper.el.addEventListener("mouseleave", function () {
    swiper.autoplay.start();
  });
});

// 이벤트 슬라이더*******************************************************************
// 슬라이더 끗-

// --------------------------------------------------------------------------------
// 구현해야할 JS 리스트

// 1. for문 배열 돌려서..............................
//    해당클래스에 해당하는 특별관들 display:none

$(document).ready(function () {
  var theater = $(".stheater");
  var rightSide = $(".deleteUnderline");

  var lastActiveTheater = theater.first();
  var lastActiveUnderline = null;

  theater.css("display", "none");
  theater.first().css("display", "block");

  for (var i = 0; i < theater.length; i++) {
    (function (i) {
      var underlineSpan = $(rightSide[i]).children("span").first();

      $(rightSide[i]).on("mouseenter", function () {
        // If there was a previously active underline, reset its styles
        if (lastActiveUnderline) {
          var lastUnderlineSpan = lastActiveUnderline.children("span").first();
          lastUnderlineSpan.css("font-weight", "normal");
          lastActiveUnderline.css("border", "none");
          if (i > 0) {
            // For non-first elements, also reset the border-top
            $(rightSide[i - 1]).css("border-bottom", "none");
          }
        }

        theater.css("display", "none");
        $(theater[i]).css("display", "block");

        underlineSpan.css("font-weight", "bold");
        $(rightSide[i]).css("border", "3px solid #a3a3a3");
        $(rightSide[i]).css("border-radius", "10px");
        $(rightSide[i + 1]).css("border-top", "none");

        lastActiveTheater = $(theater[i]); // 마지막으로 활성화된 stheater를 업데이트
        lastActiveUnderline = $(rightSide[i]); // 마지막으로 활성화된 underline 업데이트
      });
    })(i);
  }
});
