<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 -->

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>이벤트 목록</title>

    <link rel="stylesheet" href="../../css/managerPage/manager_event_list.css">
    <link rel="stylesheet" href="../../css/managerPage/reset.css">

    <!-- fontawesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
        integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />

    <!-- jQuery 라이브러리 추가(CDN) -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>

<body class="dark light">
    <main>

        <div class="main_Wrapper">
            <div id="left_Nav_Container">
                <div class="nav_Title">
                    로고영역
                </div>
                <!-- NAV 영역 -->
                <nav>
                    <ul class="nav_Slide">
                        <a class="title_move" href="#">
                            <li class="slide_Title">
                                <div class="slide_Left_Icon">
                                    <i class="fa-sharp fa-solid fa-house"></i>
                                </div>
                                <span>관리자 메인</span>
                            </li>
                        </a>
                        <a class="title_move" href="#">
                            <li class="slide_Title">
                                <div class="slide_Left_Icon">
                                    <i class="fa-solid fa-user"></i>
                                </div>
                                <span>회원 리스트</span>
                            </li>
                        </a>
                        <li class="slide_Content">
                            <div class="slide_Wrapper">
                                <div class="slide_Left_Icon">
                                    <i class="fa-solid fa-headset"></i>
                                </div>
                                <span class="slide_Inner_Title">1 : 1 문의</span>
                                <div class="slide_Right_Icon">
                                    <i class="fa-solid fa-caret-down"></i>
                                </div>
                            </div>
                            <div class="slide_Down_items">
                                <ul>

                                    <a href="#">
                                        <li>
                                            <div class="inner_align">
                                                <div class="inner_Left_Icon">
                                                    <i class="fa-solid fa-play fa-2xs"></i>
                                                </div>
                                                <span>1 : 1 문의 목록</span>
                                            </div>
                                        </li>
                                    </a>
                                </ul>
                            </div>
                        </li>
                        <li class="slide_Content">
                            <div class="slide_Wrapper">
                                <div class="slide_Left_Icon">
                                    <i class="fa-brands fa-youtube"></i>
                                </div>
                                <span class="slide_Inner_Title">영화</span>
                                <div class="slide_Right_Icon">
                                    <i class="fa-solid fa-caret-down"></i>
                                </div>
                            </div>
                            <div class="slide_Down_items">
                                <ul>
                                    <a href="#">
                                        <li>
                                            <div class="inner_align">
                                                <div class="inner_Left_Icon">
                                                    <i class="fa-solid fa-play fa-2xs"></i>
                                                </div>
                                                <span>영화 목록</span>
                                            </div>
                                        </li>
                                    </a>
                                    <a href="#">
                                        <li>
                                            <div class="inner_align">
                                                <div class="inner_Left_Icon">
                                                    <i class="fa-solid fa-play fa-2xs"></i>
                                                </div>
                                                <span>영화 등록</span>
                                            </div>
                                        </li>
                                    </a>
                                    <a href="#">
                                        <li>
                                            <div class="inner_align">
                                                <div class="inner_Left_Icon">
                                                    <i class="fa-solid fa-play fa-2xs"></i>
                                                </div>
                                                <span>상영시간 목록</span>
                                            </div>
                                        </li>
                                    </a>
                                    <a href="#">
                                        <li>
                                            <div class="inner_align">
                                                <div class="inner_Left_Icon">
                                                    <i class="fa-solid fa-play fa-2xs"></i>
                                                </div>
                                                <span>상영시간 등록</span>
                                            </div>
                                        </li>
                                    </a>
                                </ul>
                            </div>
                        </li>
                        <li class="slide_Content">
                            <div class="slide_Wrapper selected_Title active">
                                <div class="slide_Left_Icon">
                                    <i class="fa-sharp fa-regular fa-calendar"></i>
                                </div>
                                <span class="slide_Inner_Title">이벤트</span>
                                <div class="slide_Right_Icon">
                                    <i class="fa-solid fa-caret-down"></i>
                                </div>
                            </div>
                            <div class="slide_Down_items" style=" display: block;">
                                <ul>
                                    <a href="#">
                                        <li class="selected_Title">
                                            <div class="inner_align">
                                                <div class="inner_Left_Icon">
                                                    <i class="fa-solid fa-play fa-2xs"></i>
                                                </div>
                                                <span>이벤트 목록</span>
                                            </div>
                                        </li>
                                    </a>
                                    <a href="#">
                                        <li>
                                            <div class="inner_align">
                                                <div class="inner_Left_Icon">
                                                    <i class="fa-solid fa-play fa-2xs"></i>
                                                </div>
                                                <span>이벤트 등록</span>
                                            </div>
                                        </li>
                                    </a>
                                </ul>
                            </div>
                        </li>
                        <li class="slide_Content">
                            <div class="slide_Wrapper">
                                <div class="slide_Left_Icon">
                                    <i class="fa-sharp fa-solid fa-circle-exclamation"></i>
                                </div>
                                <span class="slide_Inner_Title">공지사항</span>
                                <div class="slide_Right_Icon">
                                    <i class="fa-solid fa-caret-down"></i>
                                </div>
                            </div>
                            <div class="slide_Down_items">
                                <ul>
                                    <a href="#">
                                        <li>
                                            <div class="inner_align">
                                                <div class="inner_Left_Icon">
                                                    <i class="fa-solid fa-play fa-2xs"></i>
                                                </div>
                                                <span>공지사항 목록</span>
                                            </div>
                                        </li>
                                    </a>
                                    <a href="#">
                                        <li>
                                            <div class="inner_align">
                                                <div class="inner_Left_Icon">
                                                    <i class="fa-solid fa-play fa-2xs"></i>
                                                </div>
                                                <span>공지사항 등록</span>
                                            </div>
                                        </li>
                                    </a>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </nav>

            </div>

            <div class="right_items_Container">
                <!-- 내부 HEADER 영역 -->
                <header>
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
                </header>

                <div id="items_Wrapper">
                    <div class="set_Edge">
                        <div class="table_Wrapper">
                            <div class="table_Title">
                                <span>이벤트 목록</span>
                                <div class="search_Box">
                                    <input placeholder="검색" />
                                    <button>
                                        <i class="fa-solid fa-magnifying-glass fa-2xs"></i>
                                    </button>
                                </div>
                            </div>
                            <table class="table_main">
                                <tr>
                                    <th>번호</th>
                                    <th>이벤트 제목</th>
                                    <th>이벤트 내용</th>
                                    <th>이벤트 시작일</th>
                                    <th>이벤트 종료일</th>
                                    <th>이벤트 작성일</th>
                                    <th>이벤트 상태</th>
                                    <th>수정</th>
                                    <th>삭제</th>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>이벤트 제목</td>
                                    <td>간략한 줄거리만 채우기, 몇 자 이상 시 ... 으로 표시하기</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>2023.05.17 13:34:21</td>
                                    <td>
                                        <select name="Is_On">
                                            <option value="N" selected>N</option>
                                            <option value="Y">Y</option>
                                        </select>
                                    </td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>이벤트 제목</td>
                                    <td>간략한 줄거리만 채우기, 몇 자 이상 시 ... 으로 표시하기</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>2023.05.17 13:34:21</td>
                                    <td>
                                        <select name="Is_On">
                                            <option value="N" selected>N</option>
                                            <option value="Y">Y</option>
                                        </select>
                                    </td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>이벤트 제목</td>
                                    <td>간략한 줄거리만 채우기, 몇 자 이상 시 ... 으로 표시하기</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>2023.05.17 13:34:21</td>
                                    <td>
                                        <select name="Is_On">
                                            <option value="N" selected>N</option>
                                            <option value="Y">Y</option>
                                        </select>
                                    </td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td>이벤트 제목</td>
                                    <td>간략한 줄거리만 채우기, 몇 자 이상 시 ... 으로 표시하기</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>2023.05.17 13:34:21</td>
                                    <td>
                                        <select name="Is_On">
                                            <option value="N" selected>N</option>
                                            <option value="Y">Y</option>
                                        </select>
                                    </td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                </tr>
                                <tr>
                                    <td>5</td>
                                    <td>이벤트 제목</td>
                                    <td>간략한 줄거리만 채우기, 몇 자 이상 시 ... 으로 표시하기</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>2023.05.17 13:34:21</td>
                                    <td>
                                        <select name="Is_On">
                                            <option value="N" selected>N</option>
                                            <option value="Y">Y</option>
                                        </select>
                                    </td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                </tr>
                                <tr>
                                    <td>6</td>
                                    <td>이벤트 제목</td>
                                    <td>간략한 줄거리만 채우기, 몇 자 이상 시 ... 으로 표시하기</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>2023.05.17 13:34:21</td>
                                    <td>
                                        <select name="Is_On">
                                            <option value="N" selected>N</option>
                                            <option value="Y">Y</option>
                                        </select>
                                    </td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                </tr>
                                <tr>
                                    <td>7</td>
                                    <td>이벤트 제목</td>
                                    <td>간략한 줄거리만 채우기, 몇 자 이상 시 ... 으로 표시하기</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>2023.05.17 13:34:21</td>
                                    <td>
                                        <select name="Is_On">
                                            <option value="N" selected>N</option>
                                            <option value="Y">Y</option>
                                        </select>
                                    </td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                </tr>
                                <tr>
                                    <td>8</td>
                                    <td>이벤트 제목</td>
                                    <td>간략한 줄거리만 채우기, 몇 자 이상 시 ... 으로 표시하기</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>2023.05.17 13:34:21</td>
                                    <td>
                                        <select name="Is_On">
                                            <option value="N" selected>N</option>
                                            <option value="Y">Y</option>
                                        </select>
                                    </td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                </tr>
                                <tr>
                                    <td>9</td>
                                    <td>이벤트 제목</td>
                                    <td>간략한 줄거리만 채우기, 몇 자 이상 시 ... 으로 표시하기</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>2023.05.17 13:34:21</td>
                                    <td>
                                        <select name="Is_On">
                                            <option value="N" selected>N</option>
                                            <option value="Y">Y</option>
                                        </select>
                                    </td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                </tr>
                                <tr>
                                    <td>10</td>
                                    <td>이벤트 제목</td>
                                    <td>간략한 줄거리만 채우기, 몇 자 이상 시 ... 으로 표시하기</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>2023.05.17 13:34:21</td>
                                    <td>
                                        <select name="Is_On">
                                            <option value="N" selected>N</option>
                                            <option value="Y">Y</option>
                                        </select>
                                    </td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                </tr>

                            </table>
                            <div class="page_Nation">
                                <div>&lt;</div>
                                <div class="selected_Cp">1</div>
                                <div>2</div>
                                <div>3</div>
                                <div>4</div>
                                <div>5</div>
                                <div>6</div>
                                <div>7</div>
                                <div>&gt;</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </main>


    <script src="../../js/managerPage/manager_event_list.js"></script>
</body>

</html>