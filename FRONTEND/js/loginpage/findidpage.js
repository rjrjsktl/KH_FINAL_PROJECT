$(document).ready(function () {
  $(".fid").hover(
    function () {
      // Mouse enter, remove border top and left of fid
      $(".fpw").css({
        "border-top": "none",
        "border-right": "none",
        "border-bottom": "1px solid #FFC400",
        color: "white",
      });
    },
    function () {
      // Mouse leave, revert the css of fid to original
      $(".fpw").css({
        "border-top": "1px solid #FFC400",
        "border-right": "1px solid #FFC400",
        "border-bottom": "none",
        color: "#FFC400",
      });
    }
  );
});
