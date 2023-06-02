console.log("loginPage.js loaded..")

console.log(document.cookie)

// 로그인 유효성 검사
function loginValidate(){
    
    console.log("loginValidate function loaded..")
    
    // validate : 유효하다    
    // invalidate : 무효하다    

    // 이메일 입력 input 요소 
    const userEmail = document.getElementsByName("userEmail")[0];

    // 비밀번호 입력 input 요소
    const userPw = document.getElementsByName("userPw")[0];


    // 이메일이 입력되지 않은 경우 false를 반환
    if( userEmail.value.trim().length == 0 ){
        // 문자열.trim() : 문자열 양쪽 공백을 제거
        // 문자열.length : 문자열 길이(몇 글자?)

        alert("이메일을 입력해주세요.");
        userEmail.value = ""; // 이메일 input에 입력된 내용을 모두 삭제
        userEmail.focus(); // 이메일 input에 포커스를 맞춰줌
        return false; // 기본 이벤트 제거를 위해 false 반환
    }

    // 비밀번호를 입력하지 않은 경우 false 반환
    if(userPw.value.trim() == ""){
        alert("비밀번호를 입력해주세요.");
        userPw.value = "";
        userPw.focus();
        return false;
    }


    return true; // form 태그 기본 이벤트 정상 수행
}

// 즉시 실행 함수(속도 빠름, 변수명 중복 문제 해결)
//(function(){
//    selectAll(); // 함수 호출 -> 회원 목록을 먼저 조회
//	window.console.log("slectAll 실행")
//    //window.setInterval(함수, 딜레이(ms))
//    window.setInterval(selectAll, 10000); // 10초
//    // 함수 이름만 작성 -> 함수 코드가 대입
//    // -> 10초마다 selectAll 함수 수행
//
//    // setInterval()은 지연 -> 수행 -> 지연 -> 수행 ... 반복
//    // --> 처음에 함수가 수행되지 않아서 공백인 상태가 있음
//
//})();



