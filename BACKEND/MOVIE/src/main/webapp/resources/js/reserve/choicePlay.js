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


// 날짜 초기화
// 공휴일과 음력 명절은 자바 공휴일 api로 처리할 수 있으므로
// 날짜 초기화는 java로 변경하겠습니다.

let date = new Date();
let weeks = ['일', '월', '화', '수', '목', '금', '토'];

$('.swiper-slide.date').each(function(index, item){
  $(this).attr('data-month', date.getMonth()+1);  // 월
  $(this).attr('data-date', date.getDate());      // 일
  $(this).attr('data-day', weeks[date.getDay()]); // 요일
  $(this).text(date.getDate());

  if(date.getDay() == 6 || date.getDay() == 0) {
    $(this).addClass("holiday");
  }

  date.setDate(date.getDate()+1);
});


// 날짜 선택

let today = new Date();
let playDay = (today.getMonth()+1) + "월 " + today.getDate() + "일 " + weeks[today.getDay()] + "요일";

$('.swiper-slide.date').on("click", function(){
  playDay = $(this).data('month') + "월 ";
  playDay += $(this).data('date') + "일 ";
  playDay += $(this).data('day') + "요일";
  $('#play_select').html(playDay);
});



// 지역 선택

let region = $('#region_list > li > a');
let regionName;

region.on("click", function(){
  regionName = this.text.substr(0, 2);
  $('.cinema_list').css('display', 'none');
  $(`.cinema_list[data-region=${regionName}]`).css('display', 'block');
});


// 극장 선택 

let cinema = $('.cinema_list > li > a');
let cinemaName = "강남"; // 디폴트 값은 본사

cinema.on("click", function(){
  cinemaName = this.text;
  $('#cinema_select').html(cinemaName);
});


// 영화 리스트 버전 선택

$('#movie_option1').on("click", function(){
  $("#movielist_text").css('display', 'block');
  $("#movielist_thumb").css('display', 'none');
});

$('#movie_option2').on("click", function(){
  $("#movielist_text").css('display', 'none');
  $("#movielist_thumb").css('display', 'block');
});


// 영화 선택

let movie = $('.movielist > li > a');
let movieName;

movie.on("click", function(){
  movieName = this.querySelector('.movie_name').innerText;
  $('#movie_select').html(movieName);
  $('.movie_play').css('display', 'none');
  $(`.movie_play[data-movie="${movieName}"]`).css('display', 'block');
});


// 상영 선택

let play = $('.playlist > li > a');
let openHour;
let openMinute;
let cinemaRoom;

play.on("click", function(){
  movieName = $(this).closest("[data-movie]").data('movie');
  $('#movie_select').html(movieName);

  cinemaRoom = this.querySelector(".cinema_room").innerText;
  openHour = this.querySelector(".open_hour").innerText;
  openMinute = this.querySelector(".open_minute").innerText;

  alert(cinemaName + " " + cinemaRoom + "관 " + playDay + " " + 
        openHour + "시 " + openMinute + "분 " + movieName);
})