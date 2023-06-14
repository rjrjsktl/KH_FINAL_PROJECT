<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <%@ page session="false" %>

                    <!DOCTYPE html>
                    <html lang="ko">

                    <head>
                        <meta charset="UTF-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>스토어 물품 등록</title>



                        <!-- fontawesome -->
                        <link rel="stylesheet"
                            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
                            integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
                            crossorigin="anonymous" referrerpolicy="no-referrer" />

                        <!-- jQuery 라이브러리 추가(CDN) -->
                        <script src="https://code.jquery.com/jquery-3.6.0.min.js"
                            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
                            crossorigin="anonymous"></script>

                        <link rel="stylesheet" href="${contextPath}/resources/css/manager/manager_store_add.css">
                        <link rel="stylesheet" href="${contextPath}/resources/css/manager/manager_inner_Header.css">
                        <link rel="stylesheet" href="${contextPath}/resources/css/manager/reset.css">

                    </head>

                    <body class="dark light">
                        <main>

                            <div class="main_Wrapper">
                                <div id="left_Nav_Container">
                                    <div class="nav_Title">로고영역</div>
                                    <jsp:include page="/WEB-INF/views/manager/manager_nav.jsp" />
                                </div>

                                <div class="right_items_Container">
                                    <jsp:include page="/WEB-INF/views/manager/manager_inner_Header.jsp" />

                                    <div id="items_Wrapper">
                                        <div class="set_Edge">
                                            <div class="table_Wrapper">
                                                <div class="table_Title">
                                                    <span>스토어 물품 등록</span>
                                                </div>


                                                <form action="addStore" method="POST" onsubmit="return storeValidate()">
                                                    <div class="table_main">

                                                        <div id="store_sub">
                                                            <span>카테고리</span>
                                                            <div>
                                                                <select id="store_category" name="store_category"
                                                                    class="store_category" aria-label="성별">
                                                                    <option value="" selected="">선택</option>
                                                                    <option value="drink">음료</option>
                                                                    <option value="F">팝콘</option>
                                                                    <option value="U">티켓</option>
                                                                    <option value="U">스낵</option>
                                                                </select>
                                                            </div>
                                                        </div>


                                                        <div id="store_sub">
                                                            <span>상품 이름</span>
                                                            <div>
                                                                <input type="text" class="store_sub_enter store_title">
                                                            </div>
                                                        </div>

                                                        <div id="store_sub">
                                                            <span>상품 설명</span>
                                                            <div>
                                                                <input type="text" class="store_sub_enter store_desc">
                                                            </div>
                                                        </div>
                                                        <div id="store_sub">
                                                            <span>상품 가격</span>
                                                            <div>
                                                                <input type="number"
                                                                    class="store_sub_enter store_price">
                                                            </div>
                                                        </div>

                                                        <div id="store_sub">
                                                            <span>상품 제한개수</span>
                                                            <div>
                                                                <input type="number"
                                                                    class="store_sub_enter store_stock">
                                                            </div>
                                                        </div>


                                                        <div id="store_sub">
                                                            <span>이미지</span>
                                                            <div>
                                                                <input type="file" class="store_image">
                                                            </div>
                                                        </div>











                                                    </div>


                                                </form>



                                                <div class="table_bottom">
                                                    <button class="bottom_Submit">저장</button>
                                                    <button class="bottom_Cancel">취소</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>

                        </main>
                        <script src="${contextPath}/resources/js/manager/manager_store_add.js"></script>
                        <script src="${contextPath}/resources/js/manager/manager_inner_Header.js"></script>
                        <script src="${contextPath}/resources/js/manager/manager_nav.js"></script>

                    </body>

                    </html>