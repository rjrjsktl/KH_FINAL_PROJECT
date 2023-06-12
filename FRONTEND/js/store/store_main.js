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
    resetStore($(this));
    $(".store_ticket").css('display', 'flex');


});

function resetStore(s) {

    $(".store_ul").css('display', 'none');
    $(".store_h3").css('display', 'none');
    $(".storeTab").removeClass("clicked");
    $(s).addClass("clicked");
}
