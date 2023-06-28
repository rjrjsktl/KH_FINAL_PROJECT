$(document).ready(function () {
    var IMP = window.IMP;

    const api = config.test;
    const imm = config.imp1;




    IMP.init(imm);
});


const storeNo = $('#storeNo');
const userEmail = $('#userEmail').val();
console.log(userEmail);
const userName = $('#userName').val();
console.log(userName);
var totalPrice = parseInt($('#totalPrice').text().replace(/,/g, ''));
console.log('결제 금액:', totalPrice);
var storeName = $("#storeName").text();
console.log('스토어 이름:', storeName);




function requestPay() {
    IMP.request_pay(
        {
            pg: "kakaopay.TC0ONETIME",
            pay_method: "card",
            merchant_uid: 'merchant_' + new Date().getTime(),
            name: storeName,
            amount: totalPrice,
            buyer_email: userEmail,
            buyer_name: userName

        },
        function (rsp) {


            console.log(rsp);

            // 결제검증
            $.ajax({

                type: "POST",
                url: "/movie/store/storeMain/store_detail/" + storeNo.val() + "/getStorePayment/verifyIamport/" + rsp.imp_uid
            }).done(function (data) {

                console.log(data);

                if (rsp.paid_amount == data.response.amount) {
                    alert("결제 및 결제검증완료");

                    //결제 성공 시 비즈니스 로직

                } else {
                    alert("결제 실패");
                }
            });
        });
}





