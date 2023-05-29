<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 -->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호찾기_1 페이지</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login/findPw_1.css">
    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>

</head>

<body>
    <div id="wrap">
    
    	<!-- header -->
        <jsp:include page="/WEB-INF/views/common/header.jsp" />    

        <main>
            <!-- 여기서 부터 작업하세요. -->
            <div>
                <div>
                    <!-- 프레임 -->
                    <div>

                        <!-- 로고 영역 -->
                        <div>
                            <p>비밀번호 찾기</p>
                            <p>찾고싶은 비밀번호의 해당하는 아이디를 기입하세요</p>
                        </div>

                        <!-- form -->
                        <div>
                            <form action="#" method="POST" onsubmit="return findPw_1_Validate()">
                                <div>
                                    <div>
                                        <div>
                                            <input type="text" placeholder="아이디" id="inputEmail" maxlength="41">
                                        </div>
                                    </div>

                                    <div>
                                        <button>다음</button>
                                    </div>
                                </div>
                            </form>
                        </div>

                        <!-- 아이디 찾기 -->
                        <div>
                            아이디도 기억이 안나시나요?<a href="findEmail">아이디 찾기</a>
                        </div>

                    </div>

                    
                </div>
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

    <script src="../../js/loginpage/loginpage.js"></script>
</body>

</html>