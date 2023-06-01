<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>판리자 페이지</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/manager/managerPage.css">
    <link rel="stylesheet" href="../../css/managerPage/reset.css">

    <!-- fontawesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
        integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />

    <!-- jQuery 라이브러리 추가(CDN) -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <!-- 그래프용 CDN -->
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/series-label.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script src="https://code.highcharts.com/modules/export-data.js"></script>
    <script src="https://code.highcharts.com/modules/accessibility.js"></script>

    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <!-- 달력 API -->


</head>

<body class="dark light">
    <main>
        <div class="main_Wrapper">
            <div id="left_Nav_Container">
                <div class="nav_Title">
                    로고영역
                </div>

                <jsp:include page="/WEB-INF/views/common/header.jsp" />

            </div>
            <div class="right_items_Container">
                <div id="header_Wrapper">
                    <div class="header_Container">
                        <div class="header_loge_Area">
                            <span>어서오세요!&nbsp;</span>
                            <span>${loginMember.userName}&nbsp;</span>
                            <span>님!</span>
                        </div>
                        <button class="header_logout_Area">
                            <div>로그아웃</div>
                        </button>
                    </div>
                </div>
                <div id="items_Wrapper">
                    <div class="left_Item_Container">

                        <!-- 일일 접속자 수 -->
                        <div class="left_Inner_Contents">
                            <div id="daily_Enter">
                                <figure class="highcharts-figure"></figure>
                            </div>
                        </div>

                        <!-- 일일 관람객 수 -->
                        <div class="left_Inner_Contents algin_Left">
                            <div id="daily_Movie_Watch">
                                <figure class="highcharts-figure"></figure>
                            </div>
                        </div>

                        <!-- 신규 회원 -->
                        <div class="left_Inner_Contents">
                            <div class="inner_Top">
                                <span class="inner_Top_Text">신규 회원</span>
                                <span class="new_more">더보기</span>
                            </div>
                            <div class="inner_Top_Content">
                                <div class="noticeTable">
                                    <table class="tableWrapper">
                                        <th class="boardNum">번호</th>
                                        <th class="boardTItle">아이디</th>
                                        <th class="boardWriter">닉네임</th>
                                        <th class="boardDate">가입일</th>
                                        <th class="boardWatch">SNS</th>
                                        <tr>
                                            <td>06</td>
                                            <td>ACCOUNT01</td>
                                            <td>NICKNAME01</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>Y</td>
                                        <tr>
                                            <td>05</td>
                                            <td>ACCOUNT 02</td>
                                            <td>NICKNAME02</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>N</td>
                                        <tr>
                                            <td>04</td>
                                            <td>ACCOUNT 03</td>
                                            <td>NICKNAME03</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>N</td>
                                        <tr>
                                            <td>03</td>
                                            <td>ACCOUNT 04</td>
                                            <td>NICKNAME04</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>Y</td>
                                        </tr>
                                        <tr>
                                            <td>02</td>
                                            <td>ACCOUNT 05</td>
                                            <td>NICKNAME05</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>Y</td>
                                        </tr>
                                        <tr>
                                            <td>01</td>
                                            <td>ACCOUNT 06</td>
                                            <td>NICKNAME06</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>N</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <!-- 상영중인 영화 -->
                        <div class="left_Inner_Contents algin_Left">
                            <div class="inner_Top">
                                <span class="inner_Top_Text">상영중인 영화</span>
                                <span class="movie_more">더보기</span>
                            </div>
                            <div class="inner_Top_Content">
                                <div class="noticeTable">
                                    <table class="tableWrapper">
                                        <th class="boardNum">번호</th>
                                        <th class="boardTItle">영화명</th>
                                        <th class="boardWriter">예매율</th>
                                        <th class="boardDate">상영시작</th>
                                        <th class="boardDate">상영종료</th>
                                        <th class="boardWatch">관람수</th>
                                        <tr>
                                            <td>06</td>
                                            <td>영화 01</td>
                                            <td>111%</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>1200</td>
                                        <tr>
                                            <td>05</td>
                                            <td>영화 02</td>
                                            <td>10%</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>1582</td>
                                        <tr>
                                            <td>04</td>
                                            <td>영화 03</td>
                                            <td>30%</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>120</td>
                                        <tr>
                                            <td>03</td>
                                            <td>영화 04</td>
                                            <td>15%</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>11112</td>
                                        </tr>
                                        <tr>
                                            <td>02</td>
                                            <td>영화 05</td>
                                            <td>1000%</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>157382</td>
                                        </tr>
                                        <tr>
                                            <td>01</td>
                                            <td>영화 06</td>
                                            <td>1%</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>121687</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <!-- 공지사항 -->
                        <div class="left_Inner_Contents">
                            <div class="inner_Top">
                                <span class="inner_Top_Text">공지사항</span>
                                <span class="notice_more">더보기</span>
                            </div>
                            <div class="inner_Top_Content">
                                <div class="noticeTable">
                                    <table class="tableWrapper">
                                        <th class="boardNum">번호</th>
                                        <th class="boardTItle">제목</th>
                                        <th class="boardWriter">작성자</th>
                                        <th class="boardDate">작성일</th>
                                        <th class="boardWatch">조회수</th>
                                        <tr>
                                            <td>06</td>
                                            <td>공지사항 01</td>
                                            <td>판리자1</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>12</td>
                                        <tr>
                                            <td>05</td>
                                            <td>공지사항 02</td>
                                            <td>판리자2</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>12</td>
                                        <tr>
                                            <td>04</td>
                                            <td>공지사항 03</td>
                                            <td>판리자3</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>12</td>
                                        <tr>
                                            <td>03</td>
                                            <td>공지사항 04</td>
                                            <td>판리자4</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>12</td>
                                        </tr>
                                        <tr>
                                            <td>02</td>
                                            <td>공지사항 04</td>
                                            <td>판리자5</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>12</td>
                                        </tr>
                                        <tr>
                                            <td>01</td>
                                            <td>공지사항 04</td>
                                            <td>판리자6</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>12</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <!-- 1 : 1 문의 -->
                        <div class="left_Inner_Contents algin_Left">
                            <div class="inner_Top">
                                <span class="inner_Top_Text">1 : 1 문의</span>
                                <span class="qna_more">더보기</span>
                            </div>
                            <div class="inner_Top_Content">
                                <div class="noticeTable">
                                    <table class="tableWrapper">
                                        <th class="boardNum">번호</th>
                                        <th class="boardTItle">제목</th>
                                        <th class="boardWriter">작성자</th>
                                        <th class="boardDate">작성일</th>
                                        <th class="boardWatch">답변여부</th>
                                        <tr>
                                            <td>06</td>
                                            <td>문의 1</td>
                                            <td>회원1</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>N</td>
                                        <tr>
                                            <td>05</td>
                                            <td>문의 2</td>
                                            <td>회원2</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>N</td>
                                        <tr>
                                            <td>04</td>
                                            <td>문의 3</td>
                                            <td>회원3</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>N</td>
                                        <tr>
                                            <td>03</td>
                                            <td>나문희</td>
                                            <td>회원4</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>Y</td>
                                        </tr>
                                        <tr>
                                            <td>02</td>
                                            <td>민무늬</td>
                                            <td>회원5</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>Y</td>
                                        </tr>
                                        <tr>
                                            <td>01</td>
                                            <td>호랑나비</td>
                                            <td>회원6</td>
                                            <td>2023.05.26 11:20:21</td>
                                            <td>Y</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="right_Item_Container">
                        <div class="top_Click_area">
                            <!-- TODO LIST 하면 괜찮을 듯 -->
                            <div class="top_items top_click1 active">메모</div>
                            <!-- <div class="top_items top_click2">일정표</div>
                            <div class="top_items top_click3">ㅁㄴㅇㄹ</div> -->
                        </div>
                        <div class="right_Items_Area">
                            <div>
                                <textarea type="text" id="crtMemo" class="crtMemo" autocomplete="off"></textarea>
                                <button id="crtbtn" class="crtbtn">등록</button>
                                
                            </div>
                            <ul id="managerMemo" class="managerMemo">
                                <!-- 어차피 메모 값이 있다면 초기화 될거임(틀잡기용) -->
                                <li id="memoList" class="memoList">
                                    <textarea id="viewMemo" class="viewMemo"></textarea>
                                    <!-- 수정 필요? -->
                                    <button type="button" id="dltbtn" class="dltbtn" name="momoNo" value="" onclick="delMemo()">삭제</button>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </main>


    <script src="../../js/managerPage/managerPage.js"></script>
</body>

</html>