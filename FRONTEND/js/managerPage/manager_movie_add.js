const slide_Wrapper = $('.slide_Content > .slide_Wrapper');

slide_Wrapper.on('click', (e) => {
    e.preventDefault();

    const slideDownItems = $(e.currentTarget).next('.slide_Down_items');
    const isActive = slideDownItems.is(':visible');

    $('.slide_Down_items').slideUp();
    slide_Wrapper.removeClass('active');

    if (!isActive) {
        slideDownItems.slideDown();
        $(e.currentTarget).addClass('active');
    }
});

const top_items = $('.top_Click_area > .top_items');

top_items.on('click', (e) => {
    e.preventDefault();

    const top_Click_area = $(e.currentTarget).next('.top_Click_area');
    const isActive = top_Click_area.is('.active');


    // top_items.addClass('active')
    top_items.removeClass('active')

    if (!isActive) {
        // $(e.currentTarget).removeClass('active')
        $(e.currentTarget).addClass('active')
    }
});

// ===============================================================================
// 장르 추가 기능 및 슬라이드
let genre_Arr = [];
const movie_Genre = $('.movie_Genre');
const movie_genre_slide = $('.movie_genre_slide > div');

movie_genre_slide.on('click', (e) => {
    e.preventDefault();
    // alert((e.currentTarget).innerText);
    const newDiv = document.createElement('div');
    const addText = $(e.currentTarget).text();
    const delBtn = '<div class="deleteBtn"><i class="fa-solid fa-xmark fa-2xs"></i></div>';
    const clickCount = movie_Genre.children().length;

    if ($.inArray($(e.currentTarget).text(), genre_Arr) == -1) {
        if (clickCount >= 5) {
            alert('5개만 선택 가능합니다.');
            return false;
        } else {
            newDiv.append(addText);
            newDiv.classList.add('added');
            newDiv.innerHTML += delBtn;
            movie_Genre.append(newDiv);
            genre_Arr.push(addText)
            console.log("추가된 값은 : " + addText);
        }
    } else {
        alert('같은 값은 추가 할 수 없습니다.');
        return false;
    }
    console.log("clickCount : " + clickCount);
    console.log(genre_Arr);
});

// 배열에서 삭제
movie_Genre.on('click', '.added', (e) => {
    e.stopPropagation();
    const clickedText = $(e.currentTarget).text();

    for (let i = 0; i < genre_Arr.length; i++) {
        if (genre_Arr[i] === clickedText) {
            genre_Arr.splice(i, 1);
            console.log("제거된 값은 : " + clickedText);
            break;
        }
    }
    console.log(genre_Arr);
    $(e.currentTarget).remove();
});

// 상영 영화 슬라이드 토글
const Genre_Items = $('.Genre_Items');

movie_Genre.on('click', (e) => {
    e.stopPropagation();
    Genre_Items.toggle();
    level_slide.hide();
});
Genre_Items.on('click', (e) => {
    e.stopPropagation();
    Genre_Items.toggle();
    level_slide.hide();
});

$(document).on('click', () => {
    Genre_Items.hide();
});

// ===============================================================================
// 관람등급 추가 기능 및 슬라이드
let level_Arr = [];
const movie_level = $('.movie_level');
const movie_level_slide = $('.movie_level_slide > div');

movie_level_slide.on('click', (e) => {
    e.preventDefault();
    // alert((e.currentTarget).innerText);
    const newDiv = document.createElement('div');
    const addText = $(e.currentTarget).text();
    const delBtn = '<div class="deleteBtn"><i class="fa-solid fa-xmark fa-2xs"></i></div>';
    const clickCount = movie_level.children().length;

    if ($.inArray($(e.currentTarget).text(), level_Arr) == -1) {
        if (clickCount >= 1) {
            alert('1개만 선택 가능합니다.');
            return false;
        } else {
            newDiv.append(addText);
            newDiv.classList.add('added');
            newDiv.innerHTML += delBtn;
            movie_level.append(newDiv);
            level_Arr.push(addText)
            console.log("추가된 값은 : " + addText);
        }
    } else {
        alert('같은 값은 추가 할 수 없습니다.');
        return false;
    }
    console.log("clickCount : " + clickCount);
    console.log(level_Arr);
});

// 배열에서 삭제
movie_level.on('click', '.added', (e) => {
    e.stopPropagation();
    const clickedText = $(e.currentTarget).text();

    for (let i = 0; i < level_Arr.length; i++) {
        if (level_Arr[i] === clickedText) {
            level_Arr.splice(i, 1);
            console.log("제거된 값은 : " + clickedText);
            break;
        }
    }
    console.log(level_Arr);
    $(e.currentTarget).remove();
});

// 상영 영화 슬라이드 토글
const level_slide = $('.level_Items');

movie_level.on('click', (e) => {
    e.stopPropagation();
    level_slide.toggle();
    Genre_Items.hide();
});
level_slide.on('click', (e) => {
    e.stopPropagation();
    level_slide.toggle();
    Genre_Items.hide();
});

$(document).on('click', () => {
    level_slide.hide();
});