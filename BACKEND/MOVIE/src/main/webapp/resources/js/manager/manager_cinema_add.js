// 슬라이더

var swiper = new Swiper(".mySwiper", {
  slidesPerView: 5,
  spaceBetween: 20,
});

$('.swiper-slide input.status').attr('value', JSON.stringify(
  {
	type: '일반관',
	maxRow : 12,
	maxColumn: 24,
	aisle: [],
	space: {},
	sweet: [],
	impared: []
  })
);

let tempNo; 

let tempRoom = {
  type: null,
  maxRow : 1,
  maxColumn: 1,
  aisle: [],
  space: {},
  sweet: [],
  impared: []
};

let clickCount = 0;
let firstSeat = [];
let secondSeat = [];

let optionArea = [];
let tempRowArr = [];



// [이벤트] 상영관 편집 버튼을 클릭하면

$('.swiper-slide .room_edit').on("click", function(){
  let room = $(this).closest('.swiper-slide');
  
  tempNo = $(room).data('room-no');
  $('#room_no').html(tempNo);
    
  tempRoom.maxRow = $(room).data('room-maxrow');
  $('#temp_row').val(tempRoom.maxRow);
  
  tempRoom.maxColumn = $(room).data('room-maxcolumn');
  $('#temp_column').val(tempRoom.maxColumn);
  
  tempRoom.type = $(room).data('room-type');
  $("#temp_type").val(tempRoom.type).prop("selected", true);
  
  // alert($(room).find('input[name="status"]').val());
  tempRoom = JSON.parse($(room).find('input[name="status"]').val());
  createBasicRoom(tempRoom.maxRow, tempRoom.maxColumn);
  changeRoom();
  hideSeatSetting();
    
  $('#room_area').css('display', 'block');
  $('#room_area').css('z-index', '3');
  
});



// [이벤트] 상영관의 타입을 변경하면

$('#temp_type').on("input", function(){
  tempRoom.type = $(this).val();
})



// [이벤트] 상영관의 가로줄과 세로줄 수를 변경하면

$('#edit_area .temp_rc').on("input", function(){
  tempRoom.maxRow = $('#temp_row').val();
  tempRoom.maxColumn = $('#temp_column').val();
  tempRoom.aisle = [];
  tempRoom.space = [];
  
  createBasicRoom(tempRoom.maxRow, tempRoom.maxColumn);
  hideSeatSetting();  
});



// [함수] 좌석 옵션 숨기기

function hideSeatSetting() {
  $('#seat_option').css('display', 'none');
  $('#seat_option select').val("").prop("selected", true);
  $('#seat_option_confirm').css('display', 'none');
  
  clickCount = 0;
}



// [함수] 기본 방 만들기

let alphabet = 'ABCDEFGHIJKLMNOPQLSTUVWXYZ';

function createBasicRoom(maxRow, maxColumn){
  let row, seat;
  tempRowArr = Array.from({length: maxRow}, () => maxColumn);
  
  $('#seat_area').empty();
  clickCount = 0;

  for(let k=1; k<=maxRow; k++){
  
    row = document.createElement('div');
    document.querySelector('#seat_area').appendChild(row);
    
    for(let i=1; i<=maxColumn; i++){
    
      seat = document.createElement('a');
      seat.href = "#none";
      
      $(seat).addClass('seat');
      $(seat).attr("data-row", k);
      $(seat).attr("data-column", i);
      
      seat.addEventListener("click", function(){
        clickSeat(this);
      });
      
      document.querySelector(`#seat_area > div:nth-child(${k})`).appendChild(seat);
    }
  }
}



function plusAisle(r, c) {
  $(`#seat_area > div:nth-child(${r}) > a:nth-of-type(${c})`).addClass('aisle');
} 



function plusSpace(r, c) {
  $(`#seat_area > div:nth-child(${r}) > a:not('.aisle'):nth-of-type(${c})`).addClass('space');
} 



function changeRoom() {
  for(let r=1; r<=tempRoom.maxRow; r++) {
    tempRoom.aisle.forEach(c => plusAisle(r, c));
  }
  
  for(let key in tempRoom.space) {
    tempRoom.space[key].forEach(v => plusSpace(key, v));
  }
}


// [함수] 좌석을 클릭하면

function clickSeat(s) { 

  if(clickCount == 0) {
    $('.seat').removeClass('option');
    clickSeatZero(s);
  } 
  
  else if(clickCount == 1) {
    $('.seat').removeClass('option');
    clickSeatOne(s, $(s).data('row'), $(s).data('column'));
    createOptionArea();
  } 
  
  else {
    clickSeatTwo(s);
  }

}



// [조건부 함수] 클릭 카운트가 0일 때 좌석을 클릭하면

function clickSeatZero(s) {
  $('#seat_option').css('display', 'flex');
  $(s).addClass('clicked');
  
  firstSeat = [$(s).data('row'), $(s).data('column')];
  clickCount++;
}



// [조건부 함수] 클릭 카운트가 1일 때 좌석을 클릭하면

function clickSeatOne(s, n0, n1) {

  if((n0 != firstSeat[0]) || (n1 != firstSeat[1])) {
    secondSeat = [n0, n1];  
    $(s).addClass('clicked');
    clickCount++;
  } else {
    firstSeat = [];
    $(s).removeClass('clicked');
    hideSeatSetting();
  }

}



// [조건부 함수] 클릭 카운트가 2일 때 좌석을 클릭하면

function clickSeatTwo(s) {
  let presentSeat = [$(s).data('row'), $(s).data('column')];
  
  if(JSON.stringify(presentSeat) === JSON.stringify(firstSeat)) {
    firstSeat = secondSeat;
    secondSeat = [];
    
    $(s).removeClass('clicked');
    $('.seat').removeClass('option');
    
    $('#seat_option select').val("").prop("selected", true);
    $('#seat_option_confirm').css('display', 'none');
    clickCount--;
  }
  
  if(JSON.stringify(presentSeat) === JSON.stringify(secondSeat)) {
    secondSeat = [];
    
    $(s).removeClass('clicked');
    $('.seat').removeClass('option');
    
    $('#seat_option select').val("").prop("selected", true);
    $('#seat_option_confirm').css('display', 'none');
    clickCount--;
  }

}



// [조건부 함수] 옵션이 적용되는 구역 만들기

let min0, min1, max0, max1;

function createOptionArea() {
  min0 = Math.min(firstSeat[0], secondSeat[0]);
  max0 = Math.max(firstSeat[0], secondSeat[0]);
  
  min1 = Math.min(firstSeat[1], secondSeat[1]);
  max1 = Math.max(firstSeat[1], secondSeat[1]);
  
  optionArea = [];
  
  for(let i = min0; i <= max0; i++) {
    for(let j = min1; j <= max1; j++) {
      optionArea.push([i, j]);
    }
  }

}



// [이벤트] 좌석 옵션창을 선택하면

$('#seat_option select').on("input", function(){
  $('.seat_detail').css('display', 'none');
  $('.seat').removeClass('option')

  if($(this).val() == '통로 만들기') {
    removeSpace();
    createTempAisle();
  } 
  
  else if($(this).val() == '통로 없애기') {
    deleteTempAisle();
  } 
  
  else if($(this).val() == '공간 만들기') {
    createTempSpace();
  }
  
  else if($(this).val() == '공간 없애기') {
    deleteTempSpace();
  }
  
  if($(this).val() != '') {
    $('#seat_option_confirm').css('display', 'flex');
  }
  
});



// [조건부 함수] 임시 통로 만들기

function createTempAisle(){

  if(clickCount == 1) {
    for(let i = 1; i <= tempRoom.maxRow; i++) {
      $(`#seat_area > div:nth-child(${i}) > a:not('.clicked'):nth-of-type(${firstSeat[1]})`).addClass('option');
    }
  } 
  
  else if(clickCount == 2) {
    for(let i = 1; i <= tempRoom.maxRow; i++) {
      for(let j=min1; j<=max1; j++) {
        $(`#seat_area > div:nth-child(${i}) > a:not('.clicked'):nth-of-type(${j})`).addClass('option');
      }
    }
  }

}



// [조건부 함수] 임시 통로 없애기

function deleteTempAisle(){

  if(clickCount == 1) {
    for(let i = 1; i <= tempRoom.maxRow; i++) {
      $(`#seat_area > div:nth-child(${i}) > a.aisle:not('.clicked'):nth-of-type(${firstSeat[1]})`).addClass('option');
    }
  } 
  
  else if(clickCount == 2) {
    for(let i = 1; i <= tempRoom.maxRow; i++) {
      for(let j=min1; j<=max1; j++) {
        $(`#seat_area > div:nth-child(${i}) > a.aisle:not('.clicked'):nth-of-type(${j})`).addClass('option');
      }
    }
  }

}




// [조건부 함수] 임시 공간 만들기

function createTempSpace() {

  if(clickCount == 1) {
    $('#seat_area > div > a.clicked').addClass('option');
  } 
  
  else if(clickCount == 2) {
    for(let i = min0; i <= max0; i++) {
      for(let j = min1; j <= max1; j++) {
        $(`#seat_area > div:nth-child(${i}) > a:not('.clicked'):nth-of-type(${j})`).addClass('option');
      }
    }
  }
}



// [조건부 함수] 임시 공간 없애기

function deleteTempSpace() {
  if(clickCount == 1) {
    $('#seat_area > div > a.space.clicked').addClass('option');
  } 
  
  else if(clickCount == 2) {
    for(let i = min0; i <= max0; i++) {
      for(let j = min1; j <= max1; j++) {
        $(`#seat_area > div:nth-child(${i}) > a.space:not('.clicked'):nth-of-type(${j})`).addClass('option');
      }
    }
  }
}

// [이벤트] 설정 적용 버튼 누르기

$('#seat_option_confirm').on("click", function() {

  if($('#seat_option select').val() == '통로 만들기') {
    createAisle();
  }
  
  else if($('#seat_option select').val() == '통로 없애기') {
    deleteAisle();
  }
  
  else if($('#seat_option select').val() == '공간 만들기') {
    createSpace();
  }
  
  else if($('#seat_option select').val() == '공간 없애기') {
    deleteSpace();
  }
  
  createBasicRoom(tempRoom.maxRow, tempRoom.maxColumn);
  changeRoom();
  hideSeatSetting();
  
});



// [조건부 함수] 통로 만들기

function createAisle() {

  if(clickCount == 1) {
    if(tempRoom.aisle.indexOf(firstSeat[1]) == '-1') {
      tempRoom.aisle.push(firstSeat[1]);
      tempRoom.aisle.sort((a,b) => a-b);
    }
  } 
  
  else if(clickCount == 2) {
    for(let i = min1; i <= max1; i++) {
      if(tempRoom.aisle.indexOf(i) == '-1') {
        tempRoom.aisle.push(i);
      }
    }
    
    tempRoom.aisle.sort((a,b)=>a-b);
  }
}



// [조건부 함수] 통로 없애기


function deleteAisle() {
  if(clickCount == 1) {
    tempRoom.aisle = tempRoom.aisle.filter(function(data) {
      return data != firstSeat[1];
    });
  } 
  
  else if(clickCount == 2) {
    tempRoom.aisle = tempRoom.aisle.filter(function(data) {
      return (data < min1) || (data > max1);
    });
  }
}



// [조건부 함수] 공간 만들기

function createSpace() {

  if(clickCount == 1) {
  
    if(!(firstSeat[0] in tempRoom.space)) {
      tempRoom.space[firstSeat[0]] = [];
    }
    
    tempRoom.space[firstSeat[0]].push(firstSeat[1]);
    tempRoom.space[firstSeat[0]] = Array.from(new Set(tempRoom.space[firstSeat[0]]));
  }
  
  else if(clickCount == 2) {
    for(let i=min0; i<=max0; i++) {
      if(!(i in tempRoom.space)) {
        tempRoom.space[i] = [];
      }
      
      for(let j=min1; j<=max1; j++) {
        tempRoom.space[i].push(j);
      }
      
      tempRoom.space[i] = Array.from(new Set(tempRoom.space[i]));
    }
  }
  
  // alert(JSON.stringify(tempRoom.space));
  
}



// [조건부 함수] 공간 없애기

function deleteSpace() {
  
  if(clickCount == 1) {
    tempRoom.space[firstSeat[0]] = tempRoom.space[firstSeat[0]].filter(function(data) {
      return data != firstSeat[1];
    });
  }
  
  else if(clickCount == 2) {
    for(let i=min0; i<=max0; i++) {
      if((i in tempRoom.space)) {
        tempRoom.space[i] = tempRoom.space[i].filter(function(data) {
          return (data < min1) || (data > max1);
        });
      }
    }
  }

}


// [조건부 함수] 공간 위에 통로를 덮어씌우기

function removeSpace() {
  if(clickCount == 1) {
    for(let key in tempRoom.space) {
      tempRoom.space[key] = tempRoom.space[key].filter(function(data){
        return data != firstSeat[1];
      });
    }
  } 
  
  else if(clickCount == 2) {
    for(let key in tempRoom.space) {
      tempRoom.space[key] = tempRoom.space[key].filter(function(data){
        return (data < min1) || (data > max1);
      });
    }
    
  }
}


// 확인 버튼 

$('#room_confirm').on("click", function() {
  let room = $(`.swiper-slide[data-room-no=${tempNo}]`);
  room.data('room-maxrow', tempRoom.maxRow);
  room.data('room-maxcolumn', tempRoom.maxColumn);
  room.data('room-type', tempRoom.type);
  room.find('.room_type').html(tempRoom.type);
  
  $(room).find('input[name="status"]').attr('value', JSON.stringify(tempRoom));
  $('#room_area').css('display', 'none');
  $('#room_area').css('z-index', '0');
});


// 리셋 버튼

$('#room_reset').on("click", function() {
  let room = $(`.swiper-slide[data-room-no=${tempNo}]`);
    
  $('#temp_row').val(12);
  $('#temp_column').val(24);
    
  tempRoom.maxRow = $('#temp_row').val();
  tempRoom.maxColumn = $('#temp_column').val();
    
  createBasicRoom(tempRoom.maxRow, tempRoom.maxColumn);
	
  tempRoom.type = "일반관";
  $("#temp_type").val(tempRoom.type).prop("selected", true);
	
  room.data('room-maxrow', tempRoom.maxRow);
  room.data('room-maxcolumn', tempRoom.maxColumn);
  room.data('room-type', tempRoom.type);
  room.find('.room_type').html(tempRoom.type);
  
  hideSeatSetting();

});


// 취소 버튼

$('#room_cancle').on("click", function() {
  $('#seat_option').css('display', 'none');

  $('#room_area').css('display', 'none');
  $('#room_area').css('z-index', '0');
});


// 우클릭 이벤트 해제

window.oncontextmenu = function(){
  return false;
}


