let totalCount = 0;
let choiceCount = 0;

let adultCount = $('#adult_count').text();
let youthCount = $('#youth_count').text();
let seniorCount = $('#senior_count').text();
let specialCount = $('#special_count').text();

let seatArray = [];
let countArray = [];
let choiceArray = [];

let priceArray = [Number(adultPrice), Number(youthPrice), Number(seniorPrice), Number(specialPrice)];
let totalPrice = 0;


// 1. 좌석 커스터마이징

// [배열] 각 줄마다 몇 개의 좌석이 있는지??

let rowArr = Array.from({length: maxRow}, () => maxColumn);


// 좌석의 가로 크기(width)는 25px, 좌석 간의 가로 공간(margin)은 5.98px

let rowWidth = 25*(maxColumn) + 5.98 * (maxColumn-1);


// 스크린과 좌석 영역의 전체 길이 설정

$('#screen_area').css('width', `calc(${rowWidth}px + 1px)`);
$('#seat_area').css('width', `calc(${rowWidth}px)`);


// 모든 좌석에 하이퍼링크 부여

let s1 = `<a href="#none"><span>`;
let s2 = `</span></a>`;

for(let k=1; k<=maxRow; k++){
  for(let i=1; i<=maxColumn; i++){
    let seat = document.createElement('a');
    seat.href = "#none";
    document.querySelector(`#seat_area > div:nth-child(${k})`).appendChild(seat);
  }
}


// 통로와 공간은 보이지 않으며, 선택되지 않는다.
// 번호를 셀 때 통로는 제외되나 공간은 포함된다.

// 1-F1) 통로 만들기 

function createAisle(i, k) {
  $(`#seat_area > div:nth-child(${i}) > a:nth-of-type(${k})`).addClass('aisle');
  rowArr[i-1] -= 1;
}

for(let r=1; r<=maxRow; r++) {
  aisle.forEach(c => createAisle(r, c));
}


// 1-F2) 공간 만들기

function createSpace(i, k) {
  $(`#seat_area > div:nth-child(${i}) > a:nth-of-type(${k})`).addClass('space');
}

for(let i=0; i<space.length; i++) {
  space[i][0].forEach(r => {
    space[i][1].forEach(c => createSpace(r, c));
  });
}



// 좌석 번호

let alphabet = 'ABCDEFGHIJKLMNOPQLSTUVWXYZ';

for(let k=1; k<=maxRow; k++) {
  $(`#seat_area > div:nth-child(${k}) > div:first-child`).text(alphabet[k-1]);
}

for(let k=1; k<=maxRow; k++) {
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




selectedSeatArray.forEach(item => {
  $(`#seat_area > div > a[data-seat=${item}]`).addClass('selected');
});

impairedSeatArray.forEach(item => {
  $(`#seat_area > div > a[data-seat=${item}]`).addClass('impared');
});

sweetSeatArray.forEach(item => {
  $(`#seat_area > div > a[data-seat=${item}]`).addClass('sweet');
});




// 2. 인원 선택

// 2-E1) 플러스 버튼을 클릭하면??

$('.plus_btn').click(function(){
  let count = $(this).prev();

  if(totalCount < 8) {
    // 총합이 8 미만이라면
    // 해당 버튼 왼쪽의 숫자가 증가함
    // 총합이 증가함
    // 일련의 함수들이 작동함
    count.text(Number(count.text()) + 1);
    totalCount++;
    updateCount();
    updateSeatSection();
    updateCountArray();
    resetPriceSection();
  } else {
    alert("최대 8명까지 선택할 수 있습니다.");
  }
});


// 2-E2) 마이너스 버튼을 클릭하면??

$('.minus_btn').click(function(){
  let count = $(this).next();

  if(Number(count.text()) > 0) {
    // 해당 버튼 오른쪽의 숫자가 0보다 크다면
    // 그 숫자가 감소하며, 총합도 감소함
    // 일련의 함수들이 작동함
    count.text(Number(count.text()) - 1);
    totalCount--;
    updateCount();
    updateSeatSection();
    updateCountArray();
    resetPriceSection();
  }
});


// 2-F1) 선택 인원 초기화

function updateCount() {
  // 연령별 선택인원이 다시 변경됨
  // 선택 중인 좌석들이 모두 없어짐
  adultCount = $('#adult_count').text();
  youthCount = $('#youth_count').text();
  seniorCount = $('#senior_count').text();
  specialCount = $('#special_count').text();

  $('#seat_area > div > a').removeClass("selecting");
  choiceCount = 0;
  seatArray = [];
}





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

for(let i=0; i<priceArray.length; i++) {
  $(`#price_calc > div:nth-child(${i+1}) > div > span:first-child`).text(priceArray[i]);
}

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


