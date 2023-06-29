$(document).ready(function () {
    // 관리자 권한 부여 설정
    const checkBtn = $('.checkBtn');
    const manager = $('.Is_Manager');
    const block = $('.Is_Blocked');


    manager.on('change', (e) => {
        let clickTarget = $(e.currentTarget).val();
        console.log("가져온 아이디는 : " + $(e.currentTarget).data('id'));


        if (clickTarget == 'Y') {
            console.log("Y가 찍힘" + clickTarget);

            $.ajax({
                url: "Manager_ST",
                data: {
                    "MST": $(e.currentTarget).val()
                    , "userId": $(e.currentTarget).data('id')
                },
                type: "POST",
                success: function (result) {
                    if (result > 0) {
                        console.log("N -> Y로 변경 완료");
                        alert("관리자 상태 변경 완료!");
                    } else {
                        console.log("N -> Y로 변경 실패");
                        alert("관리자 상태 변경 실패!");
                    }
                },

                error: function () {
                    console.log("error : N -> Y로 변경 실패");
                }
            });




        } else {
            console.log("N이 찍힘" + clickTarget);

            $.ajax({
                url: "Manager_ST",
                data: {
                    "MST": $(e.currentTarget).val()
                    , "userId": $(e.currentTarget).data('id')
                },
                type: "POST",
                success: function (result) {
                    if (result > 0) {
                        console.log("Y -> N으로 변경 완료");
                        alert("관리자 상태 변경 완료!");
                    } else {
                        console.log("Y -> N으로 변경 실패");
                        alert("관리자 상태 변경 완료!");
                    }
                },

                error: function () {
                    console.log("error : Y -> N으로 변경 실패");
                }
            });





        }

    });


    // 유저 이용제한

    block.on('change', (e) => {
        let clickTarget = $(e.currentTarget).val();
        console.log("가져온 아이디는 : " + $(e.currentTarget).data('id'));


        if (clickTarget == 'Y') {
            console.log("Y가 찍힘" + clickTarget);

            $.ajax({
                url: "Block_ST",
                data: {
                    "BST": $(e.currentTarget).val()
                    , "userId": $(e.currentTarget).data('id')
                },
                type: "POST",
                success: function (result) {
                    if (result > 0) {
                        console.log("N -> Y로 변경 완료");
                        alert("유저 이용제한 변경 완료!");
                    } else {
                        console.log("N -> Y로 변경 실패");
                        alert("유저 이용제한 변경 실패!");
                    }
                },

                error: function () {
                    console.log("error : N -> Y로 변경 실패");
                }
            });




        } else {
            console.log("N이 찍힘" + clickTarget);

            $.ajax({
                url: "Block_ST",
                data: {
                    "BST": $(e.currentTarget).val()
                    , "userId": $(e.currentTarget).data('id')
                },
                type: "POST",
                success: function (result) {
                    if (result > 0) {
                        console.log("Y -> N으로 변경 완료");
                        alert("유저 이용제한 변경 완료!");
                    } else {
                        console.log("Y -> N으로 변경 실패");
                        alert("유저 이용제한 변경 완료!");
                    }
                },

                error: function () {
                    console.log("error : Y -> N으로 변경 실패");
                }
            });





        }

    });


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
            url: "member/Search_Member",
            data: {
                searchType: search.val()
                , searchContent: searchContent.val()
            },
            type: "GET",
            success: function (result) {
                if (result != null) {
                    console.log("검색 데이터 전달 성공");
                    console.log(result);

                    let userTableBody = $('#userTableBody');
                    userTableBody.empty();

                    result.userList.forEach(function (user) {
                        let row = $('<tr>');
                        row.append('<td>' + user.userNo + '</td>');
                        row.append('<td>' + user.userEmail + '</td>');
                        row.append('<td>' + user.userName + '</td>');
                        row.append('<td>' + user.userNick + '</td>');
                        row.append('<td>' + user.userTel + '</td>');

                        let userAddr = user.userAddr ? user.userAddr : '미등록';
                        row.append('<td>' + userAddr + '</td>');

                        let userBirth = user.userBirth ? user.userBirth : '미등록';
                        row.append('<td>' + userBirth + '</td>');

                        row.append('<td>' + user.userGender + '</td>');
                        row.append('<td>' + user.userRegDate + '</td>');

                        let userDelete = user.userDelete ? user.userDelete : '-';
                        row.append('<td>' + userDelete + '</td>');

                        row.append('<td>' + user.userSt + '</td>');
                        row.append('<td>' + user.userPoint + '</td>');
                        row.append('<td>' + user.userSns + '</td>');

                        let userManagerSt = user.userManagerSt === 'Y' ? 'Y' : 'N';
                        let managerSelectHtml = '<select class="Is_Manager" data-id="' + user.userEmail + '">' +
                            '<option value="N"' + (userManagerSt === 'N' ? ' selected' : '') + '>N</option>' +
                            '<option value="Y"' + (userManagerSt === 'Y' ? ' selected' : '') + '>Y</option>' +
                            '</select>';
                        row.append('<td>' + managerSelectHtml + '</td>');

                        let userBlock = user.userBlock === 'Y' ? 'Y' : 'N';
                        let blockSelectHtml = '<select class="Is_Block" data-id="' + user.userEmail + '">' +
                            '<option value="N"' + (userBlock === 'N' ? ' selected' : '') + '>N</option>' +
                            '<option value="Y"' + (userBlock === 'Y' ? ' selected' : '') + '>Y</option>' +
                            '</select>';
                        row.append('<td>' + blockSelectHtml + '</td>');

                        userTableBody.append(row);
                    });

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

                else {
                    console.log("검색 데이터 전달 실패");
                }
            },

            error: function () {
                console.log("에러로 인해 검색 데이터 전달 실패");
            }
        });
    }

});