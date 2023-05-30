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

let rowArr = Array.from({length: 12}, () => 24);

let s1 = `<a href="#none"><span>`;
let s2 = `</span></a>`;
for(let k=1; k<=12; k++){
  for(let i=1; i<=24; i++){
    let seat = document.createElement('a');
    seat.href = "#none"; 
    document.querySelector(`#seat_area > div:nth-child(${k})`).appendChild(seat);
  }
}


// 통로 만들기 

function createAisle(i, k) {
  $(`#seat_area > div:nth-child(${i}) > a:nth-of-type(${k})`).css('border', 'none');
  $(`#seat_area > div:nth-child(${i}) > a:nth-of-type(${k})`).addClass('aisle');
  $(`#seat_area > div:nth-child(${i}) > a:nth-of-type(${k})`).empty();
  rowArr[i-1] -= 1;
}

for(let i=1; i<=12; i++) {
  createAisle(i, 5);
  createAisle(i, 6);
  createAisle(i, 19);
  createAisle(i, 20);
}

for(let i=1; i<=8; i++) {
  createAisle(i, 23);
  createAisle(i, 24);
}

for(let i=1; i<=4; i++) {
  createAisle(i, 1);
  createAisle(i, 2);
  createAisle(i, 3);
  createAisle(i, 4);
}

console.log(rowArr);


// 좌석 번호

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
    }
    j++;
  }

  console.log(k);
}



// 좌석 선택

$('#seat_area > div > a:not(.selected, .aisle)').on("click", function(){
  if((totalCount > choiceCount) && !($(this).hasClass("selecting"))) {
    $(this).addClass("selecting");
    choiceCount++;
  } else if($(this).hasClass("selecting")) {
    $(this).removeClass("selecting");
    choiceCount--;
  }
});


