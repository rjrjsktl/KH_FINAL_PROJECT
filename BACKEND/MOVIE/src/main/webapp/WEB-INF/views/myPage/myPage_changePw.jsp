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
    <title>마이페이지<비밀번호 변경>
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
                    MY KGV HOME <비밀번호 변경>

                        <!-- <span class="myPage-explanation">원하는 회원 정보를 수정할 수 있습니다.</span> -->

                        <!-- 
                     http://localhost:8080/community/member/myPage/info (GET)
                     http://localhost:8080/community/member/myPage/info (POST) 
                     -->
                        <form action="changePw" method="POST" name="myPage-form" onsubmit="return changePwValidate()">

                            <div class="mypage-info-frame">
                                <label>현재 비밀번호</label>
                            </div>
                            <div class="mypage-info-frame">
                                <input type="password" name="currentPw" id="currentPw" maxlength="30">
                            </div>

                            <div class="mypage-info-frame">
                                <label>새 비밀번호</label>
                            </div>
                            <div class="mypage-info-frame">
                                <input type="password" name="newPw" maxlength="30">
                            </div>

                            <div class="mypage-info-frame">
                                <label>새 비밀번호 확인</label>
                            </div>
                            <div class="mypage-info-frame">
                                <input type="password" name="newPwConfirm" maxlength="30">
                            </div>

                            <button id="info-update-btn">변경하기</button>

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



    <!-- myPage.js 추가 -->
    <script src="${contextPath}/resources/js/myPage/myPage.js"></script>
</body>

</html>