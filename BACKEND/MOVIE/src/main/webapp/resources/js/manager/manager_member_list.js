const checkBtn = $('td > .checkBtn');
const manager = $('.Is_Manager');
const block = $('.Is_Blocked');


manager.on('change', (e) => {
    let clickTarget = $(e.currentTarget).val();
    console.log("가져온 아이디는 : " + $(e.currentTarget).data('id'));


    if (clickTarget == 'Y') {
        console.log("Y가 찍힘" + clickTarget);

        $.ajax({
            url: "Manager_ST",
            data: {
                "MST": $(e.currentTarget).val()
                , "userId": $(e.currentTarget).data('id')
            },
            type: "POST",
            success: function (result) {
                if (result > 0) {
                    console.log("N -> Y로 변경 완료");

                } else {
                    console.log("N -> Y로 변경 실패");
                }
            },

            error: function () {
                console.log("error : N -> Y로 변경 실패");
            }
        });




    } else {
        console.log("N이 찍힘" + clickTarget);

        $.ajax({
            url: "Manager_ST",
            data: {
                "MST": $(e.currentTarget).val()
                , "userId": $(e.currentTarget).data('id')
            },
            type: "POST",
            success: function (result) {
                if (result > 0) {
                    console.log("Y -> N으로 변경 완료");

                } else {
                    console.log("Y -> N으로 변경 실패");
                }
            },

            error: function () {
                console.log("error : Y -> N으로 변경 실패");
            }
        });





    }

    // let getManager = manager.text();
    // let getBlock = block.text();

    // console.log("getManager : " + getManager);
    // console.log("getBlock : " + getBlock);

});

// if (loginMember != "" && FAV_YN == 'N' || "") { // 로그인 되어 있을 경우.
//     console.log("로그인 했음");
//     $.ajax({
//         url: "CAMP404/likeBtn",
//         data: {
//             "favYn": FAV_YN
//             , "loginUserNo": loginUserNo
//             , "lectureNo": lectureNo
//         },
//         type: "POST",
//         success: function (result) {
//             if (result > 0) {
//                 console.log("찜 목록에 등록 완료");
//                 function ask(question, yes, no) { // 등록 후 찜 목록 이동 여부 물어보기.
//                     if (confirm(question)) {
//                         yes(); // 찜 목록 이동 희망
//                         // let url = contextPath + "/main/login";
//                         // location.href = url;
//                     } else {
//                         no(); // 거부 시, 메인 화면에 계속 머물기
//                         return;
//                     }
//                 };

//                 ask( // function ask() 용 질의 구문
//                     "찜목록에 강의를 추가했습니다!.\n찜 목록으로 가시겠어요?",
//                     (ask) => alert("찜목 록 창으로 이동합니다."),
//                     (ask) => alert("취소 버튼을 누르셨습니다.")
//                 );
//             }
//         },

//         error: function () {

//         }

//     })
// };