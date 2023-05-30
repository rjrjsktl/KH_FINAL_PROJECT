 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인페이지</title>
   
       <link rel="stylesheet" href="${contextPath}/resources/css/signUp/signUp.css">
    <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>

</head>

<body>
    
    <div id="wrap">
       
		 <!-- header -->
        <jsp:include page="/WEB-INF/views/common/header.jsp" />
        <main>
            <!-- 여기서 부터 작업하세요. -->


            <section class="signUp-content">



                <form action="signUp" method="POST" name="signUp-form" onsubmit="return signUpValidate()">

                    <div>회원가입</div>
                    <label for="memberEmail">
                        <span class="required">*</span> 아이디(이메일)
                    </label>

                    <div class="signUp-input-area">
                        <input type="text" id="memberEmail" name="memberEmail" placeholder="아이디(이메일)" maxlength="30"
                            autocomplete="off" required>


                        <button type="button" id="sendBtn">인증번호 받기</button>
                    </div>

                    <span class="signUp-message" id="emailMessage"></span>



                    <label for="emailCheck">
                        <span class="required">*</span> 인증번호
                    </label>

                    <div class="signUp-input-area">
                        <!-- cNumber -->
                        <input type="text" id="cNumber" placeholder="인증번호 입력" maxlength="6" autocomplete="off">

                        <button type="button" id="cBtn">인증하기</button>
                    </div>

                    <!-- 5:00 타이머 -->
                    <span class="signUp-message" id="cMessage"></span>



                    <label for="memberPw">
                        <span class="required">*</span> 비밀번호
                    </label>

                    <div class="signUp-input-area">
                        <input type="password" id="memberPw" name="memberPw" placeholder="비밀번호" maxlength="30">
                    </div>

                    <div class="signUp-input-area">
                        <input type="password" id="memberPwConfirm" placeholder="비밀번호 확인" maxlength="30">
                    </div>

                    <span class="signUp-message" id="pwMessage"></span>




                    <label for="memberNickname">
                        <span class="required">*</span> 닉네임
                    </label>

                    <div class="signUp-input-area">
                        <input type="text" id="memberNickname" name="memberNickname" placeholder="닉네임" maxlength="10">
                    </div>

                    <span class="signUp-message" id="nicknameMessage"></span>



                    <label for="membername">
                        <span class="required">*</span> 이름
                    </label>

                    <div class="signUp-input-area">
                        <input type="text" id="membername" placeholder="이름" maxlength="10">

                    </div>

                    <span class="signUp-message" id="nameMessage"></span>

                    <label for="birthday">
                        <span class="required">*</span> 생년월일
                    </label>

                    <div class="signUp-input-area">



                        <input type="text" id="birthdayInput" placeholder="생년월일 8자리" class="input" value=""
                            maxlength="8">

                    </div>
                    <span class="error_box" id="birMessage"></span>

                    <label for="membername">
                        <span class="required">*</span> 성별
                    </label>

                    <div class="signUp-input-area">
                        <select id="gender" name="gender" class="sel" aria-label="성별">
                            <option value="" selected="">성별</option>
                            <option value="M">남자</option>
                            <option value="F">여자</option>
                            <option value="U">선택 안함</option>
                        </select>

                    </div>

                    <span class="signUp-message" id="selMessage"></span>


                    <label for="memberTel">
                        <span class="required">*</span> 연락처
                    </label>

                    <div class="signUp-input-area">
                        <input type="text" id="memberTel" name="memberTel" placeholder="(- 없이 숫자만 입력)" maxlength="11">
                    </div>

                    <span class="signUp-message" id="telMessage"></span>



                    <label for="memberAddress">
                        주소
                    </label>

                    <div class="signUp-input-area">
                        <input type="text" id="sample4_postcode" name="memberAddress" placeholder="우편번호" maxlength="6"
                            readonly>

                        <button type="button" onclick="return sample4_execDaumPostcode()">검색</button>
                    </div>

                    <div class="signUp-input-area">
                        <input type="text" id="sample4_roadAddress" name="memberAddress" placeholder="도로명주소" readonly>
                    </div>

                    <div class="signUp-input-area">
                        <input type="text" id="sample4_detailAddress" name="memberAddress" placeholder="상세주소" readonly>
                    </div>

                    <button type="button" id="signUp-btn">가입하기</button>

                </form>

            </section>







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

	
    <script src="${contextPath}/resources/js/signUp/signUp.js"></script>
  
</body>

</html>