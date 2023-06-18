<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>전체영화</title>

        <link rel="stylesheet" href="${contextPath}/resources/css/store/storeMain.css">

        <link rel="stylesheet" href="${contextPath}/resources/css/common/outline.css">
        <script src="https://kit.fontawesome.com/dc6e43e0ad.js" crossorigin="anonymous"></script>

    </head>

    <body>
        <div id="wrap">

            <!-- header -->
            <jsp:include page="/WEB-INF/views/common/header.jsp" />

            <main>
                <div><span>스토어</span></div>


                <div class="tab-list fixed">
                    <ul>

                        <li><a href="#none" id="storeTab_1" class="storeTab clicked" title="전체탭">전체</a></li>

                        <li><a href="#none" id="storeTab_2" class="storeTab" title="음료탭">음료</a></li>

                        <li><a href="#none" id="storeTab_3" class="storeTab" title="팝콘탭">팝콘</a></li>

                        <li><a href="#none" id="storeTab_4" class="storeTab" title="스낵탭">스낵</a></li>

                        <li><a href="#none" id="storeTab_5" class="storeTab" title="티켓탭">KGV티켓</a></li>

                    </ul>
                </div>

                <div>

                    <h3 class="store_h3 store_drink">음료</h3>
                    <ul class="store_ul store_drink">





                        <c:forEach var="store" items="${storeMap['storeList']}">
                            <c:choose>
                                <c:when test="${store.storeCategory eq '음료'}">
                                    <li class="">
                                        <a href="${contextPath}/store/storeMain/store_detail/${store['storeNo']}"
                                            title="${store.storeName}">
                                            <div class="img">
                                                <c:choose>


                                                    <c:when test="${store.storeName eq '사이다 M'}">
                                                        <img src="${store['storeImage']}">
                                                    </c:when>

                                                    <c:when test="${store.storeName eq '콜라 M'}">
                                                        <img src="${store['storeImage']}">
                                                    </c:when>

                                                    <c:when test="${store.storeName eq '콜라 L'}">
                                                        <img src="${store['storeImage']}">
                                                    </c:when>

                                                </c:choose>
                                            </div>
                                            <div class="info">
                                                <div class="tit">
                                                    <h4>${store.storeName}</h4>
                                                    <p>${store.storeDesc}</p>
                                                </div>
                                                <div class="price">
                                                    <p class="sale">
                                                        <em>
                                                            <fmt:formatNumber value="${store.storePrice}"
                                                                pattern="#,###" />
                                                        </em>
                                                        <span>원</span>
                                                    </p>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <!-- 다른 카테고리에 대한 처리를 필요에 따라 추가하세요 -->
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>







                    </ul>

                    <h3 class="store_h3 store_popcorn">팝콘</h3>
                    <ul class="store_ul store_popcorn">




                        <c:forEach var="store" items="${storeMap['storeList']}">
                            <c:choose>
                                <c:when test="${store.storeCategory eq '팝콘'}">
                                    <li class="">
                                        <a href="${contextPath}/store/storeMain/store_detail/${store['storeNo']}"
                                            title="${store.storeName}">
                                            <div class="img">
                                                <c:choose>
                                                    <c:when test="${store.storeName eq '오리지널팝콘 L'}">
                                                        <img src="${store['storeImage']}">
                                                    </c:when>



                                                </c:choose>
                                            </div>
                                            <div class="info">
                                                <div class="tit">
                                                    <h4>${store.storeName}</h4>
                                                    <p>${store.storeDesc}</p>
                                                </div>
                                                <div class="price">
                                                    <p class="sale">
                                                        <em>${store.storePrice}</em>
                                                        <span>원</span>
                                                    </p>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <!-- 다른 카테고리에 대한 처리를 필요에 따라 추가하세요 -->
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>







                    </ul>



                    <h3 class="store_h3 store_snack">스낵</h3>
                    <ul class="store_ul store_snack">



                        <c:forEach var="store" items="${storeMap['storeList']}">
                            <c:choose>
                                <c:when test="${store.storeCategory eq '스낵'}">
                                    <li class="">
                                        <a href="${contextPath}/store/storeMain/store_detail/${store['storeNo']}"
                                            title="${store.storeName}">
                                            <div class="img">
                                                <c:choose>
                                                    <c:when test="${store.storeName eq '칠리치즈핫도그'}">
                                                        <img src="${store['storeImage']}">
                                                    </c:when>



                                                </c:choose>
                                            </div>
                                            <div class="info">
                                                <div class="tit">
                                                    <h4>${store.storeName}</h4>
                                                    <p>${store.storeDesc}</p>
                                                </div>
                                                <div class="price">
                                                    <p class="sale">
                                                        <em>${store.storePrice}</em>
                                                        <span>원</span>
                                                    </p>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <!-- 다른 카테고리에 대한 처리를 필요에 따라 추가하세요 -->
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>





                    </ul>


                    <h3 class="store_h3 store_ticket">티켓</h3>
                    <ul class="store_ul store_ticket">



                        <c:forEach var="store" items="${storeMap['storeList']}">
                            <c:choose>
                                <c:when test="${store.storeCategory eq '티켓'}">
                                    <li class="">
                                        <a href="${contextPath}/store/storeMain/store_detail/${store['storeNo']}"
                                            title="${store.storeName}">
                                            <div class="img">
                                                <c:choose>
                                                    <c:when test="${store.storeName eq 'KGV 일반관람권 2D'}">
                                                        <img src="${store['storeImage']}">
                                                    </c:when>



                                                </c:choose>
                                            </div>
                                            <div class="info">
                                                <div class="tit">
                                                    <h4>${store.storeName}</h4>
                                                    <p>${store.storeDesc}</p>
                                                </div>
                                                <div class="price">
                                                    <p class="sale">
                                                        <em>${store.storePrice}</em>
                                                        <span>원</span>
                                                    </p>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <!-- 다른 카테고리에 대한 처리를 필요에 따라 추가하세요 -->
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>





                    </ul>


                </div>



            </main>
        </div>

        <!-- footer -->
        <jsp:include page="/WEB-INF/views/common/footer.jsp" />

        <!-- 모달 -->
        <div id="myModal" class="modal">
            <div class="modal-content">
                <div class="close-button">&times;</div>
                <iframe src="../login/login.html" frameborder="0" width="500px" height="500px"></iframe>
            </div>
        </div>



        <div id="myModal" class="modal">
            <div class="modal-content">
                <div class="close-button">&times;</div>
                <iframe src="../login/login.html" frameborder="0" width="500px" height="500px"></iframe>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>


        <script src="${contextPath}/resources/js/store/storeMain.js"></script>
        <script src="${contextPath}/resources/js/common/header.js"></script>

    </body>

    </html>