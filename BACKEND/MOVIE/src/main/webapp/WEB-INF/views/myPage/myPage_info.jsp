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
    <title>마이페이지<정보 수정>
    </title>
    
    <link rel="stylesheet" href="${contextPath}/resources/css/common/outline.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPage.css">
    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
</head>

<body>
    <div id="wrap">
        
        <!-- header -->
        <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <main>
            <!-- 여기서 부터 작업하세요. -->
            <div>
                <!-- myPage_logMemInfo.jsp -->
                <jsp:include page="/WEB-INF/views/myPage/myPage_logUserInfo.jsp" />
            </div>

            <div>
                <%--  이거 나중에 <jsp:include page="/WEB-INF/views/member/sideMenu.jsp"/>이런식으로 넣어줄 생각 --%>
                <!-- myPage_sideMenu.jsp -->
                <jsp:include page="/WEB-INF/views/myPage/myPage_sideMenu.jsp" />

                <section class="mypage-main">
                    MY KGV HOME <정보 수정>

                    <!-- <span class="myPage-explanation">원하는 회원 정보를 수정할 수 있습니다.</span> -->

                    <!-- 
                    http://localhost:8080/community/member/myPage/info (GET)
                    http://localhost:8080/community/member/myPage/info (POST) 
                    -->
                    <form action="info" method="POST" name="myPage-form" onsubmit="return infoValidate()">

                        <div class="mypage-info-frame">
                            <label>닉네임</label>
                        </div>
                        <div class="mypage-info-frame">
                            <input type="text" name="updateNickname" id="userNickname"
                            value="${loginUser.userNick}" maxlength="10">
                        </div>

                        <div class="mypage-info-frame">
                            <label>연락처</label>
                        </div>
                        <div class="mypage-info-frame">
                            <input type="text" name="updateTel" id="userTel" value="${loginUser.userTel}"
                            maxlength="11">
                        </div>

                        <!-- 주소 -->			<!--  fn:split(문자열, '구분자')  -->
					    <c:set var="addr"  value="${fn:split(loginUser.userAddr, ',,')}"  />                    

                        <div class="mypage-info-frame">
                            <label>주 소</label>
                        </div>
                        <div class="mypage-info-frame">
                            <input type="text" name="updateAddress" id="postcode" value="${addr[0]}"  maxlength="6">

                            <button type="button" id="info-address-btn" onclick="return execDaumPostcode()">검색</button>
                        </div>
    
                        <div class="mypage-info-frame">
                            <input type="text" name="updateAddress" id="address" value="${addr[1]}">
                        </div>
    
                        <div class="mypage-info-frame">
                            <input type="text" name="updateAddress" id="detailAddress" value="${addr[2]}">
                        </div>
    
                        <button id="info-update-btn">수정하기</button>
    
                     </form>

                </section>

            </div>


            <!-- 여기까지 작업하세요. -->
        </main>

    </div>
    
    <!-- footer -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    
    <!--
     <%-- session에 message 속성이 존재하는 경우 alert창으로 해당 내용을 출력 --%>
             <c:if test="${ !empty sessionScope.message }">
                 <script>
                     alert("${message}");
                     // EL 작성 시 scope를 지정하지 않으면
                     // page -> request -> session -> application 순서로 검색하여
                     // 일치하는 속성이 있으면 출력
                 </script>
 
                 <%-- message 1회 출력 후 session에서 제거 --%>
                 <c:remove var="message" scope="session" />
             </c:if>
             -->


    <!-- <%-- 다음 주소 API --%> -->
    <div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:11;-webkit-overflow-scrolling:touch;">
        <img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
    </div>           
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

    <!-- myPage.js 추가 -->
    <script src="${contextPath}/resources/js/myPage/myPage.js"></script>
</body>

</html>