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



// 인증받기 버튼을 눌렀을때
sendBtn.addEventListener("click", function(){
	console.log("인증버튼 클릭")
	
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
            console.log(result);
            if(result > 0) {
                console.log("기입한 유저가 DB에 있는것으로 확인됨");    
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


