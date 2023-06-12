$(document).ready(function(){
    $('.stheater_wrap ul li').hover(function(){
        $(this).find('a').addClass('hovered');
    }, function(){
        $(this).find('a').removeClass('hovered');
    })
})