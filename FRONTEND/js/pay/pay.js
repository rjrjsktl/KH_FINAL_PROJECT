// DOMContentLoaded 이벤트 핸들러
document.addEventListener('DOMContentLoaded', function() {
    var discountStepLi = document.querySelector('.discount_step_li.slide');
    discountStepLi.addEventListener('click', handleClick);
});
  
// 클릭 이벤트 핸들러
function handleClick(event) {
    var target = event.target;
    var parentLi = target.closest('.discount_step_li');
    var displayChoice = parentLi.nextElementSibling; // 다음 형제 요소 
    
    toggleClass(displayChoice, 'slide_none');
    toggleClass(parentLi, 'click_change_bColor');
    
    setTimeout(function() {
      toggleClass(displayChoice, 'slide_block');
    }, 0);
}
  
// toggleClass 함수 정의
function toggleClass(element, className) {
    if (element.classList.contains(className)) {
      element.classList.remove(className);
    } else {
      element.classList.add(className);
    }
}

// 모달 
$(document).ready(function() {
  // modalClick 클래스 클릭 이벤트 처리
  $(".modalClick").click(function() {
    $(".modal").show(); // 모달 표시
  });

  // 모달 내부의 닫기 버튼 클릭 이벤트 처리
  $(".modal button").click(function() {
    $(".modal").hide(); // 모달 숨기기
  });
});

///////////////////////////////////////////////////////////////////
var box1 = document.querySelector('.box_1');
var modal = document.querySelector('.modal');
var isDragging = false;
var dragOffset = { x: 0, y: 0 };

box1.addEventListener('mousedown', function(event) {
  isDragging = true;
  dragOffset.x = event.clientX - modal.offsetLeft;
  dragOffset.y = event.clientY - modal.offsetTop;
});

document.addEventListener('mousemove', function(event) {
  if (isDragging) {
    modal.style.left = event.clientX - dragOffset.x + 'px';
    modal.style.top = event.clientY - dragOffset.y + 'px';
  }
});

document.addEventListener('mouseup', function() {
  isDragging = false;
});



box1.addEventListener('mouseenter', function() {
  document.body.style.cursor = 'move';
});

box1.addEventListener('mouseleave', function() {
  document.body.style.cursor = 'default';
});