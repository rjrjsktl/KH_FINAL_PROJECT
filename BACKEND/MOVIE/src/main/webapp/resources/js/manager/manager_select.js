$(document).ready(function () {

    const url = $(location).attr('href');

    if (url.indexOf("/member") >= 0) {
        alert('member 있음 + ' + url);
    } else {
        alert('member 없음 + ' + url);
    }
});