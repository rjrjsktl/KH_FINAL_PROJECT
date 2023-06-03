$(document).ready(function() {
    var qLists = $('.qList');
    var qListDetails = $('.qList_detail');
    
    qLists.click(function() {
        var qListDetail = $(this).next('.qList_detail');
        
        if (qListDetail.hasClass('none')) {
            qListDetails.slideUp().addClass('none').removeClass('block');
            qListDetail.slideDown().removeClass('none').addClass('block');
        } else {
            qListDetail.slideUp().removeClass('block').addClass('none');
        }
    });
});