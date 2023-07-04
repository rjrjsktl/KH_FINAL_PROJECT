$(document).ready(function () {
  $(".search-form").on("submit", function (e) {
    var input = $("input[name='keyword']").val();
    console.log("하이");

    if (!input) {
      e.preventDefault();
      alert("공지사항을 검색하세요");
    }
  });
});

let params = new URLSearchParams(window.location.search);
let keyword = params.get("keyword");

if (keyword) {
  let re = new RegExp(keyword, "g");

  $(".count-td a").each(function () {
    let html = $(this).html();
    let newHtml = html.replace(re, `<span class='highlight'>${keyword}</span>`);
    $(this).html(newHtml);
  });
}

$(".selected_Cp").parent().css("border", "1px solid rgb(255, 196, 0)");
