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

$(document).ready(function () {
  var swiper = new Swiper(".swiper-container", {
    slidesPerView: 3,

    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },

    touchMoveStopPropagation: false,
    touchReleaseOnEdges: false,
    threshold: 10, // 일정 거리를 조절하는 값
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
    loop: true,
  });
  swiper.el.addEventListener("mouseenter", function () {
    swiper.autoplay.stop();
  });
  swiper.el.addEventListener("mouseleave", function () {
    swiper.autoplay.start();
  });
});

$(document).ready(function () {
  $(".location").click(function () {
    $(this).parent().css("background-color", "#484848");
    $(this).css("color", "#FCC400");
    $(".location").not(this).parent().css("background-color", "transparent");
    $(".location").not(this).css("color", "white");
  });

  function getCinemaNames(area) {
    $.ajax({
      url: "/movie/theater/normalTheater/selectArea",
      type: "GET",
      data: { area: area },
      success: function (response) {
        // clear cname-wrap
        $(".cname-wrap").empty();
        // iterate over response.cinemaNameList
        for (var i = 0; i < response.cinemaNameList.length; i++) {
          // create new anchor element with cinema name and href attribute
          var cinemaNameAnchor = $("<a class='gogo'></a>")
            .attr("href", "/movie/reserve/choicePlay")
            .text(response.cinemaNameList[i].cinemaName + "점");
          // create new span element and append the anchor
          var cinemaNameSpan = $("<span></span>").append(cinemaNameAnchor);
          // append span to cname-wrap
          $(".cname-wrap").append(cinemaNameSpan);
        }
      },
      error: function () {},
    });
  }

  $(".location").click(function () {
    var area = $(this).text();
    getCinemaNames(area);
  });

  var firstArea = $(".location").first().text();
  getCinemaNames(firstArea);
});
