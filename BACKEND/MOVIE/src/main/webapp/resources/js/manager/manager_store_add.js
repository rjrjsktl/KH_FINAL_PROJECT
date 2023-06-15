
$(document).ready(function () {
    // ===============================================================================


    // ===============================================================================
    // 유효성검사 기능

    // let confirmBtn = $('.bottom_Submit');

    // let store_category = $('.store_category');



    // let store_title = $('.store_title');

    // let store_desc = $('.store_desc');

    // let store_price = $('.store_price');


    // let store_stock = $('.store_stock');

    // let store_image = $('.store_image');







    // store_title.on('input', () => {
    //     const titleRegex = /^[가-힣]+$/;

    //     console.log("야이야이야이");
    //     console.log($(store_title).val());

    //     if (titleRegex.test($(this).val())) {

    //         console.log($(this).val());
    //         $.ajax({
    //             url: "store_add/titleDupCheck",
    //             data: { "storeTitle": $(store_title).val() },
    //             type: "GET",
    //             success: function (result) {
    //                 if (result == 1) {
    //                     alert("중복");
    //                     console.log("중복 발생");
    //                     return false;
    //                 } else {
    //                     console.log("검사 성공");

    //                 }
    //             },
    //             error: function () {
    //                 console.log("에러 발생");
    //             }
    //         });
    //     } else {
    //         alert("한글만 입력해주십쇼");
    //         // store_title.val('');
    //         // e.preventDefault();
    //         return false;
    //     };




    // });

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





    // else if (storeCategory && storeName && storeDesc && storePrice && storeStock && storeImage) {
    //     $(this).attr("type", "submit");
    //     $('#store_Submit').submit();
    // };


    // 등록된 영화 ajax
    //     console.log("영화등록 AJAX");
    //     $.ajax({
    //         url: "movie_add",
    //         data: {
    //             "movieTitle": movie_title.val(),
    //             "movieDirector": movie_director.val(),
    //             "movieCast": movie_cast.val(),
    //             "movieRuntime": movie_time.val(),
    //             "movieNation": movie_country.val(),
    //             "movieOpen": movie_releseDate.val(),
    //             "movieImg": movie_image.val(),
    //             "mgNo": JSON.stringify(level_Arr),
    //             "genreCode": JSON.stringify(genre_Arr),
    //             "movieContent": $('.movie_story').val(),
    //             "movieUploader": $("input[name=movieUploader]").val()
    //         },
    //         type: "POST",
    //         dataType: "json",

    //         success: function (result) {
    //             console.log(result);
    //             // 등록 완료 : 1
    //             // 등록 실패 : 0
    //             if (result > 0) {
    //                 console.log("영화 등록 완료");
    //                 window.alert("영화 등록 성공")
    //             } else {
    //                 console.log("영화 등록 실패");
    //             }
    //         },
    //         error: function () {
    //             window.alert("영화 등록 실패")
    //             console.log("영화 등록 ajax 실패");
    //         }
    //     })
});

