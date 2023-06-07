$(document).ready(function() {
    var foldWrap = $('.fold_wrap');
    var moreBtn = $('.more_btn');
  
    moreBtn.click(function() {
      if (foldWrap.height() === 59) {
        foldWrap.animate({height: '100%'}, 200);
      } else {
        foldWrap.animate({height: '59px'}, 200);
      }
    });
  });




  $(document).ready(function() {
    var swiper = new Swiper('.swiper-container', {
      slidesPerView: 3,
      spaceBetween: 20,
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
      loop: true,
      on: {
        slideChange: function() {
          var currentIndex = this.activeIndex;
          var currentImage = $('.swiper-slide:eq(' + currentIndex + ') img').attr('src');
          $('.swiper-detail img').attr('src', currentImage);
        }
      }
    });
  });


  $('.info-btn').click(function() {
    $('.movie-detail').show();
    $('.movie-reply').hide();
    $(this).css('background','red');
    $('.star-btn').css('background','none')
  });

  $('.star-btn').click(function() {
    $('.movie-detail').hide();
    $('.movie-reply').show();
    $(this).css('background','red');
    $('.info-btn').css('background','none')
  });
  


  $(".star_rating a").click(function() {
    $(this).parent().children("a").removeClass("on");
    $(this).addClass("on").prevAll("a").addClass("on");
    // 'on' 클래스 개수 확인
    var numberOfOnClasses = $(this).parent().children("a.on").length;
    console.log(numberOfOnClasses);
    return false;
  });


  function addReview() {
    // star_rating에서 "on" 클래스를 가진 요소의 개수를 가져옴
    const starRating = document.querySelectorAll('.star_rating .on').length;
    
    // text-area의 내용을 가져옴
    const reviewText = document.querySelector('.replywrite textarea').value;
    
    // 새로운 li 요소 생성
    const li = document.createElement('li');
    
    // li 요소 내용 작성
    li.innerHTML = `
      <span><img src="" alt="이미지"></span>
      <div>
        <span>씨*럼</span>
        <span>2023.05.24</span>
        <span>${'★'.repeat(starRating)}</span>
        <span>${starRating}</span>
      </div>
      <div>${reviewText}</div>
    `;
    
    // replyList에 li 요소 추가
    const replyList = document.querySelector('.replyList ul');
    replyList.appendChild(li);
    
    // text-area 초기화
    document.querySelector('.replywrite textarea').value = '';
  }
  
  // 버튼 클릭 이벤트 연결
  const replyBtn = document.querySelector('.replyBtn');
  replyBtn.addEventListener('click', addReview);