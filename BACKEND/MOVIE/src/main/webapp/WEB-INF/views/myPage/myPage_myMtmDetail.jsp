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
    <title>공지 세부</title>

    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
    <script src="/ckeditor5/build/ckeditor.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
	
    <link rel="stylesheet" href="${contextPath}/resources/css/common/outline.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPage_aSide.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPage_myMtmDetail.css">
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

                            <h2>1:1 문의</h2>

                            <div class="notice-contents">
                                <div> <span>1:1 문의 제목</span></div>
                                <div><span>[등록자]<span></span> <span>|</span> <span>[날짜] </span></span></div>
                                <div>
                                    [1:1문의내용]
                                </div>
                            </div>

                            <div class="movie-reply">

                                <div class="replywritewrap">
                                    <span>1:1문의 작성</span>

                                    <div>
                                        <form action="" class="replywrite">
                                            <textarea name="" id="" cols="30" rows="3"></textarea>
                                            <div class="replyBtn">문의 작성</div>
                                        </form>
                                    </div>
                                </div>



                                <div class="replyList">


                                    <ul>

                                        <li class="review" style="display: none;"><span>
                                                <img src="" alt="이미지">
                                            </span>
                                            <div>
                                                <span>씨*럼</span>
                                                <span>2023.05.24</span>
                                            </div>
                                            <div>
                                                이제 다리안아픔 개꿀띠임 역시 현대의학 개좆지리누<br>
                                                ㅋㅋㄹㅃㅃ<br>
                                            </div>
                                        </li>



                                    </ul>
                                </div>



                            </div>

                        </div>

                        <div>
                            <button>목록으로</button>
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
    <script src="${contextPath}/resources/js/myPage/myPage_myMtm.js"></script>
    <script src="${contextPath}/resources/js/myPage/myPage_randomEvent.js"></script>
    <script src="${contextPath}/resources/js/myPage/myPage_swiper.js"></script>
</body>

</html>