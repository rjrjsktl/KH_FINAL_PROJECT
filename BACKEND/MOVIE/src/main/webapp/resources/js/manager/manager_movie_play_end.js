$(document).ready(function () {
    const checkBtn = $('.checkBtn');
    // 검색 기능
    const search = $('#selectBox');
    const searchContent = $('.searchContent');
    search.on('change', (e) => {
        console.log($(e.currentTarget).val());
        searchContent.val("");
    });

    checkBtn.on('click', (e) => {
        checking();
    });

    searchContent.on('keypress', (e) => {
        if (e.keyCode === 13) {
            checking();
        }
    });

    function checking() {
        console.log(search.val());
        console.log(searchContent.val());

        $.ajax({
            url: "member/Search_PlayEnd",
            data: {
                searchType: search.val(),
                searchContent: searchContent.val()
            },
            cache: false,
            type: "GET",
            success: function (result) {
                if (result != null) {
                    console.log("검색 데이터 전달 성공");
                    console.log(result);

                    let PlayList = result.playMovieList;

                    let userTableBody = $('#userTableBody');
                    userTableBody.empty();

                    PlayList.forEach(function (PlayItems) {
                        let playNo = PlayItems.play.playNo;
                        let movieNo = PlayItems.movie.movieNo;
                        let movieTitle = PlayItems.movie.movieTitle;
                        let cinemaArea = PlayItems.cinema.cinemaArea;
                        let cinemaName = PlayItems.cinema.cinemaName;
                        let screenName = PlayItems.screen.screenName;
                        let screenStyle = PlayItems.screen.screenStyle;
                        let playStart = PlayItems.play.playStart;
                        let playEnd = PlayItems.play.playEnd;

                        userTableBody.append(
                            `<tr>
                            <td>${playNo}</td>
							<td><a href="/movie/movieList/detail_List/introduce/${movieNo}">${movieTitle}</a></td>
							<td>${cinemaArea}</td>
							<td>${cinemaName}</td>
							<td>${screenName}</td>
							<td>${screenStyle}</td>
							<td>${playStart}</td>
							<td>${playEnd}</td>
							<td><button class="delBtn"><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                            </tr>`
                        );
                    });
                }

                // Pagination 업데이트
                const pagination = result.pagination;
                const currentPage = pagination.currentPage;
                const startPage = pagination.startPage;
                const endPage = pagination.endPage;
                const maxPage = pagination.maxPage;
                const url = "?cp=";

                let paginationHtml = '';
                paginationHtml += '<div>';
                paginationHtml += '<a href="' + url + '1">&lt;&lt;</a>';
                paginationHtml += '</div>';
                paginationHtml += '<div>';
                paginationHtml += '<a href="' + url + pagination.prevPage + '">&lt;</a>';
                paginationHtml += '</div>';

                for (let i = startPage; i <= endPage; i++) {
                    if (i === currentPage) {
                        paginationHtml += '<div>';
                        paginationHtml += '<a class="selected_Cp">' + i + '</a>';
                        paginationHtml += '</div>';
                    } else {
                        paginationHtml += '<div>';
                        paginationHtml += '<a href="' + url + i + '">' + i + '</a>';
                        paginationHtml += '</div>';
                    }
                }

                paginationHtml += '<div>';
                paginationHtml += '<a href="' + url + pagination.nextPage + '">&gt;</a>';
                paginationHtml += '</div>';
                paginationHtml += '<div>';
                paginationHtml += '<a href="' + url + pagination.maxPage + '">&gt;&gt;</a>';
                paginationHtml += '</div>';

                $('.page_Nation').html(paginationHtml);
            }
        });
    }

});