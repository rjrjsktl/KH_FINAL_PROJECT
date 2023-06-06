window.oncontextmenu = function(){
	return false;
}

var swiper = new Swiper(".mySwiper", {
    slidesPerView: 5,
    spaceBetween: 20,
});


// 상영관 편집 버튼을 눌렀을 때

let tempNo;
let tempRow;
let tempColumn;
let tempType;

$('.swiper-slide .room_edit').on("click", function(){
    tempNo = $(this).closest('.swiper-slide').data('room-no');
    
    $('#room_area #room_no').html(tempNo);
    
    tempRow = $(this).closest('.swiper-slide').data('room-maxrow');
    tempColumn = $(this).closest('.swiper-slide').data('room-maxcolumn');
    
	$('#seat_area').empty();
    createBasicRoom(tempRow, tempColumn);
    
	$('#temp_row').val(tempRow);
	$('#temp_column').val(tempColumn);
	
	tempType = $(this).closest('.swiper-slide').data('room-type');
	$("#edit_area select").val(tempType).prop("selected", true);
	
    $('#room_area').css('display', 'block');
    $('#room_area').css('z-index', '3');
});


// 타입 변경시

$('#edit_area select').on("input", function(){
    tempType = $(this).val();
})

// 가로 세로 변경시

$('#edit_area input[type="number"]').on("input", function(){
    tempRow = $('#temp_row').val();
    tempColumn = $('#temp_column').val();
    $('#seat_area').empty();
	createBasicRoom(tempRow, tempColumn);
});


// 기본 방 만들기

function createBasicRoom(maxRow, maxColumn){
    let s1 = `<a href="#none"><span>`;
    let s2 = `</span></a>`;

	for(let k=1; k<=maxRow; k++){
	  let row = document.createElement('div');
	  document.querySelector('#seat_area').appendChild(row);
	  for(let i=1; i<=maxColumn; i++){
	    let seat = document.createElement('a');
	    seat.href = "#none";
	    document.querySelector(`#seat_area > div:nth-child(${k})`).appendChild(seat);
	  }
	}
}

// 확인 버튼 

$('#room_confirm').on("click", function() {
    let room = $(`.swiper-slide[data-room-no=${tempNo}]`);
	room.data('room-maxrow', tempRow);
	room.data('room-maxcolumn', tempColumn);
	room.data('room-type', tempType);
	room.find('.room_type').html(tempType);
	
	$('#room_area').css('display', 'none');
    $('#room_area').css('z-index', '0');
});


// 리셋 버튼

$('#room_reset').on("click", function() {
    let room = $(`.swiper-slide[data-room-no=${tempNo}]`);
    
    $('#temp_row').val(12);
    $('#temp_column').val(24);
    
    tempRow = $('#temp_row').val();
    tempColumn = $('#temp_column').val();
    
    $('#seat_area').empty();
	createBasicRoom(tempRow, tempColumn);
	
	tempType = "일반관";
	$("#edit_area select").val(tempType).prop("selected", true);
	
	room.data('room-maxrow', tempRow);
	room.data('room-maxcolumn', tempColumn);
	room.data('room-type', tempType);
	room.find('.room_type').html(tempType);

});


// 취소 버튼

$('#room_cancle').on("click", function() {
	$('#room_area').css('display', 'none');
    $('#room_area').css('z-index', '0');
});