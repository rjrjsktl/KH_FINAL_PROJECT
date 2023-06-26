
$(".star_rating a").click(function() {
    $(this).parent().children("a").removeClass("on");
    $(this).addClass("on").prevAll("a").addClass("on");
    // 'on' 클래스 개수 확인
    var numberOfOnClasses = $(this).parent().children("a.on").length;
    console.log(numberOfOnClasses);
    return false;
  });


  function addReview() {
    const starRating = document.querySelectorAll('.star_rating .on').length;
    
    const reviewText = document.querySelector('.replywrite textarea').value;
    
    const li = document.createElement('li');
    
  
    li.innerHTML =
    `
      <span><img src="" alt=""></span>
      <div>
        <span>${mTmWriter}</span></span>
        <span>${mTmRegDate}</span>
      </div>
      <div>${reviewText}</div>
    `;
    
    const replyList = document.querySelector('.replyList ul');
    replyList.prepend(li);
    
    document.querySelector('.replywrite textarea').value = '';
  }
  
  const replyBtn = document.querySelector('.replyBtn');
  replyBtn.addEventListener('click', addReview);
  $(document).ready(function() {
    var itemsToShow = 5;
    
    $('.review').slice(0, itemsToShow).show();
  
    $('.morePage').on('click', function() {
      itemsToShow++;
      $('.review').slice(0, itemsToShow).slideDown();
    });
  });





$(document).ready(function() {
  $('.btn-quest').on('click', function() {
    $('.btn-quest').on('click', function() {
      $(".btn-wrap button").click(function() {
 // 기존에 선택된 버튼의 스타일을 초기화합니다.
 $(".btn-wrap button").css({
   "background-color": "#151515",
   "color": "white"
 });
 
 // 현재 클릭된 버튼의 스타일을 변경합니다.
 $(this).css({
   "background-color": "white",
   "color": "#151515"
 });
       
     });
 });
      var btnNumber = $(this).data('quest-num');
      fetchQuestionCount(btnNumber);
  });
});

function fetchQuestionCount(btnNumber) {
  $.ajax({
      url: '/question_home',
      type: 'GET',
      data: {
          cp: 1, // cp 기본값 유지
          btnNumber: btnNumber // 새로운 변수 사용
      },
      success: function(data) {
          $('.counts').text(data + '건');
      },
      error: function(err) {
          console.error(err);
      }
  });
}