$(document).ready(function () {
  var IMP = window.IMP;

  const imm = config.imp2;

  IMP.init(imm);
});

const userEmail = $("#userEmail").val();
const userName = $("#userName").val();
let payPrice;

const bookNo = $("#bookNo").val();

console.log("-------------------------");
console.log("이름       :" + userName);
console.log("이메일     :" + userEmail);
console.log("최종가격   :" + payPrice);
console.log("북넘버   :" + bookNo);
console.log("-------------------------");

function requestPay() {
  console.log("시스템가동준비완료");
  payPrice = $(".finshPrice").text();

  console.log($(".finshPrice").text());
  IMP.request_pay(
    {
      pg: "kakaopay.TC0ONETIME",
      pay_method: "card",
      merchant_uid: "merchant_" + new Date().getTime(),
      name: "KGV 예매",
      amount: payPrice,
      buyer_email: userEmail,
      buyer_name: userName,
    },
    function (rsp) {
      // callback

      console.log("rep : " + rsp);
      console.log("payPrice : " + payPrice);
      console.log("rsp.imp_uid : " + rsp.imp_uid);

      // 결제 검증
      $.ajax({
        type: "POST",
        url: "/movie/pay/pay/verifyIamport/" + rsp.imp_uid,
      }).done(function (data) {
        console.log(data);
        console.log(rsp.merchant_uid);

        if (rsp.paid_amount == data.response.amount) {
          alert("결제가 완료되었습니다");

          //결제 성공 시 비즈니스 로직
          updateCouponStatus(); // 결제에 성공하면 St 상태 변경 함수 실행

          var today = new Date(); // 오늘 날짜를 나타내는 Date 객체 생성
          var year = today.getFullYear().toString().slice(-2); // 현재 연도에서 뒤의 두 자리만 추출
          var month = (today.getMonth() + 1).toString().padStart(2, "0"); // 현재 월을 2자리 숫자로 표현
          var day = today.getDate().toString().padStart(2, "0"); // 현재 일을 2자리 숫자로 표현

          var randomNum = Math.floor(Math.random() * 1000000)
            .toString()
            .padStart(6, "0"); // 0부터 999999 사이의 난수 생성 후 6자리 숫자로 표현

          reserveCodeNo = "KGV" + year + month + day + randomNum; // 예약 코드 번호 생성

          console.log("예약 코드 번호 출력 : " + reserveCodeNo); // 예약 코드 번호 출력

          // DB에 가서 테이블에 정보를 저장하는 ajax
          $.ajax({
            url: "/movie/pay/pay/successPayment",
            data: {
              bookNo: bookNo,
              reserveCodeNo: reserveCodeNo,
            },
            type: "POST",

            success: function (result) {
              console.log("결제성공");

              if (result > 0) {
                alert("결제성공 정보DB 등록 성공");
                let url = "/movie/pay/finshed";

                window.location.href = url;
              } else {
                console.log("에러 발생으로 인해 등록 실패");
              }
            },

            error: function () {
              console.log("에러 발생으로 인해 등록 실패");
            },
          });
        } else {
          alert("결제 실패하였습니다");
        }
      });
    }
  );
}
