console.log("findPwEmaile.js loaded..")

// 비밀번호 인풋값들
const userEmail = document.getElementById("userEmail")
const userName = document.getElementById("userName")
const userBirth = document.getElementById("userBirth")
// 인증하기버튼
const sendBtn = document.getElementById("sendBtn");
// 타이머
const cMessage = document.getElementById("cMessage");
let checkInterval; // setInterval을 저장할 변수
let min = 4;
let sec = 59;

let checkObj = 2;

// 인증받기 버튼을 눌렀을때
sendBtn.addEventListener("click", function(){

	console.log("인증버튼 클릭")
	console.log("checkObj 값 : " + checkObj)

    if(userName.value.length == 0){
        alert("이름을 기입해주세요");
        userName.focus();

        return false;
    }
    if(userBirth.value.length == 0){
        alert("생년월일을 기입해주세요");
        userBirth.focus();

        return false;
    }
    if(userEmail.value.length == 0){
        alert("이메일을 기입해주세요");
        userEmail.focus();

        return false;
    }

    // 인풋 3개(이름,생년월일,이메일 아이디가 제대로 되어있는지 확인하기)
    $.ajax({
        url: "checkUser",
        data: { "userName": userName.value,
                "userBirth": userBirth.value,
                "userEmail": userEmail.value },
        type: "GET",

        success: function (result) {

            console.log("checkUser controller에서 받아온 값 : " + result);

            if(result > 0) {
                console.log("기입한 유저가 DB에 있는것으로 확인됨");  
                
                console.log("sendemail 날라가기 일보직전"); 

                $.ajax({
                    url: "sendEmail",
                    data: { "userEmail": userEmail.value },
                    type: "GET",
                    success: function (result) {
                        console.log("이메일 발송 성공");
                        console.log(result);

                        checkObj = 3

                        alert("인증번호가 발송되었습니다.")
                    },
                    error: function () {
                        console.log("이메일 발송 실패")
        
        
                        
                    }
                });
                
            }
            else{
                console.log("dlfjsTlqkf~~~~~~~~~~~~!")
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
    if (checkObj==3) {

        
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
                        checkObj.cNumber = true;
                        

                    } else if (result == 2) {
                        alert("만료된 인증 번호 입니다.");

                        checkObj.cNumber = false;

                    } else { // 3
                        alert("인증 번호가 일치하기 않습니다.");

                        checkObj.cNumber = false;
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


