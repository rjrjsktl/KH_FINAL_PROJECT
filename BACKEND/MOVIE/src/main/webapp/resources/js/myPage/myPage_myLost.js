$(document).ready(function(){
    const deleteLost = $("#deleteLost"); 

        deleteLost.on('click', function(){
      
            let lostNo = $(this).data('lostno');
            let cp = $("#cp").val(); // HTML에서 'cp' 값 가져오기
            
            let url = `/movie/myPage/deleteLost/${lostNo}?cp=`+cp;

            if( confirm("정말로 삭제 하시겠습니까?") ){
                window.location.href = url; // get방식으로 url에 요청
            }
        });
});

