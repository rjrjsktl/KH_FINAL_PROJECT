
$(document).ready(function () {
    // ===============================================================================


    // ===============================================================================
    // 유효성검사 기능


    let nameCheck = false;

    const titleRegex = /^[가-힣|a-z|A-Z|0-9|{1,}$]+$/;

    $("#storeName").on("input", function () {
        if (titleRegex.test($(this).val())) {

            console.log($(this).val());
            $.ajax({
                url: "store_add/NameDupCheck",
                data: { "storeName": $(this).val() },
                type: "GET",
                success: function (result) {
                    if (result == 1) {
                        $("#storeNameMessage").text("중복!");
                        nameCheck = false;
                    } else {
                        $("#storeNameMessage").text("유효!");
                        nameCheck = true;
                    }
                },
                error: function () {
                    console.log("에러 발생");
                }
            });
        } else {
            $("#storeNameMessage").text("적절하지 않은 이름입니다!");
            nameCheck = false;
        }
    });







    $('.bottom_Submit').on("click", function (e) {

        console.log('저장버튼이 눌림.');
        if (!$("#storeCategory").val()) {
            alert('선택되지 않았습니다.');
            storeCategory.focus();
            e.preventDefault();
            storeCategory = false;
        }
        else if (!$("#storeName").val() && nameCheck == false) {
            alert('상품 이름이 입력되지 않았습니다.');
            storeName.focus();
            e.preventDefault();
            storeName = false;

        }
        else if (!$("#storeDesc").val()) {
            alert('상품 설명이 입력되지 않았습니다.');
            storeDesc.focus();
            e.preventDefault();
            storeDesc = false;
        }


        else if (!$("#storePrice").val()) {
            alert('상영 가격이 입력되지 않았습니다.');
            storePrice.focus();
            e.preventDefault();
            storePrice = false;
        }
        else if (!$("#storeStock").val()) {
            alert('제한개수가 입력되지 않았습니다.');
            storeStock.focus();
            e.preventDefault();
            storeStock = false;
        }
        else if (!$("#storeImage").val()) {
            alert('이미지가 입력되지 않았습니다.');
            storeImage.focus();
            e.preventDefault();
            storeImage = false;
        };

        $.ajax({
            url: "store_add/addStore",
            data: {
                "storeCategory": $("#storeCategory").val()
                , "storeName": $("#storeName").val()
                , "storeDesc": $("#storeDesc").val()
                , "storePrice": $("#storePrice").val()
                , "storeStock": $("#storeStock").val()
                , "storeImage": $("#storeImage").val()
            },
            type: "POST",
            success: function (result) {
                if (result > 0) {
                    alert("이벤트 등록 성공");
                    window.location.reload();
                } else {
                    alert("이벤트 등록 실패");
                    window.location.reload();
                }
            },

            error: function () {
                console.log("에러 발생으로 인해 등록 실패");
            }
        });


        console.log("상품 카테고리 : " + $("#storeCategory").val());
        console.log("상품 이름 : " + $("#storeName").val());
        console.log("상품 설명 : " + $("#storeDesc").val());
        console.log("상품 가격 : " + $("#storePrice").val());
        console.log("개수제한 : " + $("#storeStock").val());
        console.log("상품 이미지 : " + $("#storeImage").val());


    });




});

