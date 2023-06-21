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


$(document).ready(function(){
	// 읽은 알림 총 갯수
	var oldListCnt = '${oldListCnt}';
	// 조회 인덱스
	var startMovie = 1;	// 인덱스 초기값
	var addStep = 5;	// 5개씩 로딩
	
	// 페이지 로딩 시 첫 실행
	readAddMovie(startMovie);
	
	// 더보기 클릭시
	$('#list-more-btn').click(function(){
		startMovie += addStep;
		readAddMovie(startMovie);
    })
		
	// 더보기 실행함수 **
	function readAddMovie(Movie){
		let _endMovie = Movie+addStep-1;	// endMovie설정
		$.ajax({
			type: "post",
			async: "true",
			dataType: "json",
			data: {
				m_id: '${m_id}',
				startMovie: Movie,
				endMovie: _endMovie
			},
			url: "/addReview",
			success: function (data, textStatus) {
				let NodeList = "";
				for(i = 0; i < data.length; i++){
					let newNode = "<div style='display: none;' class='card form-group col-sm-10 mx-auto p-0' onClick='window.open('"+data[i].n_url+"')>";
					newNode += "<div class='card-body pt-3'><div class='row px-3 mb-2'>";
					newNode += "<strong class='d-block text-gray-dark'>"+data[i].n_type+"</strong>";
					newNode += "<span class='text-muted ml-auto'>"+data[i].n_time+"</span>";
					newNode += "</div><span>"+data[i].n_content+"</span></div></div>";
					NodeList += newNode;
				}
				$(NodeList).appendTo($("#oldList")).slideDown();

				// 더보기 버튼 삭제
				if(startMovie + addStep > oldListCnt){
					$('#addMoreNotify').remove();
				}				
			}
		});
	}
});