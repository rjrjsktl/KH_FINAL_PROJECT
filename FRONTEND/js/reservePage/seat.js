let totalCount = 0;
let choiceCount = 0;

let adultCount = $('#adult_count').text();
let youthCount = $('#youth_count').text();
let seniorCount = $('#senior_count').text();
let specialCount = $('#special_count').text();

let seatArray = [];
let countArray = [];
let choiceArray = [];


// 인원 선택

// [이벤트] 플러스 버튼을 클릭하면??

$('.plus_btn').click(function(){
  let count = $(this).prev();

  if(totalCount < 8) {
    count.text(Number(count.text()) + 1);
    totalCount++;
    resetCount();
    updateSeatSection();
    updateCountArray();
    resetPriceSection();
  } else {
    alert("최대 8명까지 선택할 수 있습니다.");
  }
});


// [이벤트] 마이너스 버튼을 클릭하면??

$('.minus_btn').click(function(){
  let count = $(this).next();

  if(Number(count.text()) > 0) {
    count.text(Number(count.text()) - 1);
    totalCount--;
    resetCount();
    updateSeatSection();
    updateCountArray();
    resetPriceSection();
  }
});


// [함수] 선택 인원 초기화

function resetCount() {
  adultCount = $('#adult_count').text();
  youthCount = $('#youth_count').text();
  seniorCount = $('#senior_count').text();
  specialCount = $('#special_count').text();

  $('#seat_area > div > a').removeClass("selecting");
  choiceCount = 0;
  seatArray = [];
}



// 좌석 커스터마이징

// [커스텀] 몇 줄? 한 줄 최대 좌석?
let maxRow = 10;
let maxColumn = 24;


// [배열] 각 줄마다 몇 개의 좌석이 있는지??
let rowArr = Array.from({length: maxRow}, () => maxColumn);


// 좌석 width는 25px, 좌석 간의 가로 공간은 5.98px
let rowWidth = 25*(maxColumn) + 5.98 * (maxColumn-1);


// 스크린과 좌석 영역의 전체 길이 설정
$('#screen_area').css('width', `calc(${rowWidth}px + 2px)`);
$('#seat_area').css('width', `calc(${rowWidth}px)`);

let s1 = `<a href="#none"><span>`;
let s2 = `</span></a>`;


// 모든 좌석에 하이퍼링크 부여

for(let k=1; k<=maxRow; k++){
  for(let i=1; i<=maxColumn; i++){
    let seat = document.createElement('a');
    seat.href = "#none";
    document.querySelector(`#seat_area > div:nth-child(${k})`).appendChild(seat);
  }
}


// [함수] 통로 만들기 

function createAisle(i, k) {
  $(`#seat_area > div:nth-child(${i}) > a:nth-of-type(${k})`).addClass('aisle');
  rowArr[i-1] -= 1;
}


// [커스텀] 몇 번째 줄을 통로로 만들까?

for(let i=1; i<=maxRow; i++) {
  createAisle(i, 5);
  createAisle(i, 6);
  createAisle(i, 19);
  createAisle(i, 20);
}


// [함수] 공간 만들기
// 통로와 공간은 보이지 않으며, 선택되지 않는다.
// 번호를 셀 때 통로는 제외되나 공간은 포함된다.

function createSpace(i, k) {
  $(`#seat_area > div:nth-child(${i}) > a:nth-of-type(${k})`).addClass('space');
}


// [커스텀] 몇번째 줄을 공간으로 만들까?

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

createSpace(1, 10);
createSpace(1, 15);

createSpace(10, 7);
createSpace(10, 8);
createAisle(10, 17);
createAisle(10, 18);



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
  $(`#seat_area > div > a[data-seat=${item}]`).addClass('selected');
});


// [Server에서 받아옴] 특수석

let impairedSeatArray = ['A9', 'A10', 'A11', 'A12'];
let sweetSeatArray = ['J7', 'J8', 'J9', 'J10', 'J11', 'J12', 'J13', 'J14'];

impairedSeatArray.forEach(item => {
  $(`#seat_area > div > a[data-seat=${item}]`).addClass('impared');
});

sweetSeatArray.forEach(item => {
  $(`#seat_area > div > a[data-seat=${item}]`).addClass('sweet');
});

// 좌석 선택

let selectableSeat = $('#seat_area > div > a:not(.selected, .aisle, .space)');

$(selectableSeat).on("click", function(){
  if((totalCount > choiceCount) && !($(this).hasClass("selecting"))) {
    $(this).addClass("selecting");
    choiceCount++;
    seatArray.push($(this).data('seat'));
    seatArray.sort((a,b) => sortSeat(a, b));
    updateSeatSection();
    updatePriceSection();
  } else if($(this).hasClass("selecting")) {
    $(this).removeClass("selecting");
    choiceCount--;
    seatArray = seatArray.filter((element) => element !== $(this).data('seat'));
    updateSeatSection();
    updatePriceSection()
  }
});


// [함수] 좌석번호 정렬

// A8 - A9 - A10 순으로 나열하고 싶은데, 숫자가 문자열로 인식되어 이상한 결과가 나온다.
// 그래서 문자열부터 비교하고, 문자열이 같다면 숫자 부분만 비교하도록 만들자.

function sortSeat(a, b) {
  if(a.substr(0,1) > b.substr(0,1)) return 1;
  else if(a.substr(0,1) < b.substr(0,1)) return -1;
  else {
    if(Number(a.substring(1)) < Number(b.substring(1))) return -1;
  }
}


// [함수] 좌석 정보창 업데이트

function updateSeatSection() {
  $('#seat_code > div').empty();

  for(let i=0; i<seatArray.length; i++) {
    if(i == 0) {
      $('#seat_code > div:first-child').append(seatArray[i]);
    } else if(i <= 3) {
      $('#seat_code > div:first-child').append(", " + seatArray[i]);
    } else if(i == 4) {
      $('#seat_code > div:first-child').append(",");
      $('#seat_code > div:last-child').append(seatArray[i]);
    } else {
      $('#seat_code > div:last-child').append(", " + seatArray[i]);
    }
  }
}


// [서버에서 받아옴] 가격 정보

let adultPrice = 15000;
let youthPrice = 12000;
let seniorPrice = 7000;
let specialPrice = 5000;

let priceArray = [Number(adultPrice), Number(youthPrice), Number(seniorPrice), Number(specialPrice)];
let totalPrice = 0;


// 선택 배열 초기화

function updateCountArray() {
  countArray = [];

  for(let i=0; i<adultCount; i++) {
    countArray.push(0);
  }

  for(let i=0; i<youthCount; i++) {
    countArray.push(1);
  }

  for(let i=0; i<seniorCount; i++) {
    countArray.push(2);
  }

  for(let i=0; i<specialCount; i++) {
    countArray.push(3);
  }
}



// 가격 계산 업데이트

let countSet;
let elementCount;
let partialCountArray;

function updatePriceSection() {
  $("#price_calc > div").css('display', 'none');
  totalPrice = 0;

  partialCountArray = countArray.slice(0, choiceCount);
  countSet = new Set(partialCountArray);

  for(let i=0; i<4; i++){
    elementCount = partialCountArray.filter(element => Number(i) === element).length;
    $(`#price_calc > div:nth-child(${i+1}) > div > span:last-child`).text(elementCount);
  }

  countSet.forEach(i => {
    $(`#price_calc > div:nth-child(${i+1})`).css('display', 'flex');
  });

  // 합계

  for(let i=0; i<choiceCount; i++) {
    totalPrice += priceArray[countArray[i]];
  }

  $(`#price_calc > div:last-child > div > span:last-child`).text(totalPrice);

  if(choiceCount > 0) {
    $("#price_calc > div:last-child").css('display', 'flex');
  } else {
    $("#price_calc > div:last-child").css('display', 'none');
  }

}


function resetPriceSection() {
  $("#price_calc > div").css('display', 'none');
}


