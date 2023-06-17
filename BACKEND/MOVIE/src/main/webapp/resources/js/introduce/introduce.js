$(document).ready(function () {
  var foldWrap = $('.fold_wrap');
  var moreBtn = $('.more_btn');
  var isFolded = true; // 초기 상태는 접혀있음으로 설정

  moreBtn.click(function () {
    if (isFolded) {
      foldWrap.animate({ height: '30vh' }, 200);
      foldWrap.css('overflow', 'visible');
      moreBtn.html('접기');
      isFolded = false; // 상태를 펼쳐진 상태로 업데이트
    } else {
      foldWrap.animate({ height: '60px' }, 200);
      foldWrap.css('overflow', 'hidden');
      moreBtn.html('더보기');
      isFolded = true; // 상태를 접혀진 상태로 업데이트
    }

  });

  var swiper0 = new Swiper('.swiper-container.zeroOne', {
    slidesPerView: 1,
    spaceBetween: 30,
    navigation: {
      nextEl: 'main section .swiper-button-next',
      prevEl: 'main section .swiper-button-prev',
    },
    loop: true
  });


  var swiper1 = new Swiper('.swiper-container.first', {
    slidesPerView: 3,
    spaceBetween: 30,
    navigation: {
      nextEl: '.first .swiper-button-next',
      prevEl: '.first .swiper-button-prev',
    }
  });

  var swiper2 = new Swiper('.swiper-container.second', {
    slidesPerView: 1,
    spaceBetween: 30,
    navigation: {
      nextEl: '.second .swiper-button-next',
      prevEl: '.second .swiper-button-prev',
    },
  });
  $('.swiper-container.first .swiper-slide').each(function (index) {
    $(this).click(function () {
      swiper2.slideTo(index);
    });
  });



  $('.info-btn').click(function () {
    $('.movie-detail').show();
    $('.movie-reply').hide();
    $('.star-btn').css('background', 'none');
    $('.star-btn').css('color', 'white');
    $(this).css('background', '#d3d3d3');
    $(this).css('color', 'black');

  });

  $('.star-btn').click(function () {
    $('.movie-detail').hide();
    $('.movie-reply').show();
    $('.info-btn').css('background', 'none')
    $('.info-btn').css('border', '1px solid #d3d3d3');
    $('.info-btn').css('color', 'white');
    $(this).css('background', '#d3d3d3');
    $(this).css('color', 'black');

  });



  $(".star_rating a").click(function () {
    $(this).parent().children("a").removeClass("on");
    $(this).addClass("on").prevAll("a").addClass("on");
    // 'on' 클래스 개수 확인
    var numberOfOnClasses = $(this).parent().children("a.on").length;
    console.log(numberOfOnClasses);
    return false;
  });


  function addReview() {
    const starRating = document.querySelectorAll('.star_rating .on').length;

    const reviewText = document.querySelector('.replywrite textarea').value;

    const li = document.createElement('li');

    const filledStars = '★'.repeat(starRating);
    const emptyStars = '☆'.repeat(5 - starRating);

    li.innerHTML =
      `
      <span><img src="" alt=""></span>
      <div>
        <span></span>
        <span>2023.05.24</span>
        <span>${filledStars}${emptyStars}</span>
        <span>${starRating}</span>
      </div>
      <div>${reviewText}</div>
    `;

    const replyList = document.querySelector('.replyList ul');
    replyList.prepend(li);

    document.querySelector('.replywrite textarea').value = '';
  }

  const replyBtn = document.querySelector('.replyBtn');
  replyBtn.addEventListener('click', addReview);
  var itemsToShow = 5;

  $('.review').slice(0, itemsToShow).show();

  $('.morePage').on('click', function () {
    itemsToShow++;
    $('.review').slice(0, itemsToShow).slideDown();
  });


});

function goBack() {
  history.back();
}