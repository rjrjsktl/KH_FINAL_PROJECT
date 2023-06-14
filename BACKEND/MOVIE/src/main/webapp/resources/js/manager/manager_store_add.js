
$(document).ready(function () {
    // ===============================================================================


    // ===============================================================================
    // 유효성검사 기능

    let confirmBtn = $('.bottom_Submit');

    let store_category = $('.store_category');



    let store_title = $('.store_title');

    let store_desc = $('.store_desc');

    let store_price = $('.store_price');


    let store_stock = $('.store_stock');

    let store_image = $('.store_image');










    // level_Arr
    // genre_Arr

    confirmBtn.on('click', (e) => {
        if (!store_category.val()) {
            alert('선택되지 않았습니다.');
            store_category.focus();
            e.preventDefault();
            return false;
        };
        if (!store_title.val()) {
            alert('상품 이름이 입력되지 않았습니다.');
            store_title.focus();
            e.preventDefault();
            return false;

        } else {
            const titleRegex = /([^가-힣ㄱ-ㅎㅏ-ㅣ])/;
            console.log("야이야이야이");
            console.log($(store_title).val());

            if (titleRegex.test($(store_title).val())) {

                console.log($(store_title).val());
                $.ajax({
                    url: "store_add/titleDupCheck",
                    data: { "storeTitle": $(store_title).val() },
                    type: "GET",
                    success: function (result) {
                        if (result == 1) {
                            alert("중복");
                            console.log("중복 발생");

                        } else {
                            console.log("검사 성공");

                        }
                    },
                    error: function () {
                        console.log("에러 발생");
                    }
                });
            } else {
                alert("한글만 입력해주십쇼");
                return false;
            };


        };
        if (!store_desc.val()) {
            alert('상품 설명이 입력되지 않았습니다.');
            store_desc.focus();
            e.preventDefault();
            return false;
        };


        if (!store_price.val()) {
            alert('상영 가격이 입력되지 않았습니다.');
            store_price.focus();
            e.preventDefault();
            return false;
        };
        if (!store_stock.val()) {
            alert('제한개수가 입력되지 않았습니다.');
            store_stock.focus();
            e.preventDefault();
            return false;
        };
        if (!store_image.val()) {
            alert('이미지가 입력되지 않았습니다.');
            store_image.focus();
            e.preventDefault();
            return false;
        };


        console.log('저장버튼이 눌림.');

        console.log("상품 카테고리 : " + store_category.val());
        console.log("상품 이름 : " + store_title.val());
        console.log("상품 설명 : " + store_desc.val());
        console.log("상품 가격 : " + store_price.val());
        console.log("개수제한 : " + store_stock.val());
        console.log("상품 이미지 : " + store_image.val());

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

});