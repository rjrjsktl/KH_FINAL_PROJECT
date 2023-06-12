
let totalCount = 0;
let totalPrice = Number($('#totalPrice').text());
let price = Number($('.price').text());


$("#price").text(numberWithCommas(price));
$("#totalPrice").text(numberWithCommas(totalPrice));


$('.btn_plus').click(function () {
    let count = $(this).prev();
    console.log(totalPrice);




    if (totalCount < 4) {

        count.text(Number(count.text()) + 1);



        totalCount++;
        totalPrice += price;
        $('#totalPrice').text(numberWithCommas(totalPrice));

        console.log(totalCount);



    } else {
        alert("최대 5개까지 선택할 수 있습니다.");
    }
});




$('.btn_minus').click(function () {
    let count = $(this).next();

    if (Number(count.text()) > 1) {

        count.text(Number(count.text()) - 1);
        totalCount--;
        totalPrice -= price;
        $('#totalPrice').text(numberWithCommas(totalPrice));


    }
});





function numberWithCommas(x) {
    if (!x) return 0;
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}







$(".btn-toggle").on("click", function () {


    var content = $(".content");

    if (content.css("display") === "none") {
        content.css("display", "block");
    } else {
        content.css("display", "none");

    }
})

$(".btn-toggle-2").on("click", function () {


    var content = $(".content-2");

    if (content.css("display") === "none") {
        content.css("display", "block");
    } else {
        content.css("display", "none");

    }
})

