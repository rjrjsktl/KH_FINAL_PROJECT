$(document).ready(function () {
    // 영화 상영 상태 설정 Y = 상영중 / N = 상영안함
    const play = $('.Is_Play');


    play.on('change', (e) => {
        let clickTarget = $(e.currentTarget).val();
        console.log("가져온 번호는 : " + $(e.currentTarget).data('id'));


        if (clickTarget == 'Y') {
            console.log("Y가 찍힘" + clickTarget);

            $.ajax({
                url: "Movie_ST",
                data: {
                    "MST": $(e.currentTarget).val()
                    , "movieNo": $(e.currentTarget).data('id')
                },
                type: "POST",
                success: function (result) {
                    if (result > 0) {
                        console.log("N -> Y로 변경 완료");
                        alert("영화 상태 변경 완료!");
                    } else {
                        console.log("N -> Y로 변경 실패");
                        alert("영화 상태 변경 실패!");
                    }
                },

                error: function () {
                    console.log("error : N -> Y로 변경 실패");
                }
            });




        } else {
            console.log("N이 찍힘" + clickTarget);

            $.ajax({
                url: "Movie_ST",
                data: {
                    "MST": $(e.currentTarget).val()
                    , "movieNo": $(e.currentTarget).data('id')
                },
                type: "POST",
                success: function (result) {
                    if (result > 0) {
                        console.log("Y -> N으로 변경 완료");
                        alert("영화 상태 변경 완료!");
                    } else {
                        console.log("Y -> N으로 변경 실패");
                        alert("영화 상태 변경 완료!");
                    }
                },

                error: function () {
                    console.log("error : Y -> N으로 변경 실패");
                }
            });





        }

    });


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
            url: "member/Search_Movie",
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

                    let MovieList = result.cleanedList;

                    let userTableBody = $('#userTableBody');
                    userTableBody.empty();

                    MovieList.forEach(function (movieItems) {
                        let movieNo = movieItems.movieNo;
                        let movieTitle = movieItems.movieTitle;
                        let movieRuntime = movieItems.movieRuntime;
                        let movieNation = movieItems.movieNation;
                        let movieOpen = movieItems.movieOpen;
                        let mgNo = movieItems.mgNo;
                        let movieContent = movieItems.movieContent;
                        let movieRegdate = movieItems.movieRegdate;
                        let genreName = movieItems.genreName;
                        let moviePlayed = movieItems.moviePlayed;
                        let movieWatched = movieItems.movieWatched;
                        let movieSt = movieItems.movieSt;

                        userTableBody.append(
                            `<tr>
                            <td>${movieNo}</td>
                            <td><a href="/movie/movieList/detail_List/introduce/${movieNo}">${movieTitle}</a></td>
                            <td>${movieRuntime}</td>
                            <td>${movieNation}</td>
                            <td>${movieOpen}</td>
                            <td>${mgNo}</td>
                            <td class="textReduce">${movieContent}</td>
                            <td>${movieRegdate}</td>
                            <td>${genreName}</td>
                            <td>${moviePlayed}</td>
                            <td>${movieWatched}</td>
                            <c:choose>
                                <c:when test="${movieSt == 'N'}">
                                    <td><select class="Is_Play"
                                            data-id="${movieNo}">
                                            <option value="N" selected>N</option>
                                            <option value="Y">Y</option>
                                        </select></td>
                                </c:when>
                                <c:otherwise>
                                    <td><select class="Is_Play"
                                            data-id="${movieNo}">
                                            <option value="N">N</option>
                                            <option value="Y" selected>Y</option>
                                        </select></td>
                                </c:otherwise>
                            </c:choose>
                            <td>
                                <a href="/movie/manager/movie_list/edit/${movieNo}"
                                    class="editEvent"><i
                                        class="fa-sharp fa-solid fa-pen-to-square"></i></a>
                            </td>
                            <td>
                                <a class="deleteEvent"><i
                                        class="fa-sharp fa-solid fa-xmark"></i></a>
                            </td>
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