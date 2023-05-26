<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<!-- 로그인 한사람의 정보, 다가오는 예약 페이지 고정으로 보여주는 부분 -->
<section>
    <div class="profile-image-area">
        <div>
            <img src="../../images/18.png" id="profile-image" alt="이미지삽입 w,h=182">
            <!-- 밑 이거 살려서 써야함 -->
            <!-- <c:if test="${empty loginMember.profileImage}">
                            <img src="${contextPath}/resources/images/user.png" id="profile-image" alt="이미지삽입 w,h=182">
                        </c:if>

                        <c:if test="${!empty loginMember.profileImage}">
                            <img src="${contextPath}${loginMember.profileImage}" id="profile-image">
                        </c:if> -->
        </div>
    </div>
    <div class="profile-info-area">

        <div class="mypage-main-frame">
            <label>이&nbsp;&nbsp;&nbsp;름</label>
            <span>ㅋㅋㄹㅃㅃ</span>
            <!-- <span>${loginMember.memberNick}</span> -->
        </div>

        <div class="mypage-main-frame">
            <label>닉네임</label>
            <span>ㅋㅋㄹㅃㅃ</span>
            <!-- <span>${loginMember.memberNick}</span> -->
        </div>

        <div class="mypage-main-frame">
            <label>이메일</label>
            <span>zzfQQ@gmail.com</span>
            <!-- <span>${loginMember.memberEmail}</span> -->
        </div>

        <div class="mypage-main-frame">
            <label>연락처</label>
            <span>010-0000-0000</span>
            <!-- <span>${loginMember.enrollDate}</span> -->
        </div>
    </div>
</section>

<section class="comemovie">
    <div>
        당신의 영화가 오고 있따옹
    </div>


    <div>
        <div>
            <!-- 나중에 db건들 때 따오는 값 바꿔줘야함 -->
            <a href="#"><img src="../../images/123123.jpg" alt="영화 포스터 w=155px,h=173px"></a>
        </div>

        <div>
            <div>
                영화 제목
            </div>
            <div>
                <ul>
                    <!-- db에 들어가는거 보고 영화 날짜, 시간, 인원, 몇관 등 추가 해야함 -->
                    <li>날&nbsp;&nbsp;&nbsp;짜 :</li>
                    <li>시&nbsp;&nbsp;&nbsp;간 :</li>
                    <li>인&nbsp;&nbsp;&nbsp;원 :</li>
                    <li>상영관 :</li>
                </ul>
                <ul>
                    <!-- db에 들어가는거 보고 영화 날짜, 시간, 인원, 몇관 등 추가 해야함 -->
                    <li>2069.69.69 </li>
                    <li>69:74 ~ 69:74</li>
                    <li>3썸</li>
                    <li>A 강의실</li>
                </ul>
            </div>
            <div>
                <button id="cancel-btn">예매 취소</button>
                <button id="change-btn">예매 변경</button>
            </div>

        </div>
    </div>
</section>