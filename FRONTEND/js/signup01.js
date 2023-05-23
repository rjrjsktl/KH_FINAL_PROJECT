/* signUp.js */


// 유효성 검사 여부를 기록할 객체 생성
const checkObj = {
    "memberEmail": false,
    "memberPw": false,
    "memberPwConfirm": false,
    "memberNickname": false,

    "memberTel": false,
    // "sendEmail"       : false   // 인증번호 발송 체크
};



// 전화번호 유효성 검사
const memberTel = document.getElementById("memberTel");
const telMessage = document.getElementById("telMessage");


memberTel.addEventListener("input", function () {

    // 입력이 되지 않은 경우
    if (memberTel.value.length == 0) {

        telMessage.innerText = "전화번호를 입력해주세요.(- 제외)";
        telMessage.classList.remove("confirm", "error");

        checkObj.memberTel = false;
        return;

    }

    // 연락처 정규식
    const regExp = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

    if (regExp.test(memberTel.value)) { // 유효한 경우
        telMessage.innerText = "유효한 연락처 형식입니다.";
        telMessage.classList.add("confirm");
        telMessage.classList.remove("error");

        checkObj.memberTel = true;

    } else { // 유효하지 않은 경우
        telMessage.innerText = "연락처 형식이 올바르지 않습니다.";
        telMessage.classList.add("error");
        telMessage.classList.remove("confirm");

        checkObj.memberTel = false;
    }
});


// 이메일 유효성 검사
const memberEmail = document.getElementById("memberEmail");
const emailMessage = document.querySelector("#emailMessage");

memberEmail.addEventListener("input", function () {

    // 입력이 되지 않은 경우
    if (memberEmail.value.length == 0) {
        emailMessage.innerText = "메일을 받을 수 있는 이메일을 입력해주세요.";
        emailMessage.classList.remove("confirm", "error");

        checkObj.memberEmail = false;

        return;
    }

    // 입력된 경우

    // emailMessage.style.display = "block";

    //emailMessage.style.color = "blue";

    const regExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

    if (regExp.test(memberEmail.value)) { // 유효한 경우

        emailMessage.innerText = "사용 가능한 이메일 입니다.";
        emailMessage.classList.add("confirm");
        emailMessage.classList.remove("error");

        checkObj.memberEmail = true;



    } else {
        emailMessage.innerText = "이메일 형식이 유효하지 않습니다.";
        emailMessage.classList.add("error");
        emailMessage.classList.remove("confirm");

        checkObj.memberEmail = false;

    }

});


// 닉네임 유효성 검사
const memberNickname = document.getElementById("memberNickname");
const nicknameMessage = document.getElementById("nicknameMessage");

memberNickname.addEventListener("input", function () {

    // 입력되지 않은 경우
    if (memberNickname.value.length == 0) {
        nicknameMessage.innerText = "영어/숫자/한글 2~10글자 사이로 작성해주세요.";
        nicknameMessage.classList.remove("confirm", "error");

        checkObj.memberNickname = false;
        return;
    }

    const regExp = /^[a-zA-Z0-9가-힣]{2,10}$/;

    if (regExp.test(memberNickname.value)) { // 유효한 경우

        nicknameMessage.innerText = "사용 가능한 닉네임 입니다.";
        nicknameMessage.classList.add("confirm");
        nicknameMessage.classList.remove("error");

        checkObj.memberNickname = true;

    } else {
        nicknameMessage.innerText = "닉네임 형식이 유효하지 않습니다.";
        nicknameMessage.classList.add("error");
        nicknameMessage.classList.remove("confirm");

        checkObj.memberNickname = flase;

    }

});



// 이름 유효성 검사
const membername = document.getElementById("membername");
const nameMessage = document.getElementById("nameMessage");

membername.addEventListener("input", function () {

    // 입력되지 않은 경우
    if (membername.value.length == 0) {
        nameMessage.innerText = "한글 2~10글자 사이로 작성해주세요.";
        nameMessage.classList.remove("confirm", "error");

        checkObj.membername = false;
    }

    const regExp = /^[가-힣]{2,10}$/;

    if (regExp.test(membername.value)) { // 유효한 경우

        nameMessage.innerText = "사용 가능한 이름 입니다.";
        nameMessage.classList.add("confirm");
        nameMessage.classList.remove("error");

        checkObj.membername = true;


    } else {
        nameMessage.innerText = "닉네임 형식이 유효하지 않습니다.";
        nameMessage.classList.add("error");
        nameMessage.classList.remove("confirm");

        checkObj.membername = false;
    }

});





// const gender = document.getElementById("gender");

// gender.addEventListener("click", function () {

//     if (checkObj.gender.value == "") {

//         alert("성별을 선택해주세요.")
//         checkObj.gender.focus();

//         checkObj.gender = true;
//     }
// })









// 비밀번호 유효성 검사
const memberPw = document.getElementById("memberPw");
const memberPwConfirm = document.getElementById("memberPwConfirm");
const pwMessage = document.getElementById("pwMessage");

memberPw.addEventListener("input", function () {

    if (memberPw.value.length == 0) {
        pwMessage.innerText = "영어, 숫자, 특수문자(!,@,#,-,_) 6~20글자 사이로 작성해주세요.";
        pwMessage.classList.remove("confirm", "error");

        checkObj.memberPw = false;
        return;
    }

    const regExp = /^[\w!@#_-]{6,20}$/;

    if (regExp.test(memberPw.value)) { // 비밀번호 유효


        checkObj.memberPw = true;



        if (memberPwConfirm.value.length == 0) {
            pwMessage.innerText = "유효한 비밀번호 형식입니다.";
            pwMessage.classList.add("confirm");
            pwMessage.classList.remove("error");
        } else {
            checkPw();
        }

    } else {
        pwMessage.innerText = "비밀번호 형식이 유효하지 않습니다.";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");

        checkObj.memberPw = false;
    }
});


// 비밀번호 확인 유효성 검사


memberPwConfirm.addEventListener("input", checkPw);
// -> 이벤트가 발생 되었을 때 정의된 함수를 호출하겠다


function checkPw() { // 비밀번호 일치 검사
    // 비밀번호 / 비밀번호 확인이 같을 경우
    if (memberPw.value == memberPwConfirm.value) {

        // if (regExp.test(memberPw.value)) {
        pwMessage.innerText = "비밀번호가 일치합니다.";
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");

        checkObj.memberPwConfirm = true;

    } else {
        pwMessage.innerText = "비밀번호가 일치하지 않습니다.";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");

        checkObj.memberPwConfirm = false;
    }
}








// 회원가입 버튼 클릭 시 유효성 검사가 완료 되었는지 확인하는 함수
function signUpValidate() {

    // checkObj에 있는 모든 속성을 반복 접근하여
    // false가 하나라도 있는 경우에는 form태그 기본 이벤트 제거

    let str;

    for (let key in checkObj) { // 객체용 향상된 for문

        // 현재 접근 중인 key의 value가 false인 경우
        if (!checkObj[key]) {

            switch (key) {
                case "memberEmail": str = "이메일이"; break;
                case "memberPw": str = "비밀번호가"; break;
                case "memberPwConfirm": str = "비밀번호 확인이"; break;
                case "memberNickname": str = "닉네임이"; break;
                case "membername": str = "이름이"; break;

                case "memberTel": str = "전화번호가"; break;
            }

            str += " 유효하지 않습니다.";

            alert(str);

            document.getElementById(key).focus();

            return false; // form태그 기본 이벤트 제거
        }
    }

    return true; // form태그 기본 이벤트 수행

}





sendBtn.addEventListener("click", function () {

    if (checkObj.memberEmail) { // 유효한 이메일이 작성되어 있을 경우에만 메일 보내기

        $.ajax({
            url: "sendEmail",
            data: { "inputEmail": memberEmail.value },
            type: "GET",
            success: function (result) {
                console.log("이메일 발송 성공");
                console.log(result);

                // 인증 버튼이 클릭되어 정상적으로 메일이 보내졌음을 checkObj에 기록
                checkObj.sendEmail = true;

            },
            error: function () {
                console.log("이메일 발송 실패")
            }
        });


        // Mail 발송 Ajax 코드는 동작이 느림....
        // -> 메일은 메일대로 보내고, 타이머는 버튼이 클릭 되자 마자 바로 실행
        // --> ajax 코드가 비동기이기 때문에 메일이 보내지는 것을 기다리지 않고
        //      바로 다음 코드가 수행된다!!

        // 5분 타이머
        // setInerval(함수, 지연시간) : 지연시간이 지난 후 함수를 수행 (반복)

        cMessage.innerText = "5:00"; // 초기값 5분
        min = 4;
        sec = 59; // 분, 초 초기화

        cMessage.classList.remove("confirm");
        cMessage.classList.remove("error");

        // 변수에 저장해야지 멈출 수 있음
        checkInterval = setInterval(function () {
            if (sec < 10) sec = "0" + sec;
            cMessage.innerText = min + ":" + sec;

            if (Number(sec) === 0) {
                min--;
                sec = 59;
            } else {
                sec--;
            }

            if (min === -1) { // 만료
                cMessage.classList.add("error");
                cMessage.innerText = "인증번호가 만료되었습니다.";

                clearInterval(checkInterval); // checkInterval 반복을 지움
            }

        }, 1000); // 1초 지연 후 수행


        alert("인증번호가 발송되었습니다. 이메일을 확인해주세요.");
    }
});


// 인증번호 확인 클릭시에 대한 동작
const cNumber = document.getElementById("cNumber");
const cBtn = document.getElementById("cBtn");
// + cMessage, memberEmail 요소도 사용

cBtn.addEventListener("click", function () {

    // 1. 인증번호 받기 버튼이 클릭되어 이메일 발송되었는지 확인
    if (checkObj.sendEmail) {

        // 2. 입력된 인증번호가 6자리가 맞는지 확인
        if (cNumber.value.length == 6) { // 6자리 맞음

            $.ajax({
                url: "checkNumber",
                data: {
                    "cNumber": cNumber.value,
                    "inputEmail": memberEmail.value
                },
                type: "GET",
                success: function (result) {
                    console.log(result);
                    // 1 : 인증번호 일치 O, 시간 만족O
                    // 2 : 인증번호 일치 O, 시간 만족X
                    // 3 : 인증번호 일치 X

                    if (result == 1) {

                        clearInterval(checkInterval); // 타이머 멈춤     

                        cMessage.innerText = "인증되었습니다.";
                        cMessage.classList.add("confirm");
                        cMessage.classList.remove("error");

                    } else if (result == 2) {
                        alert("만료된 인증 번호 입니다.");

                    } else { // 3
                        alert("인증 번호가 일치하기 않습니다.");
                    }


                },

                error: function () {
                    console.log("이메일 인증 실패")
                }
            });



        } else { // 6자리 아님
            alert("인증번호를 정확하게 입력해주세요.");
            cNumber.focus();
        }

    } else { // 인증번호를 안받은 경우
        alert("인증번호 받기 버튼을 먼저 클릭해주세요.");
    }

});



/* 카카오 주소 API */
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function (data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
        }
    }).open();
}