/* 방문자 현황용 그래프 */

var myChart = Highcharts.chart('daily_Enter', {

    title: {
        text: 'KGV 일일 방문자  수',
        align: 'left'
    },

    yAxis: {
        title: {
            text: '일 방문자 (천명)'
        }
    },

    xAxis: {
        type: "datetime",
        categories: ['6월 1일', '6월 2일', '6월 3일', '6월 4일', '6월 5일', '6월 6일', '6월 7일', '6월 8일', '6월 9일', '6월 10일', '6월 11일'],
        // labels: { style: { fontSize: '12px' } },
    },

    legend: {
        layout: 'vertical',
        floating: true,
        align: 'left',
        verticalAlign: 'middle',
        x: 240,
        y: -200,
    },

    series: [{
        name: '방문자 수',
        data: [21908, 5548, 8105, 11248, 8989, 11816, 18274,
            17300, 13053, 11906, 10073],
        // pointStart: Date.UTC(2023, 5, 1),
        // pointInterval: 24 * 3600 * 1000 // one day            
    }],

    responsive: {
        rules: [{
            condition: {
                width: 500
            },
            chartOptions: {
                legend: {
                    layout: 'horizontal',
                    align: 'center',
                    verticalAlign: 'bottom'
                }
            }
        }]
    },

    plotOptions: {
        series: {
            colorByPoint: true,
            dataLabels: {
                enabled: true, //각각의 데이터 값을 나타낼 것인지
                color: 'black' // 데이터 값을 나타낼 때 색
            }
        },
        connectNulls: true //null인 지점에 연결할 것인지

    }

});
/* 일일 영화 관람객 그래프 */

var myChart = Highcharts.chart('daily_Movie_Watch', {

    title: {
        text: 'KGV 일일 영화 관람객 수',
        align: 'left'
    },

    // subtitle: {
    //     text: 'Source: <a href="https://irecusa.org/programs/solar-jobs-census/" target="_blank">IREC</a>',
    //     align: 'left'
    // },

    yAxis: {
        title: {
            text: '일 관람객 (천명)'
        }
    },

    xAxis: {
        type: "datetime",
        categories: ['6월 1일', '6월 2일', '6월 3일', '6월 4일', '6월 5일', '6월 6일', '6월 7일', '6월 8일', '6월 9일', '6월 10일', '6월 11일'],
        // labels: { style: { fontSize: '12px' } },
    },

    legend: {
        layout: 'vertical',
        floating: true,
        align: 'left',
        verticalAlign: 'middle',
        x: 240,
        y: -200,
    },

    series: [{
        name: '관람객 수',
        data: [2908, 554, 6125, 3248, 8989, 7762, 123,
            6854, 7865, 3358, 2435],
        // pointStart: Date.UTC(2023, 5, 1),
        // pointInterval: 24 * 3600 * 1000 // one day            
    }],

    responsive: {
        rules: [{
            condition: {
                width: 500
            },
            chartOptions: {
                legend: {
                    layout: 'horizontal',
                    align: 'center',
                    verticalAlign: 'bottom'
                }
            }
        }]
    },

    plotOptions: {
        series: {
            colorByPoint: true,
            dataLabels: {
                enabled: true, //각각의 데이터 값을 나타낼 것인지
                color: 'black' // 데이터 값을 나타낼 때 색
            }
        },
        connectNulls: true //null인 지점에 연결할 것인지

    }

});

// ajax 보낼때 아마 관리자 넘버 같이 넣던가 해야할듯?
$(document).ready(function () {
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
});

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
}
