<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<!-- 최신화 종료 건들일없음 -->


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>1:1문의</title>

    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
    <link rel="stylesheet" href="${contextPath}/resources/css/common/outline.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPage_aSide.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPage_myMtmList.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPage_randomMovie.css">

</head>

<body>
    <div id="wrap">
        
        <!-- header -->
        <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <main>
            <section>
                <div class="asideAconatiner">
                    
                    <!-- aSide -->
                    <jsp:include page="/WEB-INF/views/myPage/myPage_aSide.jsp" />

                    <div class="container">
                        <div>
                            <div class="notice-content-wrap">
                                <div class="notice-header">
                                    <h2>내 문의 내역</h2>
                                    <p>내가 한 문의의 답변 상황을 확인할 수 있습니다.</p>
                                </div>

                                <div class="search-area">
                                    <p>내 1:1문의 게시글 총<span style="color:red">1</span><span>/</span><span>3</span>건</p>
                                </div>

                                <div class="table-wrap">
                                    <table>

                                        <thead>
                                            <th>번호</th>
                                            <th>내용</th>
                                            <th>등록일</th>
                                            <th>조회수</th>
                                        </thead>
                                        <tbody>
                                            <tr class="row">
                                                <td>1</td>
                                                <th><a href="">내용123</a><span>...[0]</span></th>
                                                <td>2023.01.01</td>
                                                <td>1</td>
                                            </tr>
                                            <tr class="row">
                                                <td>2</td>
                                                <th><a href="">내용123</a><span>...[1]</span></th>
                                                <td>2023.01.01</td>
                                                <td>23</td>
                                            </tr>
                                            <tr class="row">
                                                <td>3</td>
                                                <th><a href="">내용123</a><span>...[1]</span></th>
                                                <td>2023.01.01</td>
                                                <td>456</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <div>
                                        <button>게시물 등록</button>
                                    </div>
                                    <!-- 10개씩 -->
                                    <ul class="pagination">
                                        <li><a href="#">&lt;&lt;</a></li>
                                        <li><a href="#">&lt;</a></li>
                                        <li><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li><a href="#">&gt;</a></li>
                                        <li><a href="#">&gt;&gt;</a></li>
                                    </ul>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>

    </div>
    
    <!-- event-wrap -->
    <jsp:include page="/WEB-INF/views/myPage/myPage_randomMovie.jsp" />
    
    <!-- footer -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    
    <div id="myModal" class="modal">
        <div class="modal-content">
            <div class="close-button">&times;</div>
            <iframe src="../login/login.html" frameborder="0" width="500px" height="500px"></iframe>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/common/header.js"></script>
    <script src="${contextPath}/resources/js/myPage/myPage_myMtm.js"></script>
    <script src="${contextPath}/resources/js/myPage/myPage_randomMovie.js"></script>
    <script src="${contextPath}/resources/js/myPage/myPage_swiper.js"></script>


</body>

</html>