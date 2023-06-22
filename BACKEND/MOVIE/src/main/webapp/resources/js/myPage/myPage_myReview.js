// 더보기 js
$(document).ready(function loadReviewCards() {
  var cardsPerLoad = 5; // 한 번에 보여줄 카드의 개수
  var loadedCards = 0; // 현재까지 로드된 카드의 개수
  var $cards = $('.more-load li.myreview'); // 카드 요소들을 선택합니다.
  console.log("review 영역으로 들어옴");
  console.log("5개 보여주기");
  // ajax 후 처음에는 5개의 카드만 보이도록 설정
  // function loadReviewCards() {
    console.log("ajax실행됨?");
    // 서버에 요청을 보내어 추가 데이터를 받아옵니다.
    $.ajax({
      url: 'loadReviewCards', // 서버 엔드포인트 주소
      method: 'POST',
      data: { loadedCards: loadedCards
            , cardsPerLoad: cardsPerLoad 
            }, // 로드된 카드의 개수와 한 번에 로드할 카드의 개수를 전달
      success: function(response) {
        // 서버로부터 받은 데이터(response)를 처리하여 화면에 추가합니다.
        console.log(response);
        console.log(response[1]);
        console.log(response[2]);
        if (response.length > 0) {
          response.forEach(function(review) {
            var cardData = review;
            // 카드를 생성하고 데이터를 채워서 화면에 추가하는 코드 작성
            var cardHTML = `
              <li class="myreview">
                <div>
                  <div>
                    <a href="${contextPath}/movieList/detail_List/introduce/${cardData.movie.movieNo}">
                      <img src="${cardData.movie.movieImg1}" alt="영화 포스터 w=186px,h=208px">
                    </a>
                  </div>
                  <div>
                    <div>
                      <div>${cardData.movie.movieTitle}</div>
                      <a class="i-dlt-btn" href="#">
                        <i class="fa-regular fa-circle-xmark"></i>
                      </a>
                    </div>
                    <div>
                      <ul>
                        <li>작성 날짜 :</li>
                        <li>작성 시간 :</li>
                      </ul>
                      <ul>
                        <li>${cardData.review.revDate}</li>
                        <li>${cardData.review.revTime}</li>
                      </ul>
                    </div>
                    <div>
                      <textarea>${cardData.review.revContent}</textarea>
                    </div>
                    <div>
                      <button id="updatereview-btn">내 리뷰 수정</button>
                    </div>
                  </div>
                </div>
              </li>
            `;
            $('.more-load').append(cardHTML); // 생성한 카드를 추가
          });
          loadedCards += response.length; // 로드된 카드 개수 업데이트
      
          // 모든 카드가 로드되었을 경우에는 내 리뷰 더 보기 버튼을 숨김
          if (response.length < cardsPerLoad) {
            $('#list-more-btn').hide();
          }
        }
      },
      error: function() {
        console.log('데이터를 불러오는데 실패했습니다.');
      }
    });
  
  // }
  $cards.hide().slice(0, cardsPerLoad).show();

  $('#list-more-btn').on('click', function() {
    console.log("더보기 버튼 누름");
    // 다음으로 보일 카드 개수만큼 선택하여 보이도록 설정
    loadReviewCards();
  });
  // 카드가 없을 경우에는 내 리뷰 더 보기 버튼을 숨깁니다.
  if ($cards.length <= cardsPerLoad) {
    $('#list-more-btn').hide();
  }
});

    
     