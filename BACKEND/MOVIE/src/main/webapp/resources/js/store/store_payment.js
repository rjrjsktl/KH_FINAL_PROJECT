$(document).ready(function () {
    var IMP = window.IMP;

    const api = config.test;
    const imm = config.imp1;




    IMP.init(imm);




    $("#chkSavingTerm").on("click", function () {

        $(".provision_list input[type='checkbox']").prop("checked", $(this).is(":checked"));
    });


    $(".provision_list input[type='checkbox']").on("click", function () {

        var allChecked = $(".provision_list input[type='checkbox']").length === $(".provision_list input[type='checkbox']:checked").length;

        $("#chkSavingTerm").prop("checked", allChecked);
    });






    $(".pay_simple_btn_box").on("click", function () {
        $(this).toggleClass("active");
    });



    $('.pay_Submit').on("click", function (e) {
        var isPaymentSelected = $(".pay_simple_btn_box").hasClass("active");
        // var isAgreementChecked = $("#chkProvisionTerm01").prop("checked");
        var isAllChecked = $(".provision_list input[type='checkbox']:not(#chkProvisionTerm01)").length === $(".provision_list input[type='checkbox']:not(#chkProvisionTerm01):checked").length;
        var isSavingTermChecked = $("#chkProvisionTerm01").prop("checked");


        if (!isPaymentSelected) {
            e.preventDefault();
            alert('결제수단을 선택해주세요.');
        } else if (!isAllChecked || !isSavingTermChecked) {
            e.preventDefault();
            alert('약관동의를 모두 해주세요.');
        } else {
            console.log('결제버튼이 눌림.');
            requestPay();
        }

    })


});


const storeNo = $('#storeNo').val();
console.log('스토어 넘버', storeNo);
const userEmail = $('#userEmail').val();

console.log(userEmail);
const userNo = $('#userNo').val();

console.log('유저 넘버', userNo);

const userName = $('#userName').val();
console.log(userName);
var totalPrice = parseInt($('#totalPrice').text().replace(/,/g, ''));
console.log('결제 금액:', totalPrice);
var storeName = $("#storeName").text();
console.log('스토어 이름:', storeName);
var totalCount = parseInt($('#totalCount').text().replace(/,/g, ''));
console.log('총개수:', totalCount);


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


            // console.log(rsp);

            // 결제검증
            $.ajax({

                type: "POST",
                url: "/movie/store/storeMain/store_detail/store_payment/" + storeNo + "/verifyIamport/" + rsp.imp_uid
            }).done(function (data) {

                // console.log(data);
                // console.log(rsp.merchant_uid);


                if (rsp.paid_amount == data.response.amount) {

                    //console.log("결재 및 결재검증완료");
                    //결제 성공 시 비즈니스 로직
                    orderDetailNo = 'odn_' + new Date().getTime();


                    $.ajax({
                        url: "/movie/store/storeMain/store_detail/store_payment/" + storeNo + "/successPayment",
                        data: {
                            "orderPrice": totalPrice
                            , "orderCount": totalCount
                            , "storeName": storeName
                            , "storeNo": storeNo
                            , "userEmail": userEmail
                            , "orderDetailNo": rsp.merchant_uid
                            , "userName": userName
                            , "imp_uid": rsp.imp_uid
                        },
                        type: "POST",

                        success: function (result) {
                            //console.log("결제성공");

                            if (result > 0) {
                                alert("결제성공 정보DB 등록 성공");
                                let url = "/movie/store/store_Success";

                                window.location.href = url;

                            } else {
                                // console.log("에러 발생으로 인해 등록 실패");
                            }
                        },

                        error: function () {
                            // console.log("에러 발생으로 인해 등록 실패");
                        }
                    });





                } else {
                    alert("결제 실패");
                }
            });
        });
}




$(document).ready(function () {
    // modalClick 클래스 클릭 이벤트 처리
    $(".modalClick").click(function () {
        $(".modal").show(); // 모달 표시


    });

    // 모달 내부의 닫기 버튼 클릭 이벤트 처리
    $(".exitBtn").click(function () {
        $(".modal").hide(); // 모달 숨기기
    });
});
