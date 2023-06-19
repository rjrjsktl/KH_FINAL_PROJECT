<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 -->

<!-- 최신화 종료 건들일없음 -->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>개인정보 수정</title>

    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <link rel="stylesheet" href="${contextPath}/resources/css/common/outline.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPage_aSide.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPage_info.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPage_randomMovie.css">

</head>

<body>
    <div id="wrap">
        
        <!-- header -->
        <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <main>
            <section>
                <div class="asideAconatiner">
                    <aside>
                        <div class="aside-ul-wrap">
                            <ul class="aslide-list">
                                <li>
                                    <a href="notice_home.html">
                                        <h1>MY PAGE</h1>
                                    </a>
                                </li>
                                <li>
                                    <a href="notice.html">내가 쓴 리뷰</a>
                                </li>
                                <li>
                                    <a href="#">내가 본 영화</a>
                                </li>
                                <li>
                                    <a href="question_homel.html">내 문의 내역</a>
                                </li>
                                <li>
                                    <a href="find-my-item.html">내 분실물 내역</a>
                                </li>
                                <li>
                                    <a href="#">개인정보 수정</a>
                                </li>
                                <li>
                                    <a href="#">비밀번호 변경</a>
                                </li>

                            </ul>
                        </div>
                    </aside>

                    <div class="container">
                        <div>
                            <!-- 요기에 이제 필요 폼들 추가해야함 -->
                            <div class="main-content-wrap">
                                <h2>개인정보 수정</h2>

                            </div>
                            <form action="info" method="POST" name="myPage-form" class="myPage-form"
                                onsubmit="return infoValidate()">
                                <div class="myPage-info-frame">
                                    <label>닉네임</label>
                                    <input type="text" name="updateNick" id="userNick" value="${loginUser.userNick}"
                                        maxlength="10" placeholder="영어/숫자/한글 2~10글자 사이로 입력하세요.">
                                </div>
                                <div class="myPage-info-frame">
                                    <label>연락처</label>
                                    <input type="text" name="updateTel" id="userTel" value="${loginUser.userTel}"
                                        maxlength="11" placeholder="(- 제외) 전화번호를 입력하세요.">
                                </div>

                                <!-- 주소 --> <!--  fn:split(문자열, '구분자')  -->
								<c:set var="addr" value="${fn:split(loginUser.userAddr, ',,')}"  />
								
                                <div class="myPage-info-addr-frame">
                                    <label>주 소</label>
                                    <div>
                                        <input type="text" name="updateAddr" id="postcode" value="${addr[0]}"
                                            maxlength="6">
                                        <button type="button" id="info-address-btn"
                                            onclick="return execDaumPostcode()">검색</button>
                                    </div>
                                </div>
                                <div class="myPage-info-addr-frame">
                                    <input type="text" name="updateAddr" id="address" value="${addr[1]}">
                                </div>
                                <div class="myPage-info-addr-frame">
                                    <input type="text" name="updateAddr" id="detailAddress" value="${addr[2]}">
                                </div>

                                <div class="update-btn-area">
                                    <button id="info-update-btn" class="info-update-btn">수정하기</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                
                <!-- event-wrap -->
                <jsp:include page="/WEB-INF/views/myPage/myPage_randomMovie.jsp" />

            </section>
        </main>
    </div>
    
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
    <script src="${contextPath}/resources/js/myPage/myPage_swiper.js"></script>
    <script src="${contextPath}/resources/js/myPage/myPage_main.js"></script>
    <script src="${contextPath}/resources/js/myPage/myPage_randomMovie.js"></script>
</body>

</html>