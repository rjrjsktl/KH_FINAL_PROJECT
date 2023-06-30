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
            url: "member/Search_Lost",
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

                    let lostList = result.getLostList;

                    let userTableBody = $('#userTableBody');
                    userTableBody.empty();

                    lostList.forEach(function (lostItems) {
                        let lostNo = lostItems.losts.lostNo;
                        let userEmail = lostItems.user.userEmail;
                        let lostTitle = lostItems.losts.lostTitle;
                        let lostContent = lostItems.losts.lostContent;
                        let lostItem = lostItems.losts.lostItem;
                        let lostDate = lostItems.losts.lostDate;
                        let lostRepSt = lostItems.losts.lostRepSt;
                        let lostRepDate = lostItems.losts.lostRepDate;
                        let lostRepWriter = lostItems.losts.lostRepWriter;

                        userTableBody.append(
                            `<tr>
                                <td>${lostNo}</td>
                                <td>${userEmail}</td>
                                <td><a href="/movie/helpDesk/lost_detail/${lostNo}">${lostTitle}</a></td>
                                <td class="wordReduce">${lostContent}</td>
                                <td>${lostItem}</td>
                                <td>${lostDate}</td>
                                <td>${lostRepSt}</td>
                                <td>${lostRepDate != null ? lostRepDate : '-'}</td>
                                <td>${lostRepWriter != null ? lostRepWriter : '-'}</td>
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