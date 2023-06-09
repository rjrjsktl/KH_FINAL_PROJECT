function getEventNo(eventNo) {
    console.log("eventNo" + eventNo);

    $.ajax({
        url: "event_list/edit",
        data: {
            "eventNo": eventNo
        },
        type: "POST",

        success: function (result) {
            let url = "/movie/manager/event_list/edit?" + eventNo;
            location.href = url;
        },
        error: function () {
            console.log("에러 발생으로 인해 등록 실패");
        }
    });
}