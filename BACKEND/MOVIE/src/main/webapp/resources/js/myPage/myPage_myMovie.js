// 더보기 js
$(document).ready(function() {
    var cardsPerLoad = 5; // 한 번에 보여줄 카드의 개수
    var $cards = $('.more-load li.myreview'); // 카드 요소들을 선택합니다.
    
    console.log("더보기 영역으로 들어옴");
    console.log("5개 보여주기");
    // 처음에는 5개의 카드만 보이도록 설정
    $cards.hide().slice(0, cardsPerLoad).show();
  
    $('#list-more-btn').on('click', function() {
    
    console.log("더보기 버튼 누름");
      // 다음으로 보일 카드 개수만큼 선택하여 보이도록 설정
      $cards.filter(':hidden').slice(0, cardsPerLoad).show();
  
      // 모든 카드가 보여지면 내 리뷰 더 보기 버튼을 숨김
      if ($cards.filter(':hidden').length === 0) {
        $('#list-more-btn').hide();
      }
    });
  
    // 카드가 없을 경우에는 내 리뷰 더 보기 버튼을 숨깁니다.
    if ($cards.length <= cardsPerLoad) {
      $('#list-more-btn').hide();
    }
  });
  