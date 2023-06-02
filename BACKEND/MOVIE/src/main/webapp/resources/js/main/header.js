// 메뉴창 하버
$(document).ready(function() {
    $('.navBar, .dummy').hover(
        function() {
            $('.navBar ul').stop().slideDown(150); 
            $('.dummy').css('display', 'flex'); 
        },
        function() {
            $('.navBar ul').stop().slideUp(150); 
            $('.dummy').css('display', 'none'); 
        }
    )
});
