// 인원 선택

let totalCount = 0;
let choiceCount = 0;

let adultCount = $('#adult_count').text();
let youthCount = $('#youth_count').text();
let seniorCount = $('#senior_count').text();
let specialCount = $('#special_count').text();


$('.plus_btn').click(function(){
  let count = $(this).prev();

  if(totalCount < 8) {
    count.text(Number(count.text()) + 1);
    totalCount++;
    updateCount();
  } else {
    alert("최대 8명까지 선택할 수 있습니다.");
  }
});


$('.minus_btn').click(function(){
  let count = $(this).next();

  if(Number(count.text()) > 0) {
    count.text(Number(count.text()) - 1);
    totalCount--;
    updateCount();
  }
});


function updateCount() {
  adultCount = $('#adult_count').text();
  youthCount = $('#youth_count').text();
  seniorCount = $('#senior_count').text();
  specialCount = $('#special_count').text();

  $('#seat_area > div > a').removeClass("selecting");
  choiceCount = 0;
}



// 좌석 초기화

let maxRow = 10;
let maxColumn = 24;

let rowArr = Array.from({length: maxRow}, () => maxColumn);
let rowWidth = 25*(maxColumn) + 5.98 * (maxColumn-1);

$('#screen_area').css('width', `calc(${rowWidth}px + 2px)`);
$('#seat_area').css('width', `calc(${rowWidth}px)`);

let s1 = `<a href="#none"><span>`;
let s2 = `</span></a>`;
for(let k=1; k<=maxRow; k++){
  for(let i=1; i<=maxColumn; i++){
    let seat = document.createElement('a');
    seat.href = "#none";
    document.querySelector(`#seat_area > div:nth-child(${k})`).appendChild(seat);
  }
}


// 통로 만들기 

function createAisle(i, k) {
  $(`#seat_area > div:nth-child(${i}) > a:nth-of-type(${k})`).addClass('aisle');
  rowArr[i-1] -= 1;
}

for(let i=1; i<=maxRow; i++) {
  createAisle(i, 5);
  createAisle(i, 6);
  createAisle(i, 19);
  createAisle(i, 20);
}


function createSpace(i, k) {
  $(`#seat_area > div:nth-child(${i}) > a:nth-of-type(${k})`).addClass('space');
}

for(let i=1; i<=4; i++) {
  createSpace(i, 1);
  createSpace(i, 2);
  createSpace(i, 3);
  createSpace(i, 4);
}

for(let i=9; i<=12; i++) {
  createSpace(i, 21);
  createSpace(i, 22);
  createSpace(i, 23);
  createSpace(i, 24);
}



// 좌석 번호

let alphabet = 'ABCDEFGHIJKLMNOPQLSTUVWXYZ';

for(let k=1; k<=12; k++) {
  let i=1;
  let j=1;
  let seat; 
  let num;
  while(i <= rowArr[k-1]){
    seat = $(`#seat_area > div:nth-child(${k}) > a:nth-of-type(${j})`);
    if(!seat.hasClass('aisle')){
      num = document.createElement("span");
      num.innerText = i++;
      $(seat).append(num);

      $(seat).attr('data-seat', alphabet[k-1]+(i-1));
    }
    j++;
  }
}

// [Server에서 받아옴] 선택완료

let selectedSeatArray = ['D11', 'D12', 'F5', 'F6', 'H16', 'I16', 'G2', 'G3', 'G4', 'F17', 'F18'];

selectedSeatArray.forEach(item => {
  $(`#seat_area > div > a[data-seat=${item}]`).data('condition', 'selected');
  $(`#seat_area > div > a[data-seat=${item}]`).addClass('selected');
});


// 좌석 선택

$('#seat_area > div > a:not(.selected, .aisle, .space)').on("click", function(){
  if((totalCount > choiceCount) && !($(this).hasClass("selecting"))) {
    $(this).addClass("selecting");
    choiceCount++;
  } else if($(this).hasClass("selecting")) {
    $(this).removeClass("selecting");
    choiceCount--;
  }
});




