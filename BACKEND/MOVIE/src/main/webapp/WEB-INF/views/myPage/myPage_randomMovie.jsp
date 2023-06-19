<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <%@ page session="false" %>

<div class="event-wrap">
    <div>
        <div class="event-title">
            <a href="">오늘 이 영화를 추천드립니다!<br>(영화 랜덤 뿌리기 기능 찾아보기 9개정도)</a>
            <div><button>전체보기</button></div>
        </div>

        <div class="swiper-container">
            <div class="swiper-wrapper">
                <div class="swiper-slide">
                    <a href="#">
                        <img src="../../images/eventList/event001.jpg" alt="" onmouseenter="zoomIn(event)"
                            onmouseleave="zoomOut(event)">
                        <strong>이벤트1</strong>
                        <span>2023.01.01 ~ 2023.02.02</span>
                    </a>
                </div>
                <div class="swiper-slide">
                    <a href="#">
                        <img src="../../images/eventList/event002.jpg" alt="" onmouseenter="zoomIn(event)"
                            onmouseleave="zoomOut(event)">
                        <strong>이벤트1</strong>
                        <span>2023.01.01 ~ 2023.02.02</span>
                    </a>
                </div>

                <div class="swiper-slide">
                    <a href="#">
                        <img src="../../images/eventList/event003.jpg" alt="" onmouseenter="zoomIn(event)"
                            onmouseleave="zoomOut(event)">
                        <strong>이벤트1</strong>
                        <span>2023.01.01 ~ 2023.02.02</span>
                    </a>
                </div>
                <div class="swiper-slide">
                    <a href="#">
                        <img src="../../images/eventList/event002.jpg" alt="" onmouseenter="zoomIn(event)"
                            onmouseleave="zoomOut(event)">
                        <strong>이벤트1</strong>
                        <span>2023.01.01 ~ 2023.02.02</span>
                    </a>
                </div>
                <div class="swiper-slide">
                    <a href="#">
                        <img src="../../images/eventList/event001.jpg" alt="" onmouseenter="zoomIn(event)"
                            onmouseleave="zoomOut(event)">
                        <strong>이벤트1</strong>
                        <span>2023.01.01 ~ 2023.02.02</span>
                    </a>
                </div>
                <div class="swiper-slide">
                    <a href="#">
                        <img src="../../images/eventList/event002.jpg" alt="" onmouseenter="zoomIn(event)"
                            onmouseleave="zoomOut(event)">
                        <strong>이벤트1</strong>
                        <span>2023.01.01 ~ 2023.02.02</span>
                    </a>
                </div>
                <div class="swiper-slide">
                    <a href="#">
                        <img src="../../images/eventList/event003.jpg" alt="" onmouseenter="zoomIn(event)"
                            onmouseleave="zoomOut(event)">
                        <strong>이벤트1</strong>
                        <span>2023.01.01 ~ 2023.02.02</span>
                    </a>
                </div>
            </div>
            <div class="swiper-button-next swipe-nbtn"></div>
            <div class="swiper-button-prev swipe-pbtn"></div>
        </div>
    </div>
</div>