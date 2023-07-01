const userNickElement = document.getElementById("userNick");
const userNickValue = userNickElement.value;
console.log(userNickValue);

let urlParams = new URLSearchParams(window.location.search);
let reviewParam = urlParams.get('review');
console.log("reviewParam:::" + reviewParam);

$(document).ready(function () {
  var foldWrap = $(".fold_wrap");
  let foldContent = $(".fold_content");
  var moreBtn = $(".more_btn");
  var isFolded = true;

  moreBtn.click(function () {
    if (isFolded) {
      foldWrap.animate({ height: foldContent.height() }, 200);
      foldWrap.css("overflow", "visible");
      moreBtn.html("접기");
      isFolded = false;
    } else {
      foldWrap.animate({ height: "60px" }, 200);
      foldWrap.css("overflow", "hidden");
      moreBtn.html("더보기");
      isFolded = true;
    }
  });

  var swiper0 = new Swiper(".swiper-container.zeroOne", {
    slidesPerView: 1,
    spaceBetween: 30,
    navigation: {
      nextEl: "main section .swiper-button-next",
      prevEl: "main section .swiper-button-prev",
    },
    loop: true,
  });

  var swiper1 = new Swiper(".swiper-container.first", {
    slidesPerView: 3,
    spaceBetween: 30,
    navigation: {
      nextEl: ".first .swiper-button-next",
      prevEl: ".first .swiper-button-prev",
    },
    loop: true,
  });

  var swiper2 = new Swiper(".swiper-container.second", {
    slidesPerView: 1,
    spaceBetween: 30,
    navigation: {
      nextEl: ".second .swiper-button-next",
      prevEl: ".second .swiper-button-prev",
    },
  });

  $(".swiper-container.first .swiper-slide").each(function (index) {
    $(this).click(function () {
      swiper2.slideTo(index);
    });
  });

  $(".info-btn").click(function () {
    $(".movie-detail").show();
    $(".movie-reply").hide();
    $(".star-btn").css("background", "none");
    $(".star-btn").css("color", "white");
    $(this).css("background", "#d3d3d3");
    $(this).css("color", "black");
  });

  if(reviewParam === "1"){
    console.log("reviewParam=1이라서 실행");
      $(".movie-detail").hide();
      $(".movie-reply").show();
      $(".info-btn").css("background", "none");
      $(".info-btn").css("border", "1px solid #d3d3d3");
      $(".info-btn").css("color", "white");
      $(".star-btn").css("background", "#d3d3d3");
      $(".star-btn").css("color", "black");
      $("#addRevContent").focus();
  }
  updateData();

  function updateData() {
    $(".star-btn").click(function () {
      $(".movie-detail").hide();
      $(".movie-reply").show();
      $(".info-btn").css("background", "none");
      $(".info-btn").css("border", "1px solid #d3d3d3");
      $(".info-btn").css("color", "white");
      $(this).css("background", "#d3d3d3");
      $(this).css("color", "black");
    });
  }
 

  

  $(".star_rating a").click(function () {
    $(this).parent().children("a").removeClass("on");
    $(this).addClass("on").prevAll("a").addClass("on");
    var numberOfOnClasses = $(this).parent().children("a.on").length;
    console.log(numberOfOnClasses);
    return false;
  });

  function addReview() {
    const starRating = document.querySelectorAll(".star_rating .on").length;
    const reviewText = document.querySelector(".replywrite textarea").value;
    var movieNo = document.getElementById("movieNo").value;
    var revNo = $(this).data("revno");
    if (!reviewText) {
      alert("리뷰를 입력해주세요");
      return;
    }

    $.ajax({
      url: "/movie/movieList/detail_List/introduce/" + movieNo,
      type: "POST",
      data: {
        starRating: starRating,
        reviewText: reviewText,
      },
      success: function (result) {
        if (result > 0) {
          alert("리뷰가 등록되었습니다.");
          window.location.href = "/movie/movieList/detail_List/introduce/" + movieNo + "?review=1";
        }
      },
      error: function (xhr, status, error) {
        console.error(error);
      },
    });
  }

  const replyBtn = $(".replyBtn");
  replyBtn.on("click", addReview);

  const loginBtn = $(".loginBtn");
  loginBtn.on("click", function() {
    window.location.href = "/movie/user/login";
  });

  var itemsToShow = 5;
  var cp = 1;
  $(".review").hide().slice(0, itemsToShow).show();
  $(".morePage").on("click", function () {
    cp += 1;
    var movieNo = document.getElementById("movieNo").value;
    $.ajax({
      url: "/movie/movieList/detail_List/introduce/" + movieNo + "/" + cp,
      type: "GET",
      success: function (data) {
        data.forEach(function (review) {
          const li = $(document.createElement("li"));
          var userNo = document.getElementById("userNo").value;
          var userMst = document.getElementById("userMst").value;

          console.log(userMst);
          let deleteButton = "";
          li.addClass("review");
          console.log("userNo:", userNo);
          console.log("review.userNo:", review.userNo);

          if (userNo == review.userNo || userMst == 'Y') {
            deleteButton = `<div><button class="deleteReview" data-revno="${review.revNo}">Delete</button></div>`;
          } else {
            deleteButton = "<div></div>";
          }

          li.html(`
                        <div class="rvWrap">
                            <div class="user_info">
                                <img src="" alt="">
                                <p>${review.userNick}</p>
                            </div>
                            <div class="review_content">
                                <div>리뷰</div>
                                <div>${review.revLike}</div>
                                <div>${review.revContent}</div>
                                ${deleteButton}
                            </div>
                        </div>
                    `);
          li.hide(); // initially hide the li
          const replyList = $(".replyList ul");
          replyList.append(li);
          li.slideDown(); // animate to show the li
        });
      },
      error: function (xhr, status, error) {
        console.error(error);
      },
    });
  });

  $(document).on("click", ".deleteReview", function () {
    var movieNo = document.getElementById("movieNo").value;
    var revNo = $(this).data("revno");
    $.ajax({
      url: "/movie/movieList/detail_List/introduce/deleteReview/" + revNo,
      type: "POST",
      success: function (data) {
        alert("리뷰가 삭제되었습니다.");
        window.location.href = movieNo;
      },
      error: function (xhr, status, error) {
        alert("오류가 발생되었습니다.");
      },
    });
  });
});
function goBack() {
  history.back();
}
