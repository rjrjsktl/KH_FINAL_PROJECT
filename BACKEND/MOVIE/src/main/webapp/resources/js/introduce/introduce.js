const userNickElement = document.getElementById("userNick");
const userNickValue = userNickElement.value;
console.log(userNickValue);

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

  $(".star-btn").click(function () {
    $(".movie-detail").hide();
    $(".movie-reply").show();
    $(".info-btn").css("background", "none");
    $(".info-btn").css("border", "1px solid #d3d3d3");
    $(".info-btn").css("color", "white");
    $(this).css("background", "#d3d3d3");
    $(this).css("color", "black");
  });

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

    $.ajax({
      url: "/movie/movieList/detail_List/introduce/" + movieNo,
      type: "POST",
      data: {
        starRating: starRating,
        reviewText: reviewText,
      },
      success: function (data) {
        const li = document.createElement("li");

        li.innerHTML = `
              <div class="rvWrap">
                  <div class="user_info">
                      <img src="" alt="">
                      <p>${userNickValue}</p>
                  </div>
                  <div class="review_content">
                      <div>관람평</div>
                      <div>${starRating}</div>
                      <div>${reviewText}</div>
                  </div>
              </div>
              `;

        const replyList = document.querySelector(".replyList ul");
        replyList.prepend(li);

        document.querySelector(".replywrite textarea").value = "";
      },
      error: function (xhr, status, error) {
        console.error(error);
      },
    });
  }
  const addRevContent = document.getElementById("addRevContent");
  const replyBtn = document.querySelector(".replyBtn");
  replyBtn.addEventListener("click", function(){
   if(addRevContent.value.trim().length == 0) {
    alert("리뷰를 작성해 주세요.");
    addRevContent.focus();
   } else {
    confirm("리뷰를 등록하시겠습니까?");
    addReview();
   }
  });
  

  var itemsToShow = 5;

  $(".review").hide().slice(0, itemsToShow).show();

  $(".morePage").on("click", function () {
    itemsToShow += 5;
    $(".review").slice(0, itemsToShow).slideDown();
  });

  let imgs = document.querySelectorAll(".swiper-slide img");

  imgs.forEach((item) => {
    if (item.getAttribute("src") === "") {
      item.parentNode.remove();
      item.parentElement.remove();
    }
  });
});

function goBack() {
  history.back();
}
