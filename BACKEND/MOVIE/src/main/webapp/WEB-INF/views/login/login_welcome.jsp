<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 성공 페이지</title>
    
    <link rel="stylesheet" href="${contextPath}/resources/css/login/login_welcome.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/common/outline.css">
    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>

        <!-- jQuery 라이브러리 추가(CDN) -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <!-- fontawesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
        integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />

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
                        <p>Welcom KGV !</p>
                        <button>메인페이지로 가기</button>
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