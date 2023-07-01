$(document).ready(function () {
  $("#lostArea").change(function () {
    var area = $(this).val();

    console.log(area);

    $.ajax({
      url: "/movie/helpDesk/lost_List/selectName",
      type: "GET",
      data: { area: area },
      success: function (response) {
        console.log(response);
        var options = "<option disabled selected>상영관선택</option>";
        for (var i = 0; i < response.cinemaNameList.length; i++) {
          var cinemaName = response.cinemaNameList[i].cinemaName;
          options +=
            '<option value="' + cinemaName + '">' + cinemaName + "점</option>";
        }

        $("#lostName").html(options);
      },
      error: function () {},
    });
  });

  $(".submitBTN").click(function () {
    var area = $("#lostArea").val();
    var name = $("#lostName").val();
    var keyword = $("input[name='keyword']").val();

    console.log(area, name, keyword);
  });
});
