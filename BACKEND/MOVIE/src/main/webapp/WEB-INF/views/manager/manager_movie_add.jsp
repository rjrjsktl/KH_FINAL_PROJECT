<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 -->

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>영화 등록</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/manager/manager_movie_add.css">
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
                                <span>영화 등록</span>
                            </div>
                            <form>
                                <div class="table_main">
                                    <div id="movie_sub">
                                        <span>영화 제목</span>
                                        <div>
                                            <input type="text" class="movie_sub_enter movie_title">
                                        </div>
                                    </div>
                                    <div id="movie_sub">
                                        <span>상영 시간</span>
                                        <div>
                                            <input type="text" class="movie_sub_enter movie_time">
                                        </div>
                                    </div>
                                    <div id="movie_sub">
                                        <span>제작 국가</span>
                                        <div>
                                            <input type="text" class="movie_sub_enter movie_country">
                                        </div>
                                    </div>
                                    <div id="movie_sub">
                                        <span>개봉일</span>
                                        <div>
                                            <input type="date" class="movie_releseDate">
                                        </div>
                                    </div>
                                    <div id="movie_sub">
                                        <span>이미지</span>
                                        <div>
                                            <input type="file" class="movie_image">
                                        </div>
                                    </div>
                                    <div id="level">
                                        <span>관람 등급</span>
                                        <div>
                                            <div class="movie_level">

                                            </div>
                                            <div class="level_Items">
                                                <div class="movie_level_slide">
                                                    <div>test1</div>
                                                    <div>test2</div>
                                                    <div>test3</div>
                                                    <div>test4</div>
                                                    <div>test5</div>
                                                    <div>test6</div>
                                                    <div>test7</div>
                                                    <div>test8</div>
                                                    <div>test9</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="Genre">
                                        <span>장르</span>
                                        <div>
                                            <div class="movie_Genre">

                                            </div>
                                            <div class="Genre_Items">
                                                <div class="movie_genre_slide">
                                                    <div>test1</div>
                                                    <div>test2</div>
                                                    <div>test3</div>
                                                    <div>test4</div>
                                                    <div>test5</div>
                                                    <div>test6</div>
                                                    <div>test7</div>
                                                    <div>test8</div>
                                                    <div>test9</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="movie_sub">
                                        <span>줄거리</span>
                                        <div>
                                            <textarea class="movie_sub_enter movie_story"
                                                placeholder="500자 내외로 작성해 주세요."></textarea>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <div class="table_bottom">
                                <button type="submit" class="bottom_Submit">저장</button>
                                <button class="bottom_Cancel">취소</button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

    </main>


    	<script src="${contextPath}/resources/js/manager/manager_select.js"></script>
    	<script src="${contextPath}/resources/js/manager/manager_movie_add.js"></script>
	<script src="${contextPath}/resources/js/manager/manager_inner_Header.js"></script>
	<script src="${contextPath}/resources/js/manager/manager_nav.js"></script>
</body>

</html>