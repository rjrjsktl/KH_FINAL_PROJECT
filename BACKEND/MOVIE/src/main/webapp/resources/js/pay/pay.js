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

///////////////////////////////////////////////////////////////////

// 모달 
$(document).ready(function() {
  // modalClick 클래스 클릭 이벤트 처리
  $(".modalClick").click(function() {
    $(".modal").show(); // 모달 표시
  });

  // 모달 내부의 닫기 버튼 클릭 이벤트 처리
  $(".exitBtn").click(function() {
    $(".modal").hide(); // 모달 숨기기
  });
});

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

///////////////////////////////////////////////////////////////////

// 관람권 코드 확인

const movieTicket = document.getElementById("movieTicket");
const ticketCode = document.getElementById("ticketCode");
movieTicket.addEventListener("click", function() {
  console.log("관람권을 찾으러 가보자");

  $.ajax({
    url: "selectTicket",
    data: {
      "COUPONNO": ticketCode.value
    },
    type: "POST",
    success: function(storeCouponList) {
      if (storeCouponList != null) {
        console.log(storeCouponList);
        console.log("입력한 관람권코드가 유효합니다");
        ticketCode.value = ""; // 검색후 코드 인풋란 초기화
      }

      if (storeCouponList.length > 0) {
        storeCouponList.forEach(function(coupon) {
          var couponStatus = coupon.couponSt === 'Y' ? '미사용' : '사용';

          var cardHTML = `
            <tr style="border: 1px solid; width: 100%; height: 30px;">
              <td class="couponDetailNo" style="border: 1px solid; width: 60.5%; text-align: center;">
                ${coupon.couponDetailNo}
              </td>
              <td style="border: 1px solid; width: 20.5%; text-align: center;">
                ${coupon.couponSt}
              </td>
              <td style="width: 17.5%; text-align: center;">
                <button class="couponBtn" style="width: 65px;">${couponStatus}</button>
              </td>
            </tr>
          `;
          document.querySelector(".ticketTable_2").innerHTML += cardHTML;
        });
      } else {
        console.log("관람권코드가 잘못되었거나 찾을 수 없습니다");
        alert("코드를 올바르지 않거나 찾을 수 없습니다");
      }
    },
    error: function() {
      console.log("관람권을 찾으러 가기 실패했습니다");
    }
  });
});

$(document).on('click', '.couponBtn', function() {
  var couponBtn = $(this);
  var couponDetailNo = couponBtn.closest('tr').find('.couponDetailNo').text();

  if (couponBtn.text() === '미사용') {
    var confirmMessage = 'KGC 관람권을 사용하시겠습니까?';
    if (confirm(confirmMessage)) {
      couponBtn.text('사용');
      updateCouponStatus(couponDetailNo);
    }
  } else if (couponBtn.text() === '사용') {
    var confirmMessage = 'KGV 관람권 사용을 취소하시겠습니까?';
    if (confirm(confirmMessage)) {
      couponBtn.text('미사용');
      updateCouponStatus(couponDetailNo);
    }
  }
});

function updateCouponStatus(couponDetailNo) {
  $.ajax({
    url: "updateTicketStatus",
    data: {
      "COUPON_DETAIL_NO": couponDetailNo
    },
    type: "POST",
    success: function(result) {
      if (result > 0) {
        console.log("관람권 상태를 변경했습니다");
      } else {
        console.log("관람권 상태 변경에 실패했습니다");
      }
    },
    error: function() {
      console.log("관람권 상태 업데이트 중 오류가 발생했습니다");
    }
  });
}







