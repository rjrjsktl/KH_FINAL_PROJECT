/* signUp.js */

// 유효성 검사 여부를 기록할 객체 생성
const checkObj = {
    "memberEmail": false,
    "memberPw": false,
    "memberPwConfirm": false,
    "memberNickname": false,
    "memberGender": false,
    "memberBirthday": false,
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
        telMessage.innerText = "";
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



    const regExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

    if (regExp.test(memberEmail.value)) { // 유효한 경우

        emailMessage.innerText = "";
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

        nicknameMessage.innerText = "";
        nicknameMessage.classList.add("confirm");
        nicknameMessage.classList.remove("error");

        checkObj.memberNickname = true;

    } else {
        nicknameMessage.innerText = "영어/숫자/한글 2~10글자 사이로 작성해주세요.";
        nicknameMessage.classList.add("error");
        nicknameMessage.classList.remove("confirm");

        checkObj.memberNickname = false;

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
        return;
    }

    const regExp = /^[가-힣]{2,10}$/;

    if (regExp.test(membername.value)) { // 유효한 경우

        nameMessage.innerText = "";
        nameMessage.classList.add("confirm");
        nameMessage.classList.remove("error");

        checkObj.membername = true;


    } else {
        nameMessage.innerText = "한글 2~10글자 사이로 작성해주세요.";
        nameMessage.classList.add("error");
        nameMessage.classList.remove("confirm");

        checkObj.membername = false;
    }

});


/* 성별 유효성검사 */
const gender = document.getElementById("gender");
const selMessage = document.getElementById("selMessage");
gender.addEventListener("change", function () {

    if (gender.value == "") {


        selMessage.innerText = "필수 선택입니다.";
        selMessage.classList.add("error");
        selMessage.classList.remove("confirm");

        checkObj.memberGender = false;

    } else {

        selMessage.innerText = "";
        checkObj.memberGender = true;


    }


})

/* 생년월일 유효성 검사 */

let birthdayInput = document.getElementById("birthdayInput");
const birMessage = document.getElementById("birMessage");

birthdayInput.addEventListener("input", function (e) {

    if (this.value.length == 8) {
        if (checkBirthday(this.value)) {
            checkObj.memberBirthday = true;
        } else {
            checkObj.memberBirthday = false;
        }

    } else {
        checkObj.memberBirthday = false;
    }

});



function checkBirthday(dateStr) {
    let year = Number(dateStr.substr(0, 4));
    let month = Number(dateStr.substr(4, 2));
    let day = Number(dateStr.substr(6, 2));
    let today = new Date(); // 날짜 변수 선언
    let yearNow = today.getFullYear();
    let adultYear = yearNow - 15;
    let postYear = 1900;


    if (year < postYear) {
        birMessage.innerText = "도민준 되십니까?";
        birMessage.classList.add("error");
        birMessage.classList.remove("confirm");
        return false;
    }

    if (year > yearNow) {
        birMessage.innerText = "미래는 어떤 세상인가요?";
        return false;
    }
    if (year > adultYear) {
        birMessage.innerText = adultYear + "년생 이전 출생자만 등록 가능합니다.";
        return false;
    }
    if (month < 1 || month > 12) {
        birMessage.innerText = "달은 1월부터 12월까지 입력 가능합니다.";
        return false;
    }
    if (day < 1 || day > 31) {
        birMessage.innerText = "일은 1일부터 31일까지 입력가능합니다.";
        return false;
    }
    if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) {
        birMessage.innerText = month + "월은 31일이 존재하지 않습니다.";
        return false;
    }
    if (month == 2) {
        let isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
        if (day > 29 || (day == 29 && !isleap)) {
            birMessage.innerText = year + "년 2월은 " + day + "일이 없습니다.";
            return false;
        }
    }
    birMessage.innerText = "";
    return true;
};







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
        pwMessage.innerText = "영어, 숫자, 특수문자(!,@,#,-,_) 6~20글자 사이로 작성해주세요.";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");

        checkObj.memberPw = false;
    }
});


// 비밀번호 확인 유효성 검사


memberPwConfirm.addEventListener("input", checkPw);



function checkPw() { // 비밀번호 일치 검사


    const regExp = /^[\w!@#_-]{6,20}$/;

    if (memberPw.value == memberPwConfirm.value) {

        if (regExp.test(memberPw.value)) {
            pwMessage.innerText = "";
            pwMessage.classList.add("confirm");
            pwMessage.classList.remove("error");

            checkObj.memberPwConfirm = true;
        } else {
            pwMessage.innerText = "영어, 숫자, 특수문자(!,@,#,-,_) 6~20글자 사이로 작성해주세요.";
            pwMessage.classList.add("error");
            pwMessage.classList.remove("confirm");

            checkObj.memberPwConfirm = false;
        }

    } else {
        pwMessage.innerText = "비밀번호가 일치하지 않습니다.";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");

        checkObj.memberPwConfirm = false;
    }
}








// 회원가입 버튼 클릭 시 유효성 검사가 완료 되었는지 확인하는 함수
function signUpValidate() {


    let str;

    for (let key in checkObj) {


        if (!checkObj[key]) {

            switch (key) {
                case "memberEmail": str = "이메일이"; break;
                case "memberPw": str = "비밀번호가"; break;
                case "memberPwConfirm": str = "비밀번호 확인이"; break;
                case "memberNickname": str = "닉네임이"; break;
                case "membername": str = "이름이"; break;
                case "memberGender": str = "성별이"; break;
                case "memberBirthday": str = "생년월일이"; break;
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

            var roadAddr = data.roadAddress; // 도로명 주소 변수


            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;

            document.getElementById("sample4_detailAddress").readOnly = false;
        }
    }).open();
}