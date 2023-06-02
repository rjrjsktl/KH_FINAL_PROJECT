// ===============================================================================
// 상영 영화관 추가 기능 및 슬라이드
let cinema_Arr = [];
const play_cinema_enter = $('.play_cinema_enter');
const play_cinema_slide = $('.play_cinema_slide > div');

play_cinema_slide.on('click', (e) => {
    e.preventDefault();
    // alert((e.currentTarget).innerText);
    const newDiv = document.createElement('div');
    const addText = $(e.currentTarget).text();
    const delBtn = '<div class="deleteBtn"><i class="fa-solid fa-xmark fa-2xs"></i></div>';
    const clickCount = play_cinema_enter.children().length;

    if ($.inArray($(e.currentTarget).text(), cinema_Arr) == -1) {
        if (clickCount >= 5) {
            alert('최대 5개 까지 선택 가능합니다.');
            return false;
        } else {
            newDiv.append(addText);
            newDiv.classList.add('added');
            newDiv.innerHTML += delBtn;
            play_cinema_enter.append(newDiv);
            cinema_Arr.push(addText)
            console.log("추가된 값은 : " + addText);
        }
    } else {
        alert('같은 값은 추가 할 수 없습니다.');
        return false;
    }
    console.log("clickCount : " + clickCount);
    console.log(cinema_Arr);
});

// 배열에서 삭제
play_cinema_enter.on('click', '.added', (e) => {
    e.stopPropagation();
    const clickedText = $(e.currentTarget).text();

    for (let i = 0; i < cinema_Arr.length; i++) {
        if (cinema_Arr[i] === clickedText) {
            cinema_Arr.splice(i, 1);
            console.log("제거된 값은 : " + clickedText);
            break;
        }
    }
    console.log(cinema_Arr);
    $(e.currentTarget).remove();
});


// 상영 영화관 슬라이드 토글
const Cinema_slide = $('.cinema_Items');

play_cinema_enter.on('click', (e) => {
    e.stopPropagation();
    Cinema_slide.toggle();
    movie_slide.hide();
    time_slide.hide();
});
Cinema_slide.on('click', (e) => {
    e.stopPropagation();
    Cinema_slide.toggle();
    movie_slide.hide();
    time_slide.hide();
});

$(document).on('click', () => {
    Cinema_slide.hide();
});





// ===============================================================================
// 상영 영화 추가 기능 및 슬라이드
let movie_Arr = [];
const play_movie_enter = $('.play_movie_enter');
const play_movie_slide = $('.play_movie_slide > div');

play_movie_slide.on('click', (e) => {
    e.preventDefault();
    // alert((e.currentTarget).innerText);
    const newDiv = document.createElement('div');
    const addText = $(e.currentTarget).text();
    const delBtn = '<div class="deleteBtn"><i class="fa-solid fa-xmark fa-2xs"></i></div>';
    const clickCount = play_movie_enter.children().length;

    if ($.inArray($(e.currentTarget).text(), movie_Arr) == -1) {
        if (clickCount >= 1) {
            alert('1개만 선택 가능합니다.');
            return false;
        } else {
            newDiv.append(addText);
            newDiv.classList.add('added');
            newDiv.innerHTML += delBtn;
            play_movie_enter.append(newDiv);
            movie_Arr.push(addText)
            console.log("추가된 값은 : " + addText);
        }
    } else {
        alert('같은 값은 추가 할 수 없습니다.');
        return false;
    }
    console.log("clickCount : " + clickCount);
    console.log(movie_Arr);
});

// 배열에서 삭제
play_movie_enter.on('click', '.added', (e) => {
    e.stopPropagation();
    const clickedText = $(e.currentTarget).text();

    for (let i = 0; i < movie_Arr.length; i++) {
        if (movie_Arr[i] === clickedText) {
            movie_Arr.splice(i, 1);
            console.log("제거된 값은 : " + clickedText);
            break;
        }
    }
    console.log(movie_Arr);
    $(e.currentTarget).remove();
});

// 상영 영화 슬라이드 토글
const movie_slide = $('.movie_Items');

play_movie_enter.on('click', (e) => {
    e.stopPropagation();
    movie_slide.toggle();
    Cinema_slide.hide();
    time_slide.hide();
});
movie_slide.on('click', (e) => {
    e.stopPropagation();
    movie_slide.toggle();
    Cinema_slide.hide();
    time_slide.hide();
});

$(document).on('click', () => {
    movie_slide.hide();
});

// ===============================================================================
// 영화 상영시간 추가 기능 및 슬라이드
let time_Arr = [];
const play_time_enter = $('.play_time_enter');
const play_time_slide = $('.play_time_slide > div');

play_time_slide.on('click', (e) => {
    e.preventDefault();
    // alert((e.currentTarget).innerText);
    const newDiv = document.createElement('div');
    const addText = $(e.currentTarget).text();
    const delBtn = '<div class="deleteBtn"><i class="fa-solid fa-xmark fa-2xs"></i></div>';
    const clickCount = play_time_enter.children().length;

    if ($.inArray($(e.currentTarget).text(), time_Arr) == -1) {
        if (clickCount >= 8) {
            alert('최대 8개까지 선택 가능합니다.');
            return false;
        } else {
            newDiv.append(addText);
            newDiv.classList.add('added');
            newDiv.innerHTML += delBtn;
            play_time_enter.append(newDiv);
            time_Arr.push(addText)
            console.log("추가된 값은 : " + addText);
        }
    } else {
        alert('같은 값은 추가 할 수 없습니다.');
        return false;
    }
    console.log("clickCount : " + clickCount);
    console.log(time_Arr);
});

// 배열에서 삭제
play_time_enter.on('click', '.added', (e) => {
    e.stopPropagation();
    const clickedText = $(e.currentTarget).text();

    for (let i = 0; i < time_Arr.length; i++) {
        if (time_Arr[i] === clickedText) {
            time_Arr.splice(i, 1);
            console.log("제거된 값은 : " + clickedText);
            break;
        }
    }
    console.log(time_Arr);
    $(e.currentTarget).remove();
});

// 영화 상영시간 슬라이드 토글
const time_slide = $('.time_Items');

play_time_enter.on('click', (e) => {
    e.stopPropagation();
    time_slide.toggle();
    Cinema_slide.hide();
    movie_slide.hide();
});
time_slide.on('click', (e) => {
    e.stopPropagation();
    time_slide.toggle();
    Cinema_slide.hide();
    movie_slide.hide();
});

$(document).on('click', () => {
    time_slide.hide();
});


// ===============================================================================
// 날짜 비교


let startDate = $('.start_date');
let endDate = $('.end_date');
let getCurrentDate = new Date();
let currentDate = getCurrentDate.getFullYear() + "-" + ('0' + (getCurrentDate.getMonth() + 1)).slice(-2) + "-" + getCurrentDate.getDate();
// ('0' + (getCurrentDate.getMonth() + 1)).slice(-2) 을 사용하는 이유
// -> 앞에 0을 추가해준 상태로 출력하면, 011월 012월 같은 혼종이 나오기 때문에, 뒤에서 두자리만 자르게끔 한다.

// 상영 종료일
endDate.on('change', () => {

    let startValue = startDate.val(); // 시작일의 값
    let endValue = endDate.val(); // 종료일의 값

    let startArray = startValue.split('-');
    let endArray = endValue.split('-');

    // 월은 01월, 02월 같이 0부터 시작하므로 1을 뺀다.
    let checkStartDate = new Date(startArray[0], startArray[1] - 1, startArray[2]);
    let checkEndDate = new Date(endArray[0], endArray[1] - 1, endArray[2]);


    if (checkStartDate.getTime() > checkEndDate.getTime()) {
        alert('종료일은 시작일보다 빠를 수 없습니다.');
        $('.end_date').val("");
        return false;
    }

    if (!startDate.val()) {
        alert('시작일을 먼저 선택해 주세요.');
        $('.end_date').val("");
    }
});

// 상영 시작일
startDate.on('change', () => {

    let currentValue = currentDate;
    let startValue = startDate.val(); // 시작일의 값

    let currentArray = currentValue.split('-');
    let startArray = startValue.split('-');

    // 월은 01월, 02월 같이 0부터 시작하므로 1을 뺀다.
    let checkCurrentDate = new Date(currentArray[0], currentArray[1] - 1, currentArray[2]);
    let checkStartDate = new Date(startArray[0], startArray[1] - 1, startArray[2]);

    if (checkStartDate.getTime() < checkCurrentDate.getTime()) {
        alert('시작일은 오늘 (' + currentDate + ') 보다 빠를 수 없습니다.');
        $('.start_date').val("");
        return false;
    }
});
// ===============================================================================
// 결과값 확인용

const submitBtn = $('.bottom_Submit');


submitBtn.on('click', () => {
    console.log('상영 영화관 : ' + cinema_Arr);
    console.log('상영 영화 : ' + movie_Arr);
    console.log('상영 시작일 : ' + startDate.val());
    console.log('상영 종료일 : ' + endDate.val());
    console.log('상영 시간 : ' + time_Arr);
});

// const slideUpAll = $('.set_Edge');
// slideUpAll.on('click', (e) => {
//     e.preventDefault();
//     Cinema_slide.slideUp();
//     movie_slide.slideUp();
//     time_slide.slideUp();
// });