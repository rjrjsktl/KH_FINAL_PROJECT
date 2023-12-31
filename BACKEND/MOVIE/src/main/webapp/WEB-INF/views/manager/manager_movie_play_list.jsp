<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 -->

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상영영화 목록</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/manager/manager_movie_play_list.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/manager/reset.css">

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
				<div class="nav_Title">로고영역</div>
				<jsp:include page="/WEB-INF/views/manager/manager_nav.jsp" />
            </div>

            <div class="right_items_Container">
             	<jsp:include page="/WEB-INF/views/manager/manager_inner_Header.jsp" />

                <div id="items_Wrapper">
                    <div class="set_Edge">
                        <div class="table_Wrapper">
                            <div class="table_Title">
                                <span>상영영화 목록</span>
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
                                    <th>영화 제목</th>
                                    <th>영화 상영 시작일</th>
                                    <th>영화 상영 종료일</th>
                                    <th>등록일</th>
                                    <th>등록자</th>
                                    <th>수정</th>
                                    <th>삭제</th>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>가디언 오브 갤럭시 S23 ULTRA</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.06.27 12:22:55</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>관리자2</td>
                                    <td><button class="editBtn"><i
                                                class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button class="delBtn"><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>가디언 오브 갤럭시 S23 ULTRA</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.06.27 12:22:55</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>관리자2</td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                <tr>
                                    <td>3</td>
                                    <td>가디언 오브 갤럭시 S23 ULTRA</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.06.27 12:22:55</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>관리자2</td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                <tr>
                                    <td>4</td>
                                    <td>가디언 오브 갤럭시 S23 ULTRA</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.06.27 12:22:55</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>관리자2</td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                <tr>
                                    <td>5</td>
                                    <td>가디언 오브 갤럭시 S23 ULTRA</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.06.27 12:22:55</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>관리자2</td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                <tr>
                                    <td>6</td>
                                    <td>가디언 오브 갤럭시 S23 ULTRA</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.06.27 12:22:55</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>관리자2</td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                <tr>
                                    <td>7</td>
                                    <td>가디언 오브 갤럭시 S23 ULTRA</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.06.27 12:22:55</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>관리자2</td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                <tr>
                                    <td>8</td>
                                    <td>가디언 오브 갤럭시 S23 ULTRA</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.06.27 12:22:55</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>관리자2</td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                <tr>
                                    <td>9</td>
                                    <td>가디언 오브 갤럭시 S23 ULTRA</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.06.27 12:22:55</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>관리자2</td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>
                                <tr>
                                    <td>10</td>
                                    <td>가디언 오브 갤럭시 S23 ULTRA</td>
                                    <td>2023.05.27 14:51:52</td>
                                    <td>2023.06.27 12:22:55</td>
                                    <td>2023.05.27 16:34:05</td>
                                    <td>관리자2</td>
                                    <td><button><i class="fa-sharp fa-solid fa-pen-to-square"></i></button></td>
                                    <td><button><i class="fa-sharp fa-solid fa-xmark"></i></button></td>

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

    	<script src="${contextPath}/resources/js/manager/manager_select.js"></script>
    	<script src="${contextPath}/resources/js/manager/manager_movie_play_list.js"></script>
	<script src="${contextPath}/resources/js/manager/manager_inner_Header.js"></script>
	<script src="${contextPath}/resources/js/manager/manager_nav.js"></script>
</body>

</html>