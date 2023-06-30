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
            url: "member/Search_Ask",
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

                    let mtmList = result.getMTMList;

                    let userTableBody = $('#userTableBody');
                    userTableBody.empty();

                    mtmList.forEach(function (mtmItem) {
                        let mtmNo = mtmItem.mtm.mtmNo;
                        let userEmail = mtmItem.user.userEmail;
                        let mtmType = mtmItem.mtm.mtmType;
                        let mtmTitle = mtmItem.mtm.mtmTitle;
                        let mtmContent = mtmItem.mtm.mtmContent;
                        let mtmRegdate = mtmItem.mtm.mtmRegdate;
                        let mtmRepSt = mtmItem.mtm.mtmRepSt;
                        let mtmRepDate = mtmItem.mtm.mtmRepDate;
                        let mtmRepWriter = mtmItem.mtm.mtmRepWriter;

                        userTableBody.append(
                            `<tr>
                                <td>${mtmNo}</td>
                                <td>${userEmail}</td>
                                <td>${mtmType}</td>
                                <td><a href="/movie/helpDesk/mtm_detail/${mtmNo}">${mtmTitle}</a></td>
                                <td class="wordReduce">${mtmContent}</td>
                                <td>${mtmRegdate}</td>
                                <td>${mtmRepSt}</td>
                                <td>${mtmRepDate != null ? mtmRepDate : '-'}</td>
                                <td>${mtmRepWriter != null ? mtmRepWriter : '-'}</td>
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