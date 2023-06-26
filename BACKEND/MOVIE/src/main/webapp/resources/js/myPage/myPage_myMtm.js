$(document).ready(function(){
    const deleteMtm = $("#deleteMtm"); 

    	deleteMtm.on('click', function(){
  
        	let mtmNo = $(this).data('mtmno');
    		let cp = $("#cp").val(); // HTML에서 'cp' 값 가져오기
        	let url = `/movie/myPage/deleteMtm/${mtmNo}?cp=`+cp; // URL에 'cp' 파라미터 값을 추가합니다.

        	if( confirm("정말로 삭제 하시겠습니까?") ){
            	window.location.href = url;
        	}
    });
});
