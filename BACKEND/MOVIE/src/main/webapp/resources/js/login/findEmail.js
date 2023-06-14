console.log("findEmaile.js loaded..")

const checkObj = {
    
    // 인증번호 발송 체크

};

  
// 비밀번호 인풋값들
const userName = document.getElementById("userName")
const userBirth = document.getElementById("userBirth")
const userTel = document.getElementById("userTel")
// 인증하기버튼
const sendBtn = document.getElementById("sendBtn");


// 아이디 찾기 버튼을 눌렀을때
sendBtn.addEventListener("click", function () {

    console.log("아이디 찾기 버튼 클릭")
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
    if (userTel.value.length == 0) {
        alert("전화번호를 기입해주세요");
        userTel.focus();

        return false;
    }

});

// $(document).ready(function() {
//     var message = "${message}"; // Flash 속성 값 가져오기
//     if (message) {
//         alert(message); // 알림 창 표시
//     }
// });

