const slide_Wrapper = $('.slide_Content > .slide_Wrapper');

slide_Wrapper.on('click', (e) => {
    e.preventDefault();

    const slideDownItems = $(e.currentTarget).next('.slide_Down_items');
    const isActive = slideDownItems.is(':visible');

    $('.slide_Down_items').slideUp();
    slide_Wrapper.removeClass('active');

    if (!isActive) {
        slideDownItems.slideDown();
        $(e.currentTarget).addClass('active');
    }
});

const top_items = $('.top_Click_area > .top_items');

top_items.on('click', (e) => {
    e.preventDefault();

    const top_Click_area = $(e.currentTarget).next('.top_Click_area');
    const isActive = top_Click_area.is('.active');


    // top_items.addClass('active')
    top_items.removeClass('active')

    if (!isActive) {
        // $(e.currentTarget).removeClass('active')
        $(e.currentTarget).addClass('active')
    }
});







/* 방문자 현황용 그래프 */

var myChart = Highcharts.chart('daily_Enter', {

    title: {
        text: 'KGV 일일 방문자  수',
        align: 'left'
    },

    // subtitle: {
    //     text: 'Source: <a href="https://irecusa.org/programs/solar-jobs-census/" target="_blank">IREC</a>',
    //     align: 'left'
    // },

    yAxis: {
        title: {
            text: '일 방문자 (천명)'
        }
    },

    xAxis: {
        type: "datetime",
    },

    legend: {
        layout: 'vertical',
        align: 'right',
        verticalAlign: 'middle'
    },


    series: [{
        name: '방문자 수',
        data: [21908, 5548, 8105, 11248, 8989, 11816, 18274,
            17300, 13053, 11906, 10073],
        pointStart: Date.UTC(2023, 5, 1),
        pointInterval: 24 * 3600 * 1000 // one day            
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
    },

    legend: {
        layout: 'vertical',
        align: 'right',
        verticalAlign: 'middle'
    },


    series: [{
        name: '관람객 수',
        data: [21908, 5548, 8105, 11248, 8989, 11816, 18274,
            17300, 13053, 11906, 10073],
        pointStart: Date.UTC(2023, 5, 1),
        pointInterval: 24 * 3600 * 1000, // one day,
        color: 'red'
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
    }

});
