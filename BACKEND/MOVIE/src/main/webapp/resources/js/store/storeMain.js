

$("#storeTab_1").on("click", function () {
    $(".store_ul").css('display', 'flex');
    $(".store_h3").css('display', 'flex');
    $(".storeTab").removeClass("clicked");
    $(this).addClass("clicked");
})


$("#storeTab_2").on("click", function () {

    resetStore($(this));
    $(".store_drink").css('display', 'flex');





});


$("#storeTab_3").on("click", function () {
    resetStore($(this));
    $(".store_popcorn").css('display', 'flex');
});

$("#storeTab_4").on("click", function () {
    resetStore($(this));
    $(".store_snack").css('display', 'flex');

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


