// 날짜 슬라이더

var swiper = new Swiper(".mySwiper", {
  slidesPerView: 7,
  spaceBetween: 10,
  touchRatio: 0,  // 드래그 방지. 드래그하려면 1
  // grabCursor: true,
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
});


// 극장 선택 

$('.cinema_list > li > a').click(function(){
  $('#cinema_select').html(this.text);
});


// 영화 선택
/*
const test = $('#movielist_text > li > a');
$(test).on('click', function(event){
  $('#movie_select').html(event.target.find(".movie_name").text);
});
*/

// 테스트 버전입니다. 나중에 제이쿼리로 수정할 것입니다.

document.getElementById("test_seoul").addEventListener("click", function(){
  document.getElementById("seoul_cinema").style.display = 'block';
  document.getElementById("gg_cinema").style.display = 'none';
});

document.getElementById("test_gg").addEventListener("click", function(){
  document.getElementById("seoul_cinema").style.display = 'none';
  document.getElementById("gg_cinema").style.display = 'block';
});



document.getElementById("test_movie1").addEventListener("click", function() {
  document.getElementById("movielist_text").style.display = 'block';
  document.getElementById("movielist_thumb").style.display = 'none';
});

document.getElementById("test_movie2").addEventListener("click", function() {
  document.getElementById("movielist_text").style.display = 'none';
  document.getElementById("movielist_thumb").style.display = 'block';
});


// 날짜 슬라이더 

