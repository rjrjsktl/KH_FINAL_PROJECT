$(document).ready(function () {

    const dailyEnter = document.getElementById('dailyEnter');

    const today = new Date();
    const lastWeek = addDays(today, -6);
    const labels = getDateRange(today, lastWeek);

    console.log(formatDate(today));
    console.log(formatDate(lastWeek));
    console.log(labels);


    $.ajax({
        url: "/movie/manager/getDailyEnter",
        data: {
            "today": formatDate(addDays(today, 1)),
            "lastWeek": formatDate(lastWeek)
        },
        type: "POST",
        success: function (result) {
            console.log("가져온 result : ", result);

            const dateResult = [];
            for (let i = 0; i < labels.length; i++) {
                const label = labels[i];
                const targetDate = result.find(date => date.deDateStr == label)
                if (targetDate) {
                    dateResult.push(targetDate.deCount)
                } else {
                    dateResult.push(0)
                }

            }

            new Chart(dailyEnter, {
                type: 'line',
                data: {
                    labels: labels,
                    datasets: [{
                        label: '일일 접속자 수',
                        data: dateResult,
                        borderWidth: 2,
                        backgroundColor: 'rgba(203,206,145,.5)', // 배경색
                        borderColor: '#CBCE91', // 선색
                        fill: true,
                        lineTension: 0.4, //선 곡선모양 0이면 직선
                        pointStyle: 'circle', //포인터 스타일 변경
                        pointBorderWidth: 2, //포인터 보더사이즈
                        pointRadius: 4, //포인터 반경 범위 
                        pointBorderColor: '#D3687F',//포인터 보더 색상
                        pointBackgroundColor: '#D3687F' // 포인터 내부 색상
                    }],
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    },
                    legend: { // 범례 사용 안 함
                        display: false,
                    },
                }
            });
        }
    });

    const dailyWatch = document.getElementById('dailyWatch');

    new Chart(dailyWatch, {
        type: 'line',
        data: {
            labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
            datasets: [{
                label: '일일 관람객 수',
                data: [12, 19, 3, 5, 2, 3],
                borderWidth: 2,
                backgroundColor: 'rgba(43,137,224,.5)', // 배경색
                borderColor: '#2b89e0', // 선색
                fill: true,
                lineTension: 0.4, //선 곡선모양 0이면 직선
                pointStyle: 'circle', //포인터 스타일 변경
                pointBorderWidth: 2, //포인터 보더사이즈
                pointRadius: 4, //포인터 반경 범위 
                pointBorderColor: '#D3687F',//포인터 보더 색상
                pointBackgroundColor: '#D3687F' // 포인터 내부 색상
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });


});

// 날짜 추가 기능
function addDays(date, days) {
    const commonDates = new Date(date.getFullYear(), date.getMonth(), date.getDate() + days)

    return commonDates
}


// 날짜 범위
function getDateRange(date1, date2) {

    // 배열 생성
    let rangeArr = [];

    // for문 // date1이 date2 와 같을 때 까지 반복

    while (date1.getTime() > date2.getTime()) {

        const formattedDate = formatDate(date2);

        rangeArr.push(formattedDate);

        date2 = addDays(date2, 1);

    }

    return rangeArr;

}


function formatDate(date) {

    const formattedDate = date.getFullYear() + "-" + ('0' + ((date.getMonth() + 1))).slice(-2) + "-" + date.getDate();

    return formattedDate;
}


$(document).ready(function () {


    // ajax 보낼때 아마 관리자 넘버 같이 넣던가 해야할듯?
    $('#crtbtn').click(function () {
        if ($('#crtMemo').val() == "") {
            window.swal('수정 실패!', "메모를 입력 하라옹", 'warning')
            // alert('메모를 입력하라옹');
            $('#crtMemo').focus();
        }
        else {
            alert('저장 되었다옹');
        }
        console.log("관리자 메모 등록 ㄱㄱ");
        $.ajax({
            url: "createMemo",
            data: {
                "memoDetail": $("#crtMemo").value
            },
            type: "POST",
            dataType: "json",

            success: function (mmlist) {
                console.log("AJAX 성공");
                $('#memoList').html("");
                if (mmlist.length === 0) {
                    return;
                }
                // $('.memoList').html(""); 요기에 넣어야 할 수도
                for (let item of mmlist) {
                    const managerMemo = document.querySelector("#managerMemo");
                    const memoList = `
                    <li id="${item.memoNo} class="memoList">
                        <textarea id="viewMemo" class="viewMemo">${item.viewMemo}</textarea>
                        <button type="button" id="dltbtn" class="dltbtn" value="#{item.memoNo}" onclick="delMemo()">삭제</button>
                        
                    </li>   
                `;  //<input class="memoNo" name="${item.memoNo}" type="hidden"> 필요하면 백틱 추가
                    managerMemo.append(memoList);
                }
                // hidden 번호 넘어가나 확인용
                $('.memoList').off().on('click', function () {
                    console.log('test');
                    console.log($(this).attr('id'));
                    passNote($(this).attr('id'));
                })
            },
            error: function (request) {
                console.log("AJAX 에러 발생")
                console.log("상태코드 : " + request.status) // 404, 500
            }
        })
    })


    function delMemo() {
        const dltbtn = document.getElementById("dltbtn");
        window.swal('삭제', "완료 했다옹", 'success')
        console.log("관리자 메모 삭제 ㄱㄱ");
        $.ajax({
            url: "remove",
            data: {
                "noteNo": dltbtn.value
            },
            type: "POST",
            dataType: "json",

            success: function () {
                console.log("AJAX 성공");
                location.href = "/movie/manager/main";
            },
            error: function (request) {
                console.log("AJAX 에러 발생")
                console.log("상태코드 : " + request.status) // 404, 500
            }
        })
    };


});