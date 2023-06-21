let areaIndex = 0;
let prevAreaIndex = -1;
let cinemaIndex = -1;
let dateIndex = 0;
let movieIndex = -1;
let movieOptionIndex = 1;
let playListIndex = -1;
let playIndex = -1;

let areaCinemaList = [];
let movieNumList = [];
let userPlayList;

let originPlay = $("#origin_play").clone(true);
let clonePlay;
let moviePlay;
let userPlay;
let playBundle;
let movieTitle;

let originResultSection = $('main > section:nth-child(2)').clone(true);
$('main > section:nth-child(2)').remove();

$('#total_play').empty();

// [ajax] 페이지가 로딩되면 서울 지역의 극장을 극장 리스트에 저장함.

$.ajax({
  url: "cinemaList",
  data: {"areaIndex": areaIndex},
  type: "GET",
  success: function(cinemaList) {
    areaCinemaList = cinemaList;
  },
  error: function () {
    console.log("페이지 로딩 중 에러 발생");
  }
});



// [ajax] 특정 영화의 상영만 불러옴

function updatePlayAjax() {
  $.ajax({
    url: "moviePlayList",
    data: {areaIndex, cinemaIndex, dateIndex, movieOptionIndex, movieIndex},
    type: "GET",
    success: function(joinPlayList) {
      $("#total_play").empty();
	  if(joinPlayList.length){
	    updateMoviePlay(joinPlayList);
	    userPlayList = joinPlayList; 
	  }
    },
    error: function () {
      console.log("해당 극장의 상영을 불러오려다 에러 발생");
    }
  });  
}



// [ajax] 모든 영화의 상영을 불러옴

function updateGreatPlayAjax() {
  playListIndex = -1;
  $.ajax({
    url: "playList",
    data: {areaIndex, cinemaIndex, dateIndex},
    type: "GET",
    success: function(joinPlayList) {
      $("#total_play").empty();
      if(joinPlayList.length) {
        updateTotalPlay(joinPlayList);      
      }
    },
    error: function () {
      console.log("에러 발생");
    }
  });
}



// [ajax] 지역을 선택함

function selectAreaAjax() {
  $.ajax({
    url: "cinemaList",
    data: {"areaIndex": areaIndex},
    type: "GET",
    success: function(cinemaList) {
      areaCinemaList = cinemaList;
      $("#cinema_list").empty();
      updateCinemaSection(cinemaList);
      if(prevAreaIndex == areaIndex) {
    	$('#cinema_list').children().eq(cinemaIndex).children().click();
  	  }
    },
    error: function () {
      console.log("에러 발생");
    }
  });

}





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
let playDay = new Date();
let strPlayDay;

$('.swiper-slide.date').on("click", function(){
  dateIndex = $(this).index();
  today = new Date();
  playDay.setDate(today.getDate() + dateIndex);
  
  strPlayDay = (playDay.getMonth()+1) + "월 " + playDay.getDate() + "일 " + weeks[playDay.getDay()] + "요일";
  $('#play_select').html(strPlayDay);
  
  if(cinemaIndex != -1 && movieIndex == -1) {
    updateGreatPlayAjax()
  }

  else if(cinemaIndex != -1 && movieIndex != -1) {
    updatePlayAjax()
  } 
  
});



// 지역 선택

let area = $('#area_list > li');
let areaName;

area.on("click", function(){
  $(this).siblings().children().removeClass('clicked');
  $(this).children().addClass('clicked');
  areaIndex = $(this).index(); 
  
  selectAreaAjax();
});



// 지역을 클릭하면 지역별 극장을 업데이트하는 함수

function updateCinemaSection(cinemaList) {

  for(let cinema of cinemaList) {
  
    let cinemaLi = document.createElement("li");
    let cinemaItem = document.createElement("a");
        
    $(cinemaItem).html(cinema.cinemaName);
    $(cinemaItem).attr("href", "#none");
    $(cinemaItem).on("click", function(e) {
       clickCinema(e);
    });
        
    $(cinemaLi).append(cinemaItem);
    $("#cinema_list").append(cinemaLi);
  
  }
  
}



// 극장 선택 
// 사용자가 극장을 선택하여 인덱스로 접근하는데, 관리자가 극장을 추가하면...
// 분명 이름 순으로 몇 번째 극장을 선택했는데, 그새 테이블이 변경되면...??
// 이러한 문제는 스프링 격리성을 고안하면 됩니다. MVCC
// 당장 우리 프로젝트에서 적용하기 어려우므로, 추후 학습하는 게 좋을 것 같습니다.

function clickCinema(e) {

  cinemaIndex = $(e.target).parent().index();
  prevAreaIndex = areaIndex;
  
  $("#cinema_select").html(areaCinemaList[cinemaIndex].cinemaName);
  $('#cinema_list > li > a').removeClass("clicked");
  $(e.target).addClass("clicked");
  
  $('main > section:nth-child(2)').remove();
  updateGreatPlayAjax();
}

$("#cinema_list > li > a").on("click", function(e){
  clickCinema(e);
});


// 상영 정보를 업데이트하는 함수

function updateTotalPlay(joinPlayList) {

  if(joinPlayList.length) {
    
    // 영화번호 별로 그룹화함
    const movieGroup = joinPlayList.reduce((acc, play) => {
      acc[play.movie.movieNo] = acc[play.movie.movieNo] || [];
      acc[play.movie.movieNo].push(play);
      return acc;
    }, {}); 
    
    userPlayList = movieGroup;
    movieNumList = [];
         
    // 영화번호 별로 상영 목록을 만듦.
    for(let i in movieGroup) {
      moviePlay = $('<li class="movie_play"></li>');
      movieTitle = movieGroup[i][0]['movie'].movieTitle;
      moviePlay.append(`<div>${movieTitle}</div>`);
           
      playBundle = $('<div><ul class="playlist"></ul></div>');
      movieNumList.push(movieGroup[i][0]['movie'].movieNo);
      
      // 각 상영 별로 정보를 초기화함.
      for(let k in movieGroup[i]) {
        clonePlay = originPlay.clone(true);
        clonePlay.removeAttr('id');
        clonePlay.find('.open_hour').html(movieGroup[i][k].play.playStart.substring(11,13));
        clonePlay.find('.open_minute').html(movieGroup[i][k].play.playStart.substring(14,16));
        clonePlay.find('.entire_seat').html(movieGroup[i][k].screen.screenSeat);
        clonePlay.find('.empty_seat').html(movieGroup[i][k].screen.screenSeat - movieGroup[i][k].play.playBookCount);
        clonePlay.find('.cinema_room').html(movieGroup[i][k].screen.screenName);
        clonePlay.on("click", function(e) {
          clickSuperPlay(e);
        });
        playBundle.find('.playlist').append(clonePlay);
      }
           
      moviePlay.append(playBundle);
      $("#total_play").append(moviePlay);
           
    }
  }
}


function updateMoviePlay(joinPlayList) {

  if(joinPlayList.length) {
    moviePlay = $('<li class="movie_play"></li>');
    movieTitle = joinPlayList[0]['movie'].movieTitle;
    moviePlay.append(`<div>${movieTitle}</div>`);
           
    playBundle = $('<div><ul class="playlist"></ul></div>');
    
    // 각 상영 별로 정보를 초기화함.
    for(let i in joinPlayList) {
      clonePlay = originPlay.clone(true);
      clonePlay.removeAttr('id');
             
      clonePlay.find('.open_hour').html(joinPlayList[i].play.playStart.substring(11,13));
      clonePlay.find('.open_minute').html(joinPlayList[i].play.playStart.substring(14,16));
      clonePlay.find('.entire_seat').html(joinPlayList[i].screen.screenSeat);
      clonePlay.find('.empty_seat').html(joinPlayList[i].screen.screenSeat - joinPlayList[i].play.playBookCount);
      clonePlay.find('.cinema_room').html(joinPlayList[i].screen.screenName);
      clonePlay.on("click", function(e) {
          clickPlay(e);
      });
      playBundle.find('.playlist').append(clonePlay);
    }
    moviePlay.append(playBundle);
    $("#total_play").append(moviePlay);
  }

}


// 영화 리스트 버전 선택

$('#movie_option1').on("click", function(){
  $("#movielist_text").css('display', 'block');
  $("#movielist_thumb").css('display', 'none');
  $('#movie_option1').addClass('clicked');
  $('#movie_option2').removeClass('clicked');
  movieOptionIndex = 0;
});

$('#movie_option2').on("click", function(){
  $("#movielist_text").css('display', 'none');
  $("#movielist_thumb").css('display', 'block');
  $('#movie_option1').removeClass('clicked');
  $('#movie_option2').addClass('clicked');
  movieOptionIndex = 1;
});


// 영화 선택

let movie = $('.movielist > li > a');
let movieName;

movie.on("click", function(){
  $('main > section:nth-child(2)').remove();
  movieIndex = $(this).parent().index();
  if(cinemaIndex != -1) {
    updatePlayAjax()
  }
  
  movieName = this.querySelector('.movie_name').innerText;
  $('#movie_select').html(movieName);
  $('.movie_play').css('display', 'none');
  $(`.movie_play[data-movie="${movieName}"]`).css('display', 'block');
  
});


// 상영 선택

let play = $('.playlist > li > a');
let resultSection;


// 전체 영화 상영 중에서 

function clickSuperPlay(e) {
  playIndex = $(e.target).closest('li').index();
  playListIndex = $(e.target).closest('.movie_play').index();
  userPlay = userPlayList[movieNumList[playListIndex]][playIndex];
  updateResultSection(userPlay)
}    


// 한 영화만 나올 때

function clickPlay(e) {
  playIndex = $(e.target).closest('li').index();
  userPlay = userPlayList[playIndex];
  console.log(userPlay);
  updateResultSection(userPlay);
}
	

function updateResultSection(userPlay) {
  $('main > section:nth-child(2)').remove();
  resultSection = originResultSection.clone(true);
  resultSection.find('#movie_thumb > img').attr("src", `${userPlay.movie.movieImg1}`);
  console.log(userPlay);
  resultSection.find('#movie_name').html(userPlay.movie.movieTitle);
  
  resultSection.find('#movie_grade').removeClass();
  if(userPlay.movie.mgNo.indexOf('전체') != -1) {
    resultSection.find('#movie_grade').addClass('age00');
    resultSection.find('#movie_grade').html('All');
  } else if(userPlay.movie.mgNo.indexOf('12') != -1) {
    resultSection.find('#movie_grade').addClass('age12');
    resultSection.find('#movie_grade').html('12');
  } else if(userPlay.movie.mgNo.indexOf('15') != -1) {
    resultSection.find('#movie_grade').addClass('age15');
    resultSection.find('#movie_grade').html('15');
  } else {
    resultSection.find('#movie_grade').addClass('age18');
    resultSection.find('#movie_grade').html('18');  
  }

  
  let up_start = new Date(userPlay.play.playStart);
  let up_end = new Date(userPlay.play.playEnd);
  resultSection.find('#up_year').html(up_start.getFullYear() + "년");
  resultSection.find('#up_month').html((up_start.getMonth()+1) + "월");
  resultSection.find('#up_date').html(up_start.getDate() + "일");
  resultSection.find('#up_day').html(weeks[up_start.getDay()] + "요일");
  
  resultSection.find('#start_hour').html(String(up_start.getHours()).padStart(2, "0") + "시");
  resultSection.find('#start_minute').html(String(up_start.getMinutes()).padStart(2, "0") + "분 &#126;");
  
  if(up_start.getDate() == up_end.getDate()) {
    resultSection.find('#end_hour').html(String(up_end.getHours()).padStart(2, "0") + "시"); 
  } else {
    resultSection.find('#end_hour').html((up_end.getHours()+24) + "시");
  }
  resultSection.find('#end_minute').html(String(up_end.getMinutes()).padStart(2, "0") + "분"); 
  resultSection.find('#end_minute').html(String(up_end.getMinutes()).padStart(2, "0") + "분");
  
  resultSection.find('#play_cinema').html(userPlay.cinema.cinemaName);
  resultSection.find('#play_screen').html(userPlay.screen.screenName + "관");
  resultSection.find('#play_style').html("(" + userPlay.screen.screenStyle + ")");
  
  resultSection.find('#next_stage').on("click", function() {
     
  })
  
  $('main').append(resultSection);
}




/*
안 쓰는 함수...

function updatePlaySection(playMap) {
  
  // 해당 극장에서 상영 중인 영화 번호를 중복 없이 예매율 순으로 저장함.
  
  playMap.playList.forEach(play => movieNumList.push(play['movieNo']));
  
  movieNumList = movieNumList.filter((element, index) => {
    return movieNumList.indexOf(element) === index;
  });
  
  
  for(let num of movieNumList) {

    // 영화 제목을 업데이트함
    
    questMovie = playMap.thumbList.filter((movie) => {
      return movie.movieNo == num;
    });
    
    moviePlay.append(`<div>${questMovie[0]['movieTitle']}</div>`);
    
    // 시작 시간을 업데이트함
    
    questPlay = playMap.playList.filter((play) => {
      return play.movieNo == num;
    });
    questPlay.forEach(function(play) {
      clonePlay = originPlay.clone(true);
      clonePlay.removeAttr('id');
      questScreen = playMap.screenList.filter((screen) => {
        return screen.screenNo = play.screenNo
      });
      console.log(questScreen[0]);
      clonePlay.find('.open_hour').html(play.playStart.substring(11,13));
      clonePlay.find('.open_minute').html(play.playStart.substring(14,16));
      playBundle.find('.playlist').append(clonePlay);   
    });   
    moviePlay.append(playBundle);
    $("#total_play").append(moviePlay);     
  } 
}
*/