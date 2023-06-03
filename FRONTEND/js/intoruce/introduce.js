$(document).ready(function() {
    var fold = $('.fold_wrap');
    var more = $('.more_btn');

    more.click(function() {
        if (fold.hasClass('fiftyfifty')) {
            fold.slideDown().removeClass('fiftyfifty').addClass('goheight');
        } else if (fold.hasClass('goheight')) {
            fold.slideUp().removeClass('goheight').addClass('fiftyfifty');
        } else {
            fold.slideDown().addClass('goheight');
        }
    });
});