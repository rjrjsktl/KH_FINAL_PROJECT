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
    
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage/myPage.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/common/outline.css">
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
                <jsp:include page="/WEB-INF/views/myPage/myPage_logMemInfo.jsp" />
            </div>

            <div>
                <%--  이거 나중에 <jsp:include page="/WEB-INF/views/member/sideMenu.jsp"/>이런식으로 넣어줄 생각 --%>
                <!-- myPage_sideMenu.jsp -->
                <jsp:include page="/WEB-INF/views/myPage/myPage_sideMenu.jsp" />
                
                <section class="mypage-main">
                    MY KGV HOME <내가 쓴 리뷰>

                        <!-- <span class="myPage-explanation">원하는 회원 정보를 수정할 수 있습니다.</span> -->

                        <!-- 
                     http://localhost:8080/community/member/myPage/info (GET)
                     http://localhost:8080/community/member/myPage/info (POST) 
                     -->

                        <!-- 내가 본 영화, 내가 쓴 리뷰 페이지 form이 필요 없을듯? -->
                        <form action="myboard" method="POST" name="myPage-form" onsubmit="return infoValidate()">
                            <ul class="more-load">
                                <!-- 나중에 append나 폼 추가 할 때 이 li을 그대로 가져가면 됨 -->
                                <li class="myreview">
                                    <div>
                                        <div>
                                            <!-- 나중에 db건들 때 따오는 값 바꿔줘야함 -->
                                            <a href="#"><img src="../../images/123123.jpg" alt="영화 포스터 w=165px,h=210px"></a>
                                        </div>

                                        <div>
                                            <div>
                                                <div>영화 제목</div>
                                                <a class="i-dlt-btn" href="#"><i class="fa-regular fa-circle-xmark"></i></a>
                                            </div>
                                            <div>
                                                <ul>
                                                    <!-- db에 들어가는거 보고 영화 날짜, 시간, 인원, 몇관 등 추가 해야함 -->
                                                    <li>작성 날짜 :</li>
                                                    <li>작성 시간 :</li>
                                                </ul>
                                                <ul>
                                                    <!-- db에 들어가는거 보고 영화 날짜, 시간, 인원, 몇관 등 추가 해야함 -->
                                                    <li>2069.69.69 </li>
                                                    <li>69:74 ~ 69:74</li>
                                                </ul>
                                                
                                            </div>
                                            <div>
                                                <p>zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz</p>
                                            </div>
                                            <div>
                                                <button id="updatereview-btn">수정 가즈아</button>
                                            </div>

                                        </div>
                                    </div>
                                </li>

                            </ul>


                            <!-- 더보기 버튼 만들 영역 -->
                            <div id="listmore-wrap"><a href="javascript:;" id="listmore-btn">내 영화 더 보기</a></div>
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