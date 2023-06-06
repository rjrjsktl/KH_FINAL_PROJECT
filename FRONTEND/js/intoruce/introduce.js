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


$(document).ready(function(){
	
    modal = $('#modal');

    $('#loginBtn').click(function(){
        
		modal.css('display','flex');
		
	});
})

