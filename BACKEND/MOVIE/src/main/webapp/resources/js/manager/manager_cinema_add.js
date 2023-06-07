// 우클릭 이벤트 해제

window.oncontextmenu = function(){
  return false;
}



// 슬라이더

var swiper = new Swiper(".mySwiper", {
  slidesPerView: 5,
  spaceBetween: 20,
});



// 현재 상영관의 번호

let tempNo;   


// 현재 상영관의 정보        

let tempRoom = {
  type: null,
  maxRow : 1,
  maxColumn: 1,
  aisle: [],
  space: []
};


let tempRowArr = [];



// [이벤트] 상영관 편집 버튼을 클릭하면

$('.swiper-slide .room_edit').on("click", function(){
  let room = $(this).closest('.swiper-slide');
  
  tempNo = $(room).data('room-no');
  $('#room_area #room_no').html(tempNo);
    
  tempRoom.maxRow = $(room).data('room-maxrow');
  $('#temp_row').val(tempRoom.maxRow);
  
  tempRoom.maxColumn = $(room).data('room-maxcolumn');
  $('#temp_column').val(tempRoom.maxColumn);
  
  tempRoom.type = $(room).data('room-type');
  $("#edit_area select").val(tempRoom.type).prop("selected", true);
    
  $('#seat_area').empty();
  createBasicRoom(tempRoom.maxRow, tempRoom.maxColumn);
    
  $('#room_area').css('display', 'block');
  $('#room_area').css('z-index', '3');
  
});



// [이벤트] 상영관의 타입을 변경하면

$('#edit_area select').on("input", function(){
  tempRoom.type = $(this).val();
})



// [이벤트] 상영관의 가로줄과 세로줄 수를 변경하면

$('#edit_area .temp_rc').on("input", function(){
  tempRoom.maxRow = $('#temp_row').val();
  tempRoom.maxColumn = $('#temp_column').val();
  
  $('#seat_area').empty();
  createBasicRoom(tempRoom.maxRow, tempRoom.maxColumn);
});



// [함수] 기본 방 만들기

let alphabet = 'ABCDEFGHIJKLMNOPQLSTUVWXYZ';

function createBasicRoom(maxRow, maxColumn){

  let s1, s2, row, seat;
  
  s1 = `<a href="#none"><span>`;
  s2 = `</span></a>`;
  
  tempRowArr = Array.from({length: maxRow}, () => maxColumn);  

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
  
  console.log(tempRoom);
}



// [함수] 좌석을 클릭하면

let right, down;

function clickSeat(s) {
  $('.seat').removeClass('clicked');
  $(s).addClass('clicked');
  $('#seat_option').css('display', 'flex');
  $('#seat_option select').val("");
  $('.seat_detail').css('display', 'none');
   
  right = tempRoom.maxColumn - $(s).data('column') + 1;
  down = tempRoom.maxRow - $(s).data('row') + 1;

  $('.seat_detail > input').val("0");
  $('.seat_right').attr('max', right);
  $('.seat_down').attr('max', down);
}



$('#seat_option select').on("input", function(){
  $('.seat_detail').css('display', 'none');

  if($(this).val() == '통로 만들기') {
    createAisle();
  } 
  
  else if($(this).val() == '공간 만들기') {
    createSpace();
  }
});


// 통로 만들기

function createAisle(){
  $('.sd1').css('display', 'flex');
  
}

function createSpace() {
  $('.sd2').css('display', 'flex');
}



// 확인 버튼 

$('#room_confirm').on("click", function() {
  let room = $(`.swiper-slide[data-room-no=${tempNo}]`);
  room.data('room-maxrow', tempRoom.maxRow);
  room.data('room-maxcolumn', tempRoom.maxColumn);
  room.data('room-type', tempRoom.type);
  room.find('.room_type').html(tempRoom.type);
	
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
    
  $('#seat_area').empty();
  createBasicRoom(tempRoom.maxRow, tempRoom.maxColumn);
	
  tempRoom.type = "일반관";
  $("#edit_area select").val(tempRoom.type).prop("selected", true);
	
  room.data('room-maxrow', tempRoom.maxRow);
  room.data('room-maxcolumn', tempRoom.maxColumn);
  room.data('room-type', tempRoom.type);
  room.find('.room_type').html(tempRoom.type);

});


// 취소 버튼

$('#room_cancle').on("click", function() {
	$('#room_area').css('display', 'none');
    $('#room_area').css('z-index', '0');
});