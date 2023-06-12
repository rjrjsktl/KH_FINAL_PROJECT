// $('tab-list').click(function () {
//     $(this).addClass('on');
// });


$("#storeTab_2").on("click", function () {
    $("#store_drink").css('display', 'flex');
    $("#store_ticket").css('display', 'none');
    $("#store_popcorn").css('display', 'none');
    $("#store_snack").css('display', 'none');
});


$("#storeTab_3").on("click", function () {
    $("#store_popcorn").css('display', 'flex');
    $("#store_ticket").css('display', 'none');
    $("#store_drink").css('display', 'none');
    $("#store_snack").css('display', 'none');
});

$("#storeTab_4").on("click", function () {
    $("#store_snack").css('display', 'flex');
    $("#store_ticket").css('display', 'none');
    $("#store_drink").css('display', 'none');
    $("#store_popcorn").css('display', 'none');
});


$("#storeTab_5").on("click", function () {
    $("#store_ticket").css('display', 'flex');
    $("#store_drink").css('display', 'none');
    $("#store_popcorn").css('display', 'none');
    $("#store_snack").css('display', 'none');
});