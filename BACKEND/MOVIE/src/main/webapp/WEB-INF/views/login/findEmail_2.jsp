<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 -->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디찾기_2 페이지</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login/findEmail_2.css">
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
                            <p>아이디 찾기</p>
                            <p>발송된 인증번호를 기입해주세요</p>
                        </div>

                        <!-- form -->
                        <div>
                            <form action="#" method="POST" onsubmit="return findId_2_Validate()">
                                <div>
                                    <div>
                                        <div>
                                            <input type="text" placeholder="인증번호" id="cNumber" maxlength="41">
                                            <!-- 시간 타이멍 input 오른쪽 끝에 넣기 -->
                                            <button>재발송</button>
                                        </div>
                                    </div>

                                    <div>
                                        <button id="cBtn">인증하기</button>
                                        <!-- 인증완료되면, 이메일로 변경된 비밀번호 발송되었다는 alert창 -->
                                    </div>
                                </div>
                            </form>
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