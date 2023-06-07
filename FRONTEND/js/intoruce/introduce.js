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
  


  $(".star_rating a").hover(function() {
    $(this).parent().children("a").removeClass("on");
    $(this).addClass("on").prevAll("a").addClass("on");
    // 'on' 클래스 개수 확인
    var numberOfOnClasses = $(this).parent().children("a.on").length;
    console.log(numberOfOnClasses);
    return false;
  });