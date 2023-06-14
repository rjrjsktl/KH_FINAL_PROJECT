$(document).ready(function() {
    // 'count-td' 클래스 이름을 가진 테이블 행의 수를 얻습니다.
    var count = $('.count-td').length;

    // 'count-span' 클래스 이름을 가진 span 요소에 행 수를 표시합니다.
    $('.count-span').text(count);
});