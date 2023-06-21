// 내가 본 영화, 쓴 리뷰 더보기 버튼 구현 
//          참고용
// $('.more-load > div').hide();
//      $(".list > div").slice(0, 5).css("display", "block"); 
//     $("#load").click(function(e){
//         e.preventDefault();
//         $(".list >div:hidden").slice(0, 5).fadeIn(200).css('display', 'block'); // 클릭시 more 갯수 지저정
//         if($(".list >div:hidden").length == 0){ // 컨텐츠 남아있는지 확인
//             $('#load').fadeOut(100); // 컨텐츠 없을 시 버튼 사라짐
//         }
//     });


// 5개씩 불러오는 거 하다만거
// console.log("reviewJs 실행됨");

// $(document).ready(function(){
	
//     // 조회 인덱스
// 	var startMovie = 1;	// 인덱스 초기값
// 	var addStep = 5;	// 5개씩 로딩
	
// 	// 페이지 로딩 시 첫 실행
//     console.log("loadMoreReviews 실행됨");
// 	loadMoreReviews(startMovie);
	
// 	// 더보기 클릭시
// 	$('#list-more-btn').click(function(){
// 		startMovie += addStep;
// 		loadMoreReviews(startMovie);
//     })
		
// 	// 더보기 실행함수 **
// 	function loadMoreReviews(startMovie) {
//         var addStep = 5;
//         $.ajax({
//             url: "myReview/addReview",
//             dataType: "json",
//             data: {
//                 // userNo: '${loginUser.userNo}',
//                 startMovie: startMovie,
//                 endMovie: startMovie + addStep - 1
//             },
//             type: "POST",
//             success: function(data) {
//                 data.forEach(function(item) {
//                     console.log("Movie No: " + item.movie.movieNo);
//                     console.log("Movie Image: " + item.movie.movieImg1);
//                     console.log("Movie Title: " + item.movie.movieTitle);
//                     console.log("Review Date: " + item.review.revDate);
//                     console.log("Review Time: " + item.review.revTime);
//                     console.log("Review Content: " + item.review.revContent);
//                 });
//             },
//             error: function () {
//                 console.log("add AJAX 값을 못받아옴 다시하셈");
//             }
//         });
//     }
// });

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

    
     