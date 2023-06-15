console.log("findPw.js loaded..")

const checkObj = {
    "userPw": false,
    "userPwConfirm": false,
    "userNick": false,
    "sendEmail": false   // 인증번호 발송 체크

};

  






// 비밀번호 인풋값들
const userEmail = document.getElementById("userEmail")
const userName = document.getElementById("userName")
const userBirth = document.getElementById("userBirth")
// 인증하기버튼
const sendBtn = document.getElementById("sendBtn");
// 타이머
const cMessage = document.getElementById("cMessage");
let checkInterval; // setInterval을 저장할 변수
let min = 2;
let sec = 59;



// 인증받기 버튼을 눌렀을때
sendBtn.addEventListener("click", function () {

    console.log("인증버튼 클릭")
    console.log("checkObj 값 : " + checkObj)

    if (userName.value.length == 0) {
        alert("이름을 기입해주세요");
        userName.focus();

        return false;
    }
    if (userBirth.value.length == 0) {
        alert("생년월일을 기입해주세요");
        userBirth.focus();

        return false;
    }
    if (userEmail.value.length == 0) {
        alert("이메일을 기입해주세요");
        userEmail.focus();

        return false;
    }

    // 인풋 3개(이름,생년월일,이메일 아이디가 제대로 되어있는지 확인하기)
    $.ajax({
        url: "checkUser",
        data: {
            "userName": userName.value,
            "userBirth": userBirth.value,
            "userEmail": userEmail.value
        },
        type: "GET",

        success: function (result) {

            console.log("checkUser controller에서 받아온 값 : " + result);

            if (result > 0) {
                console.log("기입한 유저가 DB에 있는것으로 확인됨");

                console.log("sendemail 날라가기 일보직전");

                $.ajax({
                    url: "sendEmail",
                    data: { "userEmail": userEmail.value },
                    type: "GET",
                    success: function (result) {
                        console.log("이메일 발송 성공");
                        console.log(result);

                        alert("인증번호가 발송되었습니다.")
                        checkObj.sendEmail=true;
                        console.log(checkObj.sendEmail)

                    },
                    error: function () {
                        console.log("이메일 발송 실패")



                    }
                });

                cMessage.innerText = "3:00"; // 초기값 3분
                min = 2;
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

            }
            else {
                console.log("KGV 회원이 아닙니다")
            }

        },
        error: function () {
            console.log("가입된적 없는 유저입니다")
            alert("이름,생년월일,이메일이 올바르지 않습니다")
        }
    });



});

const cNumber = document.getElementById("cNumber");
const cBtn = document.getElementById("cBtn");

// 인증완료 버튼을 눌렀을때
cBtn.addEventListener("click", function () {

    console.log(checkObj)

    // 1. 인증번호 받기 버튼이 클릭되어 이메일 발송되었는지 확인
    if (checkObj.sendEmail) {


        // 2. 입력된 인증번호가 6자리가 맞는지 확인
        if (cNumber.value.length == 6) { // 6자리 맞음

            $.ajax({
                url: "checkNumber",
                data: {
                    "cNumber": cNumber.value,
                    "userEmail": userEmail.value
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
            checkObj.cNumber = false;
        }

    } else { // 인증번호를 안받은 경우
        alert("인증번호 받기 버튼을 먼저 클릭해주세요.");

    }

});


// 재설정할 비밀번호 유효성 검사
const userPw = document.getElementById("userPw");
const userPwConfirm = document.getElementById("userPwConfirm");
const pwMessage = document.getElementById("pwMessage");

userPw.addEventListener("keydown", function(){
    if(userPw.value.lengh == 0){
        pwMessage.innerText="영어, 숫자, 특수문자(!,@,#,-,_) 6~20글자 사이로 작성해주세요."
     
    }

    const regExp = /^[\w!@#_-]{6,20}/;

    if(regExp.test(userPw.value) ){ // 정규표현식 통과

        checkObj.userPw = true;


        if (userPwConfirm.value.length == 0) {
            pwMessage.innerText = "유효한 비밀번호 형식입니다.";
            pwMessage.classList.add("confirm");
            pwMessage.classList.remove("error");
        } else {
            checkPw();
        }

    } else { // 유효하지않은 상태
        pwMessage.innerText = "영어, 숫자, 특수문자(!,@,#,-,_) 6~20글자 사이로 작성해주세요.";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");

        checkObj.userPw = false;
    }



})


function checkPw() { // 비밀번호 일치 검사


    const regExp = /^[\w!@#_-]{6,20}$/;

    if (userPw.value == userPwConfirm.value) {

        console.log("비밀번호 일치 시킴!")
        console.log(userPwConfirm.value);
        console.log(userPw.value);


        if (regExp.test(userPw.value)) {
            pwMessage.innerText = "";
            pwMessage.classList.add("confirm");
            pwMessage.classList.remove("error");

            checkObj.userPwConfirm = true;
        } else {
            pwMessage.innerText = "영어, 숫자, 특수문자(!,@,#,-,_) 6~20글자 사이로 작성해주세요.";
            pwMessage.classList.add("error");
            pwMessage.classList.remove("confirm");

            checkObj.userPwConfirm = false;
        }

    } else {
        pwMessage.innerText = "비밀번호가 일치하지 않습니다.";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");

        checkObj.userPwConfirm = false;
    }

}





// 비밀번호 재설정
const changePw = document.getElementById("changPw");


changePw.addEventListener("click", function(){
    console("비밀번호 재설정중...")

    

});