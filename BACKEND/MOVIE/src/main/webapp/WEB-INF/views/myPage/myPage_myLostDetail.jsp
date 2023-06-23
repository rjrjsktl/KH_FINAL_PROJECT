<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 분실물 문의 내용</title>

    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
	
    <link rel="stylesheet" href="${contextPath}/resources/css/common/outline.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/mypage/myPage_aSide.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/mypage/myPage_myLostDetail.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPage_randomEvent.css">

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
                        <div class="content-wrap">

                            <h2>분실물 신고</h2>

                            <div class="notice-contents content_inner">
                                <table class="innerTable">
                                    <tr>
                                        <th>제목</th>
                                        <td><input type="text" placeholder=" 제목을 입력해 주세요."></td>
                                    </tr>
                                    <tr>
                                        <th>물품</th>
                                        <td><input type="text" placeholder=" 잃어버린 물품에 대해 입력해 주세요."></td>
                                    </tr>
                                    <tr>
                                        <th>위치</th>
                                        <td><input type="text" placeholder=" 상세한 위치를 입력해 주세요."></td>
                                    </tr>
                                    <tr>
                                        <th>날짜</th>
                                        <td><input type="date" placeholder=" 잃어버린 날짜를 입력해 주세요." class="dateBtn"
                                                onfocus="this.showPicker()"></td>
                                    </tr>
                                    <tr>
                                        <th>첨부파일</th>
                                        <td><input type="file" multiple class="align_File"></td>
                                    </tr>
                                </table>
                            </div>

                            <div id="writeForm">
                                <div class="inner_Textarea_Title">상세 내용</div>
                                <textarea class="inner_Textarea"
                                    placeholder="잃어버리신 물건의 이름, 크기, 색상 등을 자세하게 설명해 주세요."></textarea>
                            </div>

                            <div class="btn_Container">
                                <button>작성하기</button>
                                <button>취소하기</button>
                            </div>

                        </div>

                    </div>
                </div>
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

    <script src="${contextPath}/resources/js/common/header.js"></script>
    <script src="${contextPath}/resources/js/myPage/myPage_myLostList.js"></script>
    <script src="${contextPath}/resources/js/myPage/myPage_randomEvent.js"></script>
    <script src="${contextPath}/resources/js/myPage/myPage_swiper.js"></script>
</body>

</html>